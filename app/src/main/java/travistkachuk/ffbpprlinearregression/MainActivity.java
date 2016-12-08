package travistkachuk.ffbpprlinearregression;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.edtQB)
    EditText edtQBProjectedScore;
    @BindView(R.id.edtRB1)
    EditText edtRB1ProjectedScore;
    @BindView(R.id.edtRB2)
    EditText edtRB2ProjectedScore;
    @BindView(R.id.edtWR1)
    EditText edtWR1ProjectedScore;
    @BindView(R.id.edtWR2)
    EditText edtWR2ProjectedScore;
    @BindView(R.id.edtK)
    EditText edtKProjectedScore;
    @BindView(R.id.edtDST)
    EditText edtDSTProjectedScore;
    @BindView(R.id.edtFLX)
    EditText edtFLXProjectedScore;
    @BindViews({R.id.chckRB,R.id.chckTE,R.id.chckWR})
    List<CheckBox> chkFlexType;
    List<EditText> ScoreBoxes  = new ArrayList<>();
    Double[] RegressedScores = new Double[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        putScoresInList();
        setUpCheckBoxes();
    }

    private void putScoresInList() {
        ScoreBoxes.add(edtQBProjectedScore);
        ScoreBoxes.add(edtRB1ProjectedScore);
        ScoreBoxes.add(edtRB2ProjectedScore);
        ScoreBoxes.add(edtWR1ProjectedScore);
        ScoreBoxes.add(edtWR2ProjectedScore);
        ScoreBoxes.add(edtKProjectedScore);
        ScoreBoxes.add(edtDSTProjectedScore);
        ScoreBoxes.add(edtFLXProjectedScore);
    }

    private void setUpCheckBoxes() {
        for(final CheckBox checkBox: chkFlexType){
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        for(CheckBox otherBoxes:chkFlexType){
                            if(otherBoxes!=checkBox){
                                otherBoxes.setChecked(false);
                            }
                        }
                    }
                }
            });
        }
    }

    @OnClick(R.id.btnCalculate)
    public void CalcScoresAndShow(){
        double totalScore = 0;
        if(!nullValuesFound()){
            getRegressedScores();
        }
        Intent i = new Intent(this, ShowScores.class);
        i.putExtra("QBRegressedScore",RegressedScores[0]);
        i.putExtra("RB1RegressedScore",RegressedScores[1]);
        i.putExtra("RB2RegressedScore",RegressedScores[2]);
        i.putExtra("WR1RegressedScore",RegressedScores[3]);
        i.putExtra("WR2RegressedScore",RegressedScores[4]);
        i.putExtra("KRegressedScore",RegressedScores[5]);
        i.putExtra("DSTRegressedScore",RegressedScores[6]);
        i.putExtra("FLXRegressedScore",RegressedScores[7]);
        for(int z = 0; z<8;z++){
            totalScore += RegressedScores[z];
        }
        i.putExtra("TotalRegressedScore",totalScore);
        startActivity(i);
    }

    private void getRegressedScores() {
        RegressedScores[0] = CalculateScores.getQBScore(Double.valueOf(edtQBProjectedScore.getText().toString()));
        RegressedScores[1] = CalculateScores.getRBScore(Double.valueOf(edtRB1ProjectedScore.getText().toString()));
        RegressedScores[2] = CalculateScores.getRBScore(Double.valueOf(edtRB2ProjectedScore.getText().toString()));
        RegressedScores[3] = CalculateScores.getWRScore(Double.valueOf(edtWR1ProjectedScore.getText().toString()));
        RegressedScores[4] = CalculateScores.getWRScore(Double.valueOf(edtWR2ProjectedScore.getText().toString()));
        RegressedScores[5] = CalculateScores.getKScore(Double.valueOf(edtKProjectedScore.getText().toString()));
        RegressedScores[6] = CalculateScores.getDSTScore(Double.valueOf(edtDSTProjectedScore.getText().toString()));
        if(chkFlexType.get(0).isChecked())
            RegressedScores[7] = CalculateScores.getRBScore(Double.valueOf(edtFLXProjectedScore.getText().toString()));
        if(chkFlexType.get(1).isChecked())
            RegressedScores[7] = CalculateScores.getTEScore(Double.valueOf(edtFLXProjectedScore.getText().toString()));
        if(chkFlexType.get(2).isChecked())
            RegressedScores[7] = CalculateScores.getWRScore(Double.valueOf(edtFLXProjectedScore.getText().toString()));
    }

    private boolean nullValuesFound() {
        Boolean NullFound = false;
        Boolean NoBoxChecked = true;
        for(EditText edtPlayer:ScoreBoxes)
        if(edtPlayer.getText().toString().length() == 0){
            NullFound = true;
        }
        for(CheckBox chkBox:chkFlexType)
        {
            if(chkBox.isChecked()){
                NoBoxChecked = false;
            }
        }
        if(NoBoxChecked)
            return NoBoxChecked;
        else
            return NullFound;
    }
}

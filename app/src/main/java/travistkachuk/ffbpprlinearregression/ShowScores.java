package travistkachuk.ffbpprlinearregression;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowScores extends Activity {
    @BindView(R.id.txtQBScore)
    TextView txtQBScore;
    @BindView(R.id.txtRB1Score)
    TextView txtRB1Score;
    @BindView(R.id.txtRB2Score)
    TextView txtRB2Score;
    @BindView(R.id.txtWR1Score)
    TextView txtWR1Score;
    @BindView(R.id.txtWR2Score)
    TextView txtWR2Score;
    @BindView(R.id.txtKScore)
    TextView txtKScore;
    @BindView(R.id.txtDSTScore)
    TextView txtDSTScore;
    @BindView(R.id.txtFLXScore)
    TextView txtFLXScore;
    @BindView(R.id.txtTotalScore)
    TextView txtTotalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scores);
        ButterKnife.bind(this);
        Intent i = getIntent();
        txtQBScore.setText(Integer.toString((int)i.getDoubleExtra("QBRegressedScore",0)));
        txtRB1Score.setText(Integer.toString((int)i.getDoubleExtra("RB1RegressedScore",0)));
        txtRB2Score.setText(Integer.toString((int)i.getDoubleExtra("RB2RegressedScore",0)));
        txtWR1Score.setText(Integer.toString((int)i.getDoubleExtra("WR1RegressedScore",0)));
        txtWR2Score.setText(Integer.toString((int)i.getDoubleExtra("WR2RegressedScore",0)));
        txtKScore.setText(Integer.toString((int)i.getDoubleExtra("KRegressedScore",0)));
        txtDSTScore.setText(Integer.toString((int)i.getDoubleExtra("DSTRegressedScore",0)));
        txtFLXScore.setText(Integer.toString((int)i.getDoubleExtra("FLXRegressedScore",0)));
        txtTotalScore.setText(Integer.toString((int)i.getDoubleExtra("TotalRegressedScore",0)));
    }
}

package travistkachuk.ffbpprlinearregression;

/**
 * Created by Travis on 12/8/2016.
 */

public class CalculateScores {

    public static double getQBScore(double projectedSore){
        double RegressedScore;
        if(projectedSore>0)
            RegressedScore = (.4888*projectedSore)+13.333;
        else
            RegressedScore = 0;
        return RegressedScore;
    }
    public static double getRBScore(double projectedSore){
        double RegressedScore;
        if(projectedSore>0)
            RegressedScore = 22.233 - (.0476*projectedSore);
        else
            RegressedScore = 0;
        return RegressedScore;
    }
    public static double getWRScore(double projectedSore){
        double RegressedScore;
        if(projectedSore>0)
            RegressedScore = (1.0677*projectedSore)+3.8817;
        else
            RegressedScore = 0;
        return RegressedScore;
    }
    public static double getTEScore(double projectedSore){
        double RegressedScore;
        if(projectedSore>0)
            RegressedScore = (.3346*projectedSore)+11.587;
        else
            RegressedScore = 0;
        return RegressedScore;
    }
    public static double getKScore(double projectedSore){
        double RegressedScore;
        if(projectedSore>0)
            RegressedScore = (.5631*projectedSore)+5.3653;
        else
            RegressedScore = 0;
        return RegressedScore;
    }
    public static double getDSTScore(double projectedSore){
        double RegressedScore;
        if(projectedSore>0)
            RegressedScore = (.5098*projectedSore)+8.3547;
        else
            RegressedScore = 0;
        return RegressedScore;
    }
}

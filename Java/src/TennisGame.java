import static java.lang.Math.abs;

/**
 * Created by zhaoran on 6/15/14.
 */
public class TennisGame {

    private int mPointsOfPlayer1;
    private int mPointsOfPlayer2;
    private String mNameOfPlayer1;
    private String mNameOfPlayer2;

    public TennisGame(String nameOfPlayer1, String nameOfPlayer2) {
        this.mNameOfPlayer1 = nameOfPlayer1;
        this.mNameOfPlayer2 = nameOfPlayer2;
    }

    public String score() {
        final String[] score_text = new String[] {"love", "fifteen", "thirty", "forty"};

        if (mPointsOfPlayer1 == mPointsOfPlayer2) {
            return (mPointsOfPlayer1 >= 3) ? "deuce" : score_text[mPointsOfPlayer1] + " all";
        }
        if (mPointsOfPlayer1 >= 4 || mPointsOfPlayer2 >= 4) {
            return ((mPointsOfPlayer1 > mPointsOfPlayer2) ? mNameOfPlayer1 : mNameOfPlayer2) +
                    ((abs(mPointsOfPlayer1 - mPointsOfPlayer2) == 1) ? " advantage" : " wins");
        }
        return score_text[mPointsOfPlayer1] + " " + score_text[mPointsOfPlayer2];
    }

    public void player1GetPoint() {
        mPointsOfPlayer1++;
    }

    public void player2GetPoint() {
        mPointsOfPlayer2++;
    }
}

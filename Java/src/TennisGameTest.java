import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhaoran on 6/15/14.
 */
@RunWith(Parameterized.class)
public class TennisGameTest {
    private TennisGame mGame = new TennisGame("Federer", "Nadal");
    private int mPointsOfPlayer1;
    private int mPointsOfPlayer2;
    private String mExpectScore;

    @Parameterized.Parameters
    public static Collection<Object[]> prepare_test_case() {
        return Arrays.asList(new Object[][] {
                {1, 0, "fifteen love"},
                {2, 0, "thirty love"},
                {3, 0, "forty love"},
                {0, 1, "love fifteen"},
                {0, 2, "love thirty"},
                {0, 3, "love forty"},

                {1, 1, "fifteen all"},
                {2, 2, "thirty all"},
                {3, 3, "deuce"},
                {4, 4, "deuce"},

                {4, 3, "Federer advantage"},
                {3, 4, "Nadal advantage"},
                {5, 4, "Federer advantage"},
                {4, 5, "Nadal advantage"},

                {4, 0, "Federer wins"},
                {5, 3, "Federer wins"},
                {0, 4, "Nadal wins"},
                {3, 5, "Nadal wins"},

                {100, 100, "deuce"},
                {101, 100, "Federer advantage"},
                {100, 101, "Nadal advantage"},
                {102, 100, "Federer wins"},
                {100, 102, "Nadal wins"},
        });
    }

    public TennisGameTest(int pointsOfPlayer1, int pointsOfPlayer2, String expectScore) {
        this.mPointsOfPlayer1 = pointsOfPlayer1;
        this.mPointsOfPlayer2 = pointsOfPlayer2;
        this.mExpectScore = expectScore;
    }

    @Test
    public void start_from_love_all() {
        assertEquals("love all", mGame.score());
    }

    @Test
    public void test_all_cases() throws Exception {
        playersGetPoints(mPointsOfPlayer1, mPointsOfPlayer2);
        assertEquals(mExpectScore, mGame.score());
    }

    private void playersGetPoints(int pointOfPlayer1, int pointOfPlayer2) {
        int maxPoint = max(pointOfPlayer1, pointOfPlayer2);
        int minPoint = min(pointOfPlayer1, pointOfPlayer2);
        int i = 0;

        for (; i < minPoint; i++) {
            mGame.player1GetPoint();
            mGame.player2GetPoint();
        }

        if (maxPoint == pointOfPlayer1)
            for (; i < maxPoint; i++)
                mGame.player1GetPoint();

        if (maxPoint == pointOfPlayer2)
            for (; i < maxPoint; i++)
                mGame.player2GetPoint();
    }
}

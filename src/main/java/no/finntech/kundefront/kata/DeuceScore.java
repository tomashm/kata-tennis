package no.finntech.kundefront.kata;

/**
 * Created with IntelliJ IDEA.
 * User: tommorte
 * Date: 04.02.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class DeuceScore implements Score {

    @Override
    public Score registerBallWinner(Player player) {
        return new AdvantageScore(player);
    }

    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object obj) {

        return obj instanceof DeuceScore;
    }
}

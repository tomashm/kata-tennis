package no.finntech.kundefront.kata;

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

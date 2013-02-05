package no.finntech.kundefront.kata;

import com.google.common.base.Objects;

public class Winner implements Score {
    private Player winner;

    public Winner(Player player) {
        this.winner = player;
    }

    @Override
    public Score registerBallWinner(Player player) {
        throw new IllegalStateException("Game finished");
    }

    @SuppressWarnings("all")
    @Override
    public boolean equals(Object o) {
        return Objects.equal(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winner);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("player", winner).toString();
    }
}

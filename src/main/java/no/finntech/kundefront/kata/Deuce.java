package no.finntech.kundefront.kata;

import com.google.common.base.Objects;

public class Deuce implements Score {

    @Override
    public Score registerBallWinner(Player player) {
        return new Advantage(player);
    }

    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Deuce;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
}

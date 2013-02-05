package no.finntech.kundefront.kata;

import com.google.common.base.Objects;

public class Advantage implements Score {


    private final Player playerWithAdvantage;

    public Advantage(Player playerWithAdvantage) {

        this.playerWithAdvantage = playerWithAdvantage;
    }

    @Override
    public Score registerBallWinner(Player player) {
        if (player.equals(playerWithAdvantage)) {
            return new Winner(playerWithAdvantage);
        }
        return new Deuce();

    }

    @SuppressWarnings("all")
    @Override
    public boolean equals(Object o) {
        return Objects.equal(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(playerWithAdvantage);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("playerWithAdvantage", playerWithAdvantage).toString();
    }
}

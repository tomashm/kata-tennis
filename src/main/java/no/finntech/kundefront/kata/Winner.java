package no.finntech.kundefront.kata;

import com.google.common.base.Objects;

public class Winner implements Score {
    private Player player;

    public Winner(Player player) {
        this.player = player;
    }

    @Override
    public Score registerBallWinner(Player player) {
        throw new IllegalStateException("Game finished");
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("player", player)
                .toString();
    }

    @SuppressWarnings("all")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Winner winner = (Winner) o;

        if (player != winner.player) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return player != null ? player.hashCode() : 0;
    }
}

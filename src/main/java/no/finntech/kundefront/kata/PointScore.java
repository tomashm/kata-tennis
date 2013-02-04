package no.finntech.kundefront.kata;

import com.google.common.base.Objects;

import static no.finntech.kundefront.kata.Player.RECEIVER;
import static no.finntech.kundefront.kata.Player.SERVER;

public class PointScore implements Score {
    private int server;
    private int receiver;

    public PointScore(int server, int receiver) {

        this.server = server;
        this.receiver = receiver;
    }

    public Score registerBallWinner(Player player) {
        if (player == SERVER && server == 40 && receiver < 40) {
            return new Winner(SERVER);
        }
        if (player == RECEIVER && server < 40 && receiver == 40) {
            return new Winner(RECEIVER);
        }
        Score score = calculateScore(player);
        if (score.equals(new PointScore(40, 40))) {
            return new Deuce();
        }
        return score;
    }

    private Score calculateScore(Player player) {
        if (player == RECEIVER) {
            return new PointScore(this.getFor(SERVER), incrementScore(this.getFor(RECEIVER)));
        } else {
            return new PointScore(incrementScore(this.getFor(SERVER)), this.getFor(RECEIVER));
        }
    }

    private int incrementScore(int current) {
        if (current <= 15) {
            return current + 15;
        } else if (current == 30) {
            return current + 10;
        }
        return current;
    }


    @SuppressWarnings("all")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointScore pointScore = (PointScore) o;

        if (receiver != pointScore.receiver) return false;
        if (server != pointScore.server) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = server;
        result = 31 * result + receiver;
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("server", server)
                .add("receiver", receiver)
                .toString();
    }

    public int getFor(Player player) {
        if (player == SERVER) {
            return server;
        } else {
            return receiver;
        }
    }
}

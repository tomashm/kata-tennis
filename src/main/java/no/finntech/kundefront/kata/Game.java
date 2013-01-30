package no.finntech.kundefront.kata;

public class Game {

    private Score score = new Score(0, 0);

    public Score getScore() {
        return score;
    }

    public void registerBallWinner(Player player) {
        if (player == Player.RECEIVER) {
            score = new Score(score.getFor(Player.SERVER), score.getFor(Player.RECEIVER) + 15);
        } else {
            score = new Score(score.getFor(Player.SERVER) + 15, score.getFor(Player.RECEIVER));

        }

    }
}

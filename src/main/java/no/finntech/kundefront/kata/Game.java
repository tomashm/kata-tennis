package no.finntech.kundefront.kata;

public class Game {

    private Score score = new PointScore(0, 0);

    public Score getScore() {
        return score;
    }

    public void registerBallWinner(Player player) {
        score = score.registerBallWinner(player);


    }


}

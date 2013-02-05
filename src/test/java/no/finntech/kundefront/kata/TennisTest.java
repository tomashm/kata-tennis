package no.finntech.kundefront.kata;

import org.junit.Test;

import static no.finntech.kundefront.kata.Player.RECEIVER;
import static no.finntech.kundefront.kata.Player.SERVER;
import static org.fest.assertions.Assertions.assertThat;

public class TennisTest {

    @Test
    public void shouldStartWithWith_0_0_whenNewGame() {
        Game game = new Game();

        assertThat(game.getScore()).isEqualTo(new PointScore());
        assertThat(game.getScore()).isEqualTo(new PointScore(0, 0));
    }

    @Test
    public void shouldIncreaseScoreForWinnerOfBall() {
        Game game = new Game();

        game.registerBallWinner(SERVER);

        assertThat(game.getScore()).isEqualTo(new PointScore(15, 0));
    }

    @Test
    public void shouldRegisterMultipleBalls() {
        Game game = new Game();

        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);

        assertThat(game.getScore()).isEqualTo(new PointScore(15, 15));

    }

    @Test
    public void shouldScore_40_WhenOnePlayerWins_3_balls() {
        Game game = new Game();

        game.registerBallWinner(SERVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(SERVER);

        assertThat(game.getScore()).isEqualTo(new PointScore(40, 0));
    }

    @Test
    public void shouldScoreDeuceWhenBothPlayerWins_3_balls() {
        Game game = new Game();

        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);

        assertThat(game.getScore()).isEqualTo(new Deuce());
    }


    @Test
    public void shouldScoreDeuceWhenBothPlayerWins_4_balls() {
        Game game = new Game();

        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);

        assertThat(game.getScore()).isEqualTo(new Deuce());
    }

    @Test
    public void shouldScoreWinnerWhenServerWins_4_balls() {
        Game game = new Game();

        game.registerBallWinner(SERVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(SERVER);

        assertThat(game.getScore()).isEqualTo(new Winner(SERVER));
    }

    @Test
    public void shouldScoreAdvantageRWhenServerWinsAfterDeuce() {
        Game game = deuceGame();

        game.registerBallWinner(RECEIVER);

        assertThat(game.getScore()).isEqualTo(new Advantage(RECEIVER));
    }

    @Test
    public void shouldWinGameWhenScoringAfterAdvantage() {
        Game game = deuceGame();

        game.registerBallWinner(SERVER);
        game.registerBallWinner(SERVER);

        assertThat(game.getScore()).isEqualTo(new Winner(SERVER));
    }

    private Game deuceGame() {
        Game game = new Game();
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        game.registerBallWinner(SERVER);
        game.registerBallWinner(RECEIVER);
        return game;
    }
}

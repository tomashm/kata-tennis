package no.finntech.kundefront.kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TennisTest {

    @Test
    public void shouldStartWithWith_0_0_whenNewGame() {
        Game game = new Game();

        assertThat(game.getScore()).isEqualTo(new PointScore(0, 0));
    }

    @Test
    public void shouldIncreaseScoreForWinnerOfBall() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);

        assertThat(game.getScore()).isEqualTo(new PointScore(15, 0));
    }

    @Test
    public void shouldRegisterMultipleBalls() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);

        assertThat(game.getScore()).isEqualTo(new PointScore(15, 15));

    }

    @Test
    public void shouldScore_40_WhenOnePlayerWins_3_balls() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.SERVER);

        assertThat(game.getScore()).isEqualTo(new PointScore(40, 0));
    }

    @Test
    public void shouldScoreDeuceWhenBothPlayerWins_3_balls() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);

        assertThat(game.getScore()).isEqualTo(PointScore.DEUCE);
    }


    @Test
    public void shouldScoreDeuceWhenBothPlayerWins_4_balls() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);

        assertThat(game.getScore()).isEqualTo(PointScore.DEUCE);
    }

    @Test
    public void shouldScoreAdvantageServerWhenServerWinsAfterDeuce() {
        Game game = deuceGame();

        game.registerBallWinner(Player.SERVER);

        assertThat(game.getScore()).isEqualTo(new AdvantageScore(Player.SERVER));
    }

    private Game deuceGame() {
        Game game = new Game();
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);
        return game;
    }
}

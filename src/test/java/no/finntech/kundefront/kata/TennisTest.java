package no.finntech.kundefront.kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TennisTest {

    @Test
    public void shouldStartWithWith_0_0_whenNewGame() {
        Game game = new Game();

        assertThat(game.getScore()).isEqualTo(new Score(0, 0));
    }

    @Test
    public void shouldIncreaseScoreForWinnerOfBall() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);

        assertThat(game.getScore()).isEqualTo(new Score(15, 0));
    }

    @Test
    public void shouldRegisterMultipleBalls() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.RECEIVER);

        assertThat(game.getScore()).isEqualTo(new Score(15, 15));

    }

    @Test
    public void shouldGetCorrectScoreWhenOnePlayerWins_3_balls() {
        Game game = new Game();

        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.SERVER);
        game.registerBallWinner(Player.SERVER);

        assertThat(game.getScore()).isEqualTo(new Score(40, 0));
    }

}

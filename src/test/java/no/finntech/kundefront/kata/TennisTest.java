package no.finntech.kundefront.kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TennisTest {

    @Test
    public void shouldStartWithWith_0_0_whenNewGame() {
        Game game = new Game();

        Score expected = new Score(0, 0);
        assertThat(game.getScore()).isEqualTo(expected);
    }
}

package no.finntech.kundefront.kata;

import javax.swing.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            String choice = JOptionPane.showInputDialog("Ball won by [s]erver or [r]eceiver");
            if (choice == null) return;
            switch (choice) {
                case "s":
                    game.registerBallWinner(Player.SERVER);
                    break;
                case "r":
                    game.registerBallWinner(Player.RECEIVER);
                    break;
                default:
                    continue;
            }
            JOptionPane.showMessageDialog(null, game.getScore());

            if (game.isDone()) game = new Game();
        }
    }
}

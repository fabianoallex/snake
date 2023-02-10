import snakegameswing.SnakeGameTextArea;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SnakeGameTextArea game = (SnakeGameTextArea) new SnakeGameTextArea.Builder()
                .withDisplayHeight(20)
                .withDisplayWidth(50)
                .build();

        JFrame jFrame = new JFrame("Game");
        jFrame.setSize(600,600);

        JTextArea textArea = game.getDisplay().getTextArea();

        JPanel jPanel = new JPanel();
        jPanel.add(textArea);

        jFrame.add(jPanel);
        jFrame.setVisible(true);

        game.run();
    }
}
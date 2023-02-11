import snakegameswing.DisplayTextArea;
import snakegameswing.SnakeGameTextArea;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        DisplayTextArea displayTextArea = new DisplayTextArea(20, 50);

        SnakeGameTextArea game = (SnakeGameTextArea) new SnakeGameTextArea.Builder(displayTextArea)
                .withBoardHeight(5)
                .withBoardWidth(5)
                .withTopLeftCornerBoardX(10)
                .withTopLeftCornerBoardY(10)
                .build();

        JFrame jFrame = new JFrame("Game");
        jFrame.setSize(600,600);

        JTextArea textArea = displayTextArea.getTextArea();

        JPanel jPanel = new JPanel();
        jPanel.add(textArea);

        jFrame.add(jPanel);
        jFrame.setVisible(true);

        game.run();
    }
}
package snakegameswing;

import snakegameascii.DisplayAscii;
import javax.swing.*;
import java.awt.*;

public class DisplayTextArea extends DisplayAscii {
    private final JTextArea textArea;

    public DisplayTextArea(int height, int width) {
        super(height, width);
        textArea = new JTextArea();
        textArea.setFont(new Font("Courier New",Font.BOLD, 16));
        textArea.setBounds(0, 0, 450, 450);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    @Override
    public void render() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++)
                result.append(this.getBlocks()[i][j]);

            result.append("\n");
        }

        textArea.setText(result.toString());
    }
}

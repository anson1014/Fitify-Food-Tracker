package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TextClass extends JPanel {

    private JTextArea textArea;

    public TextClass() {
        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void appendText(String text) {
        textArea.append(text);
    }

    public void clear() {
        textArea.setText(null);
    }

}

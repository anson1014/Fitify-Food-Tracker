package ui.addfood;

import exceptions.Negative;
import ui.mainframe.Main;
import ui.mainframe.MainFrame;
import ui.mainframe.ProgressBarToolBar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static ui.mainframe.MainFrame.displayOut;

public class AddFoodFrame extends JFrame implements ActionListener {

    AddFoodToolBar addFoodToolBar;
    MainFrame mainFrame;
    JLabel question;
    JPanel titlePanel;
    JButton setLimit;
    ProgressBarToolBar progressBarToolBar;

    public AddFoodFrame() throws IOException {

        super("Add Food");
        setVisible(true);
        setLayout(new BorderLayout());
        addFoodToolBar = new AddFoodToolBar();

        titlePanel = new JPanel();

        question = new JLabel();
        question.setText("What type of Food are you adding?");
        question.setFont(new Font("Aria", Font.BOLD, 20));

        titlePanel.add(question);

        setLimit = new JButton("Set a Limit.");
        setLimit.addActionListener(this);

        add(setLimit, BorderLayout.SOUTH);
        add(titlePanel, BorderLayout.NORTH);
        add(addFoodToolBar, BorderLayout.CENTER);
        pack();
        this.setLocationRelativeTo(mainFrame);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Double limit = Double.parseDouble(JOptionPane.showInputDialog("Set a Limit for your Cheat Foods / Alcohol"));
        try {
            Main.foodMap.setLimit(limit);
            displayOut("New limit set!", "Success!");
            MainFrame.progressBarToolBar.setMaxLimit((int) Main.foodMap.getLimit());

        } catch (Negative negative) {
            displayOut("You can't have a negative limit!", "Error!");
        }
    }


}

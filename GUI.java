import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel[][] panels;
    private JLabel[][] labels;

    public GUI() {
        setTitle("2048");
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(4, 4));
        panels = new JPanel[4][4];
        labels = new JLabel[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setLayout(new BorderLayout());

                labels[i][j] = new JLabel("");
                panels[i][j].add(labels[i][j], BorderLayout.CENTER);

                mainPanel.add(panels[i][j]);
            }
        }

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public void updateText(int row, int col, int value) {
        labels[row][col].setText(Integer.toString(value));
    }
}

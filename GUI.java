import javax.swing.*;
import java.awt.*;

public class GridExample extends JFrame {
    private JPanel[][] panels;
    private JLabel[][] labels; // 2D array to store references to JLabel instances

    public GridExample() {
        setTitle("4x4 Grid Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(4, 4));
        panels = new JPanel[4][4];
        labels = new JLabel[4][4]; // Initialize the array

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setLayout(new BorderLayout());

                labels[i][j] = new JLabel("Label " + (i * 4 + j + 1)); // Example label text
                panels[i][j].add(labels[i][j], BorderLayout.CENTER);

                mainPanel.add(panels[i][j]);
            }
        }

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    // Method to update the text of a label at a specific position
    public void updateLabelText(int row, int col, String newText) {
        labels[row][col].setText(newText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GridExample gridExample = new GridExample();
            // Example of updating the text of a label at position (0, 0)
            gridExample.updateLabelText(0, 0, "New Text");
        });
    }
}

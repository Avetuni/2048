import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Handler implements KeyListener {
    private static GUI gui = new GUI();
    private static Spielfeld feld = new Spielfeld();

    public static void main(String[] args) {
        Handler keyListener = new Handler();
        gui.addKeyListenerToPanel(keyListener);
        update();
    }

    static void update() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                feld.resetMerge(i, j);
                gui.updateText(i, j, feld.getBlockValue(i, j));
            }
        }
    }

    public void checkForNeighboringDuplicates() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int currentValue = feld.getBlockValue(row, col);

                if (col < 3 && currentValue == feld.getBlockValue(row, col + 1)) {
                    return;
                }

                if (row < 3 && currentValue == feld.getBlockValue(row + 1, col)) {
                    return;
                }
            }
        }
        System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                feld.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                feld.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                feld.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                feld.moveRight();
                break;
        }
        if (!feld.newBlock(2)) {checkForNeighboringDuplicates();}
        update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

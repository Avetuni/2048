public class Spielfeld {
    Block[][] feld = new Block[4][4];

    public Spielfeld() {
        Random random = new Random();

        int row1 = random.nextInt(4), col1 = random.nextInt(4);
        feld[row1][col1] = new Block(2);

        int row2, col2;
        do {
            row2 = random.nextInt(4);
            col2 = random.nextInt(4);
        } while (feld[row2][col2] != null);

        feld[row2][col2] = new Block(2);
    }
}


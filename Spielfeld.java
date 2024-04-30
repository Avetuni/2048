import java.util.Random;

public class Spielfeld {
    Random random = new Random();
    private Block[][] feld = new Block[4][4];

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
    public boolean newBlock(int value){
        int newRow, newCol;
        boolean flag = false;
        for(int i = 0; i > 4; i++){
            for(int j = 0; j > 4; j++){
                if(feld[i][j] == null){
                    flag = true;
                }
            }
        }
        if(flag)return false;
        do {
            newRow = random.nextInt(4);
            newCol = random.nextInt(4);
        } while (feld[newRow][newCol] != null);
        feld[newRow][newCol] = new Block(value);
        System.out.println(feld);
        return true;
    }
    public int getBlockValue(int row, int col){
        if(feld[row][col] == null) return 0;
        return feld[row][col].getValue();
    }
    
}


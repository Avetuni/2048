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
    public void resetMerge(int row, int col){
        if(feld[row][col] != null){
            feld[row][col].resetMerge();
        }
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
    public void moveUp() {
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (feld[i][j] != null) {
                    for (int l = i - 1; l >= 0; l--) {
                        if (feld[l][j] == null) {
                            feld[l][j] = feld[l + 1][j];
                            feld[l + 1][j] = null;
                        } else if (feld[l][j].getValue() == feld[l + 1][j].getValue() && !feld[l][j].checkMerged() && !feld[l + 1][j].checkMerged()) {
                            feld[l][j].updateValue();
                            feld[l + 1][j] = null;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void moveDown() {
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                if (feld[i][j] != null) {
                    for (int l = i + 1; l < 4; l++) {
                        if (feld[l][j] == null) {
                            feld[l][j] = feld[l - 1][j];
                            feld[l - 1][j] = null;
                        } else if (feld[l][j].getValue() == feld[l - 1][j].getValue() && !feld[l][j].checkMerged() && !feld[l - 1][j].checkMerged()) {
                            feld[l][j].updateValue();
                            feld[l - 1][j] = null;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (feld[i][j] != null) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (feld[i][k] == null) {
                            feld[i][k] = feld[i][k + 1];
                            feld[i][k + 1] = null;
                        } else if (feld[i][k].getValue() == feld[i][k + 1].getValue() && !feld[i][k].checkMerged() && !feld[i][k + 1].checkMerged()) {
                            feld[i][k].updateValue();
                            feld[i][k + 1] = null;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void moveRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (feld[i][j] != null) {
                    for (int k = j + 1; k < 4; k++) {
                        if (feld[i][k] == null) {
                            feld[i][k] = feld[i][k - 1];
                            feld[i][k - 1] = null;
                        } else if (feld[i][k].getValue() == feld[i][k - 1].getValue() && !feld[i][k].checkMerged() && !feld[i][k - 1].checkMerged()) {
                            feld[i][k].updateValue();
                            feld[i][k - 1] = null;
                            break;
                        }
                    }
                }
            }
        }
    }    
}


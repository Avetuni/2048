public class Block {
    private int value;
    private boolean merged;

    public Block(int initValue) {
        value = initValue;
    }

    public int getValue() {
        return value;
    }
    public void resetMerge(){
        merged = false;
    }
    public boolean checkMerged(){
        return merged;
    }
    public void updateValue(){
        merged = true; 
        value=value*2;
    }
}
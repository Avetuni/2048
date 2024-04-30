public class Block {
    private int value;
    private bool merged;

    public Block(int initValue) {
        value = initValue;
    }

    public int getValue() {
        return value;
    }
    public void resetMerge(){
        merged = false;
    }
    public void updateValue(boolean combined){
        if(combined)merged = true; value*2;
    }
}

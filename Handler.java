public class Handler {
    private static GUI gui = new GUI();
    private static Spielfeld feld = new Spielfeld();
    public static void main(String[] args) {
        System.out.println("Trying to update");
        update();
    }
    static void update(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                gui.updateText(i, j, feld.getBlockValue(i, j));
            }
        }
    }
}

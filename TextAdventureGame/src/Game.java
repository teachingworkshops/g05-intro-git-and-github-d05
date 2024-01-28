public class Game {
    private Player[] players = {null, null, null, null}; //array of all players that we're passed by main
    private int[] x_coord; //
    private int[] y_coord;
    private  int[][] prev_coords = new int[5][5];
    private int rows = 5;
    private int col = 5;

    public Game(Player[] p){
        for(int i = 0; i < p.length; i++){
            if ( !p[ i ].getName().equals( "" ) ){
                this.players[i] = p[i];
            }
            
        }

        for (int i = 0; i<rows; i++)
        for (int j = 0; j<col; j++)
        this.prev_coords[i][j] = 0;
        
    }

    public void printMap(){
        System.out.println("0 = UNDISCOVERED     X = DISCOVERED     W = YOUR CURRENT LOCATION");
        System.out.println("-----------------");
        for (int i = 0; i<rows; i++) {
        for (int j = 0; j<col; j++) {
         System.out.print(prev_coords[i][j] + "   ");
        }
        System.out.println();
        System.out.println("-----------------");
        }
    }

}

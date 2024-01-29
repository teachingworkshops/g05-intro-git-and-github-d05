import java.util.Scanner;

public class Game {

    private Player[] players = {null, null, null, null}; //array of all players that we're passed by main
    private String[][] coords = new String[7][7]; // for map and keeping track of old coordinates
    private int rows = 7;
    private int col = 7;
    private int x;
    private int y;

    public Game(Player[] p){
        for(int i = 0; i < p.length; i++){
            if ( !p[ i ].getName().equals( "" ) ){
                this.players[i] = p[i];
            }
            
        }

        for (int i = 0; i<rows; i++)
        for (int j = 0; j<col; j++)
        this.coords[i][j] = "0";
        this.coords[col/2][rows/2] = "W";
        this.x = col/2;
        this.y = rows/2;
        
    }

    public void printMap(){
        System.out.println("0 = UNDISCOVERED     X = DISCOVERED     W = YOUR CURRENT LOCATION");
        System.out.println();
        for (int i = 0; i<rows; i++) {
        for (int j = 0; j<col; j++) {
         System.out.print(coords[j][i] + "   ");
        }
        System.out.println();
        System.out.println();
        }
    }

    public void move(){
        Scanner in = new Scanner( System.in ) ;
        String mov = " ";

        System.out.println("WHICH WAY WOULD YOU LIKE TO MOVE: ");
        if(y != (rows - 1)){
            System.out.print("DOWN, ");
        }
        if(y != 0){
            System.out.print("UP, ");
        }
        if(x != 0){
            System.out.print("LEFT, ");
        }
        if(x != (col - 1)){
            System.out.print("RIGHT: ");
        }    
        
        mov = in.next();
        moveHelper(mov);

    }

    public void moveHelper(String move){
        int a,b;
        a = x;
        b = y;
        switch(move.toLowerCase()) {
            case "down":
                if(y != (rows - 1)){
                    coords[a][b] = "X";
                    y++;
                    coords[x][y] = "W";
                    printMap();
                }else{
                    System.out.println("OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            case "up":
                if(y != 0){
                    coords[a][b] = "X";
                    y--;
                    coords[x][y] = "W";
                    printMap();
                }else{
                    System.out.println("OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            case "left":
                if(x != 0){
                    coords[a][b] = "X";
                    x--;
                    coords[x][y] = "W";
                    printMap();
                }else{
                    System.out.println("OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            case "right":
                if(x != (col - 1)){
                    coords[a][b] = "X";
                    x++;
                    coords[x][y] = "W";
                    printMap();
                }else{
                    System.out.println("OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            default:
                System.out.println("INVALID MOVE: " + move);
                move();
        }
    }




}

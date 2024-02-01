import java.util.Scanner;
import java.util.Random;
public class Game {

    private Player[] players = {null, null, null, null}; //array of all players that we're passed by main
    private String[][] coords = new String[7][7]; // for map and keeping track of old coordinates
    private Room[][] roomMap = new Room[7][7]; // map for all the rooms of the dungeon
    private int rows = 7;
    private int col = 7;
    private int x;
    private int y;
    private Random r = new Random();

    public Game(Player[] p){
        for(int i = 0; i < p.length; i++){
            if ( !(p[ i ].getName() == null) ){
                this.players[i] = p[i];
            }
            
        }

        for (int i = 0; i<rows; i++)
        for (int j = 0; j<col; j++)
        this.coords[i][j] = "0";
        this.coords[col/2][rows/2] = "W";
        this.x = col/2;
        this.y = rows/2;
        int xBoss = r.nextInt(2);
        int yBoss = r.nextInt(2);

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<col; j++){
                if(yBoss == 1)
                    yBoss = 6;
                if(xBoss == 1)
                    xBoss = 6;
                if(i == xBoss && j == yBoss){
                    this.roomMap[i][j] = new Room("Boss");
                }
                else{
                this.roomMap[i][j] = new Room();
                }
            }
        }        
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
                    System.out.println("Entering: " + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter(roomMap[x][y]);
                    }
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
                    System.out.println("Entering: " + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter(roomMap[x][y]);
                    }
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
                    System.out.println("Entering: " + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter(roomMap[x][y]);
                    }
                }else{
                    System.out.println("OUT OF BOUNDS! TRY AGAIN");
                    move();
                }
                break;
            case "right":
                if(x != (col - 1)){
                    coords[a][b] = "X";
                    x++;
                    coords[x][y] = "W";
                    System.out.println("Entering: " + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter(roomMap[x][y]);
                    }
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

    public void look(Player[] p){
        roomMap[x][y].look(p);
    }

    public void encounter(Room room){
        clearScreen();
        Enemy x;
        if(room.getRoom() == "Dungeon Door"){
            int enem = r.nextInt(5) + 10;
            x = new Enemy( enem);
        }
        else{
            x = new Enemy( r.nextInt(11));
        }
        System.out.println("YOU HAVE RAN INTO A " + x.enemyName());
        x.displayEnemyStats();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }



}

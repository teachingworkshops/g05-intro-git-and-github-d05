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
    private int numPlayers = 0;
    
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_YELLOW = "\u001B[36m";
    private String currentLoc = ANSI_GREEN + "W" + ANSI_WHITE;
    private String pastLoc = ANSI_BLUE + "X" + ANSI_WHITE;

    public Game(Player[] p){
        for(int i = 0; i < p.length; i++){
            if ( !(p[ i ].getName() == null) ){
                this.players[i] = p[i];
                numPlayers++;
            }
            
        }

        for (int i = 0; i<rows; i++)
        for (int j = 0; j<col; j++)
        this.coords[i][j] = "0";
        this.coords[col/2][rows/2] = currentLoc;
        this.x = col/2;
        this.y = rows/2;

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<col; j++){
               this.roomMap[i][j] = new Room();
            }
        }        
    }

    public void printMap(){
        System.out.println("0 = UNDISCOVERED     "+ pastLoc +" = DISCOVERED     "+ currentLoc +" = YOUR CURRENT LOCATION");
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

        System.out.println(ANSI_YELLOW + "WHICH WAY WOULD YOU LIKE TO MOVE: ");
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
            System.out.print("RIGHT: " + ANSI_WHITE);
        }    
        
        mov = in.next();
        moveHelper(mov);

    }

    public void gameOver(){
        clearScreen();
        System.out.println("GAME OVER!!!");
        System. exit(0);
    }

    public void moveHelper(String move){
        int a,b;
        a = x;
        b = y;
        switch(move.toLowerCase()) {
            case "down":
                if(y != (rows - 1)){
                    coords[a][b] = pastLoc;
                    y++;
                    coords[x][y] = currentLoc;
                    System.out.println(ANSI_YELLOW + "Entering: " + ANSI_WHITE + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter();
                    }
                }else{
                    System.out.println(ANSI_YELLOW + "OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            case "up":
                if(y != 0){
                    coords[a][b] = pastLoc;
                    y--;
                    coords[x][y] = currentLoc;
                    System.out.println(ANSI_YELLOW + "Entering: " + ANSI_WHITE + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter();
                    }
                }else{
                    System.out.println(ANSI_YELLOW + "OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            case "left":
                if(x != 0){
                    coords[a][b] = pastLoc;
                    x--;
                    coords[x][y] = currentLoc;
                    System.out.println(ANSI_YELLOW + "Entering: " + ANSI_WHITE + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter();
                    }
                }else{
                    System.out.println(ANSI_YELLOW + "OUT OF BOUNDS! TRY AGAIN");
                    move();
                }
                break;
            case "right":
                if(x != (col - 1)){
                    coords[a][b] = pastLoc;
                    x++;
                    coords[x][y] = currentLoc;
                    System.out.println(ANSI_YELLOW + "Entering: " + ANSI_WHITE + roomMap[x][y].getRoom());
                    printMap();
                    if(roomMap[x][y].hasEnemy){
                        encounter();
                    }
                }else{
                    System.out.println(ANSI_YELLOW + "OUT OF BOUNDS! TRY AGAIN" );
                    move();
                }
                break;
            default:
                System.out.println(ANSI_YELLOW + "INVALID MOVE: " + ANSI_WHITE + move);
                move();
        }
    }

    public void look(Player[] p){
        roomMap[x][y].look(p);
    }

    public void encounter(){
        clearScreen();

        Enemy x = new Enemy( r.nextInt(14));

        System.out.println("YOU HAVE RAN INTO A " + x.enemyName());
        x.displayEnemyStats();
        System.out.println();

        while(x.isAlive()){
            String move = "";
            Scanner input = new Scanner(System.in);
            for(int i  = 0; i%numPlayers < players.length;i++){

                players[i%numPlayers].combatStats();
                System.out.println();
                System.out.println("WHAT WOULD YOU LIKE TO DO?(ATTACK OR DRINK)");
                move = input.next();

                switch(move.toLowerCase()){
                    case "attack":
                    players[i%numPlayers].attack();
                    x.takeDamage(players[i%numPlayers].getAtk() + players[i%numPlayers].getmAtk());
                    break;
                    case "drink":
                    players[i%numPlayers].usePotion();
                    break;
                    default:
                    System.out.println("INVALID INPUT, TRY AGAIN!");
                    i--;
                    continue;
                }
                if(!x.isAlive()){

                    break;
                }
                x.attack();
                players[i%numPlayers].takeDamage(x.atk);
                if(players[i%numPlayers].getCurrent_Hp() == 0){
                    players[i%numPlayers] = null;
                }
                if(players[0]==null &&players[1]==null &&players[2]==null &&players[3]==null ){
                    gameOver();
                }
            }
        }
        
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }



}

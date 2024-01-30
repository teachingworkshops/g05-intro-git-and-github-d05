import java.util.Scanner;

public class App {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) throws Exception {

        int numOfPlayers = 0;
        String[] names = new String[] { null, null, null, null } ;
        

        Scanner input = new Scanner( System.in ) ;
        while ( numOfPlayers < 1 || numOfPlayers > 4 )
            {
            System.out.print( "HOW MANY PLAYERS("+ ANSI_RED +"1-4 PLAYERS"+ANSI_WHITE+"): " ) ;

            numOfPlayers = input.nextInt() ;
            if ( numOfPlayers > 4 || numOfPlayers < 1 )
                {
                System.out.println( "INVALID NUMBER OF PLAYERS("+ANSI_RED+"1-4 PLAYERS ALLOWED!"+ANSI_WHITE+")" ) ;
                }
            }
        
        for ( int i = 0 ; i < numOfPlayers ; i++ ){
            System.out.print( "ENTER PLAYER " + ( i + 1 ) + " NAME: " ) ;
            names[ i ] = input.next() ;
            }
        System.out.println() ;

        Player one = new Player( names[ 0 ] ) ;
        Player two = new Player( names[ 1 ] ) ;
        Player three = new Player( names[ 2 ] ) ;
        Player four = new Player( names[ 3 ] ) ;

        Player[] players = {one, two, three, four};

        for(int i = 0; i < players.length; i++)
        {
            if ( !(players[ i ].getName() == null) )
            {
                players[i].displayPlayerStats();
                System.out.println("CHOOSE A CLASS("+ANSI_RED+"FIGHTER, WIZARD, BARBARIAN"+ANSI_WHITE+"): ");
                // Set player class to "wizard" and race to "elf"
                players[i].setClass(input.next());
                System.out.println("CHOOSE A RACE("+ANSI_RED+"ELF, DWARF, ORC"+ANSI_WHITE+"): ");
                players[i].setPlayerRace(input.next());
                players[i].displayPlayerStats();
                System.out.println();

                
            }
        }
        Game g = new Game(players);
        while(players[0].isAlive() || players[1].isAlive() || players[2].isAlive() || players[3].isAlive() ){ //if at least one player is alive
            for(int j = 0; j%3 < players.length; j++){  //loop through all the players
                if ( !players[ j%3 ].isAlive() ){   //if the player isnt alive, change their name
                    players[j%3].setName("");
                }
                if ( (players[ j%3 ].getName() == null) ) {  //if their name is empty, that means they never existed or they died, so we skip them
                    continue;
                }
                System.out.println();
                System.out.println("-----------------------------");
                System.out.println( (players[ j%3 ].getName()).toUpperCase());

                int x = 0;
                do{
                    System.out.println("WHAT WOULD YOU LIKE TO DO ("+ANSI_RED+"MOVE, STATS, STORAGE, DRINK, MAP, OR LOOK"+ANSI_WHITE+"): ");
                    String in = input.next();
                    switch(in.toLowerCase()){
                        case "move":
                            g.move();
                            x = 1;
                            break;

                        case "stats":
                            players[j%3].displayPlayerStats();
                            break;

                        case "map":
                        g.printMap();
                        break;

                        case "storage":
                        //write code for storage
                        players[j%3].printInventory();
                        break;

                        case "look":
                        g.look(players);
                        break;

                        case "drink":
                        players[j%3].usePotion();
                        break;

                        default:
                        System.out.println("INVALID INPUT,TRY AGAIN!");
                    }
                }while(x != 1 );

            }
        }
        
    }

}

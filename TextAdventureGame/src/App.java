import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int numOfPlayers = 0;
        String[] names = new String[] { null, null, null, null } ;
        

        Scanner input = new Scanner( System.in ) ;
        while ( numOfPlayers < 1 || numOfPlayers > 4 )
            {
            System.out.print( "HOW MANY PLAYERS(1-4 PLAYERS): " ) ;
            numOfPlayers = input.nextInt() ;
            if ( numOfPlayers > 4 || numOfPlayers < 1 )
                {
                System.out.println( "INVALID NUMBER OF PLAYERS(1-4 PLAYERS ALLOWED!)" ) ;
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
                System.out.println("CHOOSE A CLASS(FIGHTER, WIZARD, BARBARIAN): ");
                // Set player class to "wizard" and race to "elf"
                players[i].setClass(input.next());
                System.out.println("CHOOSE A RACE(ELF, DWARF, ORC): ");
                players[i].setPlayerRace(input.next());
                players[i].displayPlayerStats();
                System.out.println();

                
            }
        }
        System.out.printf("You awake, head pounding, in a dimly lit prison cell.%nThe door has been torn off of its hinges, and your equipment lies neatly outside.%nAFter gathering your gear, you try to remember how you got here, and are met with hazy memories of an ambush.%nNo sign of your captors. Might as well start trying to find a way out.%n\n");
        Game g = new Game(players);
        g.printMap();
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
                    System.out.println("WHAT WOULD YOU LIKE TO DO (MOVE, STATS, STORAGE, DRINK, MAP, OR LOOK): ");
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

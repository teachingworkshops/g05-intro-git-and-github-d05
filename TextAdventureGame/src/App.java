import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int numOfPlayers = 0;
        String[] names = new String[] { "", "", "", "" } ;
        

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
            if ( !players[ i ].getName().equals( "" ) )
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
        
    }
}

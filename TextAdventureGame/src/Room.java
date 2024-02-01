import java.util.Random;
import java.util.Scanner;

public class Room {
    
//    private boolean wasHere = false;
    private String roomName = "";
    private String currentRoomName = "Unknown Room";
    private Random r = new Random();
    private int randomRoomNum;
    private boolean usedRoom = false;
    public boolean hasEnemy = false;
    private int counter = 0;

     Scanner input = new Scanner( System.in ) ;
    public Room(){
        createRoom();
    }

    public Room(String boss){
        createBoss();
    }

    public String getRoom(){
        return this.currentRoomName;
    }

    public void look(Player[] p){
        if(currentRoomName != roomName){
            this.currentRoomName = this.roomName;
            System.out.println("You have discovered: " + getRoom());
        }
        if(usedRoom == false && currentRoomName == "Item Room"){
            usedRoom = true;
            for(int y = 0; y < p.length;y++){
                if(p[ y ].getName()== null){
                    continue;
                }
                Item i = new Item();
                p[y].addItems(i);
                System.out.println(p[y].getName());
                System.out.println("You have found: " + i.getName());
                
                if(i.getName() != "Potion"){
                    System.out.println("Adding " + i.getAmount() + " to " + i.getMod());
                    System.out.println();

                }
                else{
                    System.out.println("Adding Potion to Inventory!");
                }
            }
            
            
            //gives player an item
        }
        else if(usedRoom == false && currentRoomName == "Campfire Room"){
            usedRoom = true;
            for(int x = 0; x < p.length;x++){
                if(!(p[x].playerName == null)) {
                    p[x].add_Hp(10);
                }
                
            }
            //heals the player
        }
        else if(usedRoom == false && currentRoomName == "Prison Cell"){
            usedRoom = true;
            //Chance to speak to someone
            int random = r.nextInt(100);
            
            if(random<50){
                System.out.println("NO PRISONERS SEEM TO BE HERE...");
            }
            else{
                System.out.println("THERE IS A MAN CHAINED TO THE WALLS, DO YOU WANT TO SPEAK TO HIM?(Y/N)");
                switch((input.next()).toLowerCase()){
                    case ("y"):
                    int rand = r.nextInt(100);
                    if(rand < 35){
                        System.out.println("PRISONER: \nMAKE SURE TO 'LOOK' IN EVERY ROOM YOU ENTER!\n");
                    }
                    else if(rand < 75){
                        System.out.println("PRISONER: \nI'VE HEARD THE EXIT IS ONLY IN ONE OF THE FOUR CORNERS OF THE DUNGEON\n");
                    }
                    else{
                        System.out.println("PRISONER: \n ...\n");
                    }
                    break;
                    case("n"):
                    break;

                    default:
                    System.out.println("INVALID INPUT, YOU'VE IGNORED THE PRISONER!");
                }
            }
        }
        else if(usedRoom == false && currentRoomName == "Empty Room"){
            usedRoom = true;
            //Chance to find a lore note
            int rand = r.nextInt(100);
            if(rand < 50) {
                System.out.println("YOU HAVE FOUND A NOTE. READ IT? (Y/N)");
                switch((input.next()).toLowerCase()) {
                    case("y"):
                        int rand2 = r.nextInt(100);
                        if(rand2 < 35) {
                            System.out.printf("\"We've been wandering in circles for days.%nEvery time we reach the bounds of the dungeon, we're forced out by a horrible monster.%nWe've yet to find another way out. I pray that beast isn't protecting the only exit.\"%n");
                        } else if (rand2 < 70) {
                            System.out.printf("\"To Warden Daedron,%nWe must evacuate posthaste. The encroaching monsters and undead armies make further residence here impossible.%nWhile it is a shame we will not be able to further... *interrogate* the newest prisoners we've brought in,%nwe'll at least be able to harvest their materials for the empire once the monsters clear out.%nYours,%nChancellor Markos\"%n");
                        } else {
                            System.out.printf("*The text is rendered illegible by damage and age.%nYou're only able to make out something about a \"necromancer\" and a \"time loop\"%n.");
                        }
                    case("n"):
                        break;
                    default:
                        System.out.println("INVALID INPUT, YOU'VE IGNORED THE NOTE!");
                }
            }
            } else{
                System.out.println("You have already looked in this room");
            }
        }
    

    private void createRoom(){
        randomRoomNum = r.nextInt(100);
        if(randomRoomNum%6 == 0){
            hasEnemy = true;
        }

        if(randomRoomNum < 20){
            this.roomName = "Item Room"; //When using the look command in this room, you will gain an item
        }
        else if(randomRoomNum < 40){
            this.roomName = "Campfire Room"; //when using look command in this room, you will gain health again
        }
        else if(randomRoomNum < 55){
            this.roomName = "Prison Cell"; //when using look command in this room, you will have the chance to speak to a prisoner

        }
        else if(randomRoomNum < 100){
            this.roomName = "Empty Room"; //when using the look command in this room, nothing will happen.
        }
    }

    private void createBoss(){
        hasEnemy = true;
        this.roomName = "Dungeon Door";
        this.currentRoomName = "Dungeon Door";
    }
}

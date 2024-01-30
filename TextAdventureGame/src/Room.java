import java.util.Random;

public class Room {
    
//    private boolean wasHere = false;
    private String roomName = "";
    private String currentRoomName = "Unknown Room";
    private Random r = new Random();
    private int randomRoomNum;
    private boolean usedRoom = false;


    public Room(){
        createRoom();
    }

    public String getRoom(){
        return this.currentRoomName;
    }

    public void look(Player p){
        if(currentRoomName != roomName){
            this.currentRoomName = this.roomName;
            System.out.println("You have discovered: " + getRoom());
        }
        if(usedRoom == false && currentRoomName == "Item Room"){
            usedRoom = true;
            Item i = new Item();
            p.addItems(i);
            System.out.println("You have found: " + i.getName());
            if(i.getName() != "Potion"){
                System.out.println("Adding " + i.getAmount() + " to " + i.getMod());
            }
            else{
                System.out.println("Adding Potion to Inventory!");
            }
            //gives player an item
        }
        else if(usedRoom == false && currentRoomName == "Campfire Room"){
            usedRoom = true;
            p.setCurrent_Hp(10);
            //heals the player
        }
        else if(usedRoom == false && currentRoomName == "Prison Cell"){
            usedRoom = true;
            //Chance to speak to someone
        }
        else if(usedRoom == false && currentRoomName == "Empty Room"){
            usedRoom = true;
        }
        else{
            System.out.println("You have already looked in this room");
        }
    }

    private void createRoom(){
        randomRoomNum = r.nextInt(100);
        if(randomRoomNum < 10){
            this.roomName = "Item Room"; //When using the look command in this room, you will gain an item
        }
        else if(randomRoomNum < 30){
            this.roomName = "Campfire Room"; //when using look command in this room, you will gain health again
        }
        else if(randomRoomNum < 50){
            this.roomName = "Prison Cell"; //when using look command in this room, you will have the chance to speak to a prisoner
        }
        else if(randomRoomNum < 100){
            this.roomName = "Empty Room"; //when using the look command in this room, nothing will happen.
        }
    }
}

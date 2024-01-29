import java.util.Random;

public class Room {
    
//    private boolean wasHere = false;
    private String roomName = "";
    private String currentRoomName = "Unknown Room";
    private Random r = new Random();
    private int randomRoomNum;


    public Room(){
        createRoom();
    }

    public String getRoom(){
        return this.currentRoomName;
    }

    public String look(){
        this.currentRoomName = this.roomName;
        return getRoom();
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
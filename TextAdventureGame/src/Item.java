import java.util.Random;

public class Item {
    
    private Random r = new Random();
    private String name;
    private int amount;
    private String mod;
    private int randomItemNum;

    public Item(){
        createItem();
    }

    private void createItem(){
        randomItemNum = r.nextInt(100);
        if(randomItemNum < 10){
            this.name = "Sword";
            this.amount = 10; 
            this.mod = "ATK";
        }
        else if(randomItemNum < 30){
            this.name = "Boots"; 
            this.amount = 10;
            this.mod = "STM";
        }
        else if(randomItemNum < 50){
            this.name = "Armor"; 
            this.amount = 10;
            this.mod = "DEF";
        }
        else if(randomItemNum < 100){
            this.name = "Potion"; 
            this.amount = 10;
        }
    }

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public String getMod(){
        return mod;
    }
}

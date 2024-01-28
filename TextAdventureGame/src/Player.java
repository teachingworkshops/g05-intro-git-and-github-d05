

/**
 * The Player class represents a character in a game with various attributes
 */
public class Player {
    //Default attributes
    private int max_Hp = 30;
    private int current_Hp = 30;
    private int atk = 10;
    private int def = 6;
    private int stm = 10;
    private int mAtk = 0;

    private String playerClass = "";
    private String playerRace = "Human";

    private boolean isAlive = true;

    /**
     * Default constructor for the Player class.
     * Initializes the player with default attributes.
     */
    public Player(){
        this.max_Hp = 30;
        this.current_Hp = 30;
        this.atk = 10;
        this.def = 6;
        this.stm = 10;
        this.mAtk = 0;

        this.playerClass = ""; 
        this.playerRace = "Human";
        this.isAlive = true;
    }

    //_________Getter methods___________________________________________________
    public int getMax_Hp() {
        return max_Hp;
    }
    public int getCurrent_Hp() {
        return current_Hp;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public int getStm() {
        return stm;
    }
    public int getmAtk() {
        return mAtk;
    }
    public String getPlayerClass() {
        return playerClass;
    }
    public String getPlayerRace() {
        return playerRace;
    }

    /**
     * Check if the player is alive based on their current health.
     * @return true if the player is alive, false otherwise.
     */
    public boolean isAlive() {
        if (current_Hp <= 0) {
            isAlive = false; 
        }
        return isAlive;
    }
    //_________________________________________________________________________


    //_______Setter methods____________________________________________________
    /**
     * Set the maximum health of the player.
     * @param max_Hp Max hp value added/decreased by.
     */
    public void setMax_Hp(int max_Hp) {
        this.max_Hp += max_Hp;
    }
    /**
     * Set the maximum health of the player.
     * @param value current hp value added/decreased by.
     */
    public void setCurrent_Hp(int value) {
        this.current_Hp += current_Hp;
    }
    /**
     * Set the maximum health of the player.
     * @param atk atk value added/decreased by.
     */
    public void setAtk(int atk) {
        this.atk += atk;
    }
    /**
     * Set the maximum health of the player.
     * @param def def value added/decreased by.
     */
    public void setDef(int def) {
        this.def += def;
    }
    /**
     * Set the maximum health of the player.
     * @param stm stm value added/decreased by.
     */
    public void setStm(int stm) {
        this.stm += stm;
    }
    /**
     * Set the maximum health of the player.
     * @param mAtk mAtk value added/decreased by.
     */
    public void setmAtk(int mAtk) {
        this.mAtk += mAtk;
    }
    //_____________________________________________________________________

    /**
     * Set the player's class and apply corresponding modifiers.
     * @param playerClass The player's class ("fighter", "wizard", "barbarian").
     */
    public void setStat (String playerClass){
        this.playerClass = playerClass;
        
        switch (playerClass.toLowerCase()) {
            case "fighter":
                this.atk += 3;
                this.def += 4;
                this.max_Hp += 20;
                this.current_Hp += 20;
                this.mAtk = 0;
                break;
            case "wizard":
                this.atk += 1;
                this.def += 2;
                this.max_Hp += 15;
                this.current_Hp += 15;
                this.mAtk += 15;
                break;
            case "barbarian":
                this.atk += 5;
                this.def += 2;
                this.max_Hp += 25;
                this.current_Hp += 25;
                this.mAtk = 0;
                break;
            default:
                // No changes for unknown class
                break;

         }
    }

    /**
     * Set the player's race and apply corresponding modifiers.
     * @param playerRace The player's race ("elf", "orc", "dwarf").
     */
    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;

        // Apply race modifiers
        switch (playerRace.toLowerCase()) {
            case "elf":
                this.mAtk += 2;
                this.max_Hp -= 5;
                this.current_Hp -= 5;
                break;
            case "orc":
                this.def += 2;
                this.max_Hp += 5;
                this.current_Hp += 5;
                break;
            case "dwarf":
                this.max_Hp -= 5;
                this.current_Hp -= 5;
                this.atk += 2;
                break;
            default:
                // No changes for unknown race
                break;
        }
    }

    /**
     * Display the player's statistics.
     * @param player The player whose stats are to be displayed.
     */
    private static void displayPlayerStats(Player player) {
        System.out.println("Player Class: " + player.getPlayerClass());
        System.out.println("Player Race: " + player.getPlayerRace());
        System.out.println("Max HP: " + player.getMax_Hp());
        System.out.println("Current HP: " + player.getCurrent_Hp());
        System.out.println("Attack: " + player.getAtk());
        System.out.println("Defense: " + player.getDef());
        System.out.println("Stamina: " + player.getStm());
        System.out.println("Magic Attack: " + player.getmAtk());
        System.out.println("Is Alive: " + player.isAlive());
        System.out.println("-----------------------------");
    }

    //test
    public static void main(String[] args) {
        // Create a new player
        Player player = new Player();

        // Display initial stats
        displayPlayerStats(player);

        // Set player class to "wizard" and race to "elf"
        player.setStat("wizard");
        player.setPlayerRace("elf");

        // Display updated stats
        displayPlayerStats(player);
    }

}
public class Enemy {
    private int max_Hp = 0;
    private int current_Hp = 0;
    private int atk = 0;
    private int def = 0;

    private String name= "";
    private boolean isAlive = true;

    //Constructor 
    //currently 
    //id 1-10 normal
    //id 11-15 elite
    //* note that they are not super balenced(did it kind of just randomly), I had made it with 1-2 player in mind*/
    //* idk the item stats so change enemy stats as needed */
    //* may need to adjust(add a modifyier) if we have multiple floors */
    //* probaly just modify hp mostly, modify def not that high since we are using flat stats */
    //* Delete later */
    public Enemy(int id){
        switch (id) {
            //normal enemies__________________________________________
            case 1:
                this.name = "Goblin";
                this.max_Hp = 30;
                this.current_Hp = 30;
                this.atk = 8;
                this.def = 4;
                break;
            case 2:
                this.name = "Orc";
                this.max_Hp = 45;
                this.current_Hp = 45;
                this.atk = 12;
                this.def = 6;
                break;
            case 3:
                this.name = "Slime";
                this.max_Hp = 35;
                this.current_Hp = 35;
                this.atk = 7;
                this.def = 4;
                break;
            case 4:
                this.name = "Wraith";
                this.max_Hp = 35;
                this.current_Hp = 35;
                this.atk = 16;
                this.def = 8;
                break;
            case 5:
                this.name = "Zombie";
                this.max_Hp = 25;
                this.current_Hp = 25;
                this.atk = 10;
                this.def = 5;
                break;
            case 6:
                this.name = "Harpy";
                this.max_Hp = 25;
                this.current_Hp = 25;
                this.atk = 10;
                this.def = 5;
                break;
            case 7:
                this.name = "Werewolf";
                this.max_Hp = 35;
                this.current_Hp = 35;
                this.atk = 15;
                this.def = 7;
                break;
            case 8:
                this.name = "Ghost";
                this.max_Hp = 18;
                this.current_Hp = 18;
                this.atk = 5;
                this.def = 2;
                break;
            case 9:
                this.name = "Witch";
                this.max_Hp = 25;
                this.current_Hp = 25;
                this.atk = 14;
                this.def = 6;
                break;
            case 10:
                this.name = "Giant Spider";
                this.max_Hp = 18;
                this.current_Hp = 18;
                this.atk = 7;
                this.def = 4;
                break;
            //Elite enemy_________________________________________________________________
            case 11:
                this.name = "Dragon";
                this.max_Hp = 50;
                this.current_Hp = 50;
                this.atk = 20;
                this.def = 10;
                break;
            case 12:
                this.name = "Vampire";
                this.max_Hp = 40;
                this.current_Hp = 40;
                this.atk = 18;
                this.def = 8;
                break;
            case 13:
                this.name = "Giant";
                this.max_Hp = 60;
                this.current_Hp = 60;
                this.atk = 25;
                this.def = 12;
                break;
            case 14:
                this.name = "Minotaur";
                this.max_Hp = 50;
                this.current_Hp = 50;
                this.atk = 20;
                this.def = 10;
                break;
            case 0:
                this.name = "Cyclops";
                this.max_Hp = 60;
                this.current_Hp = 60;
                this.atk = 25;
                this.def = 12;
            default:
                throw new IllegalArgumentException("Invalid enemy id");
        }
    }

    // Getter Methods
    public boolean isAlive() {
        return isAlive;
    }

    public int getCurrentHp() {
        return current_Hp;
    }


    /**
     * Display attacks to console
     */
    public void attack() {
        System.out.println(name + " attacks for " + atk + " damage!");
    }

    /**
     * Sets current hp of enemy 
     * Display damage taken and current health to console
     * Also if defeated
     * 
     * @param amount damage vale taken
     */
    public void takeDamage(int amount) {
        current_Hp -= amount;
        if (current_Hp <= 0) {
            current_Hp = 0;
            isAlive = false;
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + current_Hp + " health remaining.");
        }
    }

    //Display enemy stats
    public void displayEnemyStats() {
        String text = String.format("%s [HP: %d/%d, ATK: %d, DEF: %d]", name, current_Hp, max_Hp, atk, def);
        System.out.println(text);
    }

    public String enemyName(){
        return this.name;
    }

    //test
    public static void main(String[] args) {
        Enemy goblin = new Enemy(1);
        Enemy orc = new Enemy(2);

        goblin.attack();
        orc.attack();

        goblin.takeDamage(5);
        orc.takeDamage(10);

        goblin.displayEnemyStats();
        orc.displayEnemyStats();

    }

}

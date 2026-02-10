package guild;

/**
 * Represents a monster in the game.
 * A monster has a name, health, attack power, and armor.
 * It can take damage, attack adventurers, and be defeated.
 * 
 * @author Kanan
 */
public class Monster {
    private String name; 
    private int health; 
    private int attack; 
    private int armor;

/**
 * Constructs a new Monster with the specified attributes.
 * 
 * @param name the name of the monster
 * @param health the health of the monster
 * @param attack the attack power of the monster
 * @param armor the armor of the monster
    */



    public Monster(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }


    /**
     * Attacks an adventurer, dealing damage based on the monster's attack power.
     * 
     * @param damage
     */

    public void takeDamage(int damage) {
        int effectiveDamage = Math.max(0, damage - armor);
        health -= effectiveDamage;
    }

    /**
     * Checks if the monster is defeated (health <= 0).
     * 
     * @return true if the monster is defeated, false otherwise
     */
  
    public boolean isDefeated() {
        return health <= 0;
    }

    /**
     * gets the monster's attack power.
     * 
     * @return the attack power of the monster
     */

    public int getAttackPower() {
        return attack;
    }


    /**
     * gets the monster's defense power.
     * 
     * @return the defense power of the monster
     */
    public int getDefense() {
        return armor;
    }

    /**
     * gets the monster's health.
     * 
     * @return the health of the monster
     */

    public int getHealth() {
        return health;
    }

    /**
     * gets the monster's name.
     * 
     * @return the name of the monster
     */

    public String getName() {
        return name;
    }

    /**
     * gets the monster's armor.
     * 
     * @return the armor of the monster
     */

    public int getArmor() {
        return armor;
    }

    
    /**
     * toString method to represent the monster as a string.
     * 
     * @return a string representation of the monster
     */



    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }
}

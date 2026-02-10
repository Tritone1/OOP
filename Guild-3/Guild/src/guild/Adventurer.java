package guild;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an adventurer in the game.
 * An adventurer has a name, health, base power, experience, rank, and an inventory of weapons.
 * They can attack monsters, take damage, and gain experience.
 * 
 * @author Kanan
 */
public class Adventurer {
    private String name; // The name of the adventurer
    private int health; // The current health of the adventurer
    private int maxHealth; // The maximum health of the adventurer
    private int basePower; // The base attack power of the adventurer
    private int experience; // The experience points of the adventurer
    private int rank; // The rank of the adventurer
    public List<Weapon> inventory; // The inventory of weapons
    public List<Quest> completedQuests; // The list of completed quests

   
    /**
     * Constructs a new Adventurer with the specified attributes.
     *
     * @param name the name of the adventurer
     * @param health the health of the adventurer
     * @param basePower the base attack power of the adventurer
     */
    public Adventurer(String name, int health, int basePower) {
        this.name = name;
        this.basePower = basePower;
        this.experience = 0;
        this.rank = 1;
        this.health = health;
        this.maxHealth = health;
        this.inventory = new ArrayList<>();
    }

    /**
     * Adds a weapon to the adventurer's inventory.
     *
     * @param weapon the weapon to add
     */
    public void equipWeapon(Weapon weapon) {
        inventory.add(weapon);
    }

    /**
     * Calculates the total attack power of the adventurer, including weapon boosts and rank bonus.
     *
     * @return the total attack power
     */
    public int calculateAttackPower() {
        int totalWeaponBoost = 0;
        for (Weapon weapon : inventory) {
            if (weapon.isUsable()) {
                totalWeaponBoost += weapon.getBoost();
            }
        }
        int rankBonus = (rank * basePower) / 10;
        return basePower + rankBonus + totalWeaponBoost;
    }

    /**
     * Reduces the adventurer's health by the specified damage.
     *
     * @param damage the damage to take
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Checks if the adventurer is defeated (health <= 0).
     *
     * @return true if the adventurer is defeated, false otherwise
     */
    public boolean isDefeated() {
        return health <= 0;
    }

    /**
     * Restores the adventurer's health to the maximum value.
     */
    public void restoreHealth() {
        health = maxHealth;
    }

    /**
     * Adds experience points to the adventurer and increments rank if necessary.
     *
     * @param exp the experience points to add
     */
    public void gainExperience(int exp) {
        experience += exp;
        if (experience >= rank * 10) {
            incrementRank();
        }
    }

    /**
     * Increments the adventurer's rank and boosts their base power.
     */
    private void incrementRank() {
        rank++;
        basePower *= 1.2;
        experience = 0;
    }
 /**
     * Adds a completed quest to the adventurer's list of completed quests.
     *
     * @param quest the completed quest
     */
    public void addCompletedQuest(Quest quest) {
        completedQuests.add(quest);
    }

    /**
     * Retrieves the list of completed quests.
     *
     * @return the list of completed quests
     */
    public List<Quest> getCompletedQuests() {
        return completedQuests;
    }


    /**
     * Attacks a monster using the adventurer's attack power and equipped weapon.
     * If a weapon is usable, its boost is added to the attack power, and its durability is reduced.
     *
     * @param monster the monster to attack
     */
    public void attackMonster(Monster monster) {
        int damage = calculateAttackPower();
        if (!inventory.isEmpty()) {
            Weapon weapon = inventory.get(0);
            if (weapon.isUsable()) {
                damage += weapon.getBoost();
                weapon.useWeapon();
            }
        }
        monster.takeDamage(damage);
    }

    /**
     * Gets the name of the adventurer.
     * @return the name of the adventurer
     * 
     */

    public String getName() {
        return name;
    }
    /**
     * Gets the current health of the adventurer.
     * @return the current health of the adventurer
     */
    
    public int getHealth() {
        return health;
    }
    
    /**
     * Gets the maximum health of the adventurer.
     * @return the maximum health of the adventurer
     */

    public int getMaxHealth() {
        return maxHealth;
    }
    
    /**
     * Gets the base power of the adventurer.
     * @return the base power of the adventurer
     */
    public int getBasePower() {
        return basePower;
    }
    
    /**
     * Gets the experience points of the adventurer.
     * @return the experience points of the adventurer
     */

    public int getExperience() {
        return experience;
    }

    /**
     * Gets the rank of the adventurer.
     * @return the rank of the adventurer
     */

    public int getRank() {
        return rank;
    }
    
    /**
     * Gets the inventory of weapons of the adventurer.
     * @return the inventory of weapons
     */


    public List<Weapon> getInventory() {
        return inventory;
    }
    

    /**
     * toString method to represent the adventurer.
     * 
     * @return a string representation of the adventurer
     */
    


    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", basePower=" + basePower +
                ", experience=" + experience +
                ", rank=" + rank +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", inventory=" + inventory +
                '}';
    }
}
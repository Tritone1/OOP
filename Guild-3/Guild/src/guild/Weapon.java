package guild;

import java.util.Random;




/**
 * Abstract class representing a weapon in the game.
 * The weapon has a boost, durability, and state.
 * The state can be NEW, USED, DAMAGED, or BROKEN.
 * The weapon can be used to calculate damage based on the monster's armor.
 */

public abstract class Weapon {
    private int boost;
    private int durability;
    private WeaponState state;

   
    /**
     * Constructor to initialize the weapon with a boost and durability.
     *
     * @param boost      The boost value of the weapon.
     * @param durability The durability of the weapon.
     */
   
    public Weapon(int boost, int durability) {
        this.boost = boost;
        this.durability = durability;
        this.state = WeaponState.NEW;
    }

    /**
     * Constructor to initialize the weapon with a boost and a random durability.
     *
     * @param boost The boost value of the weapon.
     */

    public int getBoost() {
        return state == WeaponState.DAMAGED ? (int) (boost * 0.75) : boost;
    }

    /**
     * Get the durability of the weapon.
     * @return The durability of the weapon.
     */

    public int getDurability() {
        return durability;
    }

    /**
     * Get the state of the weapon.
     * @return The state of the weapon.
     */

    public boolean isUsable() {
        return state != WeaponState.BROKEN;
    }

    
    /**
     *  Use the weapon, which decreases its durability.
     * If the durability reaches 0, the weapon becomes broken.
     */

    public void useWeapon() {
        if (durability > 0) {
            durability--;
            updateState();
        }
    }



    /**
     * Repair the weapon if it is broken and the player has enough experience points.
     *
     * @param experiencePoints The experience points of the player.
     */
    public void repair(int experiencePoints) {
        if (state == WeaponState.BROKEN && experiencePoints >= boost) {
            durability = 100;
            state = WeaponState.NEW;
        }
    }

    /**
     * Update the state of the weapon based on its durability.
     */

    private void updateState() {
        if (durability == 0) {
            state = WeaponState.BROKEN;
        } else if (durability < 50) {
            state = WeaponState.DAMAGED;
        } else if (durability < 100) {
            state = WeaponState.USED;
        }
    }

    /**
     * Abstract method to calculate damage based on the monster's armor.
     *
     * @param monsterArmor The armor of the monster.
     * @return The calculated damage.
     */

    public abstract int calculateDamage(int monsterArmor);


    /**
     * Abstract method to get the name of the weapon.
     *
     * @return The name of the weapon.
     */
    public enum WeaponState {
        NEW, USED, DAMAGED, BROKEN
    }
}

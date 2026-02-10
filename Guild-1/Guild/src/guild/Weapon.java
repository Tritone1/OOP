package guild;

/**
 * Represents a weapon used by adventurers.
 */
public class Weapon {
    private int boost; // The attack power increase provided by the weapon
    private int durability; // The number of uses left for the weapon

    // Constructor to initialize the weapon
    public Weapon(int boost, int durability) {
        this.boost = boost;
        this.durability = durability;
    }

    // Method to use the weapon (reduces durability by 1)
    public void useWeapon() {
        if (durability > 0) {
            durability--;
        }
    }

    // Method to check if the weapon is still usable
    public boolean isUsable() {
        return durability > 0;
    }
    // Method to retrieve the weapon's attack boost, returns 0 if the weapon is broken
    public int getBoost() {
        if (isUsable()) {
            return boost;
        } else {
            return 0;
        }
    }

    // Getter for durability (optional, for debugging or testing)
    public int getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "boost=" + boost +
                ", durability=" + durability +
                '}';
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guild;

import java.util.Random;
/**
 *
 * @author Kanan
 */
public class Sword extends Weapon {
    private static final Random random = new Random();
    private static final int BONUS = 10; // Fixed bonus for Sword

    /**
     * Constructs a new Sword with the specified boost and durability.
     *
     * @param boost the attack power boost of the sword
     * @param durability the durability of the sword
     */

    public Sword(int boost, int durability) {
        super(boost, durability);
    }


    /**
     * Uses the sword, reducing its durability.
     */

  @Override
    public int calculateDamage(int monsterArmor) {

        if (!isUsable()) {
            // When broken, only return normal damage (no critical)
            return getBoost()+ BONUS;
        }

        useWeapon();
        int damage = getBoost() + BONUS;

        // 20% chance for a critical hit
        if (isUsable()&&random.nextDouble() < 0.2) {
            damage *= 2;
        }

        return damage;
    }
}


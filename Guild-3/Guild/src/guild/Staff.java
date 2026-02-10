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
public class Staff extends Weapon {
    private static final Random random = new Random();

    /**
     * Constructs a new Staff with the specified boost and durability.
     *
     * @param boost the boost value of the staff
     * @param durability the durability of the staff
     */


    public Staff(int boost, int durability) {
        super(boost, durability);
    }

    /**
     * Uses the staff, reducing its durability by 1.
     */


    @Override
    public int calculateDamage(int monsterArmor) {
        if (random.nextDouble() < 0.25) { // 25% chance to halve monster strength
            useWeapon();
            return getBoost() / 2;
        }
        useWeapon();
        return getBoost();
    }
}
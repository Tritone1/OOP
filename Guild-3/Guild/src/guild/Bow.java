/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guild;

/**
 *
 * @author Kanan
 */
public class Bow extends Weapon {

    /**
     * Constructor for Bow class.
     *
     * @param boost      The attack boost of the bow.
     * @param durability The durability of the bow.
     */

    public Bow(int boost, int durability) {
        super(boost, durability);
    }

    

    @Override
    public int calculateDamage(int monsterArmor) {
        int effectiveArmor = (int) (monsterArmor * 0.7); // Bypass 30% of armor
        useWeapon();
        return Math.max(0, getBoost() - effectiveArmor);
    }
}

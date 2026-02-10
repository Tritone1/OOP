package results;

import guild.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {

    private Weapon weapon;

    @Before
    public void setUp() {
        weapon = new Weapon(20, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals(20, weapon.getBoost());
        assertEquals(5, weapon.getDurability());
    }

    @Test
    public void testUseWeapon() {
        weapon.useWeapon();
        assertEquals(4, weapon.getDurability());
    }

    @Test
    public void testUseWeaponUntilBroken() {
        for (int i = 0; i < 5; i++) {
            weapon.useWeapon();
        }
        assertEquals(0, weapon.getDurability());
        assertFalse(weapon.isUsable());
    }

    @Test
    public void testIsUsable() {
        assertTrue(weapon.isUsable());
        weapon.useWeapon();
        weapon.useWeapon();
        weapon.useWeapon();
        weapon.useWeapon();
        weapon.useWeapon(); 
        assertFalse(weapon.isUsable());
    }

    @Test
    public void testGetBoost() {
        assertEquals(20, weapon.getBoost());
        for (int i = 0; i < 5; i++) {
            weapon.useWeapon();
        }
        assertEquals(0, weapon.getBoost());
    }

    @Test
    public void testGetDurability() {
        assertEquals(5, weapon.getDurability());
        weapon.useWeapon();
        assertEquals(4, weapon.getDurability());
    }
}
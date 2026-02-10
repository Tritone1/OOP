package results;

import guild.Adventurer;
import guild.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerTest {

    private Adventurer adventurer;

    @Before
    public void setUp() {
        adventurer = new Adventurer("Aragorn", 100, 50);
    }

    @Test
    public void testConstructor() {
        assertEquals("Aragorn", adventurer.getName());
        assertEquals(100, adventurer.getHealth());
        assertEquals(55, adventurer.calculateAttackPower());
    }

    @Test
    public void testEquipWeapon() {
        Weapon weapon = new Weapon(20, 5);
        adventurer.equipWeapon(weapon);
        assertEquals(1, adventurer.getInventory().size());
        assertEquals(weapon, adventurer.getInventory().get(0));
    }

    @Test
    public void testCalculateAttackPower() {
        Weapon weapon = new Weapon(30, 3);
        adventurer.equipWeapon(weapon);
        assertEquals(85, adventurer.calculateAttackPower()); 
    }

    @Test
    public void testTakeDamage() {
        adventurer.takeDamage(30);
        assertEquals(70, adventurer.getHealth());
    }

    @Test
    public void testIsDefeated() {
        adventurer.takeDamage(100);
        assertTrue(adventurer.isDefeated());
    }

    @Test
    public void testRestoreHealth() {
        adventurer.takeDamage(50);
        adventurer.restoreHealth();
        assertEquals(100, adventurer.getHealth());
    }

    @Test
    public void testGainExperienceAndRankUp() {
        adventurer.gainExperience(10);
        assertEquals(2, adventurer.getRank());
        assertTrue(adventurer.calculateAttackPower() > 50); 
    }

    @Test
    public void testIncrementRank() {
        adventurer.gainExperience(20); 
        assertEquals(2, adventurer.getRank());
        assertTrue(adventurer.calculateAttackPower() > 50); 
    }
}
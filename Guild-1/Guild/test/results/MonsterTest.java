package results;

import guild.Monster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {

    private Monster monster;

    @Before
    public void setUp() {
        monster = new Monster("Goblin", 50, 20, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals("Goblin", monster.getName());
        assertEquals(50, monster.getHealth());
        assertEquals(20, monster.getAttackPower());
        assertEquals(5, monster.getDefense());
    }

    @Test
    public void testTakeDamage() {
        monster.takeDamage(30); 
        assertEquals(25, monster.getHealth()); 
    }

    @Test
    public void testTakeDamageWithOverkill() {
        monster.takeDamage(55);
        assertEquals(0, monster.getHealth()); 
    }

    @Test
    public void testIsDefeated() {
        monster.takeDamage(100); 
        assertTrue(monster.isDefeated());
    }

    @Test
    public void testIsNotDefeated() {
        monster.takeDamage(30);
        assertFalse(monster.isDefeated());
    }

    @Test
    public void testGetAttackPower() {
        assertEquals(20, monster.getAttackPower());
    }

    @Test
    public void testGetDefense() {
        assertEquals(5, monster.getDefense());
    }

    @Test
    public void testGetName() {
        assertEquals("Goblin", monster.getName());
    }

    @Test
    public void testGetHealth() {
        assertEquals(50, monster.getHealth());
    }
}
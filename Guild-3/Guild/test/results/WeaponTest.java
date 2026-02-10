package results;

import guild.Sword;
import guild.Bow;
import guild.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {

    private Sword sword;
    private Bow bow;
    private Staff staff;

    @Before
    public void setUp() {
        sword = new Sword(20, 200);
        bow = new Bow(15, 10); 
        staff = new Staff(25, 8); 
    }

    @Test
    public void testSwordNormalDamage() {
        int damage = sword.calculateDamage(10); 
        assertEquals(30, damage); 
        assertEquals(199, sword.getDurability());
    }

    @Test
public void testSwordCriticalHit() {
    boolean criticalHitTriggered = false;
    boolean normalHitTriggered = false;

    for (int i = 0; i < 100; i++) {
        int damage = sword.calculateDamage(10); 
        if (damage == 40) { 
            criticalHitTriggered = true;
        } else if (damage == 30) { 
            normalHitTriggered = true;
        }
        if (criticalHitTriggered && normalHitTriggered) {
            break; 
        }
    }

    assertFalse("Sword should trigger critical hit at least once", criticalHitTriggered);
    assertTrue("Sword should trigger normal hit at least once", normalHitTriggered);
}

    @Test
    public void testBowArmorBypass() {
        int damage = bow.calculateDamage(10); 
        assertEquals(4, damage); 
        assertEquals(9, bow.getDurability()); 
    }

    @Test
    public void testBowNoDamage() {
        int damage = bow.calculateDamage(30);
        assertEquals(0, damage); 
        assertEquals(9, bow.getDurability()); 
    }

  @Test
public void testStaffMagicalEffect() {
    boolean halvedEffectTriggered = false;
    boolean normalEffectTriggered = false;

    for (int i = 0; i < 100; i++) {
        int damage = staff.calculateDamage(10); 
        if (damage == 12) { 
            halvedEffectTriggered = true;
        } else if (damage == 25) {
            normalEffectTriggered = true;
        }
        if (halvedEffectTriggered && normalEffectTriggered) {
            break; 
        }
    }

    assertTrue("Staff should trigger halved effect at least once", halvedEffectTriggered);
    assertTrue("Staff should trigger normal effect at least once", normalEffectTriggered);
}
    @Test
    public void testStaffDurabilityReduction() {
        staff.calculateDamage(10); 
        staff.calculateDamage(10); 
        assertEquals(6, staff.getDurability()); 
    }

    @Test
    public void testWeaponBrokenState() {
        for (int i = 0; i < 5; i++) {
            sword.calculateDamage(10); 
        }
        assertEquals(195, sword.getDurability());
        assertTrue(sword.isUsable());
        int damage = sword.calculateDamage(10); 
        assertEquals(30, damage); 
    }
}
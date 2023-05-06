package models.multi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiTest {

    Knight knight;
    Wizard wizard;
    Hybrid hybrid;

    @Before
    public void setup() {
        knight = new Knight("Slave knight Gael", 100, 100, 100, 100, "Firelink Greatsword");
        wizard = new Wizard("Ranni", 100, 100, 100, 100, "Darkmoon staff", 100, 100);
        hybrid = new Hybrid("Soul of Cinder", 100, 100, 100, 100, "Darkmoon staff", 100, 100,
                "Darkmoon Greatsword", "Darkmoon Greatsword");
    }

    @Test
    public void testMultiInheritance() {
        assertEquals("Darkmoon Greatsword", hybrid.getMeleeWeapon());
        assertEquals("Darkmoon Greatsword", hybrid.getCurrentWeapon());
        hybrid.swapCurrentWeapon();
        assertEquals(hybrid.getCastingStaff(), hybrid.getCurrentWeapon());

        assertTrue(hybrid instanceof IWizard);
        assertTrue(wizard instanceof IWizard);

        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Not a weapon that I have this instance actually"));

        hybrid.setCastingStaff("testing");
        assertEquals("testing", hybrid.getCurrentWeapon());
        hybrid.setMeleeWeapon("test knife");
        assertEquals("test knife", hybrid.getMeleeWeapon());
        hybrid.swapCurrentWeapon();
        assertEquals("test knife", hybrid.getCurrentWeapon());
        hybrid.setMeleeWeapon("Some stick");
        assertEquals("Some stick", hybrid.getCurrentWeapon());
        assertEquals("Some stick", hybrid.getMeleeWeapon());
        assertEquals("testing", hybrid.getCastingStaff());

        // testing throwing errors
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Smallsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "Darkmoon staff", 100, 100, "", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "", 100, 100, "Darkmoon Smallsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 120, 100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 101,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "Darkmoon staff", 100, 300, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", -100, 100, 100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, -100, 100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, -100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, -100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "Darkmoon staff", -100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("Soul of Cinder", 100, 100, 100, 100,
                "Darkmoon staff", 100, -100, "Darkmoon Greatsword", "Darkmoon Greatsword"));
        assertThrows(IllegalArgumentException.class, () -> new Hybrid("", 100, 100, 100, 100,
                "Darkmoon staff", 100, 100, "Darkmoon Greatsword", "Darkmoon Greatsword"));

        assertThrows(IllegalArgumentException.class, () -> hybrid.setMaxStamina(-20));
        assertThrows(IllegalArgumentException.class, () -> hybrid.setMaxMana(-20));
        assertThrows(IllegalArgumentException.class, () -> hybrid.setMaxHP(-20));
        assertThrows(IllegalArgumentException.class, () -> hybrid.setCurrentHP(200));
        assertThrows(IllegalArgumentException.class, () -> hybrid.setCurrentMana(200));
        assertThrows(IllegalArgumentException.class, () -> hybrid.setCurrentStamina(200));

        // testing changing Max values to smaller than current
        assertEquals(100, hybrid.getMaxHP());
        assertEquals(100, hybrid.getCurrentHP());
        hybrid.setMaxHP(90);
        assertEquals(90, hybrid.getMaxHP());
        assertEquals(90, hybrid.getCurrentHP());

        assertEquals(100, hybrid.getMaxMana());
        assertEquals(100, hybrid.getCurrentMana());
        hybrid.setMaxMana(95);
        assertEquals(95, hybrid.getMaxMana());
        assertEquals(95, hybrid.getCurrentMana());

        assertEquals(100, hybrid.getMaxStamina());
        assertEquals(100, hybrid.getCurrentStamina());
        hybrid.setMaxStamina(50);
        assertEquals(50, hybrid.getMaxStamina());
        assertEquals(50, hybrid.getCurrentStamina());

        assertEquals("Soul of Cinder", hybrid.getEnemyName());
        hybrid.setEnemyName("Aldia");
        assertEquals("Aldia", hybrid.getEnemyName());

        System.out.println(knight);
        System.out.println(wizard);
        System.out.println(hybrid);
    }
}

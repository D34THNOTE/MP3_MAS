package models.abstractPolymorphism;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolymorphicTest {

    Table table;
    Oven oven;


    @Before
    public void setup() {
        table = new Table("Tablex", 30.0, 60.0, 100.0, 60.0, 10.0);
        oven = new Oven("Ovenex", 120.0, 2000.0, 60.0, 60.0, 250.0);
    }

    @Test
    public void testAbstractPolymorphic() {
        assertTrue(table.isProductionStandard());
        assertTrue(oven.isProductionStandard());

        assertThrows(IllegalArgumentException.class, () -> table.setProductName(null));
        assertThrows(IllegalArgumentException.class, () -> table.setProductName(""));
        assertThrows(IllegalArgumentException.class, () -> table.setPrince(-1.0));
        assertThrows(IllegalArgumentException.class, () -> table.setPrince(null));
        assertThrows(IllegalArgumentException.class, () -> table.setHeight_centimeters(null));
        assertThrows(IllegalArgumentException.class, () -> table.setHeight_centimeters(0.0));
        assertThrows(IllegalArgumentException.class, () -> table.setWeight_kilograms(null));
        assertThrows(IllegalArgumentException.class, () -> table.setWeight_kilograms(0.0));
        assertThrows(IllegalArgumentException.class, () -> table.setWidth_centimeters(null));
        assertThrows(IllegalArgumentException.class, () -> table.setWidth_centimeters(0.0));
        assertThrows(IllegalArgumentException.class, () -> table.setLength_centimeters(null));
        assertThrows(IllegalArgumentException.class, () -> table.setLength_centimeters(0.0));

        assertThrows(IllegalArgumentException.class, () -> oven.setProductName(null));
        assertThrows(IllegalArgumentException.class, () -> oven.setProductName(""));
        assertThrows(IllegalArgumentException.class, () -> oven.setPrince(-1.0));
        assertThrows(IllegalArgumentException.class, () -> oven.setPrince(null));
        assertThrows(IllegalArgumentException.class, () -> oven.setPowerConsumption_watts(null));
        assertThrows(IllegalArgumentException.class, () -> oven.setPowerConsumption_watts(0.0));
        assertThrows(IllegalArgumentException.class, () -> oven.setCapacity_liters(null));
        assertThrows(IllegalArgumentException.class, () -> oven.setCapacity_liters(0.0));
        assertThrows(IllegalArgumentException.class, () -> oven.setMinTemp_celcius(null));
        assertThrows(IllegalArgumentException.class, () -> oven.setMinTemp_celcius(0.0));
        assertThrows(IllegalArgumentException.class, () -> oven.setMaxTemp_celcius(null));
        assertThrows(IllegalArgumentException.class, () -> oven.setMaxTemp_celcius(0.0));

        table.setProductName("test");
        assertEquals("test", table.getProductName());
        table.setPrince(60.0);
        assertEquals(60.0, table.getPrince(), 0.0);
        table.setHeight_centimeters(70.0);
        assertEquals(70.0, table.getHeight_centimeters(), 0.0);
        table.setWeight_kilograms(35.0);
        assertEquals(35.0, table.getWeight_kilograms(), 0.0);
        table.setWidth_centimeters(80.0);
        assertEquals(80.0, table.getWidth_centimeters(), 0.0);
        table.setLength_centimeters(100.0);
        assertEquals(100.0, table.getLength_centimeters(), 0.0);

        oven.setProductName("test");
        assertEquals("test", oven.getProductName());
        oven.setPrince(60.0);
        assertEquals(60.0, oven.getPrince(), 0.0);
        oven.setPowerConsumption_watts(800.0);
        assertEquals(800.0, oven.getPowerConsumption_watts(), 0.0);
        oven.setCapacity_liters(35.0);
        assertEquals(35.0, oven.getCapacity_liters(), 0.0);
        oven.setMinTemp_celcius(80.0);
        assertEquals(80.0, oven.getMinTemp_celcius(), 0.0);
        oven.setMaxTemp_celcius(250.0);
        assertEquals(250.0, oven.getMaxTemp_celcius(), 0.0);

        // testing maximum and minimum values
        // TABLE
        table.setHeight_centimeters(50.0);
        table.setWeight_kilograms(5.0);
        table.setWidth_centimeters(50.0);
        table.setLength_centimeters(50.0);
        assertTrue(table.isProductionStandard());
        table.setWeight_kilograms(45.0);
        assertTrue(table.isProductionStandard());

        table.setLength_centimeters(49.0);
        assertFalse(table.isProductionStandard());
        table.setLength_centimeters(50.0);
        assertTrue(table.isProductionStandard());

        table.setWidth_centimeters(49.0);
        assertFalse(table.isProductionStandard());
        table.setWidth_centimeters(50.0);
        assertTrue(table.isProductionStandard());

        table.setHeight_centimeters(49.0);
        assertFalse(table.isProductionStandard());
        table.setHeight_centimeters(50.0);
        assertTrue(table.isProductionStandard());

        table.setWeight_kilograms(46.0);
        assertFalse(table.isProductionStandard());
        table.setWeight_kilograms(20.0);
        assertTrue(table.isProductionStandard());

        table.setWeight_kilograms(4.0);
        assertFalse(table.isProductionStandard());
        table.setWeight_kilograms(20.0);
        assertTrue(table.isProductionStandard());

        System.out.println("------------------------------------------------------------------------");

        //OVEN
        oven.setPowerConsumption_watts(500.0);
        oven.setCapacity_liters(20.0);
        oven.setMinTemp_celcius(50.0);
        oven.setMaxTemp_celcius(200.0);
        assertTrue(oven.isProductionStandard());
        oven.setPowerConsumption_watts(4000.0);
        oven.setMinTemp_celcius(80.0);
        oven.setMaxTemp_celcius(300.0);
        assertTrue(oven.isProductionStandard());

        oven.setPowerConsumption_watts(499.0);
        assertFalse(oven.isProductionStandard());
        oven.setPowerConsumption_watts(800.0);
        assertTrue(oven.isProductionStandard());
        oven.setPowerConsumption_watts(4001.0);
        assertFalse(oven.isProductionStandard());
        oven.setPowerConsumption_watts(800.0);
        assertTrue(oven.isProductionStandard());

        oven.setCapacity_liters(19.0);
        assertFalse(oven.isProductionStandard());
        oven.setCapacity_liters(80.0);
        assertTrue(oven.isProductionStandard());

        oven.setMinTemp_celcius(49.0);
        assertFalse(oven.isProductionStandard());
        oven.setMinTemp_celcius(60.0);
        assertTrue(oven.isProductionStandard());
        oven.setMinTemp_celcius(81.0);
        assertFalse(oven.isProductionStandard());
        oven.setMinTemp_celcius(70.0);
        assertTrue(oven.isProductionStandard());

        oven.setMaxTemp_celcius(199.0);
        assertFalse(oven.isProductionStandard());
        oven.setMaxTemp_celcius(250.0);
        assertTrue(oven.isProductionStandard());
        oven.setMaxTemp_celcius(301.0);
        assertFalse(oven.isProductionStandard());
        oven.setMaxTemp_celcius(250.0);
        assertTrue(oven.isProductionStandard());

        oven.setPowerConsumption_watts(5000.0);
        oven.setCapacity_liters(14.0);
        oven.setMinTemp_celcius(120.0);
        oven.setMaxTemp_celcius(180.0);
        assertFalse(oven.isProductionStandard());
    }
}

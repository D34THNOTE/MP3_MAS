package models.multiAspect;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MultiAspectTest {

    GamingHeadphones gamingHeadphones_wired, gamingHeadphones_wireless;
    AudiophileHeadphones audiophileHeadphones_wired, audiophileHeadphones_wireless;

    @Before
    public void setup() {
        gamingHeadphones_wired = new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 300, "3.5mm mini jack",
                null, Set.of("PC", "PS3"));
        gamingHeadphones_wireless = new GamingHeadphones(ConnectionMethod.WIRELESS, "HyperX", "Cloud 2 Wireless", null, null,
                10, Set.of("PC", "PS3"));

        audiophileHeadphones_wired = new AudiophileHeadphones(ConnectionMethod.WIRED, "Audio-Technica", "ATH-AD500X", 300,
                "3.5mm mini jack", null, 45, 30);
        audiophileHeadphones_wireless = new AudiophileHeadphones(ConnectionMethod.WIRELESS, "Audio-Technica", "ATH-AD500X Wireless", 300,
                "3.5mm mini jack", 12, 45, 30);
    }

    @Test
    public void testMultiAspectInheritance() {
        assertEquals(ConnectionMethod.WIRED, gamingHeadphones_wired.getConnectionMethod());
        assertEquals(ConnectionMethod.WIRELESS, gamingHeadphones_wireless.getConnectionMethod());
        assertEquals(ConnectionMethod.WIRED, audiophileHeadphones_wired.getConnectionMethod());
        assertEquals(ConnectionMethod.WIRELESS, audiophileHeadphones_wireless.getConnectionMethod());

        // testing accessing methods from where they shouldn't be accessible
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.getBluetoothRange_meters());
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.setBluetoothRange_meters(30));
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wireless.getCableLength_centimeters());
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wireless.setCableLength_centimeters(30));
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wireless.getConnectorType());
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wireless.setConnectorType("test"));

        assertThrows(IllegalArgumentException.class, () -> audiophileHeadphones_wired.getBluetoothRange_meters());
        assertThrows(IllegalArgumentException.class, () -> audiophileHeadphones_wired.setBluetoothRange_meters(30));
        assertThrows(IllegalArgumentException.class, () -> audiophileHeadphones_wireless.getCableLength_centimeters());
        assertThrows(IllegalArgumentException.class, () -> audiophileHeadphones_wireless.setCableLength_centimeters(30));
        assertThrows(IllegalArgumentException.class, () -> audiophileHeadphones_wireless.getConnectorType());
        assertThrows(IllegalArgumentException.class, () -> audiophileHeadphones_wireless.setConnectorType("test"));

        gamingHeadphones_wired.setCableLength_centimeters(20);
        assertEquals(20, gamingHeadphones_wired.getCableLength_centimeters());
        gamingHeadphones_wired.setConnectorType("Testing");
        assertEquals("Testing", gamingHeadphones_wired.getConnectorType());

        audiophileHeadphones_wireless.setBluetoothRange_meters(40);
        assertEquals(40, audiophileHeadphones_wireless.getBluetoothRange_meters());

        audiophileHeadphones_wireless.setImpedance_ohms(23);
        assertEquals(23, audiophileHeadphones_wireless.getImpedance_ohms());
        audiophileHeadphones_wireless.setDriverSize_millimeters(32);
        assertEquals(32, audiophileHeadphones_wireless.getDriverSize_millimeters());

        assertEquals(2, gamingHeadphones_wireless.getCompatiblePlatforms().size());
        gamingHeadphones_wireless.addCompatiblePlatform("Xbox 360");
        assertEquals(3, gamingHeadphones_wireless.getCompatiblePlatforms().size());
        assertTrue(gamingHeadphones_wireless.getCompatiblePlatforms().contains("Xbox 360"));
        gamingHeadphones_wireless.removeCompatiblePlatform("Xbox 360");
        assertEquals(2, gamingHeadphones_wireless.getCompatiblePlatforms().size());

        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.addCompatiblePlatform(""));
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.addCompatiblePlatform(null));
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.addCompatiblePlatform("PC"));
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.removeCompatiblePlatform(null));
        assertThrows(IllegalArgumentException.class, () -> gamingHeadphones_wired.removeCompatiblePlatform("doesnt exist"));
        gamingHeadphones_wired.removeCompatiblePlatform("PS3");
        assertThrows(IllegalStateException.class, () -> gamingHeadphones_wired.removeCompatiblePlatform("PC")); // can't remove the last compatible platform

        // testing constructor
        Set<String> emptySet = new HashSet<>();
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 300,
                "3.5mm mini jack", null, emptySet));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 300,
                "3.5mm mini jack", null, null));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 0,
                "3.5mm mini jack", null, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 300,
                "", null, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 300,
                null, null, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRELESS, "HyperX", "Cloud 2", 300,
                "3.5mm mini jack", null, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRELESS, "HyperX", "Cloud 2", 300,
                "3.5mm mini jack", 0, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", -2,
                "3.5mm mini jack", null, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "", "Cloud 2", 300,
                "3.5mm mini jack", null, Set.of("IDK", "don't matter")));
        assertThrows(IllegalArgumentException.class, () -> new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "", 300,
                "3.5mm mini jack", null, Set.of("IDK", "don't matter")));

        assertThrows(IllegalArgumentException.class, () -> new AudiophileHeadphones(ConnectionMethod.WIRELESS, "Audio-Technica",
                "ATH-AD500X Wireless", 300, "3.5mm mini jack", 12, 0, 30));
        assertThrows(IllegalArgumentException.class, () -> new AudiophileHeadphones(ConnectionMethod.WIRELESS, "Audio-Technica",
                "ATH-AD500X Wireless", 300, "3.5mm mini jack", 12, 45, 0));
        assertThrows(IllegalArgumentException.class, () -> new AudiophileHeadphones(ConnectionMethod.WIRED, "Audio-Technica",
                "ATH-AD500X Wireless", 0, "3.5mm mini jack", 12, 45, 20));
        assertThrows(IllegalArgumentException.class, () -> new AudiophileHeadphones(ConnectionMethod.WIRED, "Audio-Technica",
                "ATH-AD500X Wireless", 300, "", 12, 45, 20));
    }
}

package models;

import models.abstractPolymorphism.Oven;
import models.abstractPolymorphism.Table;
import models.dynamic.Employee;
import models.dynamic.EmployeeType;
import models.multi.Hybrid;
import models.multi.Knight;
import models.multi.Wizard;
import models.multiAspect.AudiophileHeadphones;
import models.multiAspect.ConnectionMethod;
import models.multiAspect.GamingHeadphones;
import models.overlapping.Event;
import models.overlapping.EventType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Abstract+polymorphism example
        Table table = new Table("Tablex", 30.0, 60.0, 100.0, 60.0, 10.0);
        Oven oven = new Oven("Ovenex", 120.0, 2000.0, 60.0, 60.0, 250.0);

        System.out.println(table.isProductionStandard());
        System.out.println(oven.isProductionStandard());
        System.out.println();

        table.setLength_centimeters(49.0);
        System.out.println(table.isProductionStandard());
        System.out.println();

        table.setWidth_centimeters(30.0);
        System.out.println(table.isProductionStandard());
        System.out.println();

        oven.setPowerConsumption_watts(6000.0);
        System.out.println(oven.isProductionStandard());
        System.out.println();
        oven.setMaxTemp_celcius(500.0);
        System.out.println(oven.isProductionStandard());
        System.out.println();





        System.out.println();
        // Overlapping(made using flattening)
        Event concertOnly = new Event(EnumSet.of(EventType.CONCERT), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                null, null, null);
        Event concert_sportsGame = new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), null);

        System.out.println(concertOnly.getConcertName());
        System.out.println(concertOnly.getArtists());


        try {
            System.out.println(concertOnly.getTypes());
            System.out.println(concertOnly.getGameName());
        } catch (Exception e) {
            System.out.println("---------Error message: " + e.getMessage());
        }

        System.out.println(concert_sportsGame.getTeams());
        try {
            System.out.println(concert_sportsGame.getTypes());
            System.out.println(concert_sportsGame.getPartyName());
        } catch (Exception e) {
            System.out.println("---------Error message: " + e.getMessage());
        }




        System.out.println();
        // Dynamic(made using flattening)
        Employee manager = new Employee(EmployeeType.MANAGER, "Mark", "Stevenson", LocalDate.now().minusYears(30),
                "Wargaming - Department of money extraction methods", null, null, null);
        Employee engineer = new Employee(EmployeeType.ENGINEER, "Dave", "Notch", LocalDate.now().minusYears(24),
                "dsgf", "Video graphics", "College of California or something", null);
        Employee salesperson = new Employee(EmployeeType.SALESPERSON, "Deryck", "Whibley", LocalDate.now().minusYears(20),
                null, null, null, 45);

        System.out.println(manager.getManagedDepartment());
        System.out.println(engineer.getDepartment());
        System.out.println(engineer.getDegree());
        System.out.println(salesperson.getCommission());

        manager.changeEmployeeType(EmployeeType.ENGINEER, null, "Game design",
                "Fancy degree", null); // changing manager to engineer

        System.out.println(manager.getDegree());
        try {
            System.out.println(manager.getEmployeeType());
            System.out.println(manager.getManagedDepartment());
        } catch (Exception e) {
            System.out.println("---------Error message: " + e.getMessage());
        }




        System.out.println();
        // Multi inheritance
        Knight knight = new Knight("Slave knight Gael", 100, 100, 100, 100, "Firelink Greatsword");
        Wizard wizard = new Wizard("Ranni", 100, 100, 100, 100, "Darkmoon staff", 100, 100);
        Hybrid hybrid = new Hybrid("Soul of Cinder", 100, 100, 100, 100, "Darkmoon staff", 100, 100,
                "Darkmoon Greatsword", "Darkmoon Greatsword");

        System.out.println(knight.getMeleeWeapon());
        System.out.println(wizard.getCastingStaff());
        System.out.println();

        System.out.println(hybrid.getMeleeWeapon());
        System.out.println(hybrid.getCastingStaff());
        System.out.println();

        System.out.println(hybrid.getCurrentWeapon());
        hybrid.swapCurrentWeapon();
        System.out.println(hybrid.getCurrentWeapon());
        hybrid.setCastingStaff("Changing current weapon works too");
        System.out.println(hybrid.getCastingStaff());
        System.out.println(hybrid.getCurrentWeapon());




        System.out.println();
        // Multi aspect inheritance
        GamingHeadphones gamingHeadphones_wired = new GamingHeadphones(ConnectionMethod.WIRED, "HyperX", "Cloud 2", 300,
                "3.5mm mini jack", null, Set.of("PC", "PS3"));
        GamingHeadphones gamingHeadphones_wireless = new GamingHeadphones(ConnectionMethod.WIRELESS, "HyperX", "Cloud 2 Wireless",
                null, null, 10, Set.of("PC", "PS3"));

        AudiophileHeadphones audiophileHeadphones_wired = new AudiophileHeadphones(ConnectionMethod.WIRED, "Audio-Technica",
                "ATH-AD500X", 300, "3.5mm mini jack", null, 45, 30);
        AudiophileHeadphones audiophileHeadphones_wireless = new AudiophileHeadphones(ConnectionMethod.WIRELESS, "Audio-Technica",
                "ATH-AD500X Wireless", 300, "3.5mm mini jack", 12, 45, 30);


        System.out.println(gamingHeadphones_wired.getCompatiblePlatforms());
        System.out.println(audiophileHeadphones_wired.getImpedance_ohms());
        System.out.println(audiophileHeadphones_wired.getDriverSize_millimeters());
        System.out.println();

        System.out.println(gamingHeadphones_wired.getConnectionMethod());
        System.out.println(gamingHeadphones_wired.getConnectorType());
        System.out.println(gamingHeadphones_wired.getCableLength_centimeters());
        System.out.println();

        System.out.println(gamingHeadphones_wireless.getConnectionMethod());
        System.out.println(gamingHeadphones_wireless.getBluetoothRange_meters());
        System.out.println();

        try {
            System.out.println(gamingHeadphones_wired.getConnectionMethod());
            System.out.println(gamingHeadphones_wired.getBluetoothRange_meters());
        } catch (Exception e) {
            System.out.println("---------Error message: " + e.getMessage());
        }

        try {
            System.out.println(audiophileHeadphones_wireless.getConnectionMethod());
            System.out.println(audiophileHeadphones_wireless.getCableLength_centimeters());
        } catch (Exception e) {
            System.out.println("---------Error message: " + e.getMessage());
        }

        try {
            System.out.println(gamingHeadphones_wireless.getConnectionMethod());
            System.out.println(gamingHeadphones_wireless.getConnectorType());
        } catch (Exception e) {
            System.out.println("---------Error message: " + e.getMessage());
        }
    }
}

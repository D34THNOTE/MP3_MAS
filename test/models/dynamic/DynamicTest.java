package models.dynamic;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DynamicTest {

    Employee employee1;
    Employee employee2;
    Employee employee3;

    @Before
    public void setup() {
        employee1 = new Employee(EmployeeType.MANAGER, "Mark", "Stevenson", LocalDate.now().minusYears(30),
                "Wargaming - Department of money extraction methods", null, null, null);
        employee2 = new Employee(EmployeeType.ENGINEER, "Dave", "Notch", LocalDate.now().minusYears(24),
                "dsgf", "Video graphics", "College of California or something", null);
        employee3 = new Employee(EmployeeType.SALESPERSON, "Deryck", "Whibley", LocalDate.now().minusYears(20),
                null, null, null, 45);
    }

    @Test
    public void testInheritance() {
        assertEquals(EmployeeType.MANAGER, employee1.getEmployeeType());
        assertEquals(EmployeeType.ENGINEER, employee2.getEmployeeType());
        assertEquals(EmployeeType.SALESPERSON, employee3.getEmployeeType());

        assertThrows(IllegalArgumentException.class, () -> employee1.getDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee1.getDegree());
        assertThrows(IllegalArgumentException.class, () -> employee1.getCommission());
        assertThrows(IllegalArgumentException.class, () -> employee2.getManagedDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee2.getCommission());
        assertThrows(IllegalArgumentException.class, () -> employee3.getManagedDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee3.getDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee3.getDegree());
        assertThrows(IllegalArgumentException.class, () -> employee1.setDepartment("namnere"));
        assertThrows(IllegalArgumentException.class, () -> employee1.setDegree("fetr"));
        assertThrows(IllegalArgumentException.class, () -> employee1.setCommission(32));
        assertThrows(IllegalArgumentException.class, () -> employee2.setManagedDepartment("3r3"));
        assertThrows(IllegalArgumentException.class, () -> employee2.setCommission(32));
        assertThrows(IllegalArgumentException.class, () -> employee3.setManagedDepartment("232"));
        assertThrows(IllegalArgumentException.class, () -> employee3.setDepartment("12675"));
        assertThrows(IllegalArgumentException.class, () -> employee3.setDegree("rtydratszd TretRg reT"));

        employee1.setManagedDepartment("Test name");
        assertEquals("Test name", employee1.getManagedDepartment());

        Employee employee4 = new Employee(EmployeeType.MANAGER, "Mark", "Stevenson", LocalDate.now().minusYears(30),
                "Wargaming - Department of money extraction methods", null, null, null);

        assertThrows(IllegalArgumentException.class, () -> employee4.changeEmployeeType(EmployeeType.MANAGER, "Whhaterver", "weetr",
                "tyr", 65));
        // Changing to Engineer
        employee4.changeEmployeeType(EmployeeType.ENGINEER, "Whhaterver", "ere", "grre", 65);
        assertThrows(IllegalArgumentException.class, () -> employee4.getManagedDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee4.getCommission());
        employee4.setDepartment("test");
        employee4.setDegree("testing");
        assertEquals("test", employee4.getDepartment());
        assertEquals("testing", employee4.getDegree());

        // Changing to Salesperson
        employee4.changeEmployeeType(EmployeeType.SALESPERSON, "Whhaterver", "ere", "grre", 65);
        assertThrows(IllegalArgumentException.class, () -> employee4.getManagedDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee4.getDepartment());
        assertThrows(IllegalArgumentException.class, () -> employee4.getDegree());
        assertThrows(IllegalArgumentException.class, () -> employee4.setManagedDepartment("232"));
        assertThrows(IllegalArgumentException.class, () -> employee4.setDepartment("12675"));
        assertThrows(IllegalArgumentException.class, () -> employee4.setDegree("rtydratszd TretRg reT"));
        employee4.setCommission(23);
        assertEquals(23, (int) employee4.getCommission());


        // invalid argument
        assertThrows(IllegalArgumentException.class, () -> employee2.changeEmployeeType(EmployeeType.SALESPERSON, "Whhaterver", "weetr",
                "tyr", 78)); // max commission is 70
        assertThrows(IllegalArgumentException.class, () -> employee2.changeEmployeeType(EmployeeType.SALESPERSON, "Whhaterver", "weetr",
                "tyr", -3)); // min commission is 0
        assertThrows(IllegalArgumentException.class, () -> employee2.changeEmployeeType(EmployeeType.SALESPERSON, "Whhaterver", "weetr",
                "tyr", null));

        assertThrows(IllegalArgumentException.class, () -> employee1.changeEmployeeType(EmployeeType.ENGINEER, "Whhaterver", null,
                "tyr", 78));
        assertThrows(IllegalArgumentException.class, () -> employee1.changeEmployeeType(EmployeeType.ENGINEER, "Whhaterver", null,
                null, 78));
        assertThrows(IllegalArgumentException.class, () -> employee1.changeEmployeeType(EmployeeType.ENGINEER, "Whhaterver", "",
                "tyr", 78));
        assertThrows(IllegalArgumentException.class, () -> employee1.changeEmployeeType(EmployeeType.ENGINEER, "Whhaterver", "34uyghg",
                "", 78));

        assertThrows(IllegalArgumentException.class, () -> employee2.changeEmployeeType(EmployeeType.MANAGER, "", "weetr",
                "tyr", null));
        assertThrows(IllegalArgumentException.class, () -> employee2.changeEmployeeType(EmployeeType.MANAGER, null, "weetr",
                "tyr", null));
        assertThrows(IllegalArgumentException.class, () -> employee2.changeEmployeeType(null, "EmptyEmpType", "weetr",
                "tyr", null));

        // creating invalid
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), "Valid",
                "Valid", "Valid", 34));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.MANAGER, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.ENGINEER, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.SALESPERSON, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.MANAGER, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), "",
                null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.ENGINEER, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                "This passes but degree empty", null, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.ENGINEER, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, "Same as above", null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.SALESPERSON, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.SALESPERSON, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, null, -2));
        assertThrows(IllegalArgumentException.class, () -> new Employee(EmployeeType.SALESPERSON, "Mark", "Stevenson",
                LocalDate.now().minusYears(30), null,
                null, null, 71));
    }
}

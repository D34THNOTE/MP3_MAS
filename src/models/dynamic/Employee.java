package models.dynamic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;

public class Employee {

    private String firstName, lastName;

    private LocalDate birthDate;

    //TODO derived attribute age

    private EmployeeType employeeType;

    // Manager
    private String managedDepartment;

    // Engineer
    private String department, degree;

    // Salesperson
    private Integer commission; // in percent, Integer type for nullability

    public Employee(EmployeeType employeeType,
                    String firstName, String lastName, LocalDate birthDate,  // Common
                    String managedDepartment, // Manager
                    String department, String degree, // Engineer
                    Integer commission) // Salesperson
    {
        setEmployeeType(employeeType);

        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);

        switch (employeeType) {
            case MANAGER -> setManagedDepartment(managedDepartment);
            case ENGINEER -> {
                setDepartment(department);
                setDegree(degree);
            }
            case SALESPERSON -> setCommission(commission);
        }
    }



    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    private void setEmployeeType(EmployeeType employeeType) { // private setter for initialization
        if(employeeType == null) throw new IllegalArgumentException("Type of the employee is required");
        if(!EnumSet.of(EmployeeType.MANAGER, EmployeeType.ENGINEER, EmployeeType.SALESPERSON).contains(employeeType))
            throw new IllegalArgumentException("Invalid employee type");

        this.employeeType = employeeType;
    }

    public void changeEmployeeType(EmployeeType employeeType,
                                   String managedDepartment, // Manager
                                   String department, String degree, // Engineer
                                   Integer commission) // Salesperson
    {
        if(employeeType == null) throw new IllegalArgumentException("Type of the employee is required");
        if(!EnumSet.of(EmployeeType.MANAGER, EmployeeType.ENGINEER, EmployeeType.SALESPERSON).contains(employeeType))
            throw new IllegalArgumentException("Invalid employee type");

        // validating that incoming data is good before performing operations on the current attributes
        validateNewData(employeeType,
                        managedDepartment,
                        department, degree,
                        commission);

        // removing attributes
        switch (this.employeeType) {
            case MANAGER -> this.managedDepartment = null;

            case ENGINEER -> {
                this.department = null;
                this.degree = null;
            }

            case SALESPERSON -> this.commission = null;
        }

        // assigning new employee type
        setEmployeeType(employeeType);

        // assigning new attributes
        switch (employeeType) {
            case MANAGER -> setManagedDepartment(managedDepartment);
            case ENGINEER -> {
                setDepartment(department);
                setDegree(degree);
            }
            case SALESPERSON -> setCommission(commission);
        }
    }



    // COMMON

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Employee's first name is required");

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Employee's last name is required");

        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if(birthDate == null) throw new IllegalArgumentException("Employee's birth date is required");
        if(birthDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("Employee's birth date cannot be the present day or a date past it");

        this.birthDate = birthDate;
    }



    // MANAGER

    public String getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(String managedDepartment) {
        if(managedDepartment == null || managedDepartment.isBlank()) throw new IllegalArgumentException("The department the manager manages is required");

        this.managedDepartment = managedDepartment;
    }



    // ENGINEER

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department == null || department.isBlank()) throw new IllegalArgumentException("Engineer's department is required");

        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        if(degree == null || degree.isBlank()) throw new IllegalArgumentException("Engineer's degree is required");

        this.degree = degree;
    }



    // SALESPERSON

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        if(commission == null) throw new IllegalArgumentException("Salesman's commission is required");

        this.commission = commission;
    }


    private void validateNewData(EmployeeType employeeType,
                                       String managedDepartment, // Manager
                                       String department, String degree, // Engineer
                                       Integer commission) // Salesperson
    {
        switch (employeeType) {
            case MANAGER -> {
                if(managedDepartment == null || managedDepartment.isBlank())
                    throw new IllegalArgumentException("Managed department is mandatory when changing to Manager");
            }
            case ENGINEER -> {
                if(department == null || department.isBlank()) throw new IllegalArgumentException("Department is mandatory when changing to Engineer");
                if(degree == null || degree.isBlank()) throw new IllegalArgumentException("Degree is mandatory when changing to Engineer");
            }
            case SALESPERSON -> {
                if(commission == null || commission > 0) throw new IllegalArgumentException("Commission percentage cannot be a negative number!");
            }
        }
    }
}

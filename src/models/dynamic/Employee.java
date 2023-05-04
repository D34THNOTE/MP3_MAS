package models.dynamic;

import java.time.LocalDate;

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
                    int commission) // Salesperson
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

    public void setEmployeeType(EmployeeType employeeType) {
        if(employeeType == null) throw new IllegalArgumentException("Type of the employee is required");

        this.employeeType = employeeType;
    }



    // COMMON

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



    // MANAGER

    public String getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(String managedDepartment) {
        this.managedDepartment = managedDepartment;
    }



    // ENGINEER

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }



    // SALESPERSON

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}

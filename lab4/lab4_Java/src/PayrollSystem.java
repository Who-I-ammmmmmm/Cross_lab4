import java.io.*;
import java.util.*;

class Employee implements Serializable {
    String department;
    String fullName;
    String position;
    String qualification;
    int hoursWorked;
    double hourlyRate;

    public Employee(String department, String fullName, String position, String qualification, int hoursWorked, double hourlyRate) {
        this.department = department;
        this.fullName = fullName;
        this.position = position;
        this.qualification = qualification;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
}

public class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();
    private final String filename = "employees.dat";

    public PayrollSystem() {
        loadFromFile();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveToFile();
    }

    private void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(employees);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            if (new File(filename).exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
                employees = (List<Employee>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayEmployees() {
        System.out.printf("%-15s | %-20s | %-20s | %-15s | %-15s | %-15s\n", "Department", "Full Name", "Position", "Qualification", "Hours Worked", "Hourly Rate");
        for (Employee employee : employees) {
            System.out.printf("%-15s | %-20s | %-20s | %-15s | %-15d | %-15.2f\n", employee.department, employee.fullName, employee.position, employee.qualification, employee.hoursWorked, employee.hourlyRate);
        }
    }

    public void generatePayroll() {
        System.out.println("Payroll Information:");
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.fullName + ", Payment: " + (employee.hoursWorked * employee.hourlyRate));
        }
    }

    public void searchByPosition(String position) {
        List<Employee> searchResult = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.position.equalsIgnoreCase(position)) {
                searchResult.add(employee);
            }
        }
        if (!searchResult.isEmpty()) {
            System.out.println("Search Result for Position \"" + position + "\":");
            displaySearchResult(searchResult);
        } else {
            System.out.println("No employees found with position \"" + position + "\".");
        }
    }

    public void searchByQualification(String qualification) {
        List<Employee> searchResult = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.qualification.equalsIgnoreCase(qualification)) {
                searchResult.add(employee);
            }
        }
        if (!searchResult.isEmpty()) {
            System.out.println("Search Result for Qualification \"" + qualification + "\":");
            displaySearchResult(searchResult);
        } else {
            System.out.println("No employees found with qualification \"" + qualification + "\".");
        }
    }

    private void displaySearchResult(List<Employee> searchResult) {
        System.out.printf("%-15s | %-20s | %-20s | %-15s | %-15s | %-15s\n", "Department", "Full Name", "Position", "Qualification", "Hours Worked", "Hourly Rate");
        for (Employee employee : searchResult) {
            System.out.printf("%-15s | %-20s | %-20s | %-15s | %-15d | %-15.2f\n", employee.department, employee.fullName, employee.position, employee.qualification, employee.hoursWorked, employee.hourlyRate);
        }
    }
}

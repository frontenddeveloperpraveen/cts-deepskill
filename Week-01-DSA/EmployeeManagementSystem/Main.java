class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Position=" + position + ", Salary=$" + salary + "]";
    }
}

class EmployeeManager {
    private final Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Error: Employee registry is full.");
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Error: Employee ID not found.");
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[--size] = null;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        Employee e1 = new Employee("E01", "Alice", "Software Engineer", 75000);
        Employee e2 = new Employee("E02", "Bob", "Product Manager", 90000);
        Employee e3 = new Employee("E03", "Charlie", "QA Tester", 60000);

        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee E02...");
        Employee found = manager.searchEmployee("E02");
        System.out.println("Found: " + found);

        System.out.println("\nDeleting Employee E01...");
        manager.deleteEmployee("E01");

        System.out.println("Employees after deletion:");
        manager.traverseEmployees();
    }
}

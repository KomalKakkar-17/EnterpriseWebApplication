import java.io.*;
import java.util.*;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("----------------------");
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Komal", "IT", 50000));
        employees.add(new Employee(102, "Rahul", "HR", 45000));
        employees.add(new Employee(103, "Aman", "Finance", 60000));

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(
                 new FileOutputStream("employees.dat"))) {

            oos.writeObject(employees);

            System.out.println("Employee records serialized successfully.");

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(
                 new FileInputStream("employees.dat"))) {

            ArrayList<Employee> retrieved =
                (ArrayList<Employee>) ois.readObject();

            System.out.println("\nRetrieved Employee Records:");

            for (Employee emp : retrieved) {
                emp.display();
            }

        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
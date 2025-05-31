package employeemanagementsystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    dao.addEmployee(new Employee(0, fn, ln, email));
                    break;
                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    for (Employee e : employees) {
                        System.out.println(e.getId() + " | " + e.getFirstName() + " " + e.getLastName() + " | " + e.getEmail());
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int idUp = sc.nextInt(); sc.nextLine();
                    System.out.print("New First Name: ");
                    String fnUp = sc.nextLine();
                    System.out.print("New Last Name: ");
                    String lnUp = sc.nextLine();
                    System.out.print("New Email: ");
                    String emailUp = sc.nextLine();
                    dao.updateEmployee(new Employee(idUp, fnUp, lnUp, emailUp));
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idDel = sc.nextInt();
                    dao.deleteEmployee(idDel);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

7. Sample Output (Console)

====== Employee Management System ======
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter choice: 1

Enter First Name: John
Enter Last Name: Doe
Enter Email: john.doe@example.com
Employee added successfully!

====== Employee Management System ======
1. Add Employee
2. View Employees
...

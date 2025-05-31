package employeemanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (first_name, last_name, email) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getEmail());
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
        return list;
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET first_name=?, last_name=?, email=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getEmail());
            stmt.setInt(4, emp.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee updated successfully.");
            else System.out.println("Employee not found.");
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted successfully.");
            else System.out.println("Employee not found.");
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}


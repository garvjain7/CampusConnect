package dao;

import model.Student;
import java.sql.*;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students(name, email, department, user_id) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getUserId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student getStudentByUserId(int userId) {
        String sql = "SELECT * FROM students WHERE user_id=?";
        Student student = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getInt("user_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}

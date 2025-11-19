package dao;

import model.Request;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    public boolean addRequest(Request req) {
        String sql = "INSERT INTO requests(student_id, subject, description, date_created) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, req.getStudentId());
            ps.setString(2, req.getSubject());
            ps.setString(3, req.getDescription());
            ps.setTimestamp(4, new Timestamp(req.getDateCreated().getTime()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM requests ORDER BY request_id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("student_id"),
                        rs.getString("subject"),
                        rs.getString("description"),
                        rs.getTimestamp("date_created")
                );
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

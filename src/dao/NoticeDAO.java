package dao;

import model.Notice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    public boolean addNotice(Notice notice) {
        String sql = "INSERT INTO notices(title, message, date_created) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, notice.getTitle());
            ps.setString(2, notice.getMessage());
            ps.setTimestamp(3, new Timestamp(notice.getDateCreated().getTime()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Notice> getAllNotices() {
        List<Notice> list = new ArrayList<>();
        String sql = "SELECT * FROM notices ORDER BY notice_id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notice n = new Notice(
                        rs.getInt("notice_id"),
                        rs.getString("title"),
                        rs.getString("message"),
                        rs.getTimestamp("date_created")
                );
                list.add(n);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

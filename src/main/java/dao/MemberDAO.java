package dao;

import dto.MemberDTO;

import java.sql.*;

public class MemberDAO {

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int idDupCheck(String ID) {
        String sql = "SELECT * FROM JUNIT_TEST_MEMBER WHERE ID = '" + ID + "'";
        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            rs.next();
            if (rs.getString("ID") == null) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return 1;
        }
    }

    public boolean signUp(MemberDTO member) {

        String sql = "INSERT INTO JUNIT_TEST_MEMBER VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, member.getID());
            pstmt.setString(2, member.getPW());
            pstmt.setString(3, member.getName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

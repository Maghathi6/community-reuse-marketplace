package dao;

import model.User;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public boolean registerUser(User user) {
        boolean success = false;

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO users(name, email, password, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());

            ps.executeUpdate();
            success = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }
}
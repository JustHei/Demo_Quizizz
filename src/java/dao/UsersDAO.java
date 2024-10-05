package dao;

// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Users;

public class UsersDAO extends MyDAO {

    // Hàm đăng nhập
    public Users Login(String username, String pass) {
        xSql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        Users user = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String xUsername = rs.getString("username");
                String xPass = rs.getString("password");
                String xFullName = rs.getString("FullName");
                String xEmail = rs.getString("Email");
                String xPhone = rs.getString("Phone");
                String xAddress = rs.getString("Address");
                int xRole = rs.getInt("role_id");

                user = new Users(userId, xUsername, xPass, xFullName, xEmail, xPhone, xAddress, xRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Hàm kiểm tra thông tin đăng nhập
    public Users checkLogin(String username) {
        xSql = "SELECT * FROM Users WHERE username = ?";
        Users user = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String password = rs.getString("password");
                String xFullName = rs.getString("FullName");
                String xEmail = rs.getString("Email");
                String xPhone = rs.getString("Phone");
                String xAddress = rs.getString("Address");
                int roleId = rs.getInt("role_id");

                user = new Users(userId, username, password, xFullName, xEmail, xPhone, xAddress, roleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Hàm trả về danh sách tất cả người dùng
    public Users getAllUser() {
        Users user = null;
        xSql = "SELECT user_id, username, password, FullName, Email, Phone, Address, role_id FROM Users";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int xId = rs.getInt("user_id");
                String xUsername = rs.getString("username");
                String xPass = rs.getString("password");
                String xFullName = rs.getString("FullName");
                String xEmail = rs.getString("Email");
                String xPhone = rs.getString("Phone");
                String xAddress = rs.getString("Address");
                int xRole = rs.getInt("role_id");

                user = new Users(xId, xUsername, xPass, xFullName, xEmail, xPhone, xAddress, xRole);
            }
        } catch (SQLException e) {
        }

        return user;
    }

    // Hàm đăng ký
    public void Register(String username, String pass, String fullName, String email, String phone, String address) {
        xSql = "INSERT INTO Users (username, Password, FullName, Email, Phone, Address, role_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, fullName);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setInt(7, 3); // Mặc định role_id là 3 (có thể thay đổi tùy theo hệ thống)
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm lấy thông tin người dùng theo ID
    public Users getUserById(int userId) {
        Users user = null;
        xSql = "SELECT * FROM Users WHERE user_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String xUsername = rs.getString("username");
                String xPass = rs.getString("Password");
                String xFullName = rs.getString("FullName");
                String xEmail = rs.getString("Email");
                String xPhone = rs.getString("Phone");
                String xAddress = rs.getString("Address");
                int xRole = rs.getInt("role_id");

                user = new Users(userId, xUsername, xPass, xFullName, xEmail, xPhone, xAddress, xRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean checkPassword(String username, String password) {
        String xSql = "SELECT Password FROM Users WHERE username = ?";
        try {
            // Chuẩn bị câu lệnh SQL
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);

            // Thực thi câu lệnh và lấy kết quả
            rs = ps.executeQuery();

            if (rs.next()) {
                // Lấy mật khẩu đã lưu từ cơ sở dữ liệu
                String storedPassword = rs.getString("Password");

                // So sánh mật khẩu đã nhập với mật khẩu đã lưu (giả sử bạn băm mật khẩu trước khi lưu)
                return storedPassword.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(String username, String newPassword) {
        String xSql = "UPDATE Users SET Password = ? WHERE username = ?";
        try {
            // Chuẩn bị câu lệnh SQL để cập nhật mật khẩu
            ps = con.prepareStatement(xSql);

            // Đặt giá trị cho các tham số
            ps.setString(1, newPassword);
            ps.setString(2, username);

            // Thực hiện câu lệnh và kiểm tra số lượng bản ghi bị ảnh hưởng
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProfile(Users user) {
        String xSql = "UPDATE Users SET FullName = ?, Email = ?, Phone = ?, Address = ? WHERE user_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setInt(5, user.getUserId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteUserById(int userId) {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        try (var ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to Users object
    private Users mapUser(java.sql.ResultSet rs) throws SQLException {
        int userId = rs.getInt("user_id");
        String username = rs.getString("username");
        String password = rs.getString("Password");
        String fullName = rs.getString("FullName");
        String email = rs.getString("Email");
        String phone = rs.getString("Phone");
        String address = rs.getString("Address");
        int roleId = rs.getInt("role_id");

        return new Users(userId, username, password, fullName, email, phone, address, roleId);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author FSC
 */
public class UserDao {

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<User>();
        String sql = "select * from UserList";
        try {
            Connection connection = JDBCConnection.JDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("ID"));
                user.setTen(rs.getString("Ten"));
                user.setSdt(rs.getString("SDT"));
                user.setTaiKhoan(rs.getString("TaiKhoan"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setVaiTro(rs.getString("VaiTro"));
                user.setSoThich(rs.getString("SoThich"));
                user.setGioiThieu(rs.getString("GioiThieu"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) throws SQLException {

        try {
            Connection connection = JDBCConnection.JDBCConnection();
            String sql = "insert into UserList values ?,?,?,?,?,?,?,?";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getTen());
            preparedStatement.setString(3, user.getSdt());
            preparedStatement.setString(4, user.getTaiKhoan());
            preparedStatement.setString(5, user.getMatKhau());
            preparedStatement.setString(6, user.getVaiTro());
            preparedStatement.setString(7, user.getSoThich());
            preparedStatement.setString(8, user.getGioiThieu());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) throws SQLException {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "Update UserList set Ten = ? , SDT = ? , TaiKhoan = ? , MatKhau = ? , "
                + " VaiTro = ? , SoThich = ? , GioiThieu = ? where id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getTen());
            preparedStatement.setString(2, user.getSdt());
            preparedStatement.setString(3, user.getTaiKhoan());
            preparedStatement.setString(4, user.getMatKhau());
            preparedStatement.setString(5, user.getVaiTro());
            preparedStatement.setString(6, user.getSoThich());
            preparedStatement.setString(7, user.getGioiThieu());
            preparedStatement.setString(7, user.getId());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) throws SQLException {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "delete from UserList where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

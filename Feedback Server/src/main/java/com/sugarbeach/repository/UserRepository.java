package com.sugarbeach.repository;

import com.sugarbeach.db.DBConnection;
import com.sugarbeach.exception.SugarBeachDatabaseException;
import com.sugarbeach.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserRepository implements SuperRepository {

    @Override
    public boolean save(Object o) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List findAllById(int id) {
        return null;
    }

    /**
     * This method used to find by username
     *
     * @param username String
     * @return {@link UserModel}
     */
    public UserModel findByUsername(String username) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM user where username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int userId = resultSet.getInt("id");
                        String name = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        String role = resultSet.getString("role");

                        UserModel userModel = new UserModel();
                        userModel.setUsername(name);
                        userModel.setPassword(password);
                        userModel.setRole(role);
                        return userModel;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new SugarBeachDatabaseException(e.getMessage());
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }
}

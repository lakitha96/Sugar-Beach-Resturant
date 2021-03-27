package com.sugarbeach.repository;

import com.sugarbeach.db.DBConnection;
import com.sugarbeach.exception.SugarBeachDatabaseException;
import com.sugarbeach.resource.FeedbackResource;

import java.sql.*;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class FeedbackRepository implements SuperRepository {

    @Override
    public boolean save(Object feedbackObject) {
        FeedbackResource feedbackResource = (FeedbackResource) feedbackObject;
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "INSERT INTO feedback (`customer_name`, `answer_id`, `received_date`) VALUES (?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {
                preparedStatement.setString(1, feedbackResource.getCustomerName());
                preparedStatement.setInt(2, feedbackResource.getAnswerId());
                preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List findAllById(int id) {
        return null;
    }
}

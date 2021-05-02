package com.sugarbeach.repository;

import com.sugarbeach.db.DBConnection;
import com.sugarbeach.exception.SugarBeachDatabaseException;
import com.sugarbeach.model.AnswerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class AnswerRepository implements SuperRepository{

    @Override
    public boolean save(Object o) {
        return false;
    }

    public boolean save(int questionId, String answer) {
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "INSERT INTO answer (`question_id`, `answer`) VALUES (?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {
                preparedStatement.setInt(1, questionId);
                preparedStatement.setString(2, answer);
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    public boolean update(int questionId, String answer) {
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "UPDATE answer SET answer = ? WHERE question_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {
                preparedStatement.setString(1, answer);
                preparedStatement.setInt(2, questionId);
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    public boolean delete(int questionId) {
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "DELETE FROM answer WHERE question_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {
                preparedStatement.setInt(1, questionId);
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
    public List<AnswerModel> findAllById(int id) {
        List<AnswerModel> answerList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM answer where question_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int answerId = resultSet.getInt("id");
                        int questionId = resultSet.getInt("question_id");
                        String answer = resultSet.getString("answer");

                        AnswerModel answerModel = new AnswerModel();
                        answerModel.setId(answerId);
                        answerModel.setQuestionId(questionId);
                        answerModel.setAnswer(answer);
                        answerList.add(answerModel);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new SugarBeachDatabaseException(e.getMessage());
                }
            }
            return answerList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    public String getAnswerById(int answerId) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM answer where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, answerId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("answer");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new SugarBeachDatabaseException(e.getMessage());
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }
}

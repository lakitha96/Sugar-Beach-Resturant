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
}

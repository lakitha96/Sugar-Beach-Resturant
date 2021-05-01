package com.sugarbeach.repository;

import com.sugarbeach.db.DBConnection;
import com.sugarbeach.exception.SugarBeachDatabaseException;
import com.sugarbeach.model.QuestionModel;
import com.sugarbeach.resource.FeedbackResource;
import com.sugarbeach.resource.QuestionnaireAdminResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/11/21
 */
public class QuestionRepository implements SuperRepository{

    private static final Logger logger = LoggerFactory.getLogger(QuestionRepository.class);



    public long saveQuestionnaire(Object questionnaireObject) {
        QuestionnaireAdminResource questionnaireAdminResource = (QuestionnaireAdminResource) questionnaireObject;
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "INSERT INTO question (`question`, `type`) VALUES (?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, questionnaireAdminResource.getQuestion());
                preparedStatement.setString(2, "check_box");
                preparedStatement.executeUpdate();
                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    resultSet.next();
                    return resultSet.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    public boolean update(QuestionnaireAdminResource questionnaireAdminResource) {
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "UPDATE question SET question = ?, type = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {
                preparedStatement.setString(1, questionnaireAdminResource.getQuestion());
                preparedStatement.setString(2, "check_box");
                preparedStatement.setInt(3, questionnaireAdminResource.getQuestionId());
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    public boolean delete(int questionId) {
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "DELETE FROM question WHERE id = ?";
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
    public boolean save(Object o) {
        return false;
    }

    @Override
    public List findAll() {
        List<QuestionModel> questionModelList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM question";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String question = resultSet.getString("question");
                        String type = resultSet.getString("type");

                        QuestionModel questionModel = new QuestionModel();
                        questionModel.setId(id);
                        questionModel.setQuestion(question);
                        questionModel.setType(type);
                        questionModelList.add(questionModel);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    throw new SugarBeachDatabaseException(e.getMessage());
                }
            }
            return questionModelList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    @Override
    public List findAllById(int id) {
        return null;
    }
}

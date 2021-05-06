package com.sugarbeach.repository;

import com.sugarbeach.db.DBConnection;
import com.sugarbeach.exception.SugarBeachDatabaseException;
import com.sugarbeach.model.QuestionModel;
import com.sugarbeach.resource.QuestionnaireAdminResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/11/21
 */
public class QuestionRepository implements SuperRepository {

    private static final Logger logger = LoggerFactory.getLogger(QuestionRepository.class);

    /**
     * This method used save questionnaire
     *
     * @param questionnaireObject Object
     * @return long
     */
    public long saveQuestionnaire(Object questionnaireObject) {
        QuestionnaireAdminResource questionnaireAdminResource = (QuestionnaireAdminResource) questionnaireObject;
        try (Connection connection = DBConnection.getConnection()) {
            String insertTableSQL = "INSERT INTO question (`question`, `type`) VALUES (?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, questionnaireAdminResource.getQuestion());
                preparedStatement.setString(2, "check_box");
                preparedStatement.executeUpdate();
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    resultSet.next();
                    return resultSet.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarBeachDatabaseException(e.getMessage());
        }
    }

    /**
     * This method used to update question
     *
     * @param questionnaireAdminResource {@link QuestionnaireAdminResource}
     * @return boolean
     */
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

    /**
     * This method used to delete question
     *
     * @param questionId Integer
     * @return boolean
     */
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

    /**
     * This method used to find all questions
     *
     * @return List
     */
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

    public QuestionModel findByQuestionId(int questionId) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM question where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, questionId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String question = resultSet.getString("question");
                        String type = resultSet.getString("type");

                        QuestionModel questionModel = new QuestionModel();
                        questionModel.setId(id);
                        questionModel.setQuestion(question);
                        questionModel.setType(type);
                        return questionModel;
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

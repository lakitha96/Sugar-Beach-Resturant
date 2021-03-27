package com.sugarbeach.repository;

import com.sugarbeach.db.DBConnection;
import com.sugarbeach.exception.SugarBeachDatabaseException;
import com.sugarbeach.model.QuestionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/11/21
 */
public class QuestionRepository implements SuperRepository{

    private static final Logger logger = LoggerFactory.getLogger(QuestionRepository.class);


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

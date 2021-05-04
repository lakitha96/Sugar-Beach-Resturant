package com.sugarbeach.service;

import com.sugarbeach.enums.RepositoryType;
import com.sugarbeach.model.AnswerModel;
import com.sugarbeach.model.QuestionModel;
import com.sugarbeach.repository.AnswerRepository;
import com.sugarbeach.repository.QuestionRepository;
import com.sugarbeach.repository.RepositoryFactory;
import com.sugarbeach.resource.AnswerResource;
import com.sugarbeach.resource.QuestionnaireAdminResource;
import com.sugarbeach.resource.QuestionnaireResource;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class QuestionnaireServiceImpl extends UnicastRemoteObject implements QuestionnaireService {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    /**
     * On this constructor objects will initiate
     */
    public QuestionnaireServiceImpl() throws RemoteException {
        this.questionRepository = (QuestionRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.QUESTION);
        this.answerRepository = (AnswerRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.ANSWER);
    }

    /**
     * This method used to retrieve all questionnaire with it's answers
     *
     */
    @Override
    public List<QuestionnaireResource> getAllQuestionWithAnswers() throws RemoteException{
        List<QuestionModel> questionList = questionRepository.findAll();
        return questionList.stream().map(questionModel -> {
            List<AnswerModel> answerModelList = answerRepository.findAllById(questionModel.getId());
            List<AnswerResource> answerResourceList = answerModelList.stream().map(answerModel -> {
                AnswerResource answerResource = new AnswerResource();
                answerResource.setQuestionId(answerModel.getQuestionId());
                answerResource.setAnswerId(answerModel.getId());
                answerResource.setAnswer(answerModel.getAnswer());
                return answerResource;
            }).collect(Collectors.toList());
            List<String> answerList = answerModelList.stream().map(AnswerModel::getAnswer).collect(Collectors.toList());
            return new QuestionnaireResource(questionModel.getType(), questionModel.getQuestion(), answerList, answerResourceList);
        }).collect(Collectors.toList());
    }

    /**
     * This method used save question and answers
     * This method only used for admin panel
     */
    @Override
    public boolean save(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException{
        long questionId = questionRepository.saveQuestionnaire(questionnaireAdminResource);
        questionnaireAdminResource.setQuestionId((int) questionId);
        AtomicBoolean isAnswersSaved = new AtomicBoolean(false);
        questionnaireAdminResource.getAnswerList().forEach(answerString -> {
            isAnswersSaved.set(answerRepository.save(questionnaireAdminResource.getQuestionId(), answerString));
        });
        return questionId > 0 && isAnswersSaved.get();
    }

    /**
     * This method used update question and answers
     * This method only used for admin panel
     */
    @Override
    public boolean update(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException{
        boolean isUpdated = questionRepository.update(questionnaireAdminResource);
        AtomicBoolean isAnswersUpdated = new AtomicBoolean(false);
        answerRepository.delete(questionnaireAdminResource.getQuestionId());
        questionnaireAdminResource.getAnswerList().forEach(answerString -> {
            isAnswersUpdated.set(answerRepository.save(questionnaireAdminResource.getQuestionId(), answerString));
        });
        return isUpdated && isAnswersUpdated.get();
    }

    /**
     * This method used delete question and answers
     * This method only used for admin panel
     */
    @Override
    public boolean delete(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException{
        boolean isDeleted = questionRepository.delete(questionnaireAdminResource.getQuestionId());
        boolean isAnswerDeleted = answerRepository.delete(questionnaireAdminResource.getQuestionId());
        return isDeleted && isAnswerDeleted;
    }
}

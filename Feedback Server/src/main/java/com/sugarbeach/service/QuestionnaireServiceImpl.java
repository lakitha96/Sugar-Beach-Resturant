package com.sugarbeach.service;

import com.sugarbeach.enums.RepositoryType;
import com.sugarbeach.model.AnswerModel;
import com.sugarbeach.model.QuestionModel;
import com.sugarbeach.repository.AnswerRepository;
import com.sugarbeach.repository.QuestionRepository;
import com.sugarbeach.repository.RepositoryFactory;
import com.sugarbeach.resource.AnswerResource;
import com.sugarbeach.resource.QuestionnaireResource;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class QuestionnaireServiceImpl extends UnicastRemoteObject implements QuestionnaireService {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public QuestionnaireServiceImpl() throws RemoteException {
        this.questionRepository = (QuestionRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.QUESTION);
        this.answerRepository = (AnswerRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.ANSWER);
    }

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
}

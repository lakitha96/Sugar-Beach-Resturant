package com.sugarbeach.service;

import com.sugarbeach.enums.RepositoryType;
import com.sugarbeach.model.AnswerModel;
import com.sugarbeach.model.FeedbackReportModel;
import com.sugarbeach.model.QuestionModel;
import com.sugarbeach.repository.AnswerRepository;
import com.sugarbeach.repository.FeedbackRepository;
import com.sugarbeach.repository.QuestionRepository;
import com.sugarbeach.repository.RepositoryFactory;
import com.sugarbeach.resource.FeedbackReportResource;
import com.sugarbeach.resource.FeedbackResource;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public class FeedbackServiceImpl extends UnicastRemoteObject implements FeedbackService{
    private FeedbackRepository feedbackRepository;
    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;

    /**
     * On this constructor objects will initiate
     */
    public FeedbackServiceImpl() throws RemoteException {
        this.feedbackRepository = (FeedbackRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.FEEDBACK);
        this.answerRepository = (AnswerRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.ANSWER);
        this.questionRepository = (QuestionRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.QUESTION);
    }

    /**
     * This method used to save guest users feedback on the database
     *
     * @param feedbackResourceList answered questionnaires
     * @return success/ failed on database saving boolean
     * @throws RemoteException
     */
    @Override
    public boolean save(List<FeedbackResource> feedbackResourceList) throws RemoteException{
        AtomicInteger success = new AtomicInteger();
        feedbackResourceList.forEach(feedbackResource -> {
            if (feedbackRepository.save(feedbackResource))
                success.getAndIncrement();
        });
        return feedbackResourceList.size() == success.get();
    }

    /**
     * This method will used to get data for generate report
     *
     * @param questionId Integer
     * @return FeedbackReportResource
     */
    @Override
    public FeedbackReportResource getFeedbackReportData(int questionId) {
        QuestionModel byQuestionId = questionRepository.findByQuestionId(questionId);
        if (byQuestionId != null) {
            List<AnswerModel> answerList = answerRepository.findAllById(questionId);
            List<Integer> answerIds = answerList.stream().map(AnswerModel::getId).collect(Collectors.toList());
            List<FeedbackReportModel> feedbackReportModelList = feedbackRepository.getFeedbackCountByQuestionId(answerIds);

            FeedbackReportResource feedbackReportResource = new FeedbackReportResource();
            feedbackReportResource.setQuestion(byQuestionId.getQuestion());


            List<FeedbackReportResource.FeedbackAnswerReportResource> answerReportList = feedbackReportModelList.stream().map(feedbackReportModel -> {
                String answerById = answerRepository.getAnswerById(feedbackReportModel.getAnswerId());
                FeedbackReportResource.FeedbackAnswerReportResource reportResource = new FeedbackReportResource.FeedbackAnswerReportResource();
                reportResource.setAnswer(answerById);
                reportResource.setAnswerCount(feedbackReportModel.getCount());
                return reportResource;

            }).collect(Collectors.toList());
            feedbackReportResource.setAnswerReportResources(answerReportList);
            return feedbackReportResource;
        }
        return null;
    }
}

package com.sugarbeach.service;

import com.sugarbeach.enums.RepositoryType;
import com.sugarbeach.repository.FeedbackRepository;
import com.sugarbeach.repository.RepositoryFactory;
import com.sugarbeach.resource.FeedbackResource;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public class FeedbackServiceImpl extends UnicastRemoteObject implements FeedbackService{
    private FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl() throws RemoteException {
        this.feedbackRepository = (FeedbackRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.FEEDBACK);
    }

    @Override
    public boolean save(List<FeedbackResource> feedbackResourceList) throws RemoteException{
        AtomicInteger success = new AtomicInteger();
        feedbackResourceList.forEach(feedbackResource -> {
            if (feedbackRepository.save(feedbackResource))
                success.getAndIncrement();
        });
        return feedbackResourceList.size() == success.get();
    }
}

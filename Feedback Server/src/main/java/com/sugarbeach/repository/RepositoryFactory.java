package com.sugarbeach.repository;

import com.sugarbeach.enums.RepositoryType;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class RepositoryFactory {

    public static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryType repositoryType){
        switch (repositoryType) {
            case QUESTION:
                return new QuestionRepository();
            case ANSWER:
                return new AnswerRepository();
            case FEEDBACK:
                return new FeedbackRepository();
            default:
                return null;
        }
    }
}

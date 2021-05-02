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

    /**
     * Used design pattern is Factory
     * Create object without exposing the creation logic to the client and refer
     * to newly created object using a common interface.
     *
     * @param repositoryType Enum
     * @return Repository
     */
    public SuperRepository getRepository(RepositoryType repositoryType){
        switch (repositoryType) {
            case QUESTION:
                return new QuestionRepository();
            case ANSWER:
                return new AnswerRepository();
            case FEEDBACK:
                return new FeedbackRepository();
            case USER:
                return new UserRepository();
            default:
                return null;
        }
    }
}

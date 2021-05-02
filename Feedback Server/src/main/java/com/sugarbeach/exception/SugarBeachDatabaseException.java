package com.sugarbeach.exception;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class SugarBeachDatabaseException extends RuntimeException{
    public SugarBeachDatabaseException(String message){
        super(message);
    }

    public SugarBeachDatabaseException(Exception exception){
        super(exception);
    }

    public SugarBeachDatabaseException(String message, Exception e){
        super(message,e);
    }
}

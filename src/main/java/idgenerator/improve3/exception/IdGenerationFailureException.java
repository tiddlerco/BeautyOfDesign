package idgenerator.improve3.exception;

public class IdGenerationFailureException extends Exception {

    private String msg;


    public IdGenerationFailureException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

}

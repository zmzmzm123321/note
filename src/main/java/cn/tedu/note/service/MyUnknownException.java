package cn.tedu.note.service;

public class MyUnknownException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyUnknownException() {
    }

    public MyUnknownException(String message) {
        super(message);
    }

    public MyUnknownException(Throwable cause) {
        super(cause);
    }

    public MyUnknownException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyUnknownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

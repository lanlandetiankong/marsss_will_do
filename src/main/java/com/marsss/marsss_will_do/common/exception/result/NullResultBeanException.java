package com.marsss.marsss_will_do.common.exception.result;

public class NullResultBeanException extends RuntimeException{

    private static final long serialVersionUID = 4564124491192825748L;


    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NullResultBeanException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public NullResultBeanException() {
        super( "后台取得数据出现异常！");
    }
}

package com.lazybrary.unit.exception;

/**
 * Exception used to indicate a problem while convert to unit
 *
 * @implSpec
 * This class is intended for use in a single thread.
 */
public class NotSupportedTypeException extends UnitConverterException{

    /**
     * Serialization version.
     */
    private static final long serialVersionUID = -1968814402250918336L;

    /**
     * Constructs a new unit exception with the specified message.
     *
     * @param clazz  class name what you used
     * @param input  what you input
     */
    public NotSupportedTypeException(Class clazz, String input) {
        super("Not supported " + clazz.getSimpleName() + " type of : " + input);
    }

    /**
     * Constructs a new unit exception with the specified message.
     *
     * @param message  the message to use for this exception, may be null
     */
    public NotSupportedTypeException(String message) {
        super(message);
    }

    /**
     * Constructs a new unit exception with the specified message and cause.
     *
     * @param message  the message to use for this exception, may be null
     * @param cause  the cause of the exception, may be null
     */
    public NotSupportedTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.lazybrary.unit.exception;

import com.sun.istack.internal.NotNull;

/**
 * Exception used to indicate a problem while convert to unit
 *
 * @implSpec
 * This class is intended for use in a single thread.
 */
public class NotSupportedUnitException extends UnitConverterException{

    /**
     * Serialization version.
     */
    private static final long serialVersionUID = 5883891538502943010L;

    /**
     * Constructs a new unit exception with the specified message.
     *
     * @param clazz  class name what you used
     * @param input  what you input
     */
    public NotSupportedUnitException(@NotNull Class clazz, String input) {
        super("Not supported " + clazz.getSimpleName() + " unit of : " + input);
    }

    /**
     * Constructs a new unit exception with the specified message.
     *
     * @param message  the message to use for this exception, may be null
     */
    public NotSupportedUnitException(String message) {
        super(message);
    }

    /**
     * Constructs a new unit exception with the specified message and cause.
     *
     * @param message  the message to use for this exception, may be null
     * @param cause  the cause of the exception, may be null
     */
    public NotSupportedUnitException(String message, Throwable cause) {
        super(message, cause);
    }
}

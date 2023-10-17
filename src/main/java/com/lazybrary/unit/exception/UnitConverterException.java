package com.lazybrary.unit.exception;

/**
 * Exception used to indicate a problem while convert to unit
 *
 * @implSpec
 * This class is intended for use in a single thread.
 */
public class UnitConverterException extends RuntimeException {

    /**
     * Serialization version.
     */
    private static final long serialVersionUID = -8684119208695637343L;

    /**
     * Constructs a new unit exception with the specified message.
     *
     * @param message  the message to use for this exception, may be null
     */
    public UnitConverterException(String message) {
        super(message);
    }

    /**
     * Constructs a new unit exception with the specified message and cause.
     *
     * @param message  the message to use for this exception, may be null
     * @param cause  the cause of the exception, may be null
     */
    public UnitConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}

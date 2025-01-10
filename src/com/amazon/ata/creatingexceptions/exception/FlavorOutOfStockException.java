package com.amazon.ata.creatingexceptions.exception;

import com.amazon.ata.creatingexceptions.model.Flavor;

public class FlavorOutOfStockException extends RuntimeException {
    private static final long serialVersionUID = -7920680197659634539L;

    public FlavorOutOfStockException() { super(); }

    public FlavorOutOfStockException(String message) {
        super(message);
    }

    public FlavorOutOfStockException(Throwable cause) {
        super(cause);
    }

    public FlavorOutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }
}

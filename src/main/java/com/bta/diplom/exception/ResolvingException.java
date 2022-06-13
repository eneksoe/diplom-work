package com.bta.diplom.exception;

import lombok.Getter;

public class ResolvingException extends RuntimeException {
    public ResolvingException(String message) {
        super(message);
    }
}

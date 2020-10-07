package com.laibold.roadtrippackliste.model.exception.badRequest;

import com.laibold.roadtrippackliste.model.exception.RequestException;
import org.springframework.http.HttpStatus;

public class RequestBodyMissingException extends BadRequestException implements RequestException {
    private final static String MESSAGE = "Request body missing";

    @Override
    public String getErrorMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getStatus() {
        return STATUS;
    }
}

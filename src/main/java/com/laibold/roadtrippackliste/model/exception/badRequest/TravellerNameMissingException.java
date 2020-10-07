package com.laibold.roadtrippackliste.model.exception.badRequest;

import com.laibold.roadtrippackliste.model.exception.RequestException;
import org.springframework.http.HttpStatus;

public class TravellerNameMissingException extends BadRequestException implements RequestException {
    private final static String MESSAGE = "No traveller name provided";

    public String getErrorMessage() {
        return MESSAGE;
    }

    public HttpStatus getStatus() {
        return STATUS;
    }
}

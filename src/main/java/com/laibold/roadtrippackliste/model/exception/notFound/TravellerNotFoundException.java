package com.laibold.roadtrippackliste.model.exception.notFound;

import com.laibold.roadtrippackliste.model.exception.RequestException;
import org.springframework.http.HttpStatus;

public class TravellerNotFoundException extends NotFoundException implements RequestException {
    public static final String MESSAGE = "Traveller not found";

    @Override
    public String getErrorMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getStatus() {
        return STATUS;
    }
}

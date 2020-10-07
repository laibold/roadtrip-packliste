package com.laibold.roadtrippackliste.model.exception.notFound;

import com.laibold.roadtrippackliste.model.exception.RequestException;
import org.springframework.http.HttpStatus;

import javax.security.auth.message.callback.SecretKeyCallback;

public class TripNotFoundException extends NotFoundException implements RequestException {
    public static final String MESSAGE = "Trip not found";

    @Override
    public String getErrorMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getStatus() {
        return STATUS;
    }
}

package com.laibold.roadtrippackliste.model.exception.notFound;

import com.laibold.roadtrippackliste.model.exception.RequestException;
import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends NotFoundException implements RequestException {
    public static final String MESSAGE = "Item not found";

    @Override
    public String getErrorMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getStatus() {
        return STATUS;
    }
}

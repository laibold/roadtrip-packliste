package com.laibold.roadtrippackliste.model.exception.notFound;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
    protected static final HttpStatus STATUS = HttpStatus.NOT_FOUND;
}

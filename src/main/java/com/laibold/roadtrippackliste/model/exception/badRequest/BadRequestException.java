package com.laibold.roadtrippackliste.model.exception.badRequest;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    protected static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
}

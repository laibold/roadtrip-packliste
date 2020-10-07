package com.laibold.roadtrippackliste.model.exception;

import org.springframework.http.HttpStatus;

public interface RequestException {

    String getErrorMessage();
    HttpStatus getStatus();
}

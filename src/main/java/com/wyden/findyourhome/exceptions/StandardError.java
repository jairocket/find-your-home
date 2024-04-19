package com.wyden.findyourhome.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private String message;
    private Integer status;
    private Long timestamp;
    private String error;
    private String path;

    public StandardError(String message, Integer status, Long timestamp, String error, String path) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
        this.path = path;
    }

    public StandardError() {
    }
}

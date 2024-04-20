package com.wyden.findyourhome.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Integer status;
    private Long timestamp;
    private String error;
    private String path;

    public StandardError(Integer status, Long timestamp, String error, String path) {
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
        this.path = path;
    }

    public StandardError() {
    }

    public Integer getStatus() {
        return status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}

package com.test.advertiser.exception;

import org.springframework.util.StringUtils;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2565431806475335331L;

    private String resourceName;
    private Integer id;

    public ResourceNotFoundException(String message, String resourceName, Integer id) {
        super(message);
        this.resourceName = resourceName;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return StringUtils.capitalize(resourceName) + " with id " + id + " is not found.";
    }
}
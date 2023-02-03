package com.lukmic.familyapplication.request;

import jakarta.validation.constraints.NotNull;

public class IdRequest {

    @NotNull(message = "Error: bad request, id can't be null")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

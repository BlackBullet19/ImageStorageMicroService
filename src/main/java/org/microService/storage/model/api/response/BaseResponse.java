package org.microService.storage.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public BaseResponse(String error) {
        this.error = error;
    }

    public BaseResponse() {
        //
    }
}

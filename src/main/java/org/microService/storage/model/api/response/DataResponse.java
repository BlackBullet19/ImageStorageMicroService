package org.microService.storage.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse<T> extends BaseResponse{

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public DataResponse(String error, boolean success, T t) {
        super(error, success);
        this.t = t;
    }

    public DataResponse() {
        //
    }
}

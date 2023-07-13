package org.microService.storage.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse<T> extends BaseResponse {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public DataResponse(String error, T t) {
        super(error);
        this.t = t;
    }

    public DataResponse() {
        //
    }

    public static <T> DataResponse<T> success(T t) {
        DataResponse dataResponse = new DataResponse();
        dataResponse.setT(t);
        return dataResponse;
    }

    public static DataResponse error(String error) {
        DataResponse dataResponse = new DataResponse();
        dataResponse.setError(error);
        return dataResponse;
    }
}

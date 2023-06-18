package org.microService.storage.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ListResponse <T> extends BaseResponse{

    private T list;

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    public ListResponse(String error, boolean success, T tList) {
        super(error, success);
        this.list = tList;
    }

    public ListResponse() {
        //
    }
}

package org.microService.storage.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ListResponse<T> extends BaseResponse {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ListResponse() {
        //
    }

    public static <T> ListResponse<T> success(List<T> list) {
        ListResponse<T> response = new ListResponse<>();
        response.setList(list);
        response.setSuccess(true);
        return response;
    }

    public static ListResponse error(String error) {
        ListResponse listResponse = new ListResponse();
        listResponse.setError(error);
        listResponse.setSuccess(false);
        return listResponse;
    }
}

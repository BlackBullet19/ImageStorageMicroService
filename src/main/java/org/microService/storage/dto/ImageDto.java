package org.microService.storage.dto;

import org.microService.storage.service.EntityMicroService;

public class ImageDto implements EntityMicroService {

    private byte[] body;

    public ImageDto(byte[] body) {
        this.body = body;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public ImageDto() {
        //
    }
}

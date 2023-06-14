package org.microService.storage.dto;

public class ImageDto {

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

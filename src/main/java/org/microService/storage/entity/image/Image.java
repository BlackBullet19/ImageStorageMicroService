package org.microService.storage.entity.image;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "images")
public class Image {
    @Id
    private String uuid;
    private byte[] body;

    public Image(String uuid, byte[] body) {
        this.uuid = uuid;
        this.body = body;
    }

    public Image() {
        //
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}

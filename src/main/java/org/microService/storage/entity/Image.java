package org.microService.storage.entity;

import org.microService.storage.service.EntityMicroService;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "images")
public class Image implements EntityMicroService {

    @MongoId
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

package org.microService.storage.model.image;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Document(collection = "images")
public class Image {
    @Id
    private Long id;
    private String uuid;
    private byte[] body;

    public Image(String uuid, byte[] body) {
        this.uuid = uuid;
        this.body = body;
    }

    public Image(Long id, String uuid, byte[] body) {
        this.id = id;
        this.uuid = uuid;
        this.body = body;
    }

    public Image(String uuid, Byte[] image) {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

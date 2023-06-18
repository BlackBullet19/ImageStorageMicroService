package org.microService.storage.entity.imageInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ImageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private Long userId;
    private Date creationDate;
    private Long size;

    public ImageInfo(String uuid, Long userId, Date creationDate, Long size) {
        this.uuid = uuid;
        this.userId = userId;
        this.creationDate = creationDate;
        this.size = size;
    }

    public ImageInfo() {
        //
    }

    public ImageInfo(Long id, String uuid, Long userId, Date creationDate, Long size) {
        this.id = id;
        this.uuid = uuid;
        this.userId = userId;
        this.creationDate = creationDate;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

package org.microService.storage.dto;

import java.util.Date;

public class ImageInfoDto {

    private String uuid;

    private Date creationDate;

    private Long size;

    public ImageInfoDto(String uuid, Date creationDate, Long size) {
        this.uuid = uuid;
        this.creationDate = creationDate;
        this.size = size;
    }

    public ImageInfoDto() {
        //
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
}

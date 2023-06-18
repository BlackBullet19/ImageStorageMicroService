package org.microService.storage.dto;

import java.time.LocalDate;

public class ImageInfoDto {

    private String uuid;

    private LocalDate creationDate;

    private Long size;

    public ImageInfoDto(String uuid, LocalDate creationDate, Long size) {
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}

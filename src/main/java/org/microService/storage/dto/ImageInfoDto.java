package org.microService.storage.dto;

import org.microService.storage.service.EntityMicroService;

import java.time.LocalDate;

public class ImageInfoDto implements EntityMicroService {

    private String uuid;

    private LocalDate creationDate;

    private Long size;

    private String name;

    private String type;

    public ImageInfoDto(String uuid, LocalDate creationDate, Long size, String name, String type) {
        this.uuid = uuid;
        this.creationDate = creationDate;
        this.size = size;
        this.name = name;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

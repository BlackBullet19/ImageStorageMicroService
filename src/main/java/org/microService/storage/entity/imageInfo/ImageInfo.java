package org.microService.storage.entity.imageInfo;

import org.microService.storage.service.EntityMicroService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ImageInfo implements EntityMicroService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private Long userId;
    private LocalDate creationDate;
    private Long size;

    private String name;

    private String type;

    public ImageInfo(String uuid, Long userId, LocalDate creationDate, Long size, String name, String type) {
        this.uuid = uuid;
        this.userId = userId;
        this.creationDate = creationDate;
        this.size = size;
        this.name = name;
        this.type = type;
    }

    public ImageInfo() {
        //
    }

    public ImageInfo(Long id, String uuid, Long userId, LocalDate creationDate, Long size, String name, String type) {
        this.id = id;
        this.uuid = uuid;
        this.userId = userId;
        this.creationDate = creationDate;
        this.size = size;
        this.name = name;
        this.type = type;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

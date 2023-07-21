package org.microService.storage.service.Mapper;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.imageInfo.ImageInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ImageInfoMapper implements Mapper<ImageInfo, ImageInfoDto> {
    @Override
    public ImageInfoDto toDto(ImageInfo entity) {
        ImageInfoDto dto = new ImageInfoDto();
        String uuid = entity.getUuid();
        LocalDate creationDate = entity.getCreationDate();
        Long size = entity.getSize();
        String name = entity.getName();
        String type = entity.getType();
        dto.setSize(size);
        dto.setUuid(uuid);
        dto.setCreationDate(creationDate);
        dto.setName(name);
        dto.setType(type);
        return dto;
    }
}

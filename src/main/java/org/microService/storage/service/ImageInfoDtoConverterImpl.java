package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.imageInfo.ImageInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageInfoDtoConverterImpl implements ImageInfoDtoConverter {
    @Override
    public ImageInfoDto toDto(ImageInfo imageInfo) {
        ImageInfoDto imageInfoDto = new ImageInfoDto();
        String uuid = imageInfo.getUuid();
        LocalDate creationDate = imageInfo.getCreationDate();
        Long size = imageInfo.getSize();
        imageInfoDto.setSize(size);
        imageInfoDto.setUuid(uuid);
        imageInfoDto.setCreationDate(creationDate);
        return imageInfoDto;
    }

    @Override
    public List<ImageInfoDto> toDtoList(List<ImageInfo> imageInfos) {
        List<ImageInfoDto> dtos = new ArrayList<>();
        imageInfos.forEach(imageInfo -> dtos.add(toDto(imageInfo)));
        return dtos;
    }
}

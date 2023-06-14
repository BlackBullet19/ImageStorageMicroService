package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.imageInfo.ImageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageInfoDtoConverterImpl implements ImageInfoDtoConverter {
    @Override
    public ImageInfoDto toImageInfoDto(ImageInfo imageInfo) {
        ImageInfoDto imageInfoDto = new ImageInfoDto();
        String uuid = imageInfo.getUuid();
        Date creationDate = imageInfo.getCreationDate();
        Long size = imageInfo.getSize();
        imageInfoDto.setSize(size);
        imageInfoDto.setUuid(uuid);
        imageInfoDto.setCreationDate(creationDate);
        return imageInfoDto;
    }

    @Override
    public List<ImageInfoDto> fromImageInfoListToImageInfoDtoList(List<ImageInfo> imageInfos) {
        List<ImageInfoDto> dtos = new ArrayList<>();
        imageInfos.forEach(imageInfo -> dtos.add(toImageInfoDto(imageInfo)));
        return dtos;
    }
}

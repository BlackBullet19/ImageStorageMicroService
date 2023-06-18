package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.imageInfo.ImageInfo;

import java.util.List;

public interface ImageInfoDtoConverter {

    ImageInfoDto toDto(ImageInfo imageInfo);

    List<ImageInfoDto> toDtoList(List<ImageInfo> imageInfos);
}

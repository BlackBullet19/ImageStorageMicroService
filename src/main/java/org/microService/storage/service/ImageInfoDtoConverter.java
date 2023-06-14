package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.imageInfo.ImageInfo;

import java.util.List;

public interface ImageInfoDtoConverter {

    ImageInfoDto toImageInfoDto(ImageInfo imageInfo);

    List<ImageInfoDto> fromImageInfoListToImageInfoDtoList(List<ImageInfo> imageInfos);
}

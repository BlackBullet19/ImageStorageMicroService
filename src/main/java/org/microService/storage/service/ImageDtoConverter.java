package org.microService.storage.service;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.entity.image.Image;

public interface ImageDtoConverter {

    ImageDto toDto(Image image);
}

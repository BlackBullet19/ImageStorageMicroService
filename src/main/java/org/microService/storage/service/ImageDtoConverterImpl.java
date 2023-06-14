package org.microService.storage.service;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.entity.image.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageDtoConverterImpl implements ImageDtoConverter {
    @Override
    public ImageDto toImageDto(Image image) {
        ImageDto imageDto = new ImageDto();
        byte[] body = image.getBody();
        imageDto.setBody(body);
        return imageDto;
    }
}

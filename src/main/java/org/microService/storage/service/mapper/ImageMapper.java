package org.microService.storage.service.mapper;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.entity.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageMapper implements Mapper<Image, ImageDto> {

    @Override
    public ImageDto toDto(Image entity) {
        ImageDto imageDto = new ImageDto();
        byte[] body = entity.getBody();
        imageDto.setBody(body);
        return imageDto;
    }
}

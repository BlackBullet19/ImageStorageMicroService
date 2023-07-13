package org.microService.storage.service;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.entity.image.Image;
import org.microService.storage.model.api.response.DataResponse;
import org.microService.storage.service.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImageApiServiceImpl implements ImageApiService {

    private final ImageStorageService service;

    private final Mapper<Image, ImageDto> mapper;

    @Autowired
    public ImageApiServiceImpl(ImageStorageService service, Mapper<Image, ImageDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public DataResponse<ImageDto> getByUUID(String uuid) {
             return DataResponse.success(mapper.toDto(service.getByUUID(uuid)));
    }
}

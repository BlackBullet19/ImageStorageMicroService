package org.microService.storage.service;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.model.api.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageApiServiceImpl implements ImageApiService {

    private final ImageStorageService service;

    private final ImageDtoConverter converter;

    @Autowired
    public ImageApiServiceImpl(ImageStorageService service, ImageDtoConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    public DataResponse<ImageDto> getByUUID(String uuid) {
        try {
            DataResponse<ImageDto> response =
                    new DataResponse<>(null, true, converter.toDto(service.getByUUID(uuid)));
            return response;
        } catch (IllegalArgumentException exception) {
            DataResponse<ImageDto> response = new DataResponse<>(exception.getMessage(), false, null);
            return response;
        }
    }
}

package org.microService.storage.service;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.model.api.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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
            return DataResponse.success(converter.toDto(service.getByUUID(uuid)));
        } catch (NoSuchElementException e) {
            return DataResponse.error(e.getMessage());

        } catch (IllegalArgumentException exception) {
            return DataResponse.error(exception.getMessage());
        }
    }
}

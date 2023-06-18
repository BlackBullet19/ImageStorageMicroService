package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageInfoApiServiceImpl implements ImageInfoApiService {

    private final ImageInfoStorageService storageService;

    private final ImageInfoDtoConverter converter;

    @Autowired
    public ImageInfoApiServiceImpl(ImageInfoStorageService storageService, ImageInfoDtoConverter converter) {
        this.storageService = storageService;
        this.converter = converter;
    }

    @Override
    public ListResponse<ImageInfoDto> getFilteredList(Long userId, String from, String to) {
        try {
            return ListResponse.success
                    (converter.toDtoList(storageService.getListByUserIdAndDateRange(userId, from, to)));
        } catch (IllegalArgumentException exception) {
            return ListResponse.error(exception.getMessage());
        }
    }
}

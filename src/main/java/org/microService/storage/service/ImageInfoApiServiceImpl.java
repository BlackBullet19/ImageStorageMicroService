package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public ListResponse<List<ImageInfoDto>> getFilteredList(Long userId, Date from, Date to) {
        try {
            ListResponse<List<ImageInfoDto>> response = new ListResponse<>
                    (null, true, converter
                            .toDtoList(storageService.getListByUserIdAndDateRange(userId, from, to)));
            return response;
        } catch (IllegalArgumentException exception) {
            ListResponse<List<ImageInfoDto>> response = new ListResponse<>
                    (exception.getMessage(), false, null);
            return response;
        }
    }
}

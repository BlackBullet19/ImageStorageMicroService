package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.imageInfo.ImageInfo;
import org.microService.storage.model.api.response.ListResponse;
import org.microService.storage.service.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageInfoApiServiceImpl implements ImageInfoApiService {

    private final ImageInfoStorageService storageService;

    private final Mapper<ImageInfo, ImageInfoDto> mapper;

    @Autowired
    public ImageInfoApiServiceImpl(ImageInfoStorageService storageService, Mapper<ImageInfo, ImageInfoDto> mapper) {
        this.storageService = storageService;
        this.mapper = mapper;
    }

    @Override
    public ListResponse<ImageInfoDto> getFilteredList(Long userId, String from, String to) {
            List<ImageInfo> list = storageService.getListByUserIdAndDateRange(userId, from, to);
            List<ImageInfoDto> collect = list.stream().map(mapper::toDto).toList();
            return ListResponse.success(collect);
    }
}

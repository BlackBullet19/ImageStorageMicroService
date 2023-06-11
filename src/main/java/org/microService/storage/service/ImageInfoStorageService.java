package org.microService.storage.service;

import org.microService.storage.model.imageInfo.ImageInfo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ImageInfoStorageService {

    ImageInfo saveImageInfo(UUID uuid, Long userId, Date date, Long size);

    List<ImageInfo> getListOfImageInfoByUserIdAndDateRange(Long userId, Date from, Date to);
}

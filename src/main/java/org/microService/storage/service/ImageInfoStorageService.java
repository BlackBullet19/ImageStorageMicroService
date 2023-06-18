package org.microService.storage.service;

import org.microService.storage.entity.imageInfo.ImageInfo;

import java.util.Date;
import java.util.List;

public interface ImageInfoStorageService {

    ImageInfo save(String uuid, Long userId, Date date, Long size);

    List<ImageInfo> getListByUserIdAndDateRange(Long userId, Date from, Date to);
}

package org.microService.storage.service;

import org.microService.storage.entity.imageInfo.ImageInfo;

import java.time.LocalDate;
import java.util.List;

public interface ImageInfoStorageService {

    ImageInfo save(String uuid, Long userId, LocalDate date, Long size, String name, String type);

    List<ImageInfo> getListByUserIdAndDateRange(Long userId, String from, String to);
}

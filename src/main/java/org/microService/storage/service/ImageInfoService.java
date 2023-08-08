package org.microService.storage.service;

import org.microService.storage.entity.ImageInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface ImageInfoService {

    ImageInfo save(String uuid, Long userId, LocalDate date, Long size, String name, String type);

    List<ImageInfo> getListByUserIdAndDateRange(Long userId, String from, String to, Locale locale);
}

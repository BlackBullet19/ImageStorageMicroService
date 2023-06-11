package org.microService.storage.service;

import org.microService.storage.model.imageInfo.ImageInfo;
import org.microService.storage.repository.imageInfo.ImageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class ImageInfoStorageServiceImpl implements ImageInfoStorageService {

    private final ImageInfoRepository imageInfoRepository;

    @Autowired
    public ImageInfoStorageServiceImpl(ImageInfoRepository imageInfoRepository) {
        this.imageInfoRepository = imageInfoRepository;
    }

    @Override
    public ImageInfo saveImageInfo(UUID uuid, Long userId, Date date, Long size) {
        if (uuid == null) throw new IllegalArgumentException("UUID must be declared");
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("UserId must be declared and cannot be less than 0");
        if (date == null) throw new IllegalArgumentException("Date cannot be null");
        if (size == null) throw new IllegalArgumentException("Size cannot be null");
        return imageInfoRepository.save(new ImageInfo(uuid, userId, date, size));
    }

    @Override
    public List<ImageInfo> getListOfImageInfoByUserIdAndDateRange(Long userId, Date from, Date to) {
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("UserId must be declared and cannot be less than 0");
        if (from == null || to == null) throw new IllegalArgumentException("Date cannot be null");
        return imageInfoRepository.getAllImageInfoByUserIdAndCreationDateGreaterThanEqualAndCreationDateIsLessThanEqual
                (userId, from, to);
    }
}

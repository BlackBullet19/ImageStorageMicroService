package org.microService.storage.service;

import org.microService.storage.entity.imageInfo.ImageInfo;
import org.microService.storage.repository.imageInfo.ImageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImageInfoStorageServiceImpl implements ImageInfoStorageService {

    private final ImageInfoRepository imageInfoRepository;

    @Autowired
    public ImageInfoStorageServiceImpl(ImageInfoRepository imageInfoRepository) {
        this.imageInfoRepository = imageInfoRepository;
    }

    @Override
    public ImageInfo save(String uuid, Long userId, Date date, Long size) {
        if (uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID must be declared");
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("UserId must be declared and cannot be less than 0");
        if (date == null) throw new IllegalArgumentException("Date cannot be null");
        if (size == null) throw new IllegalArgumentException("Size cannot be null");
        return imageInfoRepository.save(new ImageInfo(uuid, userId, date, size));
    }

    @Override
    public List<ImageInfo> getListByUserIdAndDateRange(Long userId, Date from, Date to) {
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("UserId must be declared and cannot be less than 0");
        if (from == null || to == null) throw new IllegalArgumentException("Date cannot be null");
        return imageInfoRepository.getAllByUserIdAndCreationDateGreaterThanEqualAndCreationDateIsLessThanEqual
                (userId, from, to);
    }
}

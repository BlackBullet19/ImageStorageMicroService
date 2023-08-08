package org.microService.storage.service;

import org.microService.storage.entity.ImageInfo;
import org.microService.storage.repository.imageInfo.ImageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

@Service
public class ImageInfoServiceImpl implements ImageInfoService {

    private final ImageInfoRepository imageInfoRepository;

    private final MessageSource messageSource;

    @Autowired
    public ImageInfoServiceImpl(ImageInfoRepository imageInfoRepository, MessageSource messageSource) {
        this.imageInfoRepository = imageInfoRepository;
        this.messageSource = messageSource;
    }

    @Override
    public ImageInfo save(String uuid, Long userId, LocalDate date, Long size, String name, String type) {
        if (uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID must be declared");
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("UserId must be declared and cannot be less than 0");
        if (date == null) throw new IllegalArgumentException("Date cannot be null");
        if (size == null) throw new IllegalArgumentException("Size cannot be null");
        if (name.isBlank() || name.isEmpty()) throw new IllegalArgumentException("Image must have name");
        if (type.isEmpty() || type.isBlank()) throw new IllegalArgumentException("Type must be declared");
        return imageInfoRepository.save(new ImageInfo(uuid, userId, date, size, name, type));
    }

    @Override
    public List<ImageInfo> getListByUserIdAndDateRange(Long userId, String from, String to, Locale locale) {
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException(messageSource.
                    getMessage("userId.not.declared.exception", null, locale));
        if (from.isEmpty() || to.isEmpty() || from.isBlank() || to.isBlank())
            throw new IllegalArgumentException(messageSource.
                    getMessage("date.not.declared.exception", null, locale));
        if (from.length() != 10 || to.length() != 10)
            throw new IllegalArgumentException(messageSource.
                    getMessage("date.format.exception", null, locale));
        LocalDate dateFrom;
        LocalDate dateTo;
        try {
            dateFrom = LocalDate.parse(from);
            dateTo = LocalDate.parse(to);
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException(messageSource.
                    getMessage("date.parse.format.exception", null, locale));
        }
        return imageInfoRepository.getAllByUserIdAndCreationDateGreaterThanEqualAndCreationDateIsLessThanEqual
                (userId, dateFrom, dateTo);
    }
}

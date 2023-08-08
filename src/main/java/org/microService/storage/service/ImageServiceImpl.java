package org.microService.storage.service;

import org.microService.storage.entity.Image;
import org.microService.storage.repository.image.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.NoSuchElementException;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    private final MessageSource messageSource;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, MessageSource messageSource) {
        this.imageRepository = imageRepository;
        this.messageSource = messageSource;
    }

    @Override
    public Image save(String uuid, byte[] image) {
        if (uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID must be declared");
        if (image == null) throw new IllegalStateException("Image doesnt exist");
        return imageRepository.save(new Image(uuid, image));
    }

    @Override
    public Image getByUUID(String uuid, Locale locale) {
        if (uuid == null || uuid.isEmpty() || uuid.isBlank())
            throw new IllegalArgumentException(messageSource.
                    getMessage("uuid.not.declared.exception", null, locale));
        if (uuid.length() != 36) throw new IllegalArgumentException(messageSource.
                getMessage("uuid.too.short.exception", null, locale));
        if (imageRepository.findById(uuid).isEmpty()) throw new NoSuchElementException(messageSource.
                getMessage("image.not.found.exception", null, locale));
        return imageRepository.findById(uuid).get();
    }
}

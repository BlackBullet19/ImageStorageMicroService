package org.microService.storage.service;

import org.microService.storage.entity.image.Image;
import org.microService.storage.repository.image.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageStorageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(String uuid, byte[] image) {
        if (uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID must be declared");
        if (image == null) throw new IllegalStateException("Image doesnt exist");
        return imageRepository.save(new Image(uuid, image));
    }

    @Override
    public Image getByUUID(String uuid) {
        if (uuid == null || uuid.isEmpty() || uuid.isBlank())
            throw new IllegalArgumentException("UUID must be declared");
        if(uuid.length()!= 36) throw new IllegalArgumentException("UUID must contain 36 characters");
        if(imageRepository.findById(uuid).isEmpty()) throw new NoSuchElementException("Image not found");
        return imageRepository.findById(uuid).get();
    }
}

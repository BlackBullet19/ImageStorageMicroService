package org.microService.storage.service;

import org.microService.storage.entity.image.Image;
import org.microService.storage.repository.image.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageStorageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(String uuid, byte[] image) {
        if (uuid == null) throw new IllegalArgumentException("UUID must be declared");
        if(image == null) throw new IllegalStateException("Image doesnt exist");
        return imageRepository.save(new Image(uuid, image));
    }

    @Override
    public Image getByUUID(String uuid) {
        if (uuid == null) throw new IllegalArgumentException("UUID must be declared");
        return imageRepository.findByUuid(uuid);
    }
}

package org.microService.storage.service;

import org.microService.storage.model.image.Image;

public interface ImageStorageService {

    Image saveImage(Long id, String uuid, byte[] image);

    Image getByImageId(String imageId);
}

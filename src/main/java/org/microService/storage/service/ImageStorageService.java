package org.microService.storage.service;

import org.microService.storage.entity.image.Image;

public interface ImageStorageService {

    Image saveImage(String uuid, byte[] image);

    Image getByImageUUID(String imageUUID);
}

package org.microService.storage.service;

import org.microService.storage.entity.image.Image;

public interface ImageStorageService {

    Image save(String uuid, byte[] image);

    Image getByUUID(String uuid);
}

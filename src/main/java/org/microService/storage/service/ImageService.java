package org.microService.storage.service;

import org.microService.storage.entity.Image;

import java.util.Locale;

public interface ImageService {

    Image save(String uuid, byte[] image);

    Image getByUUID(String uuid, Locale locale);
}

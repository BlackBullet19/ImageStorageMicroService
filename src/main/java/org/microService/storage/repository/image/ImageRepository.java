package org.microService.storage.repository.image;

import org.microService.storage.model.image.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository  extends MongoRepository<Image, Long>{
    Image findByUuid(String uuid);
}

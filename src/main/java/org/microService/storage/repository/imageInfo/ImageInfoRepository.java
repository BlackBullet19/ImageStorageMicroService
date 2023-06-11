package org.microService.storage.repository.imageInfo;

import org.microService.storage.model.imageInfo.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ImageInfoRepository extends JpaRepository<ImageInfo, Long> {
    List<ImageInfo> getAllImageInfoByUserIdAndCreationDateGreaterThanEqualAndCreationDateIsLessThanEqual
            (Long userId, Date creationDate, Date creationDateTo);
}

package org.microService.storage.repository.imageInfo;

import org.microService.storage.entity.imageInfo.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ImageInfoRepository extends JpaRepository<ImageInfo, Long> {

    List<ImageInfo> getAllByUserIdAndCreationDateGreaterThanEqualAndCreationDateIsLessThanEqual
            (Long userId, LocalDate creationDate, LocalDate creationDateTo);
}

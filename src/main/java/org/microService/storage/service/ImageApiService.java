package org.microService.storage.service;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.model.api.response.DataResponse;

public interface ImageApiService {

    DataResponse<ImageDto> getByUUID(String uuid);
}

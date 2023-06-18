package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;

public interface ImageInfoApiService {

    ListResponse<ImageInfoDto> getFilteredList(Long userId, String from, String to);
}

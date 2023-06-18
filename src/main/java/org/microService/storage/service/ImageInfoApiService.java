package org.microService.storage.service;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;

import java.util.Date;
import java.util.List;

public interface ImageInfoApiService {

    ListResponse<ImageInfoDto> getFilteredList(Long userId, Date from, Date to);
}

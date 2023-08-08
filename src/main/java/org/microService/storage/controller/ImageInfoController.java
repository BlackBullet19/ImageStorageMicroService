package org.microService.storage.controller;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.entity.ImageInfo;
import org.microService.storage.model.api.response.ListResponse;
import org.microService.storage.service.ImageInfoService;
import org.microService.storage.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/images_info")
public class ImageInfoController {

    private final Mapper<ImageInfo, ImageInfoDto> mapper;

    private final ImageInfoService imageInfoService;

    @Autowired
    public ImageInfoController(Mapper<ImageInfo, ImageInfoDto> mapper, ImageInfoService imageInfoService) {
        this.imageInfoService = imageInfoService;
        this.mapper = mapper;
    }

    @GetMapping(path = "/filtered_list")
    public ResponseEntity<ListResponse<ImageInfoDto>> getListByUserIdAndDateRange
            (@RequestParam(value = "id") Long userId
                    , @RequestParam(value = "from") String from
                    , @RequestParam(value = "to") String to
                    , @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        List<ImageInfo> list = imageInfoService.getListByUserIdAndDateRange(userId, from, to, locale);
        List<ImageInfoDto> collect = list.stream().map(mapper::toDto).toList();
        ListResponse<ImageInfoDto> filteredList = ListResponse.success(collect);
        return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }
}

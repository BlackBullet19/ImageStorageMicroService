package org.microService.storage.controller;

import org.microService.storage.service.ImageInfoDtoConverter;
import org.microService.storage.service.ImageInfoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/images_info")
public class ImageInfoStorageController {

    private final ImageInfoStorageService storageService;

    private final ImageInfoDtoConverter converter;

    @Autowired
    public ImageInfoStorageController(ImageInfoStorageService storageService, ImageInfoDtoConverter converter) {
        this.storageService = storageService;
        this.converter = converter;
    }

    @GetMapping(path = "/get_info_list_by_userid_date_from_date_to")
    public ResponseEntity<?> getListByUserIdAndDateRange
            (@RequestParam(value = "id") Long userId
                    , @DateTimeFormat(pattern = "yyyy-MM-dd") Date from
                    , @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        try {
            return new ResponseEntity<>
                    (converter.fromImageInfoListToImageInfoDtoList
                            (storageService.getListOfImageInfoByUserIdAndDateRange(userId, from, to)), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}

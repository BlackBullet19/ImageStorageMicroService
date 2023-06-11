package org.microService.storage.controller;

import org.microService.storage.service.ImageInfoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/storage/info")
public class ImageInfoStorageController {

    private final ImageInfoStorageService storageService;

    @Autowired
    public ImageInfoStorageController(ImageInfoStorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(path = "/getList")
    public ResponseEntity<?> getListByUserId
            (@RequestParam(value = "id") Long userId
                    , @DateTimeFormat(pattern = "yyyy-MM-dd") Date from
                    , @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        try {
            return new ResponseEntity<>
                    (storageService.getListOfImageInfoByUserIdAndDateRange(userId, from, to), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}

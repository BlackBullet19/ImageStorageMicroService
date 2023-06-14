package org.microService.storage.controller;

import org.microService.storage.service.ImageDtoConverter;
import org.microService.storage.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
public class ImageStorageController {

    private final ImageStorageService service;

    private final ImageDtoConverter converter;

    @Autowired
    public ImageStorageController(ImageStorageService service, ImageDtoConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getImageByUUID(@PathVariable(value = "uuid") String uuid) {
        try {
            return new ResponseEntity<>(converter.toImageDto(service.getByImageUUID(uuid)), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}

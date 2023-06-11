package org.microService.storage.controller;

import org.microService.storage.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/storage/image")
public class ImageStorageController {

    private final ImageStorageService service;

    @Autowired
    public ImageStorageController(ImageStorageService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getImageById(@RequestParam(value = "id")String uuid) {
        try {
            return new ResponseEntity<>(service.getByImageId(uuid), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}

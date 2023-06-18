package org.microService.storage.controller;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.model.api.response.DataResponse;
import org.microService.storage.service.ImageApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
public class ImageStorageController {

    private final ImageApiService service;

    @Autowired
    public ImageStorageController(ImageApiService service) {
        this.service = service;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DataResponse<ImageDto>> getByUUID(@PathVariable(value = "uuid") String uuid) {
        DataResponse<ImageDto> byUUID = service.getByUUID(uuid);
        return new ResponseEntity<>(byUUID, byUUID.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

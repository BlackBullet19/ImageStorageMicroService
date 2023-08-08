package org.microService.storage.controller;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.entity.Image;
import org.microService.storage.model.api.response.DataResponse;
import org.microService.storage.service.ImageService;
import org.microService.storage.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService service;

    private final Mapper<Image, ImageDto> mapper;

    @Autowired
    public ImageController(ImageService service, Mapper<Image, ImageDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DataResponse<ImageDto>> getByUUID(@PathVariable(value = "uuid") String uuid,
                                                            @RequestHeader(value = "Accept-Language",
                                                                    required = false) Locale locale) {
        Image image = service.getByUUID(uuid, locale);
        ImageDto dto = mapper.toDto(image);
        DataResponse<ImageDto> imageDtoResponse = DataResponse.success(dto);
        return new ResponseEntity<>(imageDtoResponse, HttpStatus.OK);
    }
}

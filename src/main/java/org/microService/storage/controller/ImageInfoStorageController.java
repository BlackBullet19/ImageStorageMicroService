package org.microService.storage.controller;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;
import org.microService.storage.service.ImageInfoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images_info")
public class ImageInfoStorageController {

    private final ImageInfoApiService service;

    @Autowired
    public ImageInfoStorageController(ImageInfoApiService service) {
        this.service = service;
    }

    @GetMapping(path = "/filtered_list")
    public ResponseEntity<ListResponse<ImageInfoDto>> getListByUserIdAndDateRange
            (@RequestParam(value = "id") Long userId
                    , @RequestParam(value = "from") String from
                    , @RequestParam(value = "to") String to) {
        ListResponse<ImageInfoDto> filteredList = service.getFilteredList(userId, from, to);
        return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }
}

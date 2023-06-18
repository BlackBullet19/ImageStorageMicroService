package org.microService.storage.controller;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;
import org.microService.storage.service.ImageInfoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/images_info")
public class ImageInfoStorageController {

    private final ImageInfoApiService service;

    @Autowired
    public ImageInfoStorageController(ImageInfoApiService service) {
        this.service = service;
    }

    @GetMapping(path = "/get_filtered_info_list")
    public ResponseEntity<ListResponse<List<ImageInfoDto>>> getListByUserIdAndDateRange
            (@RequestParam(value = "id") Long userId
                    , @DateTimeFormat(pattern = "yyyy-MM-dd") Date from
                    , @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        ListResponse<List<ImageInfoDto>> filteredList = service.getFilteredList(userId, from, to);
        return new ResponseEntity<>(filteredList, filteredList.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}

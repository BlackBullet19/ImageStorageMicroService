package org.microService.storage.service.handler;

import org.microService.storage.dto.ImageInfoDto;
import org.microService.storage.model.api.response.ListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ImageInfoExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ListResponse<ImageInfoDto>> handleIllegalArgumentException(IllegalArgumentException exception
            , HttpServletRequest request){
        return new ResponseEntity<ListResponse<ImageInfoDto>>
                (ListResponse.error(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

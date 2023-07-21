package org.microService.storage.service.handler;

import org.microService.storage.dto.ImageDto;
import org.microService.storage.model.api.response.DataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ImageExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DataResponse<ImageDto>> handleIllegalArgumentException(IllegalArgumentException exception,
                                                                                 HttpServletRequest request) {
        return new ResponseEntity<DataResponse<ImageDto>>
                (DataResponse.error(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<DataResponse<ImageDto>> handleNoSuchElementException(NoSuchElementException exception,
                                                                               HttpServletRequest request) {
        return new ResponseEntity<DataResponse<ImageDto>>
                (DataResponse.error(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}

package org.microService.storage.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.microService.storage.service.ImageInfoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class InfoStorageProcessor implements Processor {

    private final ImageInfoStorageService storageService;

    @Autowired
    public InfoStorageProcessor(ImageInfoStorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void process(Exchange exchange) {
        Message message = exchange.getIn();
        String uuid = UUID.randomUUID().toString();
        message.setHeader("UUID", uuid);
        Long userId = message.getHeader("UserId", Long.class);
        java.util.Date date = Date.valueOf(LocalDate.now());
        Long size = message.getHeader("CamelFileLength", Long.class);
        storageService.saveImageInfo(uuid, 1L, date, size);
        //storageService.saveImageInfo(uuid, userId, date, size);
    }
}

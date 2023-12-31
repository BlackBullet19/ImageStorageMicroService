package org.microService.storage.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.microService.storage.service.ImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class ImageInfoProcessor implements Processor {

    private final ImageInfoService service;

    @Autowired
    public ImageInfoProcessor(ImageInfoService service) {
        this.service = service;
    }

    @Override
    public void process(Exchange exchange) {
        Message message = exchange.getIn();
        String uuid = UUID.randomUUID().toString();
        message.setHeader("UUID", uuid);
        Long userId = message.getHeader("UserId", Long.class);
        LocalDate date = LocalDate.now();
        Long size = message.getHeader("size", Long.class);
        String name = message.getHeader("filename", String.class);
        String type = message.getHeader("type", String.class);
        service.save(uuid, 1L, date, size, name, type);
    }
}

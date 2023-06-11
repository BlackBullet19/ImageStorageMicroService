package org.microService.storage.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.microService.storage.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Component
public class ImageStorageProcessor implements Processor {

    private final ImageStorageService storageService;

    @Autowired
    public ImageStorageProcessor(ImageStorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void process(Exchange exchange) {
        Message message = exchange.getIn();
        File file = exchange.getIn().getBody(File.class);
        byte[] body = new byte[(int) file.length()];
        try {
            try (FileInputStream inputStream = new FileInputStream(file)) {
                inputStream.read(body);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UUID uuid = message.getHeader("UUID", UUID.class);
        String uuidString = uuid.toString();
        Long id = (long)Math.random();
        storageService.saveImage(id, uuidString, body);
    }
}

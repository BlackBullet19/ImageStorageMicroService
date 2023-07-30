package org.microService.storage.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.microService.storage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageProcessor implements Processor {

    private final ImageService service;

    @Autowired
    public ImageProcessor(ImageService service) {
        this.service = service;
    }

    @Override
    public void process(Exchange exchange) {
        Message message = exchange.getIn();
        byte[] body = message.getBody(byte[].class);
        String uuid = message.getHeader("UUID", String.class);
        service.save(uuid, body);
    }
}

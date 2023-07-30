package org.microService.storage.route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RouteBuilder extends org.apache.camel.builder.RouteBuilder {

    @Value("${storage-microservice.path:}")
    private String pathToQueue;

    @Override
    public void configure() throws Exception {
        String path = pathToQueue;

        from(path)
                .routeId("imageInputRoute")
                .process("infoStorageProcessor")
                .process("imageStorageProcessor")
                .stop();
    }
}

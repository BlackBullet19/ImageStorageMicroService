package org.microService.storage.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StorageRouteBuilder extends RouteBuilder {

    @Value("${storage-microservice.path:}")
    private String pathToQueue;

    @Override
    public void configure() throws Exception {
        String path = "file://" + pathToQueue + "?delete=true";

        from(path)
                .routeId("imageInputRoute")
                .process("infoStorageProcessor")
                .process("imageStorageProcessor")
                .stop();
    }
}

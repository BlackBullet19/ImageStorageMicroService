package org.microService.storage;

import org.microService.storage.configuration.ImageMongoConfiguration;
import org.microService.storage.configuration.ImageInfoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ImageMongoConfiguration.class, ImageInfoConfiguration.class})
public class StorageMain {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain.class, args);
    }
}
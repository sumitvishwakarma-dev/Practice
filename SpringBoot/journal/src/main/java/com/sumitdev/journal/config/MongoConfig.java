package com.sumitdev.journal.config;
    import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

    @Component
    public class MongoConfig {

        @Value("${spring.mongodb.uri}")
        private String mongoUri;

        @PostConstruct
        public void checkMongoUri() {
//            System.out.println("=================================");
//            System.out.println("Mongo URI: " + mongoUri);
//            System.out.println("=================================");
        }
    }

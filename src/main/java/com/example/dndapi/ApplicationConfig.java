package com.example.dndapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.example.dndapi.repository")
public class ApplicationConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "dndDB";
    }
}

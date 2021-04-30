package com.platform3.demoproject.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Configuration
public class MongoConfiguration {

    @Value("${mongodb.username}")
    private String userName;

    @Value("${mongodb.password}")
    private String password;

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private String port;

    @Value("${mongodb.database}")
    private String databaseName;

    @Bean
    public MongoClient mongo() throws UnsupportedEncodingException {
        /* mongodb://username:password@host:port/database_name?authSource=admin&authMechanism=SCRAM-SHA-1 */
        String connectionUri = "mongodb://"+userName+":"+ URLEncoder.encode(password, StandardCharsets.UTF_8.toString())+"@"+host+":"+port+"/"+databaseName+"?authSource=admin&authMechanism=SCRAM-SHA-1";
        System.out.println("dinesh connection url is ::"+connectionUri);
        ConnectionString connectionString = new ConnectionString(connectionUri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), Objects.requireNonNull(databaseName));
    }

}


//package com.ak.example.circleci.config;
//
//import de.flapdoodle.embed.mongo.MongodExecutable;
//import de.flapdoodle.embed.mongo.MongodProcess;
//import de.flapdoodle.embed.mongo.MongodStarter;
//import de.flapdoodle.embed.mongo.config.IMongodConfig;
//import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
//import de.flapdoodle.embed.mongo.config.Net;
//import de.flapdoodle.embed.mongo.distribution.Version;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//@Configuration
//public class MongoConfig {
//    @Autowired
//    private MongoDbFactory mongoDbFactory;
//    @Autowired
//    private MongoMappingContext mongoMappingContext;
//
//    MongodStarter starter = MongodStarter.getDefaultInstance();
//    MongodExecutable mongodExecutable;
//
//    @Bean
//    public MappingMongoConverter mappingMongoConverter() {
//        var converter = new MappingMongoConverter(
//                new DefaultDbRefResolver(mongoDbFactory),
//                mongoMappingContext
//        );
//
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        return converter;
//    }
//
//    @PostConstruct
//    public void construct() throws IOException {
//        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION).net(new Net("localhost", 5603, true)).build();
//        mongodExecutable = starter.prepare(mongodConfig);
//        MongodProcess mongod = mongodExecutable.start();
//    }
//
//    @PreDestroy
//    public void destroy() {
//        if (mongodExecutable != null) {
//            mongodExecutable.stop();
//        }
//    }
//}

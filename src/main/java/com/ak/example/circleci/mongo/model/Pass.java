package com.ak.example.circleci.mongo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
public class Pass {
    @Id
    private String id;
    private String passName;
    private String city;
    private Date createdAt;
}

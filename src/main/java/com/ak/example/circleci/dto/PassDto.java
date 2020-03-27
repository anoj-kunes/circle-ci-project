package com.ak.example.circleci.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PassDto {
    private String id;
    private String passName;
    private String city;
    private Date createdAt;
}

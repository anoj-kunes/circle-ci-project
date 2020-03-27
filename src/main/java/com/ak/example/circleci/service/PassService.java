package com.ak.example.circleci.service;

import com.ak.example.circleci.dto.PassDto;
import com.ak.example.circleci.mongo.model.Pass;
import com.ak.example.circleci.mongo.repository.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PassService {
    @Autowired
    private PassRepository passRepository;

    public PassDto createPass(PassDto passDto) {
        var pass = passRepository.save(
                Pass.builder()
                        .city(passDto.getCity())
                        .passName(passDto.getPassName())
                        .createdAt(new Date())
                        .build()
        );

        passDto.setId(pass.getId());
        passDto.setCreatedAt(pass.getCreatedAt());

        return passDto;
    }

    public PassDto getPass(String id) {
        var pass = passRepository.findById(id)
                .orElseThrow(() -> { throw new RuntimeException("id not found for #" + id); });

        return PassDto.builder()
                .city(pass.getCity())
                .id(pass.getId())
                .createdAt(pass.getCreatedAt())
                .passName(pass.getPassName())
                .build();
    }
}

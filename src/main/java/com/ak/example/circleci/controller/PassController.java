package com.ak.example.circleci.controller;

import com.ak.example.circleci.dto.PassDto;
import com.ak.example.circleci.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PassController {
    @Autowired
    private PassService passService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassDto addPass(@RequestBody PassDto inputDto)  {
        return passService.createPass(inputDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassDto getPass(@PathVariable String id)  {
        return passService.getPass(id);
    }
}

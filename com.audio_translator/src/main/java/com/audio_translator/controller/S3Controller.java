package com.audio_translator.controller;

import com.audio_translator.service.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
public class S3Controller {

    @Autowired
    S3Services s3Services;

    @PostMapping(value = "/s3")
    @ResponseBody
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("===================upload file=========================");
        s3Services.uploadFile(UUID.randomUUID().toString() + file.getOriginalFilename(), file);
        return ResponseEntity.ok().build();
    }
}

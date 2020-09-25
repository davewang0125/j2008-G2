//package com.audio_translator.controller;
//
//import com.audio_translator.service.S3Services;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//
//public class S3Controller {
//
//    @Autowired
//    S3Services s3Services;
//
//    @GetMapping("/s3")
//    public void uploadFile() {
//        s3Services.uploadFile("Firstfile.txt", "/Users/zhuoruli/Desktop/zhuoru.pdf");
//    }
//}

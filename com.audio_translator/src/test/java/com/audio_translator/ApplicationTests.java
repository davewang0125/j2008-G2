package com.audio_translator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.audio_translator.entity.Asset;
import com.audio_translator.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//    @Autowired
//    private User user;
//
//    @Autowired
//    private Asset asset;
//
//    @Test
//    public void insert() {
//        User user = new User();
//        user.setFirstName("dave");
//        user.setLastName("wang");
//        //user.insertSelective(user);
//    }
//
//    @Test
//    public void query() {
//        user.selectAll().stream().forEach(e -> {
//            try {
//                System.out.println(objectMapper.writeValueAsString(e));
//            } catch (JsonProcessingException ex) {
//                ex.printStackTrace();
//            }
//        });
//    }
}

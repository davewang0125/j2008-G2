package com.audio_translator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audio_translator.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    Boolean existsUserByUserName(String userName);

    User findByUserName(String userName);

}

package com.audio_translation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audio_translation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
}

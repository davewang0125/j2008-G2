package com.audio_translator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audio_translator.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

}

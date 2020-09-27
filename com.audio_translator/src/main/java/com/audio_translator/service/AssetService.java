package com.audio_translator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_translator.dao.AssetRepository;
import com.audio_translator.entity.Asset;

@Service
public class AssetService {

	@Autowired
	private AssetRepository repository;
	
	public Asset saveAsset(Asset asset) {
		return repository.save(asset);
	}
	
	public List<Asset> saveAssets(List<Asset> users) {
		return repository.saveAll(users);
	}
	
	public List<Asset> getAsset() {
		return repository.findAll();
	}
	
//	public User getUserByName(String name) {
//		return repository.findByName(name);
//	}
	
	public String deleteAsset(int id) {
		repository.deleteById(id);
		return "Asset " + id + " removed";
	}
	
	public Asset updateUser(Asset asset) {
		Asset existingAsset = repository.findById(asset.getAsset_id()).orElse(null);
		existingAsset.setAudio(asset.getAudio());
		existingAsset.setTranscript(asset.getTranscript());
		existingAsset.setTranslation(asset.getTranslation());
		existingAsset.setContent(asset.getContent());
		existingAsset.setTimetamp(asset.getTimetamp());
		return repository.save(existingAsset);
		
	}
}

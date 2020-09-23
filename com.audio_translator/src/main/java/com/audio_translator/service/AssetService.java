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
	
	public Asset saveUser(Asset asset) {
		return repository.save(asset);
	}
	
	public List<Asset> saveUsers(List<Asset> users) {
		return repository.saveAll(users);
	}
	
	public Asset getUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Asset> getUsers() {
		return repository.findAll();
	}
	
//	public User getUserByName(String name) {
//		return repository.findByName(name);
//	}
	
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "Asset " + id + " removed";
	}
	
	public Asset updateUser(Asset asset) {
		Asset existingAsset = repository.findById(asset.getUserId()).orElse(null);
		existingAsset.setAudio(asset.getAudio());
		existingAsset.setTranscript(asset.getTranscript());
		existingAsset.setTranslation(asset.getTranslation());
		existingAsset.setAssetId(asset.getAssetId());
		existingAsset.setContent(asset.getContent());
		existingAsset.setTimetamp(asset.getTimetamp());
		return repository.save(existingAsset);
		
	}
}

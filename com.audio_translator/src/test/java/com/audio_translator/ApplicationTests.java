package com.audio_translator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.audio_translator.dao.AssetRepository;
import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.Asset;
import com.audio_translator.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRespository;

    @Test
    public void insert() {
        User user = new User();
        user.setFirstName("dave");
        user.setLastName("wang");
        userRepository.save(user);
    }

    @Test
    public void query() {
    	User user = new User();
    	user.setFirstName("小明");
        List<Asset> assets=new ArrayList<>();
        Asset asset1 =new Asset();
        asset1.setAsset_id(10);
        assets.add(asset1);
        Asset asset2 =new Asset();
        asset2.setAsset_id(14);
        assets.add(asset2);
        user.setAssets(assets);
        userRepository.save(user);

    }
}

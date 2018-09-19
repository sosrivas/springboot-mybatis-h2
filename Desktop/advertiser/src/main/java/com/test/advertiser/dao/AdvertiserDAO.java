package com.test.advertiser.dao;

import com.test.advertiser.domain.Advertiser;
import com.test.advertiser.mapper.AdvertiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdvertiserDAO {

    @Autowired
    AdvertiserRepository advertiserRepository;

    public List<Advertiser> findAll(){
        return advertiserRepository.findAll();
    }
    public Advertiser findBy(Integer id){
        return advertiserRepository.findAdviserBy(id);
    }

    public int addAdvertiser(Advertiser advertiser){
        return advertiserRepository.insert(advertiser );
    }

    public int updateAdvertiser(Advertiser advertiser){
        return advertiserRepository.update(advertiser );
    }

    public int deleteById(int id) {return advertiserRepository.deleteById(id); }
}

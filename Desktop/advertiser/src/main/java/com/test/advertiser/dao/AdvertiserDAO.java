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

    public Advertiser addAdvertiser(Advertiser advertiser){
        advertiserRepository.insert(advertiser );
        return findBy(advertiser.getId());
    }

    public Advertiser updateAdvertiser(Advertiser advertiser){
        advertiserRepository.update(advertiser );
        return advertiser;
    }

    public int deleteById(int id) {return advertiserRepository.deleteById(id); }

    public boolean hasEnoughCredit(int id) {
        Advertiser advertiser = advertiserRepository.findAdviserBy(id);
        return advertiser != null && advertiser.getCreditlimit() > 0? true: false;
    }
}

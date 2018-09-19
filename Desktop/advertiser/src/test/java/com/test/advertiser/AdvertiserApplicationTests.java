package com.test.advertiser;

import com.test.advertiser.dao.AdvertiserDAO;
import com.test.advertiser.domain.Advertiser;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertiserApplicationTests {

    @Autowired
    AdvertiserDAO advertiserDAO;

    @Test
    public void createAdvertiser() {
        Advertiser advertiser = new Advertiser("SS Corp", "ssourab", 3000);
        advertiserDAO.addAdvertiser(advertiser);
        Advertiser newAdvertiser = advertiserDAO.findBy(5);
        assertEquals("SS Corp", newAdvertiser.getName());
        assertEquals("ssourab", newAdvertiser.getContact());
        assertEquals(3000, newAdvertiser.getCreditlimit());
    }


    @Test
    public void getAdvertiser() {
        Advertiser newAdvertiser = advertiserDAO.findBy(2);
        assertEquals("Cisco Systems", newAdvertiser.getName());
        assertEquals("Chuck Robbins", newAdvertiser.getContact());
        assertEquals(4000, newAdvertiser.getCreditlimit());
    }
    @Test
    public void updateAdvertiser() {
        Advertiser advertiser = advertiserDAO.findBy(1);
        advertiser.setName("Walmart1");
        advertiserDAO.updateAdvertiser(advertiser);
        Advertiser newAdvertiser = advertiserDAO.findBy(1);
        assertEquals("Walmart1", newAdvertiser.getName());
        assertEquals("Rick Fleming", newAdvertiser.getContact());
        assertEquals(5000, newAdvertiser.getCreditlimit());
    }
}

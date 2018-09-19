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

}

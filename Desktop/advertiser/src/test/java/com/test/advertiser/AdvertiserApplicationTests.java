package com.test.advertiser;

import com.test.advertiser.dao.AdvertiserDAO;
import com.test.advertiser.domain.Advertiser;
import static org.junit.Assert.*;

import com.test.advertiser.exception.ResourceNotFoundException;
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
    public void addAdvertiser() {
        Advertiser advertiser = new Advertiser("SS Corp", "ssourab", 3000);
        advertiserDAO.addAdvertiser(advertiser);
        Advertiser newAdvertiser = advertiserDAO.findBy(5);
        assertEquals("SS Corp", newAdvertiser.getName());
        assertEquals("ssourab", newAdvertiser.getContact());
        assertEquals(3000, newAdvertiser.getCreditlimit());
    }


    @Test
    public void getAdvertiser() {
        Advertiser newAdvertiser = advertiserDAO.findBy(3);
        assertEquals("Apple", newAdvertiser.getName());
        assertEquals("Tim Cook", newAdvertiser.getContact());
        assertEquals(70000, newAdvertiser.getCreditlimit());
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

    @Test
    public void deleteAdvertiser() {
        advertiserDAO.deleteById(2);
        Advertiser newAdvertiser = advertiserDAO.findBy(2);
        assertNull(newAdvertiser);
    }

    @Test
    public void hasEnoughCredit() {
        boolean hasEnoughMoney = advertiserDAO.hasEnoughCredit(3);
        assertTrue(hasEnoughMoney);
    }
}

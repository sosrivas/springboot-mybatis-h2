package com.test.advertiser;

import com.test.advertiser.controller.Controller;
import com.test.advertiser.dao.AdvertiserDAO;
import com.test.advertiser.domain.Advertiser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.LOCATION;

@RunWith(SpringRunner.class)
@WebMvcTest(value = Controller.class, secure = false)
public class ControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private AdvertiserDAO advertiserDAO;

    @Test
    public void whenGetAllIsCalled_AllAdvertisersAreReturned() throws Exception {
        Advertiser advertiser = new Advertiser(1,"name", "contact", 1);
        List<Advertiser> advertisers = Arrays.asList(advertiser);

        when(advertiserDAO.findAll()).thenReturn(advertisers);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/advertiser/getAll").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        String expected = "[ {\"id\":1,\"name\":\"name\",\"contact\":\"contact\",\"creditlimit\":1}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void add_advertiser() throws Exception {
        Advertiser advertiser = new Advertiser(1,"name", "contact", 1);

        when(advertiserDAO.addAdvertiser(Mockito.any(Advertiser.class))).thenReturn(advertiser);
        String newAdvertiserToBeAdded = "{ \"name\": \"Oracle\",\"contact\": \"Marc Stone\",\"creditlimit\": 3000}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/advertiser/add").accept(MediaType.APPLICATION_JSON)
                .content(newAdvertiserToBeAdded).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
        Assert.assertEquals("http://localhost/advertiser/get/1", result.getResponse().getHeader(LOCATION));
    }

    @Test
    public void update_advertiser() throws Exception {
        Advertiser advertiser = new Advertiser(1,"name", "contact", 1);

        when(advertiserDAO.updateAdvertiser(Mockito.any(Advertiser.class))).thenReturn(advertiser);
        String newAdvertiserToBeUpdated = "{ \"id\":1,\"name\":\"Oracle\",\"contact\":\"Marc Stone\",\"creditlimit\":3000}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/advertiser/update").accept(MediaType.APPLICATION_JSON)
                .content(newAdvertiserToBeUpdated).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
    }

    @Test
    public void delete_advertiser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/advertiser/delete/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
    }
}

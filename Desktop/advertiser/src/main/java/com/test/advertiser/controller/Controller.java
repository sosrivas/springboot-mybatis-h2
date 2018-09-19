package com.test.advertiser.controller;

import com.google.common.base.Preconditions;
import com.test.advertiser.dao.AdvertiserDAO;
import com.test.advertiser.domain.Advertiser;
import com.test.advertiser.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/advertiser")
public class Controller {

    @Autowired
    AdvertiserDAO advertiserDAO;

    @GetMapping(value = "/getAll")
    public List<Advertiser> getAllAdvertisers(){
        return advertiserDAO.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addAdvertiser(@Valid @RequestBody Advertiser advertiser){
        advertiserDAO.addAdvertiser(advertiser);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Advertiser advertiser) {
        Preconditions.checkNotNull(advertiser);
        advertiserDAO.updateAdvertiser(advertiser);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/get/{id}")
    public Advertiser findAdvertiserBy(@PathVariable int id){
        Advertiser advertiser = advertiserDAO.findBy(id);
        if (advertiser != null)
            return advertiser;
        else
            throw new ResourceNotFoundException("No Advertiser found", "Advertiser", id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id){
        advertiserDAO.deleteById(id);
    }


}

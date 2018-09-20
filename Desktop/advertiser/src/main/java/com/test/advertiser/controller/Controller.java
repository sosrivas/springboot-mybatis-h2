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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/advertiser")
public class Controller {

    @Autowired
    AdvertiserDAO advertiserDAO;

    public Controller(AdvertiserDAO advertiserDAO){
        this.advertiserDAO = advertiserDAO;
    }

    @GetMapping(value = "/getAll")
    public List<Advertiser> getAllAdvertisers(){
        return advertiserDAO.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Void> addAdvertiser(@Valid @RequestBody Advertiser advertiser){
        Advertiser addedAdvertiser = advertiserDAO.addAdvertiser(advertiser);
        if (null == addedAdvertiser)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/advertiser/get/{id}").buildAndExpand(addedAdvertiser.getId()).toUri();
        return ResponseEntity.created(location).build();
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
    public ResponseEntity<?> delete(@PathVariable int id){
        advertiserDAO.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/hasEnoughCredit/{id}")
    public Boolean hasEnoughCredit(@PathVariable int id){
        Advertiser advertiser = advertiserDAO.findBy(id);
        if (advertiser != null && advertiser.getCreditlimit() > 0)
            return true;
        return false;
    }


}

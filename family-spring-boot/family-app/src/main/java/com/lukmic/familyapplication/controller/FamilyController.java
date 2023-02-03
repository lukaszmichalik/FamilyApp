package com.lukmic.familyapplication.controller;

import com.lukmic.familyapplication.request.IdRequest;
import com.lukmic.familyapplication.service.FamilyService;
import com.lukmic.familyapplication.request.FamilyRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping("/create-family")
    public ResponseEntity<?> createFamily(@Valid @RequestBody FamilyRequest familyRequest){

        return familyService.createNewFamily(familyRequest);
    }

    @PostMapping("/get-family")
    public ResponseEntity<?> getFamily(@Valid @RequestBody IdRequest idRequest){

        return familyService.retrieveFamily(idRequest);
    }
}
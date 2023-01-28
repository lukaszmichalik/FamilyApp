package com.lukmic.familyspringboot.family;

import com.lukmic.familyspringboot.request.FamilyRequest;
import com.lukmic.familyspringboot.request.IdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @PostMapping("/createFamily")
    public ResponseEntity<?> createFamily(@RequestBody FamilyRequest familyRequest){

        return familyService.createNewFamily(familyRequest);
    }

    @PostMapping("/getFamily")
    public ResponseEntity<?> getFamily(@RequestBody IdRequest idRequest){

        return familyService.retrieveFamily(idRequest);
    }

    @PostMapping("/getFamilyWithSearch")
    public ResponseEntity<?> getFamilyWitchSearch(@RequestBody IdRequest idRequest){

        return familyService.retrieveFamilyWithSearch(idRequest);
    }
}
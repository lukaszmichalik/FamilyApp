package com.lukmic.familyspringboot.family;

import com.lukmic.familyspringboot.request.FamilyRequest;
import com.lukmic.familyspringboot.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {
    @Autowired
    FamilyRepository familyRepository;

    @PostMapping("/createFamily")
    public ResponseEntity<?> createFamily(@RequestBody FamilyRequest familyRequest){

        Family family = new Family(
                familyRequest.getFamilyName(),
                familyRequest.getNrOfInfants(),
                familyRequest.getNrOfChildren(),
                familyRequest.getNrOfAdults()
        );

        familyRepository.save(family);

        return ResponseEntity.ok(new MessageResponse("nice"));
    }

    @GetMapping("/testGet")
    public ResponseEntity<?> testGet(){

        return ResponseEntity.ok(new MessageResponse("nice"));
    }
}

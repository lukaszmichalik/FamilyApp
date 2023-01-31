package com.lukmic.familymemberapplication.controller;

import com.lukmic.familymemberapplication.model.FamilyMember;
import com.lukmic.familymemberapplication.request.FamilyMemberRequest;
import com.lukmic.familymemberapplication.request.IdRequest;
import com.lukmic.familymemberapplication.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyMemberController {
    @Autowired
    FamilyMemberService familyMemberService;

    @PostMapping("/create-family-member")
    public void createFamilyMember(@RequestBody FamilyMemberRequest familyMemberRequest){

        familyMemberService.createFamilyMember(familyMemberRequest);
    }
    @PostMapping("/search-family-member")
    public ResponseEntity<FamilyMember[]> searchFamilyMember(@RequestBody IdRequest familyId){

        return familyMemberService.searchFamilyMember(familyId.getId());
    }
}

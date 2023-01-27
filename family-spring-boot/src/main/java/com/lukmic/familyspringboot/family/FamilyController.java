package com.lukmic.familyspringboot.family;

import com.lukmic.familyspringboot.familyMember.FamilyMember;
import com.lukmic.familyspringboot.familyMember.FamilyMemberRepostory;
import com.lukmic.familyspringboot.familyMember.FamilyMemberService;
import com.lukmic.familyspringboot.request.FamilyRequest;
import com.lukmic.familyspringboot.response.IdResponse;
import com.lukmic.familyspringboot.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Set;

@RestController
public class FamilyController {
    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    FamilyMemberRepostory familyMemberRepostory;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    FamilyMemberService familyMemberService;



    @PostMapping("/createFamily")
    public ResponseEntity<?> createFamily(@RequestBody FamilyRequest familyRequest){

        Family family = new Family(
                familyRequest.getFamilyName(),
                familyRequest.getNrOfInfants(),
                familyRequest.getNrOfChildren(),
                familyRequest.getNrOfAdults()
        );

        familyRepository.save(family);

        familyRequest.getFamilyMembers().forEach(familyMember -> {
            familyMember.setFamilyId(family.getId());
            familyMemberService.createFamilyMember(familyMember);
        });

        return ResponseEntity.ok(new IdResponse(family.getId()));
    }

    @GetMapping("/testGet")
    public ResponseEntity<?> testGet(){

        return ResponseEntity.ok(new MessageResponse("nice"));
    }
}

package com.lukmic.familymemberapplication.service;

import com.lukmic.familymemberapplication.model.FamilyMember;
import com.lukmic.familymemberapplication.repository.FamilyMemberRepository;
import com.lukmic.familymemberapplication.request.FamilyMemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberServiceImpl implements  FamilyMemberService{
    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Override
    public void createFamilyMember(FamilyMemberRequest familyMemberRequest) {

        familyMemberRepository.save(
                new FamilyMember(familyMemberRequest.getGivenName(),
                        familyMemberRequest.getFamilyName(),
                        familyMemberRequest.getAge(),
                        familyMemberRequest.getFamilyId()));

    }

    @Override
    public ResponseEntity<FamilyMember[]> searchFamilyMember(Long familyId) {

        FamilyMember[] familyMembers = familyMemberRepository.findByFamilyId(familyId);
        return ResponseEntity.ok().body(familyMembers);
    }
}

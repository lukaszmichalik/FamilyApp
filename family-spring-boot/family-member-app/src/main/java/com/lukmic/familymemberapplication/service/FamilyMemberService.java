package com.lukmic.familymemberapplication.service;

import com.lukmic.familymemberapplication.model.FamilyMember;
import com.lukmic.familymemberapplication.request.FamilyMemberRequest;
import org.springframework.http.ResponseEntity;

public interface FamilyMemberService {
    void createFamilyMember(FamilyMemberRequest familyMemberRequest);
    ResponseEntity<FamilyMember[]> searchFamilyMember(Long id);
}

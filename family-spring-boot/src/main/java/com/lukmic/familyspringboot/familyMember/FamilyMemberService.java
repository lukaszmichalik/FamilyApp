package com.lukmic.familyspringboot.familyMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberService {

    @Autowired
    FamilyMemberRepostory familyMemberRepostory;

    public void createFamilyMember(FamilyMember familyMember){
        familyMemberRepostory.save(familyMember);
    }
}

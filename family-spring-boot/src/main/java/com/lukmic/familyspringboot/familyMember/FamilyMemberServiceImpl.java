package com.lukmic.familyspringboot.familyMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberServiceImpl implements  FamilyMemberService{
    @Autowired
    FamilyMemberRepostory familyMemberRepostory;
    @Override
    public void createFamilyMember(FamilyMember familyMember) {
        familyMemberRepostory.save(familyMember);
    }

//    @Override
//    public FamilyMember searchFamilyMember(Long familyId) {
//        familyMemberRepostory.findAllById(familyId);
//        return null;
//    }

}

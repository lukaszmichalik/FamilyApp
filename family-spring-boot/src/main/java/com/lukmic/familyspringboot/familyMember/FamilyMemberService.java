package com.lukmic.familyspringboot.familyMember;


import java.util.Set;

public interface FamilyMemberService {
    void createFamilyMember(FamilyMember familyMember);
    Set<FamilyMember> searchFamilyMember(Long familyId);
}

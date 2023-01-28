package com.lukmic.familyspringboot.familyMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;

@Service
public class FamilyMemberServiceImpl implements  FamilyMemberService{
    @Autowired
    FamilyMemberRepostory familyMemberRepostory;

    @Override
    public void createFamilyMember(FamilyMember familyMember) {
        familyMemberRepostory.save(familyMember);
    }

    @Override
    public Set<FamilyMember> searchFamilyMember(Long familyId) {
        return familyMemberRepostory.findByFamilyId(familyId);
    }
}
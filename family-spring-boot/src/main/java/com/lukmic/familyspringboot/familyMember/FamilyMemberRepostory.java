package com.lukmic.familyspringboot.familyMember;

import com.lukmic.familyspringboot.family.Family;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FamilyMemberRepostory extends CrudRepository<FamilyMember, Long> {
    @Query("SELECT * FROM family_member_db.family_member WHERE family_id = :id")
    Set<FamilyMember> findByFamilyId(Long id);
}

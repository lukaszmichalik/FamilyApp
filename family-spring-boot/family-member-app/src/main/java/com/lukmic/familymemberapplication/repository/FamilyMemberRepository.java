package com.lukmic.familymemberapplication.repository;

import com.lukmic.familymemberapplication.model.FamilyMember;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Long> {
    @Query("SELECT * FROM family_member_db.family_member WHERE family_id = :id")
    FamilyMember[] findByFamilyId(Long id);
}

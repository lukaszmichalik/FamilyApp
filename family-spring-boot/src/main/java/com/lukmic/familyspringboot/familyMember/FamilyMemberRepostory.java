package com.lukmic.familyspringboot.familyMember;

import com.lukmic.familyspringboot.family.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepostory extends CrudRepository<FamilyMember, Long> {
}

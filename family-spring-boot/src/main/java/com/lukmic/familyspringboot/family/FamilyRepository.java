package com.lukmic.familyspringboot.family;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {
//    Family getOne(Long id);
}

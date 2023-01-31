package com.lukmic.familyapplication.repository;

import com.lukmic.familyapplication.model.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {
}

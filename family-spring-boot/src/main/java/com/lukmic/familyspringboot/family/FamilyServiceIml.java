package com.lukmic.familyspringboot.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyServiceIml implements IFamilyService{
    @Autowired
    FamilyRepository familyRepository;

    @Override
    public Optional<Family> findById(Long id){
        return familyRepository.findById(id);
    }
}

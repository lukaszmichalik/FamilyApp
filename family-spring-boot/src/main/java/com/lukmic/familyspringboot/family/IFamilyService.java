package com.lukmic.familyspringboot.family;

import java.util.Optional;

public interface IFamilyService {
    Optional<Family> findById(Long id);
}

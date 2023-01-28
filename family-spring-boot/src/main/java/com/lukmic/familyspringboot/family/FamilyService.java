package com.lukmic.familyspringboot.family;

import com.lukmic.familyspringboot.request.FamilyRequest;
import com.lukmic.familyspringboot.request.IdRequest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface FamilyService {
    ResponseEntity<?> createNewFamily(FamilyRequest familyRequest);
    ResponseEntity<?> retrieveFamily(IdRequest idRequest);

}

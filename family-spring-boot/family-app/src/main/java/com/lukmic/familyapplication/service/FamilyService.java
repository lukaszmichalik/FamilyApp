package com.lukmic.familyapplication.service;

import com.lukmic.familyapplication.request.FamilyRequest;
import com.lukmic.familyapplication.request.IdRequest;
import org.springframework.http.ResponseEntity;

public interface FamilyService {
    ResponseEntity<?> createNewFamily(FamilyRequest familyRequest);
    ResponseEntity<?> retrieveFamily(IdRequest idRequest);
}

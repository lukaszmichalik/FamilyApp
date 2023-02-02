package com.lukmic.familyapplication.service;

import com.lukmic.familyapplication.model.Family;
import com.lukmic.familyapplication.response.FamilyMemberResponse;
import com.lukmic.familyapplication.repository.FamilyRepository;
import com.lukmic.familyapplication.request.FamilyMemberRequest;
import com.lukmic.familyapplication.request.FamilyRequest;
import com.lukmic.familyapplication.request.IdRequest;
import com.lukmic.familyapplication.response.FamilyResponse;
import com.lukmic.familyapplication.response.IdResponse;
import com.lukmic.familyapplication.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<?> retrieveFamily(IdRequest idRequest){

        Optional<Family> family = familyRepository.findById(idRequest.getId());
        FamilyMemberResponse[] familyMembers = callSearchFamilyMember(idRequest);

        if (family.isPresent()) {
            return ResponseEntity.ok(new FamilyResponse(
                    family.get().getFamilyName(),
                    family.get().getNrOfInfants(),
                    family.get().getNrOfChildren(),
                    family.get().getNrOfAdults(),
                    familyMembers));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse(String.format("Family with id %s not found.",idRequest.getId())));
        }

    }

    @Override
    public ResponseEntity<?> createNewFamily(FamilyRequest familyRequest){

        if(!validateFamilyData(familyRequest))
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: family data doesn't match family members data."));

        Family family = new Family(
                familyRequest.getFamilyName(),
                familyRequest.getNrOfInfants(),
                familyRequest.getNrOfChildren(),
                familyRequest.getNrOfAdults()
        );

        familyRepository.save(family);

        familyRequest.getFamilyMembers().forEach(
                familyMemberRequest -> {
                    familyMemberRequest.setFamilyId(family.getId());
                    callCreateFamilyMember(familyMemberRequest);
                }
        );

        return ResponseEntity.ok(new IdResponse(family.getId()));
    }

    private Boolean validateFamilyData(FamilyRequest familyRequest){

        if (familyRequest.getNrOfInfants() != familyRequest.getFamilyMembers().stream()
                .filter(familyMember ->
                        familyMember.getAge() >= 0 & familyMember.getAge() < 4
                ).count()) {
            return false;
        }

        if (familyRequest.getNrOfChildren() != familyRequest.getFamilyMembers().stream()
                .filter(familyMember ->
                        familyMember.getAge() >= 4 & familyMember.getAge() < 16
                ).count()) {
            return false;
        }

        if (familyRequest.getNrOfAdults() != familyRequest.getFamilyMembers().stream()
                .filter(familyMember ->
                        familyMember.getAge() >= 16
                ).count()) {
            return false;
        }
        return true;
    }

    private void callCreateFamilyMember(FamilyMemberRequest familyMemberRequest) {

        ResponseEntity<?> responseEntity =
                restTemplate.postForEntity("http://family-member-app:8081/create-family-member", familyMemberRequest
                        , ResponseEntity.class);
    }

    private FamilyMemberResponse[] callSearchFamilyMember(IdRequest familyId) {

        ResponseEntity<FamilyMemberResponse[]> responseEntity =
                restTemplate.postForEntity("http://family-member-app:8081/search-family-member", familyId,
                        FamilyMemberResponse[].class);

        return responseEntity.getBody();
    }
}

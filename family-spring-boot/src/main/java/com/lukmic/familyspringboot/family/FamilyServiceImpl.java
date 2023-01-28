package com.lukmic.familyspringboot.family;

import com.lukmic.familyspringboot.familyMember.FamilyMember;
import com.lukmic.familyspringboot.familyMember.FamilyMemberService;
import com.lukmic.familyspringboot.request.FamilyRequest;
import com.lukmic.familyspringboot.request.IdRequest;
import com.lukmic.familyspringboot.response.FamilyResponse;
import com.lukmic.familyspringboot.response.IdResponse;
import com.lukmic.familyspringboot.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    FamilyRepository familyRepository;
    @Autowired
    FamilyMemberService familyMemberService;

    public Boolean validateFamilyData(FamilyRequest familyRequest){

        AtomicReference<Integer> nrOfInfants= new AtomicReference<>(0);
        AtomicReference<Integer> nrOfChildren= new AtomicReference<>(0);
        AtomicReference<Integer> nrOfAdults= new AtomicReference<>(0);

        familyRequest.getFamilyMembers().forEach(familyMember -> {
            if(familyMember.getAge()>=0 & familyMember.getAge()<4)
                nrOfInfants.getAndSet(nrOfInfants.get() + 1);
            if(familyMember.getAge()>=4 & familyMember.getAge()<16)
                nrOfChildren.getAndSet(nrOfChildren.get() + 1);
            if(familyMember.getAge()>=16)
                nrOfAdults.getAndSet(nrOfAdults.get() + 1);
        });

        if(!Objects.equals(nrOfInfants.get(), familyRequest.getNrOfInfants()))
            return false;

        if(!Objects.equals(nrOfChildren.get(), familyRequest.getNrOfChildren()))
            return false;

        if(!Objects.equals(nrOfAdults.get(), familyRequest.getNrOfAdults()))
            return false;

        return true;

//        if(!Objects.equals(nrOfInfants.get(), familyRequest.getNrOfInfants()))
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: number of infants doesn't match delivered data of family members"));
//
//        if(!Objects.equals(nrOfChildren.get(), familyRequest.getNrOfChildren()))
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: number of children doesn't match delivered data of family members"));
//
//        if(!Objects.equals(nrOfAdults.get(), familyRequest.getNrOfAdults()))
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: number of adults doesn't match delivered data of family members"));


    }

    @Override
    public ResponseEntity<?> createNewFamily(FamilyRequest familyRequest){

        if(!validateFamilyData(familyRequest))
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: family data doesn't match family members data"));

        Family family = new Family(
                familyRequest.getFamilyName(),
                familyRequest.getNrOfInfants(),
                familyRequest.getNrOfChildren(),
                familyRequest.getNrOfAdults()
        );

        familyRepository.save(family);

        familyRequest.getFamilyMembers().forEach(familyMember -> {

            familyMember.setFamilyId(family.getId());
            familyMemberService.createFamilyMember(familyMember);
        });

        return ResponseEntity.ok(new IdResponse(family.getId()));
    }

    @Override
    public ResponseEntity<?> retrieveFamily(IdRequest idRequest){
        Optional<Family> family = familyRepository.findById(idRequest.getId());

        Family familyB =family.get();

        return ResponseEntity.ok(new FamilyResponse(
                familyB.getFamilyName(),
                familyB.getNrOfInfants(),
                familyB.getNrOfChildren(),
                familyB.getNrOfAdults(),
                familyB.getFamilyMembers()));
    }

    @Override
    public ResponseEntity<?> retrieveFamilyWithSearch(IdRequest idRequest) {
        Optional<Family> family = familyRepository.findById(idRequest.getId());

        Family familyB =family.get();

        Set<FamilyMember> familyMembers = familyMemberService.searchFamilyMember(idRequest.getId());

        return ResponseEntity.ok(new FamilyResponse(
                familyB.getFamilyName(),
                familyB.getNrOfInfants(),
                familyB.getNrOfChildren(),
                familyB.getNrOfAdults(),
                familyMembers));
    }
}
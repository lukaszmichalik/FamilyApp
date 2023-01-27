package com.lukmic.familyspringboot.family;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lukmic.familyspringboot.familyMember.FamilyMember;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.Set;
import java.util.UUID;


public class Family {
    @Id @JsonIgnore
    private Long id;
    private String familyName;
    private Integer nrOfInfants;
    private Integer nrOfChildren;
    private Integer nrOfAdults;

    @MappedCollection(keyColumn = "family_id", idColumn = "family_id")
    private Set<FamilyMember> familyMembers;

    public Family(String familyName, Integer nrOfInfants, Integer nrOfChildren, Integer nrOfAdults
//            , Set<FamilyMember> familyMembers
    ) {
        this.familyName = familyName;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
//        this.familyMembers = familyMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(Integer nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }

    public Integer getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(Integer nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public Integer getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(Integer nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

//    @Bean
//    BeforeConvertCallback<Family> beforeConvertCallback() {
//
//        return (family) -> {
//            if (family.id == null) {
//                family.id = UUID.randomUUID().toString();
//            }
//            return family;
//        };
//    }

//    @Bean
//    public ApplicationListener<?> idSetting() {
//
//        return (ApplicationListener<BeforeConvertEvent>) event -> {
//
//            if (event.getEntity() instanceof Family) {
//                setId((id) event.getEntity());
//            }
//        };
//    }

//    public List<FamilyMember> getFamilyMembers() {
//        return familyMembers;
//    }
//
//    public void setFamilyMembers(List<FamilyMember> familyMembers) {
//        this.familyMembers = familyMembers;
//    }
}

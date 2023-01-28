package com.lukmic.familyspringboot.response;

import com.lukmic.familyspringboot.familyMember.FamilyMember;

import java.util.Set;

public class FamilyResponse {
    private String familyName;
    private Integer nrOfInfants;
    private Integer nrOfChildren;
    private Integer nrOfAdults;
    private Set<FamilyMember> familyMembers;

    public FamilyResponse(String familyName, Integer nrOfInfants, Integer nrOfChildren, Integer nrOfAdults,
                          Set<FamilyMember> familyMembers) {
        this.familyName = familyName;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
        this.familyMembers = familyMembers;
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

    public Set<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }
}

package com.lukmic.familyapplication.request;

import java.util.Set;

public class FamilyRequest {

    private String familyName;
    private Integer nrOfInfants;
    private Integer nrOfChildren;
    private Integer nrOfAdults;
    private Set<FamilyMemberRequest> familyMembers;

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

    public Set<FamilyMemberRequest> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<FamilyMemberRequest> familyMembersRequset) {
        this.familyMembers = familyMembersRequset;
    }
}

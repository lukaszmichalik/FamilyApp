package com.lukmic.familyapplication.request;

import jakarta.validation.constraints.NotNull;
import java.util.Set;

public class FamilyRequest {

    @NotNull(message = "Error: bad request, family name can't be null")
    private String familyName;
    @NotNull(message = "Error: bad request, nr of infants can't be null")
    private Integer nrOfInfants;
    @NotNull(message = "Error: bad request, nr of children can't be null")
    private Integer nrOfChildren;
    @NotNull(message = "Error: bad request, nr of adults can't be null")
    private Integer nrOfAdults;
    @NotNull(message = "Error: bad request, family members can't be null")
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

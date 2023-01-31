package com.lukmic.familyapplication.response;

public class FamilyResponse {
    private String familyName;
    private Integer nrOfInfants;
    private Integer nrOfChildren;
    private Integer nrOfAdults;
    private FamilyMemberResponse[] familyMembers;

    public FamilyResponse(String familyName, Integer nrOfInfants, Integer nrOfChildren, Integer nrOfAdults
            , FamilyMemberResponse[] familyMembers
            )
    {
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

    public FamilyMemberResponse[] getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(FamilyMemberResponse[] familyMembers) {
        this.familyMembers = familyMembers;
    }
}

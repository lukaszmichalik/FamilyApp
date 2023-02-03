package com.lukmic.familymemberapplication.request;

import jakarta.validation.constraints.NotNull;

public class FamilyMemberRequest {
    @NotNull
    private String givenName;
    @NotNull
    private String familyName;
    @NotNull
    private Integer age;
    @NotNull
    private Long familyId;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }
}

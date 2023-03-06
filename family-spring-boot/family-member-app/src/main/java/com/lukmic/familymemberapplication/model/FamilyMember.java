package com.lukmic.familymemberapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "family_member", schema = "family_member_db")
public class FamilyMember {
    @Id
    @JsonIgnore
    private Long id;
    private String givenName;
    private String familyName;
    private Integer age;
    private Long familyId;

    public FamilyMember(String givenName, String familyName, Integer age, Long familyId) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
        this.familyId = familyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

package com.lukmic.familyspringboot.familyMember;

import org.springframework.data.annotation.Id;

public class FamilyMember {
    @Id
    private long id;
    private String givenName;
    private String familyName;
    private Integer age;

    public FamilyMember(Long id, String givenName, String familyName, Integer age) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
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

}
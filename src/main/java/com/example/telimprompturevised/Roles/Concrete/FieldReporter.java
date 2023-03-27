package com.example.telimprompturevised.Roles.Concrete;

import com.example.telimprompturevised.Roles.Role;
import com.example.telimprompturevised.Roles.RoleCommon;

import java.util.Arrays;
import java.util.List;

public class FieldReporter implements Role {
    private String title = "Field Reporter";
    private String description = "You are the Field Reporter. you will report live from the scene of the incident.";
    private String lastName;

    public FieldReporter() {
        this.lastName = "Fieldperson";
    }

    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getLastName() { return this.lastName; }

}

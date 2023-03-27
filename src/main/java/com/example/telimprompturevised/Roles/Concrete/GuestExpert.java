package com.example.telimprompturevised.Roles.Concrete;

import com.example.telimprompturevised.Roles.Role;
import com.example.telimprompturevised.Roles.RoleCommon;

import java.util.Arrays;
import java.util.List;

public class GuestExpert implements Role {
    private final String title = "Guest Expert";
    private final String description = "You are the Guest Expert. You will give an expert opinion on the incident.";
    private String lastName;

    public GuestExpert() {
        this.lastName = "Expertperson";
    }


    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getLastName() { return this.lastName; }
}

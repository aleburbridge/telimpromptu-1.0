package com.example.telimprompturevised.Roles.Concrete;

import com.example.telimprompturevised.Roles.Role;
import com.example.telimprompturevised.Roles.RoleCommon;

import java.util.Arrays;
import java.util.List;

public class Detective implements Role {
    private String title = "Detective";
    private String description = "You are the Detective. You will be interviewed by the CoHost.";
    private String lastName;

    public Detective() {
        this.lastName = "Detectiveperson";
    }

    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getLastName() { return this.lastName; }

}

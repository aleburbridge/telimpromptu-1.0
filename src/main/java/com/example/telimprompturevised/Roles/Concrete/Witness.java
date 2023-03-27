package com.example.telimprompturevised.Roles.Concrete;

import com.example.telimprompturevised.Roles.Role;
import com.example.telimprompturevised.Roles.RoleCommon;

public class Witness implements Role {
    private String title = "Witness";
    private String description = "You are the witness. You experienced the incident firsthand and will give an account.";
    private String lastName;

    public Witness() {
        this.lastName = "Widness-dathing";
    }

    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getLastName() { return this.lastName; }
}
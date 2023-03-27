package com.example.telimprompturevised.Roles.Concrete;

import com.example.telimprompturevised.Roles.Role;
import com.example.telimprompturevised.Roles.RoleCommon;

import java.util.Arrays;
import java.util.List;

public class CoHost implements Role {
    private String title = "CoHost";
    private String description = "You are the CoHost. You will introduce segments and interview the Field Reporter.";
    private String lastName;
    List<String> lastNames = Arrays.asList("Maddow", "Joyella", "Gloria", "Wallace", "Sawyer", "O'Donnell");
    private RoleCommon roleCommon = new RoleCommon();

    public CoHost() {
        this.lastName = roleCommon.getRandomLastName(lastNames);
    }

    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getLastName() { return this.lastName; }

}

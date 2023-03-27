package com.example.telimprompturevised.Roles.Concrete;

import com.example.telimprompturevised.Roles.Role;
import com.example.telimprompturevised.Roles.RoleCommon;

import java.util.Arrays;
import java.util.List;

public class Host implements Role {
    private String title = "Host";
    private String description = "You are the Host, the main news caster. You will introduce segments and interview the detective.";
    private String lastName;
    List<String> lastNames = Arrays.asList("Holt", "Cooper", "Muir", "Bhan", "Roberts", "Amanpour, Repord-Ondaneus");
    private RoleCommon roleCommon = new RoleCommon();

    public Host() {
        this.lastName = roleCommon.getRandomLastName(lastNames);
    }

    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getLastName() { return this.lastName; }
}

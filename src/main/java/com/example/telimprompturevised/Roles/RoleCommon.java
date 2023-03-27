package com.example.telimprompturevised.Roles;

import java.util.Collections;
import java.util.List;

public class RoleCommon {
    public RoleCommon() {}

    public String getRandomLastName(List<String> lastNames) {
        return getRandomElement(lastNames, "NewsPerson");
    }

    public String getRandomElement(List<String> lastNames, final String defaultValue) {
        Collections.shuffle(lastNames);
        if (lastNames.size() > 0) {
            return lastNames.get(0);
        }
        return defaultValue;
    }
}

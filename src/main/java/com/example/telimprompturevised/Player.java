package com.example.telimprompturevised;

import com.amazonaws.services.dynamodbv2.xspec.NULL;
import com.example.telimprompturevised.Roles.Role;

public class Player {
    private String userName;
    private String userId;
    private String lastName = "Newsperson";
    private String fullName;
    private Prompt firstPrompt = null;
    private Prompt secondPrompt = null;
    private Prompt thirdPrompt = null;

    private String firstPartScript = "";
    private String secondPartScript = "";
    private String thirdPartScript = "";

    private Role role = null;

    public Player(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        capitalizeName();
    }

    public void capitalizeName() {
        if (this.userName.length() > 1) {
            this.userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
        }
    }

    public Prompt getPromptBySequenceNum(int sequenceNum) {
        if (sequenceNum == 1) {
            return getFirstPrompt();
        } else if (sequenceNum == 2) {
            return getSecondPrompt();
        } else if (sequenceNum == 3) {
            return getThirdPrompt();
        } else {
            return null;
        }
    }

    public void setPromptBySequenceNum(int sequenceNum, Prompt prompt) {
        if (sequenceNum == 1) {
            this.setFirstPrompt(prompt);
        } else if (sequenceNum == 2) {
            this.setSecondPrompt(prompt);
        } else if (sequenceNum == 3) {
            this.setThirdPrompt(prompt);
        }
    }

    public void setPartScriptBySequenceNum(int sequenceNum, String partScript) {
        if (sequenceNum == 1) {
            setFirstPartScript(partScript);
        } else if (sequenceNum == 2) {
            setSecondPartScript(partScript);
        } else if (sequenceNum == 3) {
            setThirdPartScript(partScript);
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public String getFullName() {
        return this.userName + " " + this.lastName;
    }

    public String getRoleTitle() {
        return this.getRole().getTitle();
    }

    public Prompt getFirstPrompt() {
        return firstPrompt;
    }

    public void setFirstPrompt(Prompt firstPrompt) {
        this.firstPrompt = firstPrompt;
    }

    public Prompt getSecondPrompt() {
        return secondPrompt;
    }

    public void setSecondPrompt(Prompt secondPrompt) {
        this.secondPrompt = secondPrompt;
    }

    public Prompt getThirdPrompt() {
        return thirdPrompt;
    }

    public void setThirdPrompt(Prompt thirdPrompt) {
        this.thirdPrompt = thirdPrompt;
    }

    public String getFirstPartScript() {
        return firstPartScript;
    }

    public void setFirstPartScript(String firstPartScript) {
        this.firstPartScript = firstPartScript;
    }

    public String getSecondPartScript() {
        return secondPartScript;
    }

    public void setSecondPartScript(String secondPartScript) {
        this.secondPartScript = secondPartScript;
    }

    public String getThirdPartScript() {
        return thirdPartScript;
    }

    public void setThirdPartScript(String thirdPartScript) {
        this.thirdPartScript = thirdPartScript;
    }
}

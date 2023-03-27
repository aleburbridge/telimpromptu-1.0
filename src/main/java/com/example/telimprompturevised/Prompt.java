package com.example.telimprompturevised;

public class Prompt {
    private String roleTitle;
    private int sequenceNum;
    private int numOfInputBoxesNeeded;
    private String text = null;
    private String response = null;

    public Prompt(String roleTitle, int sequenceNum, int numOfInputBoxesNeeded, String text) {
        this.roleTitle = roleTitle;
        this.sequenceNum = sequenceNum;
        this.numOfInputBoxesNeeded = numOfInputBoxesNeeded;
        this.text = text;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public int getSequenceNum() {
        return sequenceNum;
    }

    public int getNumOfInputBoxesNeeded() {
        return numOfInputBoxesNeeded;
    }

    public String getText() {
        return text;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

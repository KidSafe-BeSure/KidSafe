package com.example.maya.kidsafe;

public class Message {
    private String message = "";
    private String badWord = "xxx";
    private boolean isBullied = true;
    private String bully;
    public Message() {

    }

    public String getBully() {
        return bully;
    }

    public void setBully(String bully) {
        this.bully = bully;
    }

    public Message(String message, String badWord, boolean isBullied, String bully) {
        this.message = message;
        this.badWord = badWord;
        this.isBullied = isBullied;
        this.bully = bully;

    }

    public boolean isBullied() {
        return isBullied;
    }

    public void setBullied(boolean bullied) {
        isBullied = bullied;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBadWord() {
        return badWord;
    }

    public void setBadWord(String badWord) {
        this.badWord = badWord;
    }
}

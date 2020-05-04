package com.mg.restController;

public class Greetings {

    private String name;
    private String content;

    public Greetings(String name, String con) {
        this.name = name;
        this.content = con;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

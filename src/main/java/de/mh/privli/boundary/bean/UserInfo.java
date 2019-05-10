package de.mh.privli.boundary.bean;

public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

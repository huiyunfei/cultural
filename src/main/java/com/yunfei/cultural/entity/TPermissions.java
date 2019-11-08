package com.yunfei.cultural.entity;

public class TPermissions {
    private Integer id;

    private Integer permissionsName;

    private String premissionsMarking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(Integer permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getPremissionsMarking() {
        return premissionsMarking;
    }

    public void setPremissionsMarking(String premissionsMarking) {
        this.premissionsMarking = premissionsMarking == null ? null : premissionsMarking.trim();
    }
}
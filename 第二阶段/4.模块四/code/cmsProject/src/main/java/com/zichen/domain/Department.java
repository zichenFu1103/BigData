package com.zichen.domain;

public class Department {
    private Integer departId;
    private String departName;
    private String departManager;
    private String managerTel;
    private String managerEmail;

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartManager() {
        return departManager;
    }

    public void setDepartManager(String departManager) {
        this.departManager = departManager;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departId=" + departId +
                ", departName='" + departName + '\'' +
                ", departManager='" + departManager + '\'' +
                ", managerTel='" + managerTel + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                '}';
    }
}

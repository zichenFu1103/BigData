package com.zichen.domain;

public class Employee {
    private Integer empId;
    private String empName;
    private Integer empDepartId;
    private String empPosition;
    private String empStartDate;
    private String empTel;

    //表示当前的用户对应哪个部门，显示外键
    private Department department;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpDepartId() {
        return empDepartId;
    }

    public void setEmpDepartId(Integer empDepartId) {
        this.empDepartId = empDepartId;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(String empStartDate) {
        this.empStartDate = empStartDate; }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDepartId=" + empDepartId +
                ", empPosition='" + empPosition + '\'' +
                ", empStartDate=" + empStartDate +
                ", empTel='" + empTel + '\'' +
                ", department=" + department +
                '}';
    }
}

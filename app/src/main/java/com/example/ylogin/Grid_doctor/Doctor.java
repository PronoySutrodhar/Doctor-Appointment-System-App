package com.example.ylogin.Grid_doctor;

public class Doctor {
    public String name;
    public String type;
    public String qualification;
    public String duty;

    public Doctor(){
    }

    public Doctor(String name, String type, String qualification, String duty) {
        this.name = name;
        this.type = type;
        this.qualification = qualification;
        this.duty = duty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}

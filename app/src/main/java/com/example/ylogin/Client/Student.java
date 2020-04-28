package com.example.ylogin.Client;

public class Student {
    private String name;
    private String age;
    private String doctor;
    private String contact;
    public Student(){

    }

    public Student(String name, String age, String doctor, String contact) {
        this.name = name;
        this.age = age;
        this.doctor = doctor;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

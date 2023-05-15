package com.example.bossManagement;

public class Employee {
    private int id;
    private String name;
    private int age;
    private int rating;
    private int bossId;

    public Employee(int id, String name, int age, int rating, int bossId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.bossId = bossId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRating() {
        return rating;
    }

    public int getBossId() {
        return bossId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBossId(int bossId) {
        this.bossId = bossId;
    }
}

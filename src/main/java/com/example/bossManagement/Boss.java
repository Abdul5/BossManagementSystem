package com.example.bossManagement;

public class Boss {
    private int id;
    private String name;
    private int rating;
    private int salary;

    public Boss(int id, String name, int rating, int salary) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

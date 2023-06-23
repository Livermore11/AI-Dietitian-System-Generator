package com.example.javaaidietician;

import javafx.event.ActionEvent;

public class User extends Member {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;
    private String exerciseLVL;

    public User(String name, int age, String gender, double weight, double height, String exerciseLVL) {
        super(name);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.exerciseLVL = exerciseLVL;
    }
    public void logIn(ActionEvent event,String username,String password ){
        return;
    }
    public void viewRecommendedDiet(){
        return;
    }
    public void alternateDiet(){
        return;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getExerciseLVL() {
        return exerciseLVL;
    }

    public void setExerciseLVL(String exerciseLVL) {
        this.exerciseLVL = exerciseLVL;
    }
}

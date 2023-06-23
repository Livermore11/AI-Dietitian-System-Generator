package com.example.javaaidietician;

public class Guest extends User {
    public Guest(String name, int age, String gender, double weight, double height, String exerciseLVL) {
        super(name, age, gender, weight, height, exerciseLVL);
    }

    @Override
    public void viewRecommendedDiet() {
        super.viewRecommendedDiet();
    }
    @Override
    public void alternateDiet() {
        super.alternateDiet();
    }
}

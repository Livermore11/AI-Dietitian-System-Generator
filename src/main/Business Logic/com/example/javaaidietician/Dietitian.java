package com.example.javaaidietician;

public class Dietitian extends Member {
    private int id_Dietitian;
    public Dietitian(String name, int id_Dietitian) {
        super(name);
        this.id_Dietitian = id_Dietitian;
    }

    public int getId_Dietitian() {
        return id_Dietitian;
    }
    public void addFood(){
        return;
    }
    public  void deleteFood(){
        return;
    }
}

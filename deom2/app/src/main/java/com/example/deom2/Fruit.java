package com.example.deom2;

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}

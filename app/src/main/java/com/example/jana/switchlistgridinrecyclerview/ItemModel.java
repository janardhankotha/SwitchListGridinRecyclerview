package com.example.jana.switchlistgridinrecyclerview;

/**
 * Created by Jana on 3/30/2018.
 */

public class ItemModel {

    private String name;
    private Integer imagePath;

    public ItemModel(){

    }

    public ItemModel(String name, Integer imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImagePath() {
        return imagePath;
    }

    public void setImagePath(Integer imagePath) {
        this.imagePath = imagePath;
    }
}

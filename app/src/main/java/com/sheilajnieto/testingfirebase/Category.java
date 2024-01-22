package com.sheilajnieto.testingfirebase;/*
@author sheila j. nieto 
@version 0.1 2024 -01 - 16
*/

import androidx.annotation.NonNull;

public class Category {

    private String categoryName;
    private String image;

    public Category() {
    }

    public Category(String categoryName, String image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

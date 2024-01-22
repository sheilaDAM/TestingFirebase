package com.sheilajnieto.testingfirebase;/*
@author sheila j. nieto 
@version 0.1 2024 -01 - 16
*/

import androidx.annotation.NonNull;

public class Product {

    private String productName;
    private String image;
    private double price;
    private Category category;

    public Product() {
    }
    public Product(String productName, String image, double price, Category category) {
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", category=" + category +
                '}';
    }
}

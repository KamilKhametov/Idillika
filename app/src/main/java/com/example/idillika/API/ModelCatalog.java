package com.example.idillika.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCatalog {

    @SerializedName("id")

    private int id;
    @SerializedName("imageLink")

    private String imageLink;
    @SerializedName("title")

    private String title;
    @SerializedName("price")

    private int price;
    @SerializedName("available")

    private boolean available;

    @SerializedName("favorite")
    private boolean favorite;

    @SerializedName("brand")

    private String brand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}

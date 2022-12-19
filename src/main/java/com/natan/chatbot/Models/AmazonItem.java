package com.natan.chatbot.Models;

public class AmazonItem {
    private String name;
    private String price;
    private String rating;

    @Override
    public String toString() {
        return "AmazonItem{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public AmazonItem(String name, String price, String rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

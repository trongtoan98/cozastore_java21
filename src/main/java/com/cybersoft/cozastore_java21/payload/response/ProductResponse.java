package com.cybersoft.cozastore_java21.payload.response;

public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private String description;
    private String image;
    private String imageDetail;

    private SizeResponse size;

    private ColorResponse color;

    private CategoryResponse category;

    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SizeResponse getSize() {
        return size;
    }

    public void setSize(SizeResponse size) {
        this.size = size;
    }

    public ColorResponse getColor() {
        return color;
    }

    public void setColor(ColorResponse color) {
        this.color = color;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(String imageDetail) {
        this.imageDetail = imageDetail;
    }
}

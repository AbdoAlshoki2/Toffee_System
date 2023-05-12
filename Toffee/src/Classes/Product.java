package Classes;

import java.util.*;

public class Product {
    private String name; // Private field to store the name of the product
    private double price; // Private field to store the price of the product
    private Category category; // Private field to store the category of the product
    private int quantity; // Private field to store the quantity of the product
    private double discount; // Private field to store the discount percentage for the product

    // Category is an enum that represents the possible categories for the product
    public enum Category {
        Candy, Toffee, Chocolate, Cakes, Donuts, Cookies, Biscuits, Wafers, IceCreams, Others;
    }

    // Constructor that takes the name, price, category, quantity, and discount percentage for the product
    public Product(String name, double price, Category category, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.discount = discount;
    }

    // Getter function for the name field
    public String getName() {
        return name;
    }

    // Setter function for the name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter function for the price field
    public double getPrice() {
        return price;
    }

    // Setter function for the price field
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter function for the category field
    public Category getCategory() {
        return category;
    }

    // Setter function for the category field
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter function for the quantity field
    public int getQuantity() {
        return quantity;
    }

    // Setter function for the quantity field
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter function for the discount field
    public double getDiscount() {
        return discount;
    }

    // Setter function for the discount field
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Function to check if two products are equal based on their name and category
    public boolean equal(Product obj) {
        Product p = (Product) obj;
        return this.getName().equals(p.getName()) && this.getCategory() == p.getCategory();
    }

    // Function to display the details of the product
    public void display() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Category: " +
                getCategory() + ", Quantity: " + getQuantity() + ", Discount: " + getDiscount() * 100 +"%");
    }
}
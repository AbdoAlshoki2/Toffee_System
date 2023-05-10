import java.util.*;
public class Product {
    private String name;
    private double price;
    private Category category;
    private int quantity;
    private double discount;

    public enum Category {
        Candy, Toffee, Chocolate, Cakes, Donuts, Cookies, Biscuits, Wafers, IceCreams, Others;
    }

    public Product(String name, double price, Category category, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.discount = discount;
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

    public void setPrice() {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory() {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount() {
        this.discount = discount;
    }

    public boolean equal(Product obj) {
        Product p = (Product) obj;
        return this.getName().equals(p.getName()) &&
                this.getCategory() == p.getCategory();
    }

    public void display() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Category: " +
                getCategory() + ", Quantity: " + getQuantity() + ", Discount: " + getDiscount() * 100 +"%");
    }
}

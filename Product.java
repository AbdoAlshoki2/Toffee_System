import java.util.*;
enum ProductType {
    CANDY,
    CHOCOLATE,
    TOFFEE,
    OTHERS
}

class Product {
    private String name;
    private double price;
    private ProductType category;
    private int quantity;

    public Product(String name, double price, ProductType category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
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

    public ProductType getCategory() {
        return this.category;
    }

    public void setType(ProductType type) {
        this.category = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Product otherProduct) {
        return this.name.equals(otherProduct.getName()) && this.price == otherProduct.getPrice()
                && this.getCategory() == otherProduct.getCategory() && this.quantity == otherProduct.getQuantity();
    }
}

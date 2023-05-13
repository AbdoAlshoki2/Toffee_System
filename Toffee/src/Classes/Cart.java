package Classes;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products; // Private field to store the list of products in the cart

    public Cart() {
        products = new ArrayList<>(); // Constructor that initializes the products field as an empty ArrayList
    }

    public ArrayList<Product> getProducts() {
        return products; // Getter function for the products field
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products; // Setter function for the products field
    }

    // Function to calculate the total payment for the cart
    public double totalPayment() {
        double total = 0;
        // Loop through all the products in the cart and add up their prices
        for (Product p : products) {
            // Calculate the price of the product by multiplying its price, quantity, and discount (if any)
            total += p.getPrice() * p.getQuantity() * (1 - p.getDiscount());
        }
        return total; // Return the total payment for the cart
    }

    // Function to add a product to the cart
    public void addProduct(Product product) {
        products.add(product); // Add the product to the products list
    }

    // Function to remove a product from the cart
    public void removeProduct(Product product) {
        products.remove(product); // Remove the product from the products list
    }


    // Function to display the contents of the cart
    public void display() {
        System.out.println("Cart contents:");
        // Loop through all the products in the cart and display their details
        for (int i = 0; i < products.size(); i++) {
            System.out.print("Product "+ (i+1) + " => ");
            products.get(i).display(); // Call the display function of the Product class to display the product details
        }
        System.out.println("Total payment: " + totalPayment() +"EGP"); // Display the total payment for the cart
    }
}
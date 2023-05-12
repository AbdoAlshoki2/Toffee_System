package Classes;

import java.util.*;

public class Catalog {
    private ArrayList<Product> products; // Private field to store the list of products in the catalog

    public enum ProductAttributes{
        name , price , category , quantity;
    }

    public Catalog() {
        products = new ArrayList<Product>(); // Constructor that initializes the products field as an empty ArrayList
        // Create some sample products and add them to the products list
        Product p = new Product("Candy",20.0, Product.Category.Candy ,100 , 0.10);
        Product p1 = new Product("Cupcake",15.0, Product.Category.Cakes ,200 , 0.10);
        Product p2 = new Product("Galaxy",23.0, Product.Category.Chocolate ,300 , 0.10);
        Product p5 = new Product("Cake",23.0, Product.Category.Cakes ,300 , 0.10);
        Product p6 = new Product("Lollipop",23.0, Product.Category.Candy ,300 , 0.10);
        Product p3 = new Product("Kitkat",77.0, Product.Category.Chocolate ,400, 0.10);
        products.add(p); products.add(p1); products.add(p2); products.add(p3); products.add(p5) ; products.add(p6);
    }

    public Catalog(ArrayList<Product> p){
        this.products = p; // Constructor that takes a list of products and sets it as the products field
    }

    public ArrayList<Product> getProducts() {
        return products; // Getter function for the products field
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products; // Setter function for the products field
    }

    // Function to sort the products in the catalog by a given attribute (name, price, category, or quantity)
    public void sortBy(ProductAttributes attribute) {
        switch (attribute) {
            case name:
                Collections.sort(products, Comparator.comparing(Product::getName));
                break;
            case price:
                Collections.sort(products, Comparator.comparing(Product::getPrice));
                break;
            case category:
                Collections.sort(products, Comparator.comparing(Product::getCategory));
                break;
            case quantity:
                Collections.sort(products, Comparator.comparing(Product::getQuantity));
                break;
            default:
                System.out.println("Invalid attribute!");
                break;
        }
        display(); // Display the sorted catalog
    }

    // Function to search for products in the catalog by a given attribute value (name, price, category, or quantity)
    public ArrayList<Product> searchBy(ProductAttributes attribute, String value) {
        ArrayList<Product> result = new ArrayList<Product>();
        switch (attribute) {
            case name:
                for (Product p : products) {
                    if (p.getName().equalsIgnoreCase(value)) {
                        result.add(p);
                    }
                }
                break;
            case category:
                for (Product p : products) {
                    if (p.getCategory().toString().equalsIgnoreCase(value)) {
                        result.add(p);
                    }
                }
                break;
            case price:
                double price = Double.parseDouble(value);
                for (Product p : products) {
                    if (p.getPrice() == price) {
                        result.add(p);
                    }
                }
                break;
            case quantity:
                int quantity = Integer.parseInt(value);
                for (Product p : products) {
                    if (p.getQuantity() == quantity) {
                        result.add(p);
                    }
                }
                break;
            default:
                System.out.println("Invalid attribute!");
                break;
        }
        return result; // Return the list of products that match the search criteria
    }

    // Function to display the contents of the catalog
    public void display() {
        System.out.println("Catalog:");
        int count = 1;
        for (Product product : products) {
            System.out.print(count++ +"=>");
            product.display(); // Call the display function of the Product class to display the product details
        }
    }

    // Function to add a product to the catalog
    public void addProduct(Product product) {
        products.add(product); // Add the product to the products list
    }

    // Function to remove a product from the catalog
    public void removeProduct(Product product) {
        products.remove(product); // Remove the product from the products list
    }

    // Function to filter the products in the catalog by a given category
    public void filter(Product.Category category) {
        int count = 1;
        for (Product product : products) {
            if (product.getCategory() == category) {
                System.out.print("Product "+ count++ + " => ");
                product.display(); // Call the display function of the Product class to display the product details
            }
        }
    }
}
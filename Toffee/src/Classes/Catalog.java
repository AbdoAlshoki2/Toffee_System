package Classes;

import java.util.*;



public class Catalog {
    private ArrayList<Product> products;

    public enum ProductAttributes{
        name , price , category , quantity;
    }

    public Catalog() {
        products = new ArrayList<Product>();
        Product p = new Product("Candy",20.0, Product.Category.Candy ,100 , 0.10);
        Product p1 = new Product("Cupcake",15.0, Product.Category.Cakes ,200 , 0.10);
        Product p2 = new Product("Galaxy",23.0, Product.Category.Chocolate ,300 , 0.10);
        Product p3 = new Product("Kitkat",77.0, Product.Category.Chocolate ,400, 0.10);
        products.add(p); products.add(p1); products.add(p2); products.add(p3);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    // sort products by attribute
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
    }

    // search for products by attribute value
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
        return result;
    }

    public void display() {
        System.out.println("Catalog:");
        for (Product product : products) {
            product.display();
        }
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void filter(Product.Category category) {
        ArrayList<Product> result = new ArrayList<Product>();
        int count = 1;
        for (Product product : products) {
            if (product.getCategory() == category) {
                System.out.print("Product "+ count++ + " => ");
                product.display();
            }
        }
    }

}

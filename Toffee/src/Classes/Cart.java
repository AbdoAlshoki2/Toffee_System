package Classes;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double totalPayment() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity() * (1 - p.getDiscount());
        }
        return total;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

//    public ArrayList<Product> searchBy(String attribute) {
//        ArrayList<Product> result = new ArrayList<>();
//        for (Product p : products) {
//            if (p.getName().equals(attribute) || p.getCategory().toString().equals(attribute)) {
//                result.add(p);
//            }
//        }
//        return result;
//    }

    public void display() {
        System.out.println("Cart contents:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print("Product "+ i+1 + " => ");
            products.get(i).display();
        }
        System.out.println("Total payment: " + totalPayment());
    }
}

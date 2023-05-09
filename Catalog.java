import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Catalog {
    private ArrayList<Product> products;

    public Catalog() {
        products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    // sort products by attribute
    public void sortBy(String attribute) {
        switch (attribute.toLowerCase()) {
            case "name":
                Collections.sort(products, Comparator.comparing(Product::getName));
                break;
            case "price":
                Collections.sort(products, Comparator.comparing(Product::getPrice));
                break;
            case "category":
                Collections.sort(products, Comparator.comparing(Product::getCategory));
                break;
            case "quantity":
                Collections.sort(products, Comparator.comparing(Product::getQuantity));
                break;
            default:
                System.out.println("Invalid attribute!");
                break;
        }
    }

    // search for products by attribute value
    public ArrayList<Product> searchBy(String attribute, String value) {
        ArrayList<Product> result = new ArrayList<Product>();
        switch (attribute.toLowerCase()) {
            case "name":
                for (Product p : products) {
                    if (p.getName().equalsIgnoreCase(value)) {
                        result.add(p);
                    }
                }
                break;
            case "category":
                for (Product p : products) {
                    if (p.getCategory().toString().equalsIgnoreCase(value)) {
                        result.add(p);
                    }
                }
                break;
            case "price":
                double price = Double.parseDouble(value);
                for (Product p : products) {
                    if (p.getPrice() == price) {
                        result.add(p);
                    }
                }
                break;
            case "quantity":
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

    public ArrayList<Product> filter(Product.Category category) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

}

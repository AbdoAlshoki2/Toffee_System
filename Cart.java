import java.util.Vector;

public class Cart {
    private Vector<Product> products;

    public Cart() {
        products = new Vector<>();
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public void setProducts(Vector<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double totalPayment() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public Vector<Product> searchBy(String attribute) {
        Vector<Product> searchResult = new Vector<>();
        for (Product product : products) {
            if (product.getName().equals(attribute) || product.getType().name().equals(attribute)) {
                searchResult.add(product);
            }
        }
        return searchResult;
    }

}

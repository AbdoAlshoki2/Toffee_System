import java.util.Vector;
import java.util.Comparator;

public class Catalog {
    private Vector<Product> products;

    public Catalog() {
        products = new Vector<>();
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public void setProducts(Vector<Product> products) {
        this.products = products;
    }

    public Vector<Product> sortBy(String attribute) {
        Vector<Product> sortedProducts = (Vector<Product>) products.clone();
        switch (attribute) {
            case "name":
                sortedProducts.sort(Comparator.comparing(Product::getName));
                break;
            case "type":
                sortedProducts.sort(Comparator.comparing(Product::getCategory));
                break;
            case "price":
                sortedProducts.sort(Comparator.comparing(Product::getPrice));
                break;
            default:
                break;
        }
        return sortedProducts;
    }

    public Vector<Product> searchBy(String attribute) {
        Vector<Product> results = new Vector<>();
        for (Product product : products) {
            switch (attribute) {
                case "name":
                    if (product.getName().equals(attribute)) {
                        results.add(product);
                    }
                    break;
                case "type":
                    if (product.getCategory().toString().equals(attribute)) {
                        results.add(product);
                    }
                    break;
                case "price":
                    if (product.getPrice() == Double.parseDouble(attribute)) {
                        results.add(product);
                    }
                    break;
                default:
                    break;
            }
        }
        return results;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Vector<Product> display() {
        return products;
    }

}

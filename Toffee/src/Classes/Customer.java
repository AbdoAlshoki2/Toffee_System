package Classes;

// Class to represent a customer
public class Customer extends User{
    private int loyaltyPoints = 0; // Private field to store the loyalty points of the customer
    private String address;  // Private field to store the address of the customer
    private Cart shoppingCart;  // Private field to store the shopping cart of the customer

    // Constructor that takes the name, id, telephone, email, password, loyalty points, address, and shopping cart for the customer
    public Customer(String username, String email , String phone , String pass , String address ) {
        this.name = username;
        this.address = address;
        this.email = email;
        this.telephone = phone;
        this.password = pass;
    }

    // Constructor that takes the name, id, telephone, email, password, loyalty points, address, and shopping cart for the customer
    public Customer(String name, String id, String telephone, String email, String password, int loyaltyPoints, String address, Cart shoppingCart) {
        super(name, id, telephone, email, password);
        this.loyaltyPoints = loyaltyPoints;
        this.address = address;
        this.shoppingCart = shoppingCart;
    }

    // Getter function for the address field
    public String getAddress() {
        return address;
    }

    // Setter function for the address field
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter function for the loyalty points field
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setter function for the loyalty points field
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getter function for the shopping cart field
    public Cart getShoppingCart() {
        return shoppingCart;
    }

    // Setter function for the shopping cart field
    public void setShoppingCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // Function to add a product to the shopping cart
    public void addProduct(Product p){
        this.shoppingCart.addProduct(p);
    }


    public Bill generateBill(){
        return new Bill(this.shoppingCart.getProducts());
    }

    // Function to display the details of the customer
    @Override
    public void display(){
        super.display();
        System.out.println("Loyalty points: " + this.loyaltyPoints);
    }

}

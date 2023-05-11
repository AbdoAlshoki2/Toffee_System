package Classes;

public class Customer extends User{
    private int loyaltyPoints = 0;
    private String address;
    private Cart shoppingCart;

    public Customer(String username, String email , String phone , String pass , String address ) {
        this.name = username;
        this.address = address;
        this.email = email;
        this.telephone = phone;
        this.password = pass;
    }

    public Customer(String name, String id, String telephone, String email, String password, int loyaltyPoints, String address, Cart shoppingCart) {
        super(name, id, telephone, email, password);
        this.loyaltyPoints = loyaltyPoints;
        this.address = address;
        this.shoppingCart = shoppingCart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Cart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addProduct(Product p){
        this.shoppingCart.addProduct(p);
    }

    public Bill generateBill(){
        return new Bill(this.shoppingCart.getProducts());
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Loyalty points: " + this.loyaltyPoints);
    }

}

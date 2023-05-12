package Mangement;

import Classes.*; // Importing classes from another package

import java.io.*; // Importing java.io for file input/output
import java.util.*; // Importing java.util for ArrayList

public class SystemData { // Defining a public class called SystemData
    ArrayList<Order> orders; // Initializing an ArrayList of Order objects

    Catalog catalog; // Initializing a Catalog object

    ArrayList<User> users; // Initializing an ArrayList of User objects

    ArrayList<Customer> customers; // Initializing an ArrayList of Customer objects
    double LoyaltyPointsSchema; // Initializing a double variable

    public SystemData(){ // Defining a constructor for the SystemData class
        customers = new ArrayList<Customer>(); // Initializing an ArrayList of Customer objects
        loadCustomersFromFile(); // Loading customers from a file
        catalog = new Catalog(); // Initializing a new Catalog object
    }

    public ArrayList<Order> getOrders() { // Defining a public method called getOrders that returns an ArrayList of Order objects
        return orders; // Returning the orders ArrayList
    }

    public void setOrders(ArrayList<Order> orders) { // Defining a public method called setOrders that takes in an ArrayList of Order objects as an argument
        this.orders = orders; // Setting the orders ArrayList to the argument
    }

    public Catalog getCatalog() { // Defining a public method called getCatalog that returns a Catalog object
        return catalog; // Returning the catalog object
    }

    public void setCatalog(Catalog catalog) { // Defining a public method called setCatalog that takes in a Catalog object as an argument
        this.catalog = catalog; // Setting the catalog object to the argument
    }

    public double getLoyaltyPointsSchema() { // Defining a public method called getLoyaltyPointsSchema that returns a double variable
        return LoyaltyPointsSchema; // Returning the LoyaltyPointsSchema variable
    }

    public void setLoyaltyPointsSchema(double loyaltyPointsSchema) { // Defining a public method called setLoyaltyPointsSchema that takes in a double variable as an argument
        LoyaltyPointsSchema = loyaltyPointsSchema; // Setting the LoyaltyPointsSchema variable to the argument
    }

    public void addOrder(Order o){ // Defining a public method called addOrder that takes in an Order object as an argument
        orders.add(o); // Adding the Order object to the orders ArrayList
    }

    public void addItem(Product p){ // Defining a public method called addItem that takes in a Product object as an argument
        catalog.addProduct(p); // Adding the Product object to the catalog
    }

    public void editLoyaltySchema(){ // Defining a public method called editLoyaltySchema that does nothing
    }

    public void AddCustomer(Customer c){ // Defining a public method called AddCustomer that takes in a Customer object as an argument
        customers.add(c); // Adding the Customer object to the customers ArrayList
    }

    public ArrayList<Customer> getCustomers() { // Defining a public method called getCustomers that returns an ArrayList of Customer objects
        return customers; // Returning the customers ArrayList
    }

    public void searchInCatalog(Catalog.ProductAttributes attribute, String value){ // Defining a public method called searchInCatalog that takes in a Catalog.ProductAttributes enum and a String as arguments
        catalog.searchBy(attribute,value); // Searching the catalog by the given attribute and value
    }

    public void loadCustomersFromFile(){ // Defining a public method called loadCustomersFromFile
        customers.add(new Customer("Nourhan Mahmoud","nourhanidc@gmail.com" ,"01111111111","Nourhan123" , "Cairo")); // Adding a new Customer object to the customers ArrayList
        customers.add(new Customer("Sama Ahmed","Samaa2772@gmail.com" ,"01222222222","SamaAhmed123" , "Cairo")); // Adding a new Customer object to the customers ArrayList
        customers.add(new Customer("Abdelrahman","Abdelrahmanalshoki@gmail.com" ,"01333333333","Alshoki123" , "Cairo")); // Adding a new Customer object to the customers ArrayList
    }
}
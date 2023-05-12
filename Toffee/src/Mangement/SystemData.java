package Mangement;
import Classes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;

public class SystemData {

    ArrayList<Order> orders;

    Catalog catalog;

    ArrayList<User> users;

    ArrayList<Customer> customers;
    double LoyaltyPointsSchema;


    public SystemData(){
        // implement files & read
        catalog = new Catalog();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public double getLoyaltyPointsSchema() {
        return LoyaltyPointsSchema;
    }

    public void setLoyaltyPointsSchema(double loyaltyPointsSchema) {
        LoyaltyPointsSchema = loyaltyPointsSchema;
    }

    public void addOrder(Order o){
        orders.add(o);
    }

    public void addItem(Product p){
        catalog.addProduct(p);
    }

    public void editLoyaltySchema(){

    }

    public void AddCustomer(Customer c){
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void searchInCatalog(Catalog.ProductAttributes attribute, String value){
        catalog.searchBy(attribute,value);
    }
    public void loadCustomersFromFile(){
              // Specify the path of the file to read
        String filePath = "Customers.txt";

        try {
            // Create a File object representing the file
            File file = new File(filePath);

            // Create a Scanner object to read the file
            Scanner scanner = new Scanner(file);

            // Read the file line by line
            while (scanner.hasNextLine()) {
                String username = scanner.nextLine();
                String address = scanner.nextLine();
                String email = scanner.nextLine();
                String password = scanner.nextLine();
                String telephone = scanner.nextLine();
                Customer c = new Customer(username,address,email,password,telephone);
                
                
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        }
        }

}

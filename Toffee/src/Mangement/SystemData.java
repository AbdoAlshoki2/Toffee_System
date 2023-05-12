package Mangement;
import Classes.*;
import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class SystemData {

    ArrayList<Order> orders;

    Catalog catalog;

    ArrayList<User> users;

    ArrayList<Customer> customers;
    double LoyaltyPointsSchema;


    public SystemData(){
        customers = new ArrayList<Customer>();
        loadCustomersFromFile();
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
        customers.add(new Customer("Nourhan Mahmoud","nourhanidc@gmail.com" ,
                "01111111111","Nourhan123" , "Cairo"));
        customers.add(new Customer("Sama Ahmed","Samaa2772@gmail.com" ,
                "01222222222","SamaAhmed123" , "Cairo"));
        customers.add(new Customer("Abdelrahman","Abdelrahmanalshoki@gmail.com" ,
                "01333333333","Alshoki123" , "Cairo"));

    }

}

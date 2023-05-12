package Classes;

import java.util.*;

public class Bill {
    private String date = new String(); // Private field to store the date of the bill
    private ArrayList<Product> products; // Private field to store the list of products in the bill

    public Bill(ArrayList<Product> p){
        this.products = p; // Constructor that takes a list of products and sets it as the products field
        this.date = date; // This line does nothing, as the date field is never initialized
    }

    // Function to get the date of the bill
    public String getDate(){
        return this.date;
    }

    // Function to set the date of the bill
    public void setDate(String newDate){
        this.date = newDate;
    }

    // Function to calculate the total payment for the bill
    public double totalPayment(){
        double total = 0.0;
        // Loop through all the products in the bill and add up their prices
        for (int i = 0; i < this.products.size(); i++) {
            // Calculate the price of the product by multiplying its price, quantity, and discount (if any)
            total+= (products.get(i).getPrice() * products.get(i).getQuantity() * (1-products.get(i).getDiscount()));
        }
        return total; // Return the total payment for the bill
    }

    // Function to display the details of each product in the bill
    public void displayDetails(){
        // Loop through all the products in the bill and display their details
        for (int i = 0; i < this.products.size(); i++) {
            System.out.print("Product "+ i+1 + " => ");
            products.get(i).display(); // Call the display function of the Product class to display the product details
        }
    }

    // Function to check if two bills are equal
    public Boolean equal(Bill bill){
        // Check if the two bills have the same number of products
        if(bill.products.size() != products.size()) return false;
        // Loop through all the products in the bills and check if they are equal
        for (int i = 0; i < products.size(); i++) {
            if(!bill.products.get(i).equal(products.get(i))) return false;
        }
        // Check if the date of the two bills is the same
        return bill.getDate() == getDate();
    }
}
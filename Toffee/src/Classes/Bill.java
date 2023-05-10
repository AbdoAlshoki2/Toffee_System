package Classes;

import java.util.*;

public class Bill {
    private String date = new String();

    private ArrayList<Product> products;


    public Bill(ArrayList<Product> p,String date){
        this.products = p;
        this.date = date;
    }

    // function to get the date
    public String getDate(){
        return this.date;
    }

    // function to get the date
    public void setDate(String newDate){
        this.date = newDate;
    }

    // function to calc the payment of this bill
    public double totalPayment(){
        double total = 0.0;
        for (int i = 0; i < this.products.size(); i++) {
            total+= (products.get(i).getPrice() * products.get(i).getQuantity() * (1-products.get(i).getDiscount()));
        }
        return total;
    }

    public void displayDetails(){
        for (int i = 0; i < this.products.size(); i++) {
            System.out.print("Product "+ i+1 + " => ");
            products.get(i).display();
        }
    }

    public Boolean equal(Bill bill){
        if(bill.products.size() != products.size()) return false;
        for (int i = 0; i < products.size(); i++) {
            if(!bill.products.get(i).equal(products.get(i))) return false;
        }
        return bill.getDate() == getDate();
    }

}

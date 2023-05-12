package Classes;

import java.util.ArrayList;

public class StoreSales {
    private ArrayList<Bill> sales = new ArrayList<Bill>(); // Private field to store the list of bills

    // Function to get the list of bills
    public ArrayList<Bill> getSales() {
        return this.sales;
    }

    // Function to add a bill to the list of bills
    public void addBill(Bill bill) {
        sales.add(bill);
    }

    // Function to calculate the total payment for all the bills
    public double totalPayment() {
        double sum = 0.0;
        for (int i = 0; i < sales.size(); i++) {
            sum += sales.get(i).totalPayment();
        }
        return sum;
    }
}
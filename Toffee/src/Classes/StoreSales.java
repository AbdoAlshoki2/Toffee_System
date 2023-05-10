
package Classes;

import java.util.ArrayList;
public class StoreSales {
    private ArrayList<Bill> sales = new ArrayList<Bill>();


    // function to get the List of bills
    public ArrayList<Bill> getSales(){
        return this.sales;
    }

    // function to add bill to list of bills
    public void addBill(Bill bill){
        sales.add(bill);
    }
    
    // function to calc all the bills payments
    public double totalPayment(){
        double sum = 0.0;
        for (int i = 0; i < sales.size(); i++) {
            sum += sales.get(i).totalPayment();
        }
        return sum ;
    }

}

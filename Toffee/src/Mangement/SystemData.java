package Mangement;
import Classes.*;

import java.util.ArrayList;

public class SystemData {

    ArrayList<Order> orders;

    Catalog catalog;
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

    public void searchInCatalog(Catalog.ProductAttributes attribute, String value){
        catalog.searchBy(attribute,value);
    }


}

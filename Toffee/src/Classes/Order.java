package Classes;

public class Order {
    // PaymentWay and OrderState are two enums to represent the payment methods and order states respectively
    public enum PaymentWay {
        onDelivery, eWallet, creditCard;
    }

    public enum OrderState {
        shipped, processing, delivered, canceled, returned, pending;
    }

    private Bill bill; // Private field to store the bill for the order
    // Need to add a Customer attribute to this class
    private Customer customer;
    private String location; // Private field to store the location for the order
    private String dateToDelivery; // Private field to store the date for the delivery of the order
    private PaymentWay paymentWay; // Private field to store the payment method for the order
    private OrderState orderState; // Private field to store the order state for the order

    public Order() {
    }

    // Constructor that takes a Bill object and an address string
    public Order(Bill firstBill, String address, Customer customer) {
        // Here too, need to add a Customer parameter
        this.bill = firstBill;
        this.location = address;
        this.customer = customer;
    }

    // Function to get the bill for the order
    public Bill getBill() {
        return this.bill;
    }

    // Function to set the bill for the order
    public void setBill(Bill newBill) {
        this.bill = newBill;
    }

    // Function to get the location for the order
    public String getLocation() {
        return this.location;
    }

    // Function to set the location for the order
    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    // Function to get the payment method for the order
    public PaymentWay getPaymentMethod() {
        return this.paymentWay;
    }

    // Function to set the payment method for the order
    public void setPaymentMethod(PaymentWay newMethod) {
        this.paymentWay = newMethod;
    }

    // Function to get the order state for the order
    public OrderState getOrderState() {
        return this.orderState;
    }

    // Function to set the order state for the order
    public void setOrderState(OrderState newState) {
        this.orderState = newState;
    }

    // Function to display the details of the order
    public void display() {
        // Here you can print the customer information using the `customer` field
        customer.display();
        // Then print the details of the bill using the `bill` field
        bill.displayDetails();
    }
}
enum PaymentWay{
    onDelivery , eWallet , creditCard ;
}

enum OrderState{
    shipped,processing,delivered,canceled,returned,pending;
}

public class Order {

    private Bill bill; // Need to add constructor to Bill class
    private String location ;
    private String dateToDelivery;
    private PaymentWay paymentWay;
    private OrderState orderState;

    public Order(){

    }
    public Order(Bill firstBill, String address){ // constructor
        this.bill = firstBill ;
        this.location = address;
    }

    //function to get the bill
    public Bill getBill(){
        return this.bill ;
    }

    //function to set the bill
    public void setBill(Bill newBill){
        this.bill  = newBill;
    }

    // function to get the location
    public String getLocation(){
        return this.location ;
    }

    //function to set the location
    public void setLocation(String newLocation){
        this.location = newLocation;
    }

    // function to get the payment method
    public PaymentWay getPaymentMethod(){
        return this.paymentWay;
    }

    //function to set the payment method
    public void setPaymentMethod(PaymentWay newMethod){
        this.paymentWay = newMethod;
    }

    // function to display the state for the order
    public OrderState getOrderState(){
        return this.orderState;
    }

    //function to set the state for the order
    public void setOrderState(OrderState newState){
        this.orderState = newState;
    }




}

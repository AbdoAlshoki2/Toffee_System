public class Bill {
    private String date = new String();


    public Bill(String date){
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
        return 1;
    }

}

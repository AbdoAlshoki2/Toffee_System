package Mangement;
import Classes.*;

import java.util.*;

public class MainSystem {
    SystemData s;

    Customer loggedUser = null;

    public MainSystem(){
        s = new SystemData();
    }

    public void MainPage(){
        Authentication class1 = new Authentication(s);
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Toffee Store");
        System.out.println("1-Login\n2-Register\n3-skip");
        System.out.println("Enter your choice");
        char choice = sc.next().charAt(0);
        switch(choice){
            case '1': {
                loggedUser = class1.Login();
                if (loggedUser == null) {
                    System.out.println("Do you want to use Forget Password (Y/N)");
                    choice = sc.next().charAt(0);
                    switch (choice) {
                        case 'Y':
                            loggedUser = class1.forgetPassword();
                            MainPage();
                            break;
                        case 'N':
                            nonCustomerMenu();
                    }
                } else {
                    Cart shopping = new Cart();
                    loggedUser.setShoppingCart(shopping);
                    customerMenu();
                }
                break;
            }
            case '2': {
                class1.Register();
                MainPage();
                break;
            }
            case '3':
                nonCustomerMenu();
        }
    }

    public void customerMenu(){
        Scanner sc = new Scanner(System.in);
        int choice = 0 , quantity = 0;
        System.out.println("1-Shopping\n2-Make order");
        choice = sc.nextInt();
        switch (choice) {
            case 1: {
                s.catalog.display();
                ArrayList<Product> current = s.catalog.getProducts();
                while (choice != -1) {
                    System.out.println("Enter the number of product and quantity you want. (If you want to finish,Enter -1)");
                    choice = sc.nextInt();
                    if (choice == -1) break;
                    quantity = sc.nextInt();
                    if (quantity <= current.get(choice - 1).getQuantity()) {
                        Product p = current.get(choice - 1);
                        Product q = new Product(p.getName(), p.getPrice(), p.getCategory(),
                                quantity, p.getDiscount());

                        loggedUser.addProduct(q);
                    } else {
                        System.out.println("Invalid quantity, try again");
                    }
                }
                customerMenu();
                break;
            }
            case 2:{
                makeOrder(loggedUser);
                break;
            }
        }

    }

    public void nonCustomerMenu(){
        s.catalog.display();
    }
    public Order makeOrder(Customer c){
        Payment paymentWay = new Payment();
        c.getShoppingCart().display();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your address : ");
        String address = sc.next();
        Bill n = c.generateBill();
        Order new_order = new Order(n , address , c);
        new_order.setPaymentMethod(Order.PaymentWay.onDelivery);
        System.out.println("Your order has been completed successfully");
        System.out.println("The total price needed to pay is :" + n.totalPayment());
        paymentWay.makePaymentOnDelivery();
        return new_order;
    }

    public void something2(){


    }
}

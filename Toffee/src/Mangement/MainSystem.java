package Mangement;
import Classes.*; // Importing classes from another package

import java.util.*; // Importing java.util for Scanner and ArrayList

public class MainSystem { // Defining a public class called MainSystem
    SystemData s; // Initializing a SystemData object

    Customer loggedUser = null; // Initializing a Customer object and setting it to null

    public MainSystem(){ // Defining a constructor for the MainSystem class
        s = new SystemData(); // Initializing a new SystemData object
    }

    public void MainPage(){ // Defining a public method called MainPage
        Authentication class1 = new Authentication(s); // Initializing an Authentication object
        Scanner sc = new Scanner(System.in); // Initializing a Scanner object
        System.out.println("Welcome to Toffee Store"); // Printing a welcome message
        System.out.println("1-Login\n2-Register\n3-skip"); // Displaying options for the user to choose
        System.out.println("Enter your choice"); // Prompting the user to enter their choice
        char choice = sc.next().charAt(0); // Reading the user's choice
        switch(choice){ // Using a switch statement to handle the user's choice
            case '1': { // If the user chose to login
                loggedUser = class1.Login(); // Attempting to log the user in
                if (loggedUser == null) { // If login failed
                    System.out.println("Do you want to use Forget Password (Y/N)"); // Prompting the user to reset their password
                    choice = sc.next().charAt(0); // Reading the user's choice
                    switch (choice) { // Using a switch statement to handle the user's choice
                        case 'Y': // If the user chose to reset their password
                            class1.forgetPassword(); // Attempting to reset the user's password
                            MainPage(); // Returning to the main page
                            break;
                        case 'N': // If the user chose not to reset their password
                            nonCustomerMenu(); // Displaying the non-customer menu
                    }
                } else { // If login succeeded
                    Cart shopping = new Cart(); // Initializing a new Cart object
                    loggedUser.setShoppingCart(shopping); // Setting the user's shopping cart to the new Cart object
                    customerMenu(); // Displaying the customer menu
                }
                break;
            }
            case '2': { // If the user chose to register
                class1.Register(); // Registering a new user
                MainPage(); // Returning to the main page
                break;
            }
            case '3': // If the user chose to skip
                nonCustomerMenu(); // Displaying the non-customer menu
        }
    }

    public void customerMenu(){ // Defining a public method called customerMenu
        Scanner sc = new Scanner(System.in); // Initializing a Scanner object
        int choice = 0 , quantity = 0; // Initializing two integer variables
        System.out.println("1-Shopping\n2-Make order"); // Displaying options for the customer to choose
        choice = sc.nextInt(); // Reading the customer's choice
        switch (choice) { // Using a switch statement to handle the customer's choice
            case 1: { // If the customer chose to shop
                s.catalog.display(); // Displaying the catalog of products
                ArrayList<Product> current = s.catalog.getProducts(); // Initializing an ArrayList of Product objects
                while (choice != -1) { // Using a while loop to allow the customer to shop multiple products
                    System.out.println("Enter the number of product and quantity you want. (If you want to finish,Enter -1)"); // Prompting the customer to enter the product number and quantity they want to add to their shopping cart
                    choice = sc.nextInt(); // Reading the customer's choice
                    if (choice == -1) break; // If the customer is done shopping, break out of the loop
                    quantity = sc.nextInt(); // Reading the quantity the customer wants to add to their shopping cart
                    if (quantity <= current.get(choice - 1).getQuantity() && quantity <= 50) { // If the quantity the customer wants to add is less than or equal to the product's quantity in stock
                        Product p = current.get(choice - 1); // Initializing a new Product object with the chosen product's information
                        Product q = new Product(p.getName(), p.getPrice(), p.getCategory(), quantity, p.getDiscount()); // Initializing a new Product object with the chosen product's information and the customer's chosen quantity
                        p.setQuantity(p.getQuantity()-quantity); // Reducing the quantity that customer added to the cart

                        loggedUser.addProduct(q); // Adding the product to the customer's shopping cart
                    } else { // If the quantity the customer wants to add is greater than the product's quantity in stock
                        System.out.println("Invalid quantity, try again (Quantity <=50)"); // Displaying an error message
                    }
                }
                customerMenu(); // Returning to the customer menu
                break;
            }
            case 2:{ // If the customer chose to make an order
                makeOrder(loggedUser); // Calling the makeOrder method with the logged in customer as an argument
                break;
            }
        }

    }

    public void nonCustomerMenu(){ // Defining a public method called nonCustomerMenu
        s.catalog.display(); // Displaying the catalog of products
    }

    public Order makeOrder(Customer c){ // Defining a public method called makeOrder that takes in a Customer object as an argument and returns an Order object
        Payment paymentWay = new Payment(); // Initializing a new Payment object
        c.getShoppingCart().display(); // Displaying the customer's shopping cart
        Scanner sc = new Scanner(System.in); // Initializing a Scanner object
        System.out.println("Enter your address : "); // Prompting the customer to enter their address
        String address = sc.next(); // Reading the customer's address
        Bill n = c.generateBill(); // Generating a bill for the customer
        Order new_order = new Order(n , address , c); // Initializing a new Order object with the customer's information and the generated bill
        new_order.setPaymentMethod(Order.PaymentWay.onDelivery); // Setting the payment method for the new order
        System.out.println("Your order has been completed successfully"); // Displaying a success message
        System.out.println("The total price needed to pay is :" +( n.totalPayment() + 10) +" EGP"); // Displaying the total price for the order
        paymentWay.makePaymentOnDelivery(); // Making a payment on delivery
        return new_order; // Returning the new order
    }

    public void something2(){ // Defining a public method called something2 that does nothing
    }
}
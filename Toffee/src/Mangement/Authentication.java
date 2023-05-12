package Mangement;
import Classes.User;
import Classes.Customer;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Authentication { // Defining a public class called Authentication
    SystemData SD = null;  // Initializing a SystemData object
    Authentication (SystemData SD){
        this.SD = SD;
    } // Defining a constructor for the Authentication class that takes in a SystemData object as an argument
    // Function to check if the email is valid
    private int isFound(String username, String password){
        ArrayList<Customer> allCustomers;
        allCustomers = SD.getCustomers();
        int found = 0;
        for(Customer c: allCustomers){
            String UName = c.getName(), Password = c.getPassword();
            if(UName.equals(username)&&Password.equals(password)){
                return found;
            }
            found++;
        }
        return -1;
    }

    // Function to check if the email is used before
    private Boolean isFound(String email){
        for(Customer c: SD.customers){
            String UName = c.getName(), Password = c.getPassword();
            if(email.equalsIgnoreCase(c.getEmail())){
                return true;
            }
        }
        return false;
    }

    //login function
    public Customer Login(){
        Customer cust = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        int res = isFound(username,password);  // Check if username and password exist in the customers list.
        if(res !=-1){
            cust = SD.customers.get(res) ;
            System.out.println("Login successful. Welcome!"); // if login successful, print welcome message.
        }
        else{
            System.out.println("Invalid username or password"); // if login failed, print invalid username or password message.
        }
        return cust;
    }

    //Register function
    public void Register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        while(!validInputs(2,email) || isFound(email)){ // Check if the entered email is valid or used before.
            System.out.println("Please enter a valid email: ");
            email = sc.nextLine();
        }
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        while(!validInputs(1,password)){ //Check if the entered password is valid.
            System.out.println("The password must be 8 characters or numbers. Please enter your password");
            password = sc.nextLine();
        }
        System.out.println("Enter your phone number: ");
        String telephone = sc.nextLine();

          int otp = sendOTP(email); // Send an OTP to the entered email.
          System.out.println("Enter received OTP: ");
          int receivedOTP = sc.nextInt();
          while(otp != receivedOTP){ // Check if the entered OTP is correct.
              System.out.println("The entered OTP is incorrect. Please double-check the OTP you received and try again. ");
              receivedOTP = sc.nextInt();
          }
        SD.AddCustomer(new Customer(username,email,telephone,password,address));
    }

    // This method generates a random 6-digit OTP and sends it to the provided email address
    public  int sendOTP(String email) {
        // Generate a random 6-digit OTP
        Random rand = new Random();
        int otp = rand.nextInt(900000) + 100000; // range: 100000 - 999999

        // Email properties
        String host = "smtp.gmail.com";
        String username = "gamefix9000@gmail.com"; // emailak
        String password = "vosfcwrwlbfjegrz"; // passwordak
        int port = 587;

        // Sender's and recipient's email addresses
        String from = "gamefix9000@gmail.com"; // emailak
        String to = email;

        // Email message
        String subject = "One-Time Password (OTP)";
        String body = "Your OTP is: " + otp;

        // Setup email session and properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Authenticate sender's email
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Send email message
            Transport.send(message);

            System.out.println("OTP sent to " + email);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return otp;
    }

    // This method allows a user to reset their password
    public void forgetPassword(){
        int cust = - 1;
        Scanner sc = new Scanner(System.in);
        // Get the user's email address
        String email = sc.nextLine();
        // Validate the email address format
        while(!validInputs(2,email)){
            System.out.println("Please enter a valid email: ");
            email = sc.nextLine();
        }
        // Check if the email address exists in the list of customers
        for (int i = 0; i < SD.customers.size(); i++) {
            if(email.equalsIgnoreCase(SD.customers.get(i).getEmail())){
                cust = i;
            }
        }
        // If the email address doesn't exist, notify the user and return
        if(cust == -1){
            System.out.println("Don't found this Email");
        }
        // If the email address exists, generate and send an OTP to the user's email
        else {
            int otp = sendOTP(email);
            // Prompt the user to enter the OTP they received
            System.out.println("Enter received OTP: ");
            int receivedOTP = sc.nextInt();
            // Validate the OTP
            while (otp != receivedOTP) {
                System.out.println("The entered OTP is incorrect. Please double-check the OTP you received and try again. ");
                receivedOTP = sc.nextInt();
            }
            // Prompt the user to enter a new password
            System.out.println("Enter your new password: ");
            String password = sc.nextLine();
            //checks if the input password is valid, Else the loop will continue to prompt the user to enter a valid password until they provide one that meets the validation requirements.
            while(!validInputs(1,password)){
                System.out.println("The password must be 8 characters or numbers. Please enter your password");
                password = sc.nextLine();
            }
            SD.customers.get(cust).setPassword(password);
        }
    }

    //check the validity of the input data based on the type of data entered.
    private boolean validInputs(int type,String data){
        // The method initializes a boolean variable "valid" to true by default.
        boolean valid = true;
        switch(type) {
            case 1:{
                //checks whether the password length is less than 8 characters and sets the "valid" variable to false if it is.
                if(data.length()<8){
                    valid = false;
                }
                 break;
            }
            case 2:{
                //the method uses regular expressions to check whether the email is a valid gmail address, and sets the "valid" variable to false if it is not.
                String patternString = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
                Pattern pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(data);

                if (!matcher.matches()) {
                    valid = false;
                }
                break;
            }
        }
        return valid;
    }

}

package Mangement;
import Classes.User;
import Classes.Customer;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Authentication {
    SystemData SD = null;
    Authentication (SystemData SD){
        this.SD = SD;
    }
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
    public User Login(){
        Customer cust = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        int res = isFound(username,password);
        if(res !=-1){
            cust = SD.customers.get(res) ;
            System.out.println("Login successful. Welcome!");
        }
        else{
            System.out.println("Invalid username or password");
        }
        return cust;
    }
    public void Regester(){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        while(!validInputs(2,email)){
            System.out.println("Please enter a valid email: ");
            email = sc.nextLine();
        }
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        while(!validInputs(1,password)){
            System.out.println("The password must be 8 characters or numbers. Please enter your password");
            password = sc.nextLine();
        }
        System.out.println("Enter your phone number: ");
        String telephone = sc.nextLine();
        
          int otp = sendOTP(email);
          System.out.println("Enter received OTP: ");
          int receivedOTP = sc.nextInt();
          while(otp != receivedOTP){
              System.out.println("The entered OTP is incorrect. Please double-check the OTP you received and try again. ");
              receivedOTP = sc.nextInt();
          }
        SD.AddCustomer(new Customer(username,address,email,password,telephone,0));
    }

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


    private boolean validInputs(int type,String data){
        boolean valid = true;
        switch(type) {
            case 1:{
                if(data.length()<8){
                    valid = false;
                }
                 break;
            }
            case 2:{
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
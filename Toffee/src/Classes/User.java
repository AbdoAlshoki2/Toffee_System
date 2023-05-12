package Classes;

// Class to represent a user
public class User {
    protected String name; //protected field to store the name of the user
    protected String id;  //protected field to store the id of the user
    protected String telephone;  //protected field to store the telephone of the user
    protected String email;  //protected field to store the email of the user
    protected String password;  //protected field to store the password of the user

    public User(){
        //default constructor
    }

    // Constructor that takes the name, id, telephone, email, and password for the user
    public User(String name, String id, String telephone, String email, String password) {
        this.name = name;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }

    // Getter function for the name field
    public String getName() {
        return name;
    }

    // Setter function for the name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter function for the id field
    public String getId() {
        return id;
    }

    // Setter function for the id field
    public void setId(String id) {
        this.id = id;
    }

    // Getter function for the telephone field
    public String getTelephone() {
        return telephone;
    }

    // Setter function for the telephone field
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Getter function for the email field
    public String getEmail() {
        return email;
    }

    // Setter function for the email field
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter function for the password field
    public String getPassword() {
        return password;
    }

    // Setter function for the password field
    public void setPassword(String password) {
        this.password = password;
    }

    // Function to display the user's information
    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Email: " + this.email);
        System.out.println("Telephone: " + this.telephone);
    }

    // Function to check if two users are equal
    public Boolean equal(User u){
        return u.getEmail() == this.email && u.getId() == this.id && u.getName().contentEquals(this.name);
    }
}

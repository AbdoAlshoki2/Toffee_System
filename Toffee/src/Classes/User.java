package Classes;

public class User {
    protected String name;
    protected String id;
    protected String telephone;
    protected String email;
    protected String password;

    public User(){

    }

    public User(String name, String id, String telephone, String email, String password) {
        this.name = name;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Email: " + this.email);
        System.out.println("Telephone: " + this.telephone);
    }

    public Boolean equal(User u){
        return u.getEmail() == this.email && u.getId() == this.id && u.getName().contentEquals(this.name);
    }
}

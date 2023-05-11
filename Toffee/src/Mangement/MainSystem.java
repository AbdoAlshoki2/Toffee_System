package Mangement;
import Classes.Catalog;
import Classes.Product;

import java.util.*;

public class MainSystem {
    SystemData s;

    public MainSystem(){
        s = new SystemData();
    }

    public void something(){
        Authentication class1 = new Authentication(s);
        class1.sendOTP("abdelrahmanalshoki@gmail.com");

    }

    public void something2(){
        String choice;
        System.out.println("Choose one of these  types:\n1-Name\n2-Price\n3-Quantity");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.next();
        switch (choice){
            case "Name":
                s.getCatalog().sortBy(Catalog.ProductAttributes.name);
                break;
            case "Price":
                s.getCatalog().sortBy(Catalog.ProductAttributes.price);
                break;

            case "Quantity":
                s.getCatalog().sortBy(Catalog.ProductAttributes.quantity);
                break;
            default:

        }
    }
}

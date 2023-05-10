package Mangement;
import Classes.Product;

import java.util.*;

public class MainSystem {
    SystemData s;

    public MainSystem(){
        s = new SystemData();
    }

    public void something(){
        String choice;
        System.out.println("Choose one of these  types:\n1-Candy\n2-Cake\n3-Chocolate");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.next();
        switch (choice){
            case "Candy":
                s.getCatalog().filter(Product.Category.Candy);
                break;
            case "Cake":
                s.getCatalog().filter(Product.Category.Cakes);
                break;

            case "Chocolate":
                s.getCatalog().filter(Product.Category.Chocolate);
                break;
            default:

        }

    }
}

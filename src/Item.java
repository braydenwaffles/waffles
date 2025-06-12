import java.util.Scanner;
import java.util.Random;

public class Item {
    public String itemName;
    //public String itemType;
    public boolean isPlayerItem;


    //constructor
    public Item (String itemName, boolean isPlayerItem) {
        this.itemName = itemName;
        //this.itemType = itemType;
        this.isPlayerItem = isPlayerItem;
    }

    public double useItem (Scanner scan, Random random) {
        double modifiedOutput = 0;
        if (isPlayerItem == true) { //player item useage
            //int itemChoice = scan.nextInt();
            if (itemName.equals("Potion")) {
                System.out.println("You used a potion!");
                modifiedOutput = 0;
                modifiedOutput += 20;
                return modifiedOutput;
            } else {
                System.out.println("You used the pokeflute!");
                modifiedOutput = 0;
                modifiedOutput +=  1.11;
                return modifiedOutput;
                //does not need to return anything in reality
            }
        } else {
            //int rivalItemChoice = random.nextInt(2) + 1;
            if (itemName.equals("Potion")) {
                System.out.println("Rival used a potion!");
                modifiedOutput = 0;
                modifiedOutput += 20;
                return modifiedOutput;
            } else {
                System.out.println("Rival used the pokeflute!");
                modifiedOutput = 0;
                modifiedOutput +=  1.11;
                return modifiedOutput;
            }
        }
    }

}
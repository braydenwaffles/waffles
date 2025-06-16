import java.util.Scanner;
import java.util.Random;

public class Charmander extends Pokemon {
    public Charmander(boolean isPlayerPokemon){
        super("Charmander", isPlayerPokemon);
        super.type = "Fire";
    }

    @Overide
    public int useAttack(int energy, Scanner scan){
        int damageOutput = 0;
        if (isPlayerPokemon == true){ //player pokemon attack
            if (energy < 1) {
                System.out.println("You don't have enough energy to attack!");
            } else{
                System.out.println("Which attack would you like to choose?");
                System.out.println("1. Ember (20 dmg) \n2. Slash (30 dmg)"); //make attacks cost energy in the future
                int attackChoice = scan.nextInt();
                if (attackChoice == 1) {
                    System.out.println("You used Ember!");
                    damageOutput = 0;
                    damageOutput += 20;
                    return damageOutput;           
                } else {
                    System.out.println("You used Slash!");
                    damageOutput = 0;
                    damageOutput += 30;
                    return damageOutput;    
                }
            }
        }else{//rival pokemon attack
            if (energy < 1) {
                System.out.println("Your rival tried to attack but does not have enough energy!");
            } else {
                System.out.println("Which attack would you like to choose?");
                System.out.println("1. Ember (20 dmg) \n2. Slash (30 dmg)"); //make attacks cost energy in the future
                int attackChoice = scan.nextInt();
                if (attackChoice == 1) {
                    System.out.println("You used Ember!");
                    damageOutput = 0;
                    damageOutput += 20;
                    return damageOutput;           
                } else {
                    System.out.println("You used Slash!");
                    damageOutput = 0;
                    damageOutput += 30;
                    return damageOutput;    
                }
            }
        }
    }
}
import java.util.Scanner;
import java.util.Random;

public class Bulbasaur extends Pokemon {
    public Bulbasaur(boolean isPlayerPokemon){
        super("Bulbasaur", isPlayerPokemon);
        super.type = "Grass";
    }

    @Overide
    public int useAttack(int energy, Scanner scan){
        int damageOutput = 0;
        if (isPlayerPokemon == true){ //player pokemon attack
            System.out.println("Which attack would you like to choose?");
            System.out.println("1. Vine whip (20 dmg)\n2. Bloom (30 dmg)");
            int attackChoice = scan.nextInt();
            if (attackChoice == 1) {
                System.out.println("You used Vine whip!");
                damageOutput = 0;
                damageOutput += 20;
                return damageOutput;           
            } else {
                System.out.println("You used Bloom!");
                damageOutput = 0;
                damageOutput += 30;
                return damageOutput; 
            }
        }else{//rival pokemon attack
            System.out.println("Which attack would you like to choose?");
            System.out.println("1. Vine whip (20 dmg)\n2. Bloom (30 dmg)");
            int attackChoice = scan.nextInt();
            if (attackChoice == 1) {
                System.out.println("You used Vine whip!");
                damageOutput = 0;
                damageOutput += 20;
                return damageOutput;           
            } else {
                System.out.println("You used Bloom!");
                damageOutput = 0;
                damageOutput += 30;
                return damageOutput; 
            }
        }
    }
}
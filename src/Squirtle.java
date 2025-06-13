import java.util.Scanner;
import java.util.Random;

public class Squirtle extends Pokemon {
    public Squirtle(boolean isPlayerPokemon){
        super("Squirtle", isPlayerPokemon);
        super.type = "Water";
    }

    @Overide
    public int useAttack(int energy, Scanner scan){
        int damageOutput = 0;
        if (isPlayerPokemon == true){ //player pokemon attack
            if (energy < 1) {
                System.out.println("You don't have enough energy to attack!");
            } else{
                System.out.println("Which attack would you like to choose?");
                System.out.println("1. Water Gun (20 dmg) \n2. Tail whip (30 dmg)");
                int attackChoice = scan.nextInt();
                if (attackChoice == 1) {
                    System.out.println("You used Water gun!");
                    damageOutput = 0;
                    damageOutput += 20;
                    return damageOutput;           
                }else{
                    System.out.println("You used Tail whip!");
                    damageOutput = 0;
                    damageOutput += 30;
                    return damageOutput;    
                }
            }
        }else{//rival pokemon attack
            if (energy < 1) {
                System.out.println("Your rival tried to attack but does not have enough energy!");
            } else {
                int rivalAttackChoice = random.nextInt(2) + 1;
                //System.out.println("Debug: " + rivalAttackChoice);
                if (rivalAttackChoice == 1) {
                    System.out.println("Your rival used Water gun!");
                    damageOutput = 0;
                    damageOutput += 20;
                    return damageOutput;           
                } else {
                    System.out.println("Your rival used Tail whip!");
                    damageOutput = 0;
                    damageOutput += 30;
                    return damageOutput;    
                }
            }
        }
    }
}
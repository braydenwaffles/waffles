import java.util.Scanner;
import java.util.Random;

public class Pokemon {
    public String name;
    public String type;
    public int energy;
    // public boolean evo;
    public int health;
    private boolean isPlayerPokemon;

    public Pokemon(String name, String type, int energy, boolean isPlayerPokemon) {
        this.name = name;
        this.type = type;
        this.energy = energy;
        // this.evo = evo;
        this.health = 60;
        this.isPlayerPokemon = isPlayerPokemon;
    }

    public int useAttack(String name, int energy, Scanner scan, Random random) {
        int damageOutput = 0;
        if (isPlayerPokemon == true) { //player pokemon attack
            if (energy < 1) {
                System.out.println("You don't have enough energy to attack!");
            } else {
                if (name.equals("Charmander")) {
                    System.out.println("Which attack would you like to choose?");
                    System.out.println("1. Ember (20 dmg) \n2. Slash (30 dmg)");
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
                } else if (name.equals("Squirtle")) {
                    System.out.println("Which attack would you like to choose?");
                    System.out.println("1. Water Gun (20 dmg) \n2. Tail whip (30 dmg)");
                    int attackChoice = scan.nextInt();
                    if (attackChoice == 1) {
                        System.out.println("You used Water gun!");
                        damageOutput = 0;
                        damageOutput += 20;
                        return damageOutput;           
                    } else {
                        System.out.println("You used Tail whip!");
                        damageOutput = 0;
                        damageOutput += 30;
                        return damageOutput;    
                    }
                } else if (name.equals("Bulbasaur")) {
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
        } else { //rival pokemon attack
            if (energy < 1) {
                System.out.println("Rival does not have enough energy to attack!");
            } else {
                if (name.equals("Charmander")) {
                    int rivalAttackChoice = random.nextInt(2) + 1;
                    System.out.println("Debug: " + rivalAttackChoice);
                    if (rivalAttackChoice == 1) {
                        System.out.println("Your rival used Ember!");
                        damageOutput = 0;
                        damageOutput += 20;
                        return damageOutput;           
                    } else {
                        System.out.println("Your rival used Slash!");
                        damageOutput = 0;
                        damageOutput += 30;
                        return damageOutput;    
                    }
                } else if (name.equals("Squirtle")) {
                    int rivalAttackChoice = random.nextInt(2) + 1;
                    System.out.println("Debug: " + rivalAttackChoice);
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
                } else if (name.equals("Bulbasaur")) {
                    int rivalAttackChoice = random.nextInt(2) + 1;
                    System.out.println("Debug: " + rivalAttackChoice);
                    if (rivalAttackChoice == 1) {
                        System.out.println("Your rival used Vine whip!");
                        damageOutput = 0;
                        damageOutput += 20;
                        return damageOutput;           
                    } else {
                        System.out.println("Your rival used Bloom!");
                        damageOutput = 0;
                        damageOutput += 30;
                        return damageOutput; 
                    }
                    
                }
            }

        }
        return damageOutput;
    }
    
    public int useItem() {
        //ADD ITEM CODE
        return 0;
    }
    
}

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean hasPokemon = false;

        //must declare
        Pokemon playerPokemon = null;
        Pokemon rivalPokemon = null;


        //picking a pokemon
        while (hasPokemon == false) {
            System.out.println("Please choose your basic pokemon:\n1. Charmander \n2. Squirtle \n3. Bulbasaur");
            int beginningChoice = scan.nextInt();

            if (beginningChoice == 1) {
                playerPokemon = new Pokemon("Charmander", "Fire", 0, 60, true);
                rivalPokemon = new Pokemon("Bulbasaur", "Grass", 0, 60, false);
                System.out.println("You chose Charmander!");
                hasPokemon = true;
            } else if (beginningChoice == 2) {
                playerPokemon = new Pokemon("Squirtle", "Water", 0, 60, true);
                rivalPokemon = new Pokemon("Charmander", "Fire", 0, 60, false);
                System.out.println("You chose Squirtle!");
                hasPokemon = true;
            } else if (beginningChoice == 3) {
                playerPokemon = new Pokemon("Bulbasaur", "Grass", 0, 60, true);
                rivalPokemon = new Pokemon("Squirtle", "Water", 0, 60, false);
                System.out.println("You chose Bulbasaur!");
                hasPokemon = true;
            } else {
                System.out.println("Not an option!");
            } 
        }

        //creating items
        Item playerItemPotion = new Item("Potion", true);
        Item playerItemFlute = new Item("Pokeflute", true);
        Item rivalItemPotion = new Item("Potion", false);
        Item rivalItemFlute = new Item("Pokeflute", false);

        System.out.println("Great choice! \nIt's now time for your first battle against your rival!");
        //battle phase loop
        
        int turnCount = 1;
        
        while (playerPokemon.health > 0 && rivalPokemon.health > 0) {

            //turn
            System.out.println("Turn " + turnCount);

            //health
            System.out.println("Your " + playerPokemon.name + " has " + playerPokemon.health + " health");
            System.out.println("Your rival's " + rivalPokemon.name + " has " + rivalPokemon.health + " health");

            //energy
            System.out.println("Your pokemon has " + playerPokemon.energy + " energy");

            System.out.println("What would you like to do? \n 1. Attach an energy \n 2. Attack \n 3. Use an item");
            int battleChoice = scan.nextInt();

            if (battleChoice == 1) {
                playerPokemon.energy += 1;
                System.out.println("You attatched an energy!");
            } else if (battleChoice == 2) {
                int damage = 0;
                damage = playerPokemon.useAttack(playerPokemon.name, playerPokemon.energy, scan, random);
                rivalPokemon.health -= damage;
            } else if (battleChoice == 3) {
                System.out.println("Which item would you like to use?");
                System.out.println("1. Potion (Heals 20HP) \n2. Pokeflute (Makes opponent fall asleep for one turn!)");
                int itemChoice = scan.nextInt(); 
                if (itemChoice == 1) {
                    System.out.println("You used a potion!");
                    double modifier = 0;
                    modifier = playerItemPotion.useItem(scan, random);
                    playerPokemon.health += modifier;
                    System.out.println("Your " + playerPokemon.name + " has " + playerPokemon.health + " health");
                } else {
                    System.out.println("You used the Pokeflute!");
                    double modifier = 0;
                    modifier = playerItemFlute.useItem(scan, random);
                    //add disrupt code to here and item
                }
                
            } else {
                System.out.println("Not an option!");
            }


            //rival turn logic
            int rivalChoice = random.nextInt(3) + 1;

            if (rivalChoice == 1) { //energy
                rivalPokemon.energy += 1;
                System.out.println("Your rival attatched an energy!");
            } else if (rivalChoice == 2) { //attack
                int damage = 0;
                damage = rivalPokemon.useAttack(rivalPokemon.name, rivalPokemon.energy, scan, random);
                playerPokemon.health -= damage;
            } else if (rivalChoice == 3) { //item
                int rivalItemChoice = random.nextInt(2) + 1;
                if (rivalItemChoice == 1) {
                    System.out.println("Rival used a potion!");
                    double modifier = 0;
                    modifier = rivalItemPotion.useItem(scan, random);
                    rivalPokemon.health += modifier;
                    System.out.println("Your rival's " + rivalPokemon.name + " has " + rivalPokemon.health + " health");
                } else {
                    System.out.println("Rival used the Pokeflute!");
                    double modifier = 0;
                    modifier = rivalItemFlute.useItem(scan, random);
                    //add disrupt code to here and item
                }
            } else {
                //failsafe but should never happen
                System.out.println("Your rival didn't do anything!");
            }

            turnCount += 1;

        }

        // end of battle
        if (rivalPokemon.health <= 0) {
            System.out.println("Your rival's " + rivalPokemon.name + " fainted!"); 
            System.out.println("You defeated your rival!");
        } else if (playerPokemon.health <= 0) {
            System.out.println("Your " + playerPokemon.name + " fainted!"); 
            System.out.println("Your rival defeated you!");
        }



        
    }
}

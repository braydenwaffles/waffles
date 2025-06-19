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
                playerPokemon = new Charmander(true, 60);
                rivalPokemon = new Bulbasaur(false, 60);
                System.out.println("You chose Charmander!");
                hasPokemon = true;
            } else if (beginningChoice == 2) {
                playerPokemon = new Squirtle(true, 60);
                rivalPokemon = new Charmander(false, 60);
                System.out.println("You chose Squirtle!");
                hasPokemon = true;
            } else if (beginningChoice == 3) {
                playerPokemon = new Bulbasaur(true, 60);
                rivalPokemon = new Squirtle(false, 60);
                System.out.println("You chose Bulbasaur!");
                hasPokemon = true;
            } else {
                System.out.println("Not an option!");
            } 
        }

        int playerMaxHealth = playerPokemon.getHealth();
        int rivalMaxHealth = rivalPokemon.getHealth();

        //creating items
        Item playerItemPotion = new Item("Potion", true);
        //Item playerItemFlute = new Item("Pokeflute", true);
        Item rivalItemPotion = new Item("Potion", false);
        //Item rivalItemFlute = new Item("Pokeflute", false);

        System.out.println("Great choice! \nIt's now time for your first battle against your rival!");
        //battle phase loop
        
        int turnCount = 1;
        
        //player logic
        while (playerPokemon.getHealth() > 0 && rivalPokemon.getHealth() > 0) {

            //turn
            System.out.println("Turn " + turnCount);

            //health
            System.out.println("Your " + playerPokemon.getName() + " has " + playerPokemon.getHealth() + " health");
            System.out.println("Your rival's " + rivalPokemon.getName() + " has " + rivalPokemon.getHealth() + " health");

            //energy
            System.out.println("Your pokemon has " + playerPokemon.getEnergy() + " energy");
            System.out.println("Debug" + rivalPokemon.getEnergy());

            System.out.println("What would you like to do? \n 1. Attach an energy \n 2. Attack \n 3. Use an item");
            int battleChoice = scan.nextInt();

            if (battleChoice == 1) {
                playerPokemon.addEnergy(1);
                System.out.println("You attatched an energy!");
            } else if (battleChoice == 2) {
                int damage = 0;
                damage = playerPokemon.useAttack(playerPokemon.getEnergy(), true, scan, random);
                rivalPokemon.modifyHealth(true, damage);
            } else if (battleChoice == 3) {
                boolean itemUsed = false;
                while (!itemUsed) {
                    System.out.println("Which item would you like to use?");
                    System.out.println("1. Potion (Heals 20HP) \n2. Pokeflute (Makes opponent fall asleep for one turn!)");
                    int itemChoice = scan.nextInt(); 

                    if (itemChoice == 1) {
                        if (playerPokemon.getHealth() >= playerMaxHealth) {
                            System.out.println("You're already at max health!");
                            continue; // Show item menu again
                        }
                        System.out.println("You used a potion!");
                        int heal = playerItemPotion.useItem(scan, random);
                        playerPokemon.modifyHealth(false, heal);
                        System.out.println("Your " + playerPokemon.getName() + " has " + playerPokemon.getHealth() + " health");
                        itemUsed = true;
                    } else if (itemChoice == 2) {
                        System.out.println("You used a Pokeflute!");
                        // apply pokeflute effect
                        itemUsed = true;
                    } else {
                        System.out.println("Invalid item choice.");
                    }
                }
            } else {
                System.out.println("Not an option!");
            }


            //rival turn logic
            int rivalChoice = random.nextInt(3) + 1;

            if (rivalChoice == 1) { //energy
                rivalPokemon.addEnergy(1);
                System.out.println("Your rival attatched an energy!");
            } else if (rivalChoice == 2) { //attack
                int damage = 0;
                damage = rivalPokemon.useAttack(rivalPokemon.getEnergy(), false, scan, random);
                playerPokemon.modifyHealth(true, damage);
            } else if (rivalChoice == 3) { //item
                boolean itemUsed = false;
                while (!itemUsed) {
                    int rivalItemChoice = random.nextInt(2) + 1;
                    if (rivalItemChoice == 1) {
                        if (rivalPokemon.getHealth() >= rivalMaxHealth) {
                            continue;
                        }
                        //System.out.println("Rival used a potion!");
                        int heal = rivalItemPotion.useItem(scan, random);
                        rivalPokemon.modifyHealth(false, heal);
                        System.out.println("Your rival's " + rivalPokemon.getName() + " has " + rivalPokemon.getHealth() + " health");
                        itemUsed = true;
                    } else {
                        //System.out.println("Rival used the Pokeflute!");
                        //double modifier = 0;
                        //modifier = rivalItemFlute.useItem(scan, random);
                        //add disrupt code to here and item
                        itemUsed = true;
                }
                }
                
            } else {
                //failsafe but should never happen
                System.out.println("Your rival didn't do anything!");
            }

            turnCount += 1;

        }

        // end of battle
        if (rivalPokemon.getHealth() <= 0) {
            System.out.println("Your rival's " + rivalPokemon.getName() + " fainted!"); 
            System.out.println("You defeated your rival!");
        } else if (playerPokemon.getHealth() <= 0) {
            System.out.println("Your " + playerPokemon.getName() + " fainted!"); 
            System.out.println("Your rival defeated you!");
        }



        
    }
}

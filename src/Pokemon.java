import java.util.Scanner;
import java.util.Random;

public abstract class Pokemon {
    //public String name;
    public String type;
    private int energy;
    // public boolean evo;
    private int health;
    public final boolean isPlayerPokemon;
    
    //constructor
    public Pokemon(boolean isPlayerPokemon, int health) {
        this.isPlayerPokemon = isPlayerPokemon;
        this.energy = 0;
        this.health = health;      
        // this.evo = evo; evolution add on for later
    }

    //abstract method for the subclass to override
    public abstract int useAttack(int energy, boolean isPlayerPokemon, Scanner scan, Random random);


    //abstract getter for name because the subclass tells it's own name
    public abstract String getName();


    //getter for type
    public String getType(){
        return this.type;
    }

    //getter for energy
    public int getEnergy() {
        return this.energy;
    }

    //getter for health
    public int getHealth() {
        return this.health;
    }

    /*
    //setter for health ???
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    
    //setter for energy ???
    public void setEnergy(int newEnergy){
        this.energy = newEnergy;
    }
    */

    //energy add
    public void addEnergy(int addedEnergy) {
        this.energy += addedEnergy;
    }
    

    public void modifyHealth(boolean damage, int modifier) {
        if (damage == false) {
            this.health += modifier;
        } else {
            this.health -= modifier;
        }
    }


}

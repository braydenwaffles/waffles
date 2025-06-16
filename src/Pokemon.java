import java.util.Scanner;
import java.util.Random;

public abstract class Pokemon {
    //public String name;
    public String type;
    public int energy;
    // public boolean evo;
    public int health;
    public boolean isPlayerPokemon;
    
    //constructor
    public Pokemon(boolean isPlayerPokemon, int health) {
        this.isPlayerPokemon = isPlayerPokemon;
        this.energy = 0;
        this.health = health;      
        // this.evo = evo; evolution add on for later
    }

    //abstract method for the subclass to override
    public abstract int useAttack(int energy, boolean isPlayerPokemon, Scanner scan, Random random);


    //getter for name
    public abstract String getName();

    //getter for type
    public String getType(){
        return type;
    }
    
    //setter for energy
    public void setEnergy(int new_energy){
        energy = new_energy;
    }
}

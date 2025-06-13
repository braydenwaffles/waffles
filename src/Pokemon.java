import java.util.Scanner;
import java.util.Random;

public class Pokemon {
    private String name;
    private String type;
    public int energy;
    // public boolean evo;
    public int health;
    private boolean isPlayerPokemon;
    
    //constructor
    public abstract Pokemon(String name, boolean isPlayerPokemon){
        this.name = name;
        this.isPlayerPokemon = isPlayerPokemon;
        this.energy = 0;
        this.health = 60;
        
        // this.evo = evo; evolution add on for later
        this.energy = energy;
        this.health = health;
    }

    //getter for name
    public String getName(){
        return name;
    }

    //getter for name
    public String getType(){
        return name;
    }

    public void setEnergy(int new_energy){
        energy = new_energy;
    }
}

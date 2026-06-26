import java.util.ArrayList;

/**
 * Abstract base class for all animals in the conservation system.
 */
public abstract class Animal {
    // TODO M1: Declare static nextId field, starting at 1
    private static int nextId = 1;

    // TODO M1: Declare private fields:
        private int animalId;

        private String species,
                       nickname,
                       healthStatus,
                       island;

        private double weightKg;
        
        private ArrayList<String> sightings;
    // TODO M4: Declare private ArrayList<String> sightings field

    
    /**
     * Constructor: assigns auto-incremented ID, validates all parameters.
     * Species, nickname, island must not be null or empty.
     * weightKg must be > 0.
     * healthStatus must be "Healthy", "Injured", or "Critical".
     *
     * TODO M1: Implement constructor with validation
     * 
     * TODO M4: Initialize sightings list
     */
    public Animal(String species, String nickname, String island, double weightKg, String healthStatus) {
        // TODO M1: Validate parameters and assign fields
        this.species = species;
        this.nickname = nickname;
        this.island = island;
        this.weightKg = weightKg;
        this.healthStatus = healthStatus;
        // TODO M1: Auto-assign animalId from nextId, then increment nextId
        animalId = nextId;
        nextId+=1;
        sightings = new ArrayList<>();
        // TODO M4: Initialize sightings ArrayList
        // ArrayList<> sightings;
    }

    // TODO M1: Write getters for all fields (getAnimalId, getSpecies, getNickname,
    //          getIsland, getWeightKg, getHealthStatus)
    public String getIsland(){
        return island;
    }
    public int getAnimalId(){
        return animalId;
    }
    public String getSpecies(){
        return species;
    }
    public double getWeightKg(){
        return weightKg;
    }
    public String getNickname(){
        return nickname;
    }
    public String getHealthStatus(){
        return healthStatus;
    }
    // TODO M2: Write setIsland(String island) method

    // TODO M4: Write getSightings() getter that returns the ArrayList<String>
    protected ArrayList<String> getSightings(){
        return sightings;
    }
    /**
     * Updates the health status after validation.
     * TODO M1: Implement updateHealth
     */
    public void updateHealth(String newStatus) {
        healthStatus = newStatus;       
        // TODO M1: Validate newStatus and update the field
    }
    public void setIsland(String newIsland){
        island = newIsland;
    }

    /**
     * Returns the animal type: "Bird", "Reptile", or "Marine".
     * TODO M2: Declare as abstract
     */
    public abstract String getType();

    /**
     * Returns the daily food cost in TTD. Varies by subclass.
     * TODO M2: Declare as abstract
     */
    public abstract double getDailyFoodCostTTD();

    /**
     * Format: "#%03d %s '%s' (%s) [%s] %.2f kg - %s"
     * Example: "#001 Scarlet Ibis 'Ruby' (Trinidad) [Bird] 0.35 kg - Healthy"
     *
     * TODO M1: Implement toString
     */
    @Override
    public String toString() {
        
        return String.format("#%03d %s '%s' (%s) [%s] %.2fkg - %s", 
        getAnimalId(),getSpecies(),getNickname(),getIsland(),getType(),getWeightKg(),getHealthStatus());
    }

    /**
     * Two animals are equal if they have the same animalId.
     *
     * TODO M5: Implement equals
     */
    @Override
    public boolean equals(Object obj) {
        // TODO M5: Implement equality by animalId
        if(obj instanceof Animal){
            Animal other = (Animal) obj;
            return this.animalId == other.animalId;
        }
            return false;
    }

    /**
     * TODO M5: Implement hashCode based on animalId
     */
    @Override
    public int hashCode() {
        // TODO M5: Return hash based on animalId
        return Integer.hashCode(animalId);
    }
}

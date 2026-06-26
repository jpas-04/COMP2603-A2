import java.util.ArrayList;

/**
 * Manages a collection of animals at a single location.
 */
public class Sanctuary {
    // TODO M5: Declare private fields: name (String), island (String),
    //          capacity (int), animals (ArrayList<Animal>)
    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;
    /**
     * TODO M5: Implement constructor
     */
    public Sanctuary(String name, String island, int capacity) {
        // TODO M5: Initialize all fields, create empty ArrayList
        this.name = name;
        this.island = island;
        this.capacity = capacity;
        animals = new ArrayList<>();
    }

    // TODO M5: Write getters for name, island, capacity, and animals
    public String getName(){
        return name;
    }
    public String getIsland(){
        return island;
    }
    public int getCapacity(){
        return capacity;
    }
    public ArrayList<Animal> getAnimals(){
        return animals;
    }
    /**
     * Adds an animal to this sanctuary.
     * Rejects null animals, rejects if at capacity, rejects if animal's island
     * does not match this sanctuary's island.
     *
     * TODO M5: Implement addAnimal
     */
    public boolean addAnimal(Animal a) {
        if (a.equals(null) || getAnimals().size() == capacity || a.getIsland() != island)
        return false;
        animals.add(a);
        return true;
    }

    /**
     * Removes and returns the animal with the given ID, or null if not found.
     *
     * TODO M5: Implement removeAnimal
     */
    public Animal removeAnimal(int animalId) {
        // TODO M5: Find by ID, remove, and return
        for(Animal a : animals){
            if(a.getAnimalId() == animalId){
                animals.remove(a);
            }
        }
        return null;
    }

    /**
     * TODO M5: Implement getAnimalCount
     */
    public int getAnimalCount() {
        // TODO M5
        return animals.size();
    }

    public void printRoster(){
        for(Animal a : animals)
            System.out.println(a);
    }

    /**
     * Returns a new ArrayList containing only animals of the given type.
     *
     * TODO M7: Implement getAnimalsOfType
     */
    public ArrayList<Animal> getAnimalsOfType(String type) {
        ArrayList<Animal> a = new ArrayList<>();
        for(Animal ani : animals){
            if(ani.getType() == type)
                a.add(ani);
            }
        return a;
    }

    /**
     * Returns the total daily food cost for all animals, rounded to 2 decimal places.
     *
     * TODO M7: Implement getDailyFoodBudget
     */
    public double getDailyFoodBudget() {
        double money=0;
        for(Animal ani : animals){
            money = ani.getDailyFoodCostTTD() + money;
        }
        return Math.round(money * 100.0) / 100.0;
    }

    /**
     * Returns all animals that implement the Relocatable interface.
     * Hint: use instanceof.
     *
     * TODO M8: Implement getRelocatableAnimals
     */
    public ArrayList<Animal> getRelocatableAnimals() {
        // TODO M8: Filter using instanceof Relocatable
        return new ArrayList<Animal>();
    }

    /**
     * Returns the animal with the highest daily food cost, or null if empty.
     *
     * TODO M7: Implement getMostExpensiveAnimal
     */
    public Animal getMostExpensiveAnimal() {
        // TODO M7: Find max by getDailyFoodCostTTD()
        Animal a = null;
        if(animals == null){
            return null;
        }
        for(Animal ani : animals){
            if(ani.getDailyFoodCostTTD() > a.getDailyFoodCostTTD())
                a = ani;
        }
        return a;
    }

    /**
     * Transfers an animal to another sanctuary.
     * If the animal does not implement Relocatable, the transfer fails:
     * re-add the animal to this sanctuary and return false.
     * Otherwise, call relocateTo on the animal, then addAnimal on target.
     *
     * TODO M8: Implement transferAnimal
     */
    public boolean transferAnimal(int animalId, Sanctuary target) {
        // TODO M8: Remove animal, check Relocatable, relocate, add to target
        return false;
    }

    /**
     * Prints each animal's toString, indented by 2 spaces.
     *
     * TODO M5: Implement printRoster
     */

    /**
     * Format: "Name (Island) [count/capacity animals]"
     * Example: "Caroni Bird Sanctuary (Trinidad) [12/50 animals]"
     *
     * TODO M5: Implement toString
     */
    @Override
    public String toString() {
        // TODO M5: Return formatted string

        return String.format("%s (%s) [%s/%s animals]", name, island,getAnimalCount(),capacity);
    }
}

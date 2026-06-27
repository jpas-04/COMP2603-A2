import java.util.ArrayList;

public class Sanctuary {

    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;

    public Sanctuary(String name, String island, int capacity) {
        this.name = name;
        this.island = island;
        this.capacity = capacity;
        animals = new ArrayList<>();
    }

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

    public boolean addAnimal(Animal a) {
        if (a.equals(null) || getAnimals().size() == capacity || a.getIsland() != island)
        return false;
        animals.add(a);
        return true;
    }

    public Animal removeAnimal(int animalId) {
        // TODO M5: Find by ID, remove, and return
        for(Animal a : animals){
            if(a.getAnimalId() == animalId){
                animals.remove(a);
                return a;
            }
        }
        return null;
    }

    public int getAnimalCount() {
        // TODO M5
        return animals.size();
    }

    public void printRoster(){
        for(Animal a : animals)
            System.out.println("  " + a);
    }

    public ArrayList<Animal> getAnimalsOfType(String type) {
        ArrayList<Animal> a = new ArrayList<>();
        for(Animal ani : animals){
            if(ani.getType() == type)
                a.add(ani);
            }
        return a;
    }

    public double getDailyFoodBudget() {
        double money=0;
        for(Animal ani : animals){
            money = ani.getDailyFoodCostTTD() + money;
        }
        return Math.round(money * 100.0) / 100.0;
    }

    public ArrayList<Animal> getRelocatableAnimals() {
        ArrayList<Animal> a = new ArrayList<>();
        for(Animal ani : animals)
        if(ani instanceof Relocatable){
            a.add(ani);
        }
        return a;
    }

    public Animal getMostExpensiveAnimal() {     
        if(animals.isEmpty()){
            return null;
        }
        Animal max = animals.get(0);
        for(Animal ani : animals){
            if(ani.getDailyFoodCostTTD() > max.getDailyFoodCostTTD())
                max = ani;
        }
        return max;
    }

    public boolean transferAnimal(int animalId, Sanctuary target) {
        Animal a = removeAnimal(animalId);
            if(a==null)
                return false;        
            
            if(!(a instanceof Relocatable)){
                addAnimal(a);
                return false;
            }
            Relocatable reloc = (Relocatable) a;
            reloc.relocateTo(target.getIsland());
            if(target.addAnimal(a)==false){
                reloc.relocateTo(this.getIsland());
                animals.add(a);
                return false;
            }
        return true;
    }

    @Override
    public String toString() {

        return String.format("%s (%s) [%s/%s animals]", name, island,getAnimalCount(),capacity);
    }
}

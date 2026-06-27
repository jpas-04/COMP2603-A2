import java.util.ArrayList;

public class Driver {
    public static void main(String[] args){
         
      Sanctuary Caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
      Sanctuary Blue = new Sanctuary("Blue Lagoon Marine Park", "Jamaica", 15);
      Bird b = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
      Bird c = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
      Bird d = new Bird("Cocorico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
      Reptile r = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
      Reptile s = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
      Marine m = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0,"Healthy",1200.0,8000);
      Bird e = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
      Marine n = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
      Marine o = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Health", 75.0, 5000);
      Caroni.addAnimal(b);
      Caroni.addAnimal(c);
      Caroni.addAnimal(d);
      Caroni.addAnimal(r);
      Caroni.addAnimal(s);
      Caroni.addAnimal(m);
      Blue.addAnimal(e);
      Blue.addAnimal(n);
      Blue.addAnimal(o);
      System.out.println("=== Caroni Bird Sanctuary roster ===");
      Caroni.printRoster();
      System.out.println("=== Blue Lagoon Marine Park Sanctuary roster ===");
      Blue.printRoster();
      System.out.println("=== Daily Food Budgets ===");
      System.out.println(Blue.getDailyFoodBudget());
      System.out.println(Caroni.getDailyFoodBudget());
      System.out.println("=== Birds at Caroni ===");
      for(Animal ani : Caroni.getAnimalsOfType("Bird"))
        System.out.println("  " + ani);
      System.out.println("=== Relocatable Animals at Caroni ===");
      for(Animal ani : Caroni.getRelocatableAnimals())
        System.out.println("  " + ani);
      System.out.println("=== Sighting Logs ===");
      b.logSighting("2010-06-09", "Caroni Swamp");
      b.logSighting("2026-06-12", "Caroni Swamp");
      System.out.println("Ruby Sighting Count: " +b.getSightingCount());
      System.out.println("Ruby Last Sighting: " + b.getLastSighting());
      m.logSighting("2026-06-11", "Matura Beach");
      System.out.println("Atlas Sighting Count: " +m.getSightingCount());
      System.out.println("Atlas Last Sighting: " + m.getLastSighting());
      System.out.println("=== Transfer Atlas to Blue Lagoon ===");
      System.out.println("Transfer Status: " + Caroni.transferAnimal(6, Blue));
      System.out.println("Blue Lagoon After Transfer:");
      Blue.printRoster();
      System.out.println("=== Attempt to Transfer Brutus (Reptile) ===");
      System.out.println("Transfer Status: " + Caroni.transferAnimal(4, Blue));
      System.out.println("=== Most Expensive Animal at Each Sanctuary ===");
      System.out.println("Most Expensive Animal in Caroni: " + Caroni.getMostExpensiveAnimal());
      System.out.println("Most Expensive Animal in Blue Lagoon: " + Blue.getMostExpensiveAnimal());
      System.out.println("=== Updated Food Budgets ===");
      System.out.println(Blue.getDailyFoodBudget());
      System.out.println(Caroni.getDailyFoodBudget());
    }
}

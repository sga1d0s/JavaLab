package Loops;

public class LoopsDoWhile {
  public static void main(String[] args) throws Exception {

    // WHILE LOOP
    // ----------

    float time = 10.f;

    while (time > 0) {
      System.out.println("Time: " + time + " - Time not finished.");
      time -= 0.5f;
    }

    System.out.println("Time: " + time + " - time finished.");

    System.out.println();

    // DO WHILE LOOP
    // -------------

    int energyPercent = 0;

    do {
      // Load battery
      System.out.println("Loading the battery... " + energyPercent + "%.");
      energyPercent += 10;
    } while (energyPercent < 100);

    System.out.println("Battery loaded... " + energyPercent + "%.");
  }
}

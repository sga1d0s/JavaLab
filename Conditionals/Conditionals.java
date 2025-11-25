package Conditionals;

public class Conditionals {
  public static void main(String[] args) {

    int life = 2;

    // IF - ELSE statement
    if (life > 0) {
      System.out.println("Yuri the Mate is alive");
    } else { // Life <= 0
      System.out.println("Yuri the Mage is dead");
    }

    int level = 5;

    // IF - ELSE IF - ELSE Statement
    if (level == 5) {
      System.out.println("Yuri is an archmage");
    } else if (level == 3 || level == 4) { // Mejor: Level > 2
      System.out.println("Yuri is an skillful mage");
    } else { // Level == 2 || Level == 1
      System.out.println("Yuri is a novice mage");
    }
  }
}

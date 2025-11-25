package Loops;

public class Loops {
  public static void main(String[] args) throws Exception {

    // FOR LOOP
    // --------

    System.out.println("Count forward from 0 to 9");
    System.out.println("-------------------------");

    // Count forward from 0 to 10
    for (int i = 0; i < 10; i++) {
      System.out.println("Number: " + i);
    }

    System.out.println();

    System.out.println("Count backward from 20 to 1");
    System.out.println("---------------------------");

    // Count backward from 20 to 1 by twos
    for (int i = 20; i > 0; i--) {
      System.out.println("Number: " + i);
    }

    System.out.println();

    System.out.println("Count backward from 20 to 1 by Twos");
    System.out.println("-----------------------------------");

    // Count backward from 20 to 1 by twos
    for (int i = 20; i > 0; i-=2) {
      System.out.println("Number: " + i);
    }
  }
}

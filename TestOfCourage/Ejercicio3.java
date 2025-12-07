package TestOfCourage;

import java.util.Scanner;

public class Ejercicio3 {
  public static void main(String[] args) {

    // 1) Mensaje de Bienvenida
    System.out.println("Character Creation");
    System.out.println("------------------");

    // 2) Read Inputs
    Scanner sc = new Scanner(System.in);

    // Read name
    System.out.println("Insert character name");
    String name = sc.next();

    // Read class
    System.out.println("Insert character class (Fighter, Cleric, Thief, Mage)");
    String type = sc.next();

    // Read age
    System.out.println("Insert character age (15-40)");
    int age = sc.nextInt();

    // Read strength
    System.out.println("Insert character strength (2-10)");
    int strength = sc.nextInt();

    // Read speed
    System.out.println("Insert character speed (8-20)");
    int speed = sc.nextInt();

    // Read intelligence
    System.out.println("Insert character intelligence (7-15)");
    int intelligence = sc.nextInt();

    // 3 Calculate the remaining attributes
    // ------------------------------------------

    // Level
    int level = (age - 15) / 2 + 1;

    // Calculate hp in a full line

    int hp = (int) Math.ceil((30 + level * ((strength - 2.0) / 3)));

    // Calculate hp in parts
    double part1 = (strength - 2.0) / 3;
    double part2 = part1 * level;
    double part4 = Math.ceil(part2 + 30);
    int hp2 = (int) part4;

    // 4) Show attributes on the console
    System.out.println("Character Attributes");
    System.out.println("------------------");

    System.out.println("Name: " + name);
    System.out.println("Type: " + type);
    System.out.println("Age: " + age);
    System.out.println("Strength: " + strength);
    System.out.println("Speed: " + speed);
    System.out.println("Intelligence: " + intelligence);

    System.out.println("Level: " + level);
    System.out.println("HP: " + hp);
    System.out.println("HP (vers. 2): " + hp2);

    sc.close();
  }
}

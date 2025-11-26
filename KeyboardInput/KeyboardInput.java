package KeyboardInput;

import java.util.Scanner;

public class KeyboardInput {
  public static void main(String[] args) {
    
    System.out.println("CHARACTER CREATION");
    System.out.println("------------------");

    Scanner sc = new Scanner(System.in);
    System.out.println("Insert character name: ");

    // Read name as String
    String name = sc.next();

    System.out.println("Insert character age: ");

    // Read age as integer
    int age = sc.nextInt();

    System.out.println("name: " + name);
    System.out.println("age: " + age + " years");

    sc.close();
  }
}

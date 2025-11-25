package Loops;

import java.util.Scanner;

public class BreakContinue {
  public static void main(String[] args) throws Exception {

    // El programa se ejecuta hasta que pulse la tecla '4'
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Press a key to perform an action: 1(new), 2(save), 3(load) 4(quit)");

      // Reload action
      int action;

      // Validate before reading
      if (sc.hasNextInt()) {
        action = sc.nextInt();
      } else {
        System.out.println("Please type a number");
        sc.next(); // consume la entrada incorrecta
        continue;  // vuelve al while sin romper nada
      }

      if (action == 1) {
        System.out.println("New file created");
      } else if (action == 2) {
        System.out.println("File saved");
      } else if (action == 3) {
        System.out.println("File loaded");
      } else if (action == 4) {
        System.out.println("Farewell");
        break; // While ended
      } else {
        System.out.println("Action no valid");
      }
    }

    sc.close();

  }
}

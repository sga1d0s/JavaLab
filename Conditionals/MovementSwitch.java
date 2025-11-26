package Conditionals;

import java.util.Scanner;

/* 
 * MovementSwitch
 */

public class MovementSwitch {
  public static void main(String[] args) {

    // 1) Mensaje de bienvenida
    System.out.println("WELCOME TO THE DUNGEON OF THE ARCHMAGE");
    System.out.println("--------------------------------------");

    // 2) Introducir datos. Solicitar datos al usuario.
    // ------------------------------------------------

    Scanner sc = new Scanner(System.in);

    // Seleccionar dirección de movimiento
    System.out.println("Please select a direction of movement: " +
        "(0-left, 1-up, 2-right, 3-down)");

    int direction = sc.nextInt();

    // Caso 3. Un único IF separado por el operador OR lógico ||
    if (direction < 0 || direction > 3) {
      System.out.println("WARNING! You choose a wrong direction");
    }

    // Select whether the archmage is shooting or not
    System.out.println("Please select if the mage is shooting or not: " +
        "(false - not shooting, true - shooting)");
    boolean isShooting = sc.nextBoolean();

    // 3) Haz algunos cálculos.

    // Inicializamos a valores no válidos
    String strDirection = "";
    String strAction = "";

    switch (direction) {
      case 0:
        strDirection = "LEFT";
        break;
      case 1:
        strDirection = "UP";
        break;
      case 2:
        strDirection = "RIGHT";
        break;
      case 3:
        strDirection = "DOWN";
        break;

      default: // Error
        break;
    }

    // Hacer cálculos de disparo
    if (isShooting) {
      strAction = "is shooting";
    } else {
      strAction = "is not shooting";
    }

    // 4) Imprimir mensajes en la consola
    System.out.println("The Archmage moves towards " + strDirection + " and " + strAction);

    sc.close();
  }
}

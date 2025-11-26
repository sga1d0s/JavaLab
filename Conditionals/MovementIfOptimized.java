package Conditionals;

import java.util.Scanner;

/* 
 * MovementIfOptimized
 */

public class MovementIfOptimized {
  public static void main(String[] args) {
    // 1) Mensaje de bienvenida
    System.out.println("WELCOME TO THE DUNGEON OF THE ARCHMAGE");
    System.out.println("--------------------------------------");

    // 2) Introducir datos. Solicitar datos al usuario.
    // ---------------------------------------------------

    Scanner sc = new Scanner(System.in);

    // Seleccionar dirección de movimiento
    System.out.println("Please select a direction of movement:" +
        "(0-left, 1-up, 2-right, 3-down)");

    int direction = sc.nextInt();

    // Caso 3: Un único IF separado por el operador OR lógico ||
    if (direction < 0 || direction > 3) {
      System.out.println("WARNING! You chose a wrong direction");
    }

    // Selecciona si el archimago está disparando o no.
    System.out.println("Please select if the mage is shooting or not:" +
        "(false - not shooting, true - shooting)");
    boolean isShooting = sc.nextBoolean();

    // 3) Haz algunos cálculos.

    // Inicializamos a valores no válidos
    String strDirection = "";
    String strAction = "";

    String resultPhraseInit = "The Archmage moves towards ";

    // Do direction calculation
    if (direction == 0) {
      strDirection = "LEFT";
    } else if (direction == 1) {
      strDirection = "UP";
    } else if (direction == 2) {
      strDirection = "RIGHT";
    } else // direction == 3. Al haber verificado previamente los datos correctos puedo
           // asegurarme que es direction == 3
    {
      strDirection = "DOWN";
    }

    // Do shooting calculation
    if (isShooting) {
      strAction = "is shooting";
    } else {
      strAction = "is not shooting";
    }

    // 4) Imprimir mensajes en la consola
    System.out.println("The Archmage moves towards " + strDirection + " and " + strAction);

    // Otra forma de imprimir el mensaje
    System.out.println(resultPhraseInit + strDirection + " and " + strAction);

    sc.close();
  }
}

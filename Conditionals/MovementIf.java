package Conditionals;

import java.util.Scanner;

/* 
 * MovementIf
 */

public class MovementIf {
  public static void main(String[] args) {

    // 1) Mensaje de bienvenida
    System.out.println("WELCOME TO THE DUNGEON OF THE ARCHMAGE");
    System.out.println("--------------------------------------");

    // 2) Introducir datos. Solicitar datos al usuario.
    // ------------------------------------------------
    Scanner sc = new Scanner(System.in);

    /* ************ */
    // Seleccionar dirección de movimiento
    System.out.println("Please select a direction of movement:" +
        "(0-left, 1-up, 2-right, 3-down)");

    int direction = sc.nextInt();

    // Caso 1: Dos condiciones IF. Se ejecutan las dos condiciones siempre.
    if (direction < 0) {
      System.out.println("WARNING! You chose a wrong direction");
    }

    if (direction > 3) {
      System.out.println("WARNING! You chose a wrong direction");
    }

    // Caso 2: IF + ELSE IF. Se ejecuta solo la que sea verdad, ignorando el resto
    // de condiciones
    if (direction < 0) {
      System.out.println("WARNING! You chose a wrong direction");
    } else if (direction > 3) {
      System.out.println("WARNING! You chose a wrong direction");
    }

    // Caso 3: Un único IF separado por el operador OR lógico ||
    if (direction < 0 || direction > 3) {
      System.out.println("WARNING! You chose a wrong direction");
    }

    /* ************ */
    // Selecciona si el archimago está disparando o no.
    System.out.println("Please select if the mage is shooting or not:" +
        "(false - not shooting, true - shooting)");
    boolean isShooting = sc.nextBoolean();

    // Caso 1. Mensajes separados por condicion
    if (direction == 0) {
      System.out.println("The Archmage moves towards LEFT");
    }

    if (isShooting == true) {
      System.out.println("The Archmage is shooting");
    }

    // Caso 2: Usando un mismo IF con el operador AND lógico &&
    if (direction == 0 && isShooting == true) {
      System.out.println("The Archmage moves towards LEFT and is shooting");
    }

    // Caso 2B: isShooting puede estar solo en la condición por ser boolean
    if (direction == 0 && isShooting) {
      System.out.println("The Archmage moves towards LEFT and is shooting");
    }

    // Caso 2C: Caso de isShooting false
    // Podemos escribir:
    // if (isShooting == false)
    // if (!isShooting) //Operador de negación lógico

    // CONDITIONS & PRINT MESSAGES
    // -----------------------------------------------

    // Caso A. Todas las condiciones. COMPLEJO
    if (direction == 0 && isShooting) {
      System.out.println("The Archmage moves towards LEFT and is shooting");
    } else if (direction == 0 && !isShooting) {
      System.out.println("The Archmage moves towards LEFT and is not shooting");
    } else if (direction == 1 && isShooting) {
      System.out.println("The Archmage moves towards UP and is shooting");
    } else if (direction == 1 && !isShooting) {
      System.out.println("The Archmage moves towards UP and is not shooting");
    } else if (direction == 2 && isShooting) {
      System.out.println("The Archmage moves towards RIGHT and is shooting");
    } else if (direction == 2 && !isShooting) {
      System.out.println("The Archmage moves towards RIGHT and is not shooting");
    } else if (direction == 3 && isShooting) {
      System.out.println("The Archmage moves towards DOWN and is shooting");
    } else if (direction == 3 && !isShooting) {
      System.out.println("The Archmage moves towards DOWN and is not shooting");
    }

    // Caso B. optimización para más claridad
    if (direction == 0) {
      if (isShooting) {
        System.out.println("The Archmage moves towards LEFT and is shooting");
      } else {
        System.out.println("The Archmage moves towards LEFT and is not shooting");
      }
    } else if (direction == 1) {
      if (isShooting) {
        System.out.println("The Archmage moves towards UP and is shooting");
      } else {
        System.out.println("The Archmage moves towards UP and is not shooting");
      }

    } else if (direction == 2) {
      if (isShooting) {
        System.out.println("The Archmage moves towards RIGHT and is shooting");
      } else {
        System.out.println("The Archmage moves towards RIGHT and is not shooting");
      }
    } else // direction == 3. Al haber verificado previamente los datos correctos puedo
           // asegurarme que es direction == 3
    {
      if (isShooting) {
        System.out.println("The Archmage moves towards DOWN and is shooting");
      } else {
        System.out.println("The Archmage moves towards DOWN and is not shooting");
      }

    }

    sc.close();
  }
}

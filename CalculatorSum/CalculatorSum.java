package CalculatorSum;

import java.util.Scanner;

public class CalculatorSum {
  public static void main(String[] args) {

    // Creamos la variable sc que controla el teclado
    Scanner sc = new Scanner(System.in);

    // Ask for a number
    System.out.println("TYPE A NUMBER");
    int num1 = sc.nextInt();

    // Ask for another number
    System.out.println("TYPE ANOTHER NUMBER");
    int num2 = sc.nextInt();

    // Calculate sum
    int suma = num1 + num2;
    System.out.println(num1 + " + " + num2 + " = " + suma);

    sc.close();
  }
}

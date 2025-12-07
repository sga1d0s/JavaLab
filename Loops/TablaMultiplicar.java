package Loops;

public class TablaMultiplicar {
  public static void main(String[] args) {

    // Tabla
    for (int i = 1; i < 10; i++) {
      // Número
      for (int x = 1; x <= 10; x++) {
        System.out.println(i + " x " + x + " = " + (i * x));
      }
      System.out.println(); // línea en blanco para imitar el formato de ejemplo
    }
  }
}

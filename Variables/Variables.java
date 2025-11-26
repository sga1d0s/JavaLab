package Variables;

public class Variables {
  public static void main(String[] args) {

    // Creación de variable int (entero)
    int age = 123;
    System.out.println("The age is: " + age + " years");

    // Reasignación de variable
    age = 75;
    System.out.println("The new age is: " + age + " years");

    byte numOfBooks = 34;
    System.out.println("There are " + numOfBooks + " books");

    // byte minimumSpeed = -768; // ERROR: La variable byte se sale de rango. Min:
    // -128

    byte minimumSpeed = -100; // OK. Dentro del rango
    System.out.println("The cars's minimum speed is: " + minimumSpeed + " MPH");

    boolean isRaining = true;
    System.out.println("Is it raining? " + isRaining);

    float gravity = 9.81f;
    System.out.println("The gravity on earth is: " + gravity);

    double pi = 3.1415926535;
    System.out.println("The pi constant in double format has a value of: " + pi);

    // Conversión de double a float (casting)
    // Redondea al decimal 7. Perdemos precisión
    float pi2 = (float) 3.1415926535;
    System.out.println("The pi constant in float format has a value of: " + pi2);

    // Definición de constantes. Usamos la palabra final
    final int numAlumnos = 7;

    // numAlumnos = 8; //ERROR: Cannot be reasigned

    final float PI = 3.141592f;
    // PI = 34; // ERROR: No se puede reasignar
    System.out.println("The PI constant has a value of: " + PI);

    // Escribir constantes. All caps and words separated by _
    final int NUM_INGREDIENTS_POTION = 4;

    // Variable sin inicializar
    int lives;

    lives = 5;
    System.out.println("Number of player lives: " + lives);

    // Mejor crear / declarar variable siempre inicializada.
    // Inicializar en valor imposible
    int energy = -1;

    // Variable final sin inicializar
    final float GRAVITY;

    GRAVITY = 9.81f;

    // Reasignación
    // GRAVITY = 1.67f; //ERROR: Cannot be reasigned
    System.out.println("The earth gravity is: " + GRAVITY + " m/s2");

    // STRINGS (cadenas de caracteres)

    // 2 formas de crear

    // 1: Con el operador =, como los tipos primitivos (int, float...)
    String name = "Oscar";
    System.out.println("My name is: " + name);

    // 2: Con el operador 'new'
    String studentName = new String("Carlos");
    System.out.println("The student name is: " + studentName);
  }
}
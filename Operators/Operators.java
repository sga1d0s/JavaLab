package Operators;

public class Operators {
  public static void main(String[] args) {
        
        // Suma y producto de 2 números
        int num1 = 2;
        int num2 = 5;

        int suma = num1 + num2;
        int prod = num1 * num2; 

        System.out.println(num1 + " + " + num2 + " = " + suma);
        System.out.println(num1 + " x " + num2 + " = " + prod);

        // Cake program (SLIDES)
        int numOfCakes = 12;
        int numOfMonsters = 4;
        int numOfCakesPerMonster = numOfCakes / numOfMonsters;
        System.out.println("There are " + numOfCakesPerMonster + " cakes");
        System.out.println("for each monster");

        // División (INTEGERS)
        // num1 = 2
        // num2 = 5
        int division1 = num1 / num2; 
        int division2 = num2 / num1;
        System.out.println("Integer division");
        System.out.println("----------------");
        System.out.println(num1 + " / " + num2 + " = " + division1);
        System.out.println(num2 + " / " + num1 + " = " + division2);
        
        // Division (FLOAT). Creamos los enteros como float
        float num3 = 2.0f;
        float num4 = 5.0f;
        float division3 = num3 / num4; 
        float division4 = num4 / num3;
        System.out.println("\nFloat division");
        System.out.println("--------------");
        System.out.println(num3 + " / " + num4 + " = " + division3);
        System.out.println(num4 + " / " + num3 + " = " + division4);
        
        // Convert Integer variables to float
        // Convertir numerador to float
        int num5 = 4;
        int num6 = 7;
        System.out.println("\nCast numerator to float.");
        System.out.println("-------------------------");
        float division5 = (float)num6 / num5;
        System.out.println(num6 + " / " + num5 + " = " + division5);
        

        // Remainder operator (RESTO: %)
        int remainder = num6 % num5;

        System.out.println(num6 + " % " + num5 + " = " + remainder);

        // Incremento de una variable
        int suma3 = 10;

        // Incrementar la variable suma3 en 5

        // Dos formas

        // Primera forma
        suma3 = suma3 + 5; // suma3 = 15
        System.out.println("Nuevo valor suma3: " + suma3);

        // Segunda forma
        suma3 += 5; // suma3 = 20
        System.out.println("Nuevo valor suma3: " + suma3);

        // Incrementar una variable en 1 unidad
        // 4 formas
        // suma 3 = 20
        suma3 = suma3 + 1; // suma3 = 21
        suma3 += 1; // suma3 = 22
        suma3++; // suma3 = 23
        ++suma3; // suma3 = 24
        
        // OJO con ++variable y variable++
        int var = 10;
        int result1 = ++var;

        var = 10;
        int result2 = var++;

        // El resultado de result1 y result2 no es el mismo
        
        // Podemos asignar una variable a otra
        // var mantiene su valor aunque variemos suma3
        suma3 = 56;
        var = suma3; // var = 56
        suma3++; // suma3 = 57, var = 56
  }
}

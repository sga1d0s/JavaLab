package FunctionsMath;

public class FunctionsMath {
  public static void main(String[] args) {

    float floatNum = 5.78f;

    // Convertir a int
    int intNum = (int) floatNum;
    System.out.println("Float positive number: " + floatNum);
    System.out.println("Float to integer conversion: " + intNum);

    // Redondear hacia abajo usando Math.floor
    double roundedNum = Math.floor(floatNum);
    System.out.println("Rounded down: " + roundedNum);

    // Conversión automática entre tipos
    double dNum2 = (double) floatNum;
    System.out.println("Automatic Conversion to double: " + dNum2);

    // Redondear hacia abajo y convertir a int
    int roundedAndIntConversion = (int) Math.floor(floatNum);
    System.out.println("Rounded down and integer: " + roundedAndIntConversion);

    // Conversión explicita de double a float no válida
    // Pérdida de precisión
    // double num5 = 2.456;
    // float num6 = num5; //ERROR

    // Caso de numeros negativos. Diferencia entre casting a int y Math.floor
    float numNegative = -2.3f;
    int roundedNumNegative = (int) Math.floor(numNegative);
    int iNumNegative = (int) numNegative;

    System.out.println("\nFloat negative number: " + numNegative);
    System.out.println("Float to integer conversion: " + iNumNegative);
    System.out.println("Rounded down: " + roundedNumNegative);

    // Random numbers.
    // Math.random() calcula un número entre [0, 1) (El 1 no está incluido)
    double rndNumber = Math.random();
    System.out.println("Random number between 0 and 1: " + rndNumber);

    // Calcular un número aleatorio entre [0, 8)
    double rndNumber2 = 8 * Math.random();
    System.out.println("Random number between 0 and 8: " + rndNumber2);

    // Constante PI (Math.PI)
    double radius = 3.5;
    double circumferenceLongitude = 2 * Math.PI * radius;
    System.out.println("The longitude is: " + circumferenceLongitude);
  }
}

package FunctionsReference;

public class FunctionsReference {
  public static void main(String[] args) {
    int[] array = { 3, 6, 7, 8, 6 };
    int[] array2 = { 4, -3, 7, 2, 0 };

    System.out.println(array);

    // EJEMPLO 1. Función que recibe un array y devuelve un entero
    // --------------------------------------
    // Calculamos la suma de los elementos de los arrays
    int suma = sumaElementsArray(array);
    int suma2 = sumaElementsArray(array2);

    // Pintamos los elementos de los arrays
    printArrayElements(array, "array");
    printArrayElements(array2, "array2");

    System.out.println("La suma de los elementos es: " + suma);
    System.out.println("La suma de los elementos es: " + suma2);

    // EJEMPLO 2. Función que recibe 2 arrays y devuelve un array
    // Recibimos 2 arrays como parámetro y devolvemos la suma de los arrays
    int[] sumaArrays = sumaArrays(array, array2);

    // Pintamos los elementos del array suma
    if (sumaArrays == null) {
      System.out.println("ERROR: Array dimensions do not match");
    } else {
      printArrayElements(sumaArrays, "sumaArrays");
    }

    // VALUE - REFERENCE
    // Ejemplo: Función que recibe un array y devuelve el array multiplicado por un
    // número

    // CASO 1: Función que devuelve el resultado con un return
    // El array original no cambia
    int[] multArray = multiplyArrayByNumber(array, 3);

    // Pintamos el array original. Vemos que no ha cambiado
    printArrayElements(array, "array");

    // Pintamos el array resultante de la multiplicación
    printArrayElements(multArray, "multArray");

    // CASO 2. Funcion que modifica el array original que pasamos como parámetro
    // No es necesario usar return.
    multiplyArrayByNumberWithoutReturn(array, 4);

    // El array original ha cambiado
    printArrayElements(array, "original array nultiplied by 4");

    // CASO 3. Función que recibe 2 arrays y devuelve los datos en 2 arrays como
    // parámetro

    // Calculamos la suma y resta de 2 arrays y devolvemos:
    // add: array con la suma de los elementos
    // substract: array con la resta de los arrays según el orden indicado por
    // substractFirstMinusSecond

    int[] add = new int[array.length];
    int[] substract = new int[array.length];
    boolean substractFirstMinusSecond = true;

    int retValue = addAndSubstractTwoArrays(array, array2, add, substract, substractFirstMinusSecond);

    if (retValue == -1) {
      System.out.println("ERROR: Array dimensions do not match");
    } else {
      printArrayElements(array, "array");
      printArrayElements(array2, "array2");
      printArrayElements(add, "array + array2");

      if (substractFirstMinusSecond) {
        printArrayElements(substract, "array - array2");
      } else {
        printArrayElements(substract, "array2 - array");
      }
    }
  }

  // Función que recibe un array de int
  // Devuelve la suma de sus elementos
  public static int sumaElementsArray(int[] array) {
    int suma = 0;
    for (int i = 0; i < array.length; ++i) {
      suma += array[i];
    }

    return suma;
  }

  // Función que recibe un array y pinta en consola sus elementos
  public static void printArrayElements(int[] array, String name) {
    System.out.println("\nArray: " + name);
    for (int i = 0; i < array.length; ++i) {
      System.out.println(i + ": " + array[i]);
    }
  }

  /**
   * Función que calcula la suma de 2 arrays
   * // @Params: 2 arrays de entrada
   * // Return value: Array con la suma
   */
  public static int[] sumaArrays(int[] array1, int[] array2) {
    if (array1.length != array2.length) {
      // Si las dimensiones no coinciden devolvemos null
      return null;
    }

    int[] sumaArrays = new int[array1.length];

    for (int i = 0; i < array1.length; ++i) {
      sumaArrays[i] = array1[i] + array2[i];
    }

    return sumaArrays;
  }

  public static int[] multiplyArrayByNumber(int[] array, int num) {
    int[] returnArray = new int[array.length];

    for (int i = 0; i < array.length; ++i) {
      returnArray[i] = array[i] * num;
    }

    return returnArray;
  }

  public static void multiplyArrayByNumberWithoutReturn(int[] array, int num) {
    for (int i = 0; i < array.length; ++i) {
      array[i] = array[i] * num;
    }
  }

  public static int addAndSubstractTwoArrays(int[] array1, int[] array2, int[] add,
      int[] substract, boolean subtractFirstMinusSecond) {

    if (!((array1.length == array2.length) &&
        (array1.length == add.length) &&
        (array1.length == substract.length))) {
      // Error. Las dimensiones no son iguales
      return -1;
    }

    // Otra forma de hacer la condición
    // if (( (array1.length != array2.length) ||
    // (array1.length != add.length) ||
    // (array1.length != substract.length)
    // )
    // )
    // {

    // }

    // Calculamos la suma de los arrays
    for (int i = 0; i < array1.length; ++i) {
      add[i] = array1[i] + array2[i];
    }

    // Calculamos la resta de los arrays

    for (int i = 0; i < array1.length; ++i) {
      if (subtractFirstMinusSecond) {
        substract[i] = array1[i] - array2[i];
      } else {
        substract[i] = array2[i] - array1[i];
      }
    }

    // OK
    return 0;
  }
}

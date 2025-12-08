package PositiveNumber;

public class PositiveNumber {
  public static void main(String[] args) {
    // Números del array
    int[] array = { -3, -6, -7, -4, -9 };

    // Extraemos el número de positivos para saber la dimensión del array final
    int[] arrayPositives = getArrayOfPositives(array);

    printArrayElements(array, "Original array");
    printArrayElements(arrayPositives, "New array. Only positives");
  }

  // Función que recibe un array y pinta en consola sus elementos
  public static void printArrayElements(int[] array, String name) {
    System.out.println("\nArray: " + name);
    for (int i = 0; i < array.length; ++i) {
      System.out.println(i + ": " + array[i]);
    }
  }

  public static int[] getArrayOfPositives(int[] array) {
    int countPositives = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > 0) {
        countPositives++;
      }
    }

    System.out.println("Number of positives: " + countPositives);

    // Creamos array con la dimension countPositives
    int[] arrayPositives = new int[countPositives];

    countPositives = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > 0) {
        arrayPositives[countPositives] = array[i];
        countPositives++;
      }
    }

    return arrayPositives;
  }
}
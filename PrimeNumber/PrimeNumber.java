package PrimeNumber;

public class PrimeNumber {
  public static void main(String[] args) {
    // Condición para saber si un número es primo o no

    // Dado un número calcular si es primo.
    // Vemos si es divisible entre algún número que no sea ni el 1 ni él mismo

    // Dividimos el número entre cualquiera que vaya desde 2 hasta numero - 1

    final int TOTAL_PRIMES = 51;
    int primeCounter = 0;

    int num = 1;

    while (primeCounter < TOTAL_PRIMES) {
      // Calculamos si el número es primo
      boolean isPrimo = calculateIfPrime(num);

      if (isPrimo) {
        System.out.println((primeCounter + 1) + ". The number " + num + " is prime");
        primeCounter++;
      }

      num++;
    }
  }

  public static boolean calculateIfPrime(int num) {
    boolean isPrimo = true;

    for (int i = 2; i < num; ++i) {
      if (num % i == 0) {
        // Al ser divisible entre i, no es primo
        isPrimo = false;
        break;
      }
    }

    return isPrimo;
  }
}

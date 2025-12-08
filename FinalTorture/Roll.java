// Clase Roll: se encarga de ejecutar tiradas de dados a partir de una cadena tipo "2D6+3".
package FinalTorture;

public class Roll {

  // Array con los distintos dados disponibles (6 caras, 12 caras, 10 unidades, 10 decenas, etc.).
  private Die[] dies;
  // Constantes para acceder a posiciones concretas del array de dados (no se usan aún en este código).
  private final static int DIE_6 = 0;
  // Constantes para acceder a posiciones concretas del array de dados (no se usan aún en este código).
  private final static int DIE_12 = 1;
  // Constantes para acceder a posiciones concretas del array de dados (no se usan aún en este código).
  private final static int DIE_10_UNITS = 2;
  // Constantes para acceder a posiciones concretas del array de dados (no se usan aún en este código).
  private final static int DIE_10_TENS = 3;

  // Constructor: recibe el array de dados que se usarán para resolver las tiradas.
  public Roll(Die[] dies) {
    this.dies = dies;
  }

  /**
   * Ejecuta una tirada de dados a partir de una cadena tipo "2D6+3".
   * 
   * @param roll Cadena con la tirada (p.ej. "1D12+4", "2D6-2", etc.).
   * @return Resultado entero de la tirada.
   */
  public int execute(String roll) {
    int rolled = -1;

    // Caso especial: si la tirada es exactamente "1D100" usamos un método específico.
    if (roll.equals("1D100")) {
      return die100Sides();
    }

    // Extraemos número de dados, caras y modificador de la cadena.
    int[] rollArray = extractDataFromRoll(roll);

    // Recorremos los dados disponibles hasta encontrar uno con el número de caras adecuado.
    for (int i = 0; i < dies.length; i++) {
      if (dies[i].getSides() == rollArray[1]) {
        // Si se lanzan varios dados (p.ej. 2D6), sumamos los resultados.
        if (rollArray[0] > 1) {
          for (int j = 0; j < rollArray[0]; j++) {
            rolled += dies[i].roll();
          }
        } else {
          rolled = dies[i].roll();
        }
      }
    }

    // Aplicamos el modificador final (positivo o negativo) si lo hay.
    if (rollArray[2] != 0) {
      rolled += rollArray[2];
    }

    return rolled;
  }

  // Genera una tirada de 1D100 simple (número entre 1 y 100).
  public static int die100Sides() {
    int rolled = (int) (Math.random() * 100) + 1;
    return rolled;
  }

  /**
   * Parsea una tirada tipo "2D6+3" y devuelve un array con:
   * [0] = número de dados, [1] = número de caras, [2] = modificador.
   */
  public static int[] extractDataFromRoll(String roll) {
    // rollArray[0] = nº de dados, rollArray[1] = nº de caras, rollArray[2] = modificador (+/-).
    int[] rollArray = new int[3];

    // Separamos la parte del número de dados y la parte de las caras + modificador.
    String[] splitRoll = roll.split("D");

    // die
    rollArray[0] = Integer.parseInt(splitRoll[0]);

    // Separamos el número de caras del posible modificador (+X o -X).
    String[] splitToSign = splitRoll[1].split("[+-]");

    // sides
    rollArray[1] = Integer.parseInt(splitToSign[0]);

    // Si hay modificador, lo parseamos; si no, se queda a 0 por defecto.
    if (splitToSign.length == 2) {
      // modifier
      rollArray[2] = Integer.parseInt(splitToSign[1]);
    }

    return rollArray;
  }
}

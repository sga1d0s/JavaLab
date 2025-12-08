// Clase Die: representa un dado genérico, con opción a funcionar en unidades o decenas (para 1D100).
package FinalTorture;

public class Die {

  // Array con los valores posibles del dado (cada cara).
  private int[] values;
  // Número de caras del dado.
  private int sides;
  // Indica si este dado es de "decenas" (0, 10, 20, ..., 90) para construir tiradas de 1D100.
  private boolean tens;

  /**
   * Constructor del dado.
   * 
   * @param sides número de caras del dado.
   * @param tens  true si el dado representa decenas (0,10,20,...), false en caso contrario.
   */
  public Die(int sides, boolean tens) {
    values = new int[sides];
    this.sides = sides;
    this.tens = tens;

    // Rellenamos el array de valores según el tipo de dado.
    for (int i = 0; i < sides; i++) {
      if (tens) {
        // Caso dado de decenas: la primera cara vale 0 y el resto 10, 20, 30, ...
        if (i == 0) {
          values[i] = 00;
        } else {
          values[i] = i * 10;
        }
      } else {
        // Si es un dado de 10 caras "normal", sus valores serán 0..9 (para las unidades del 1D100).
        if (sides == 10) {
          values[i] = i;
        } else{
          // Para otros dados (p.ej. 6 o 12 caras), sus valores serán 1..sides.
          values[i] = i + 1;
        }
      }
    }
  }

  /**
   * Realiza una tirada del dado y devuelve uno de los valores posibles al azar.
   */
  public int roll(){
    // Calculamos una posición aleatoria dentro del array de caras.
    int randomPosition = (int) (Math.random() * values.length);
    int result = values[randomPosition];
    return result;
  }

  // Devuelve el array de valores del dado (todas las caras posibles).
  public int[] getValues(){
    return values;
  }

  // Devuelve el número de caras del dado.
  public int getSides() {
    return sides;
  }

  // Indica si el dado es de decenas (se usa para construir tiradas de 1D100).
  public boolean isTens() {
    return tens;
  }
}

package LordOfTheWines2;

public class Die {

  // atributo. Array con los valores de los dados
  private int[] values;

  // constructor. Parametro name String
  public Die(String name) {
    // si usanmos dado 'Hieratic'
    if (name.equals("Hieratic")) {
      int[] values = { 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5 };
      this.values = values;
    }
    // si iusamos dado 'Gracefull'
    else if (name.equals("Graceful")) {
      int[] values = { 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8 };
      this.values = values;
    } else {
      int[] values = { 1, 2, 3, 4, 5, 6 };
      this.values = values;
    }
  }

  // método roll(). Simula la tirada de dados
  public int roll() {
    return values[(int) (Math.random() * values.length)];
  }
}

package LordOfTheWines2;

public class Wine {
  // atributos
  private String name;
  private int points;
  private String poisonTime;
  private double effectTime;

  // constructor
  public Wine(String name, int points, String poisonTime, double effectTime) {
    // añadimos los parametros al objeto
    this.name = name;
    this.points = points;
    this.poisonTime = poisonTime;
    this.effectTime = effectTime;
  }

  // método isPoison() devuelve bool si está envenenado o no
  public boolean isPoison(Time time) {
    boolean isPoison = true;

    return isPoison;
  }

  public String name() {
    return this.name;
  }

  public String poisonTime() {
    return this.poisonTime;
  }

  public int points() {
    return this.points;
  }

  public double effectTime() {
    return this.effectTime;
  }

  public int getPoints() {
    return points;
  }
}

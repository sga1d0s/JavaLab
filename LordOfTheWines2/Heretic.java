package LordOfTheWines2;

public class Heretic {
  // atributos
  String name;
  int level;
  int age;
  int stamina;
  Die[] dies;
  Wine[] bottles;
  Time goldenWatch;

  // constructor
  public Heretic(String name, int age, Die[] dies, Wine[] bottles, Time goldenWatch) {
    // caso inválido
    if (name == null || name.isEmpty() || age < 16 ||
        dies == null || bottles == null || goldenWatch == null) {

      this.name = "";
      this.age = -1;
      this.level = -1;
      this.stamina = -1;

      this.dies = null;
      this.bottles = null;
      this.goldenWatch = null;

      return; // finaliza el constructor
    }

    // caso válido
    this.name = name;
    this.age = age;
    this.dies = dies;
    this.bottles = bottles;
    this.goldenWatch = goldenWatch;

    // calculamos level y stamina
    this.level = (age - 16) / 3 + 1;
    this.stamina = 12 * level;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public int getAge() {
    return age;
  }

  public int getStamina() {
    return stamina;
  }

  public String getBottleNames() {
    String bottleNames = "";

    for (int i = 0; i < bottles.length; i++) {
      if (i != bottles.length - 1) {
        bottleNames += ", ";
      }
    }

    return bottleNames;
  }

  public void drink() {
    // mostrar día, hora y díaHora
    System.out.println(goldenWatch.getTime());
    System.out.println(goldenWatch.getTimeDay());
    System.out.println("------------------------");

    // tomamoa un vino al azar
    Wine randomWine = bottles[(int) (Math.random() * bottles.length)];

    // si efecto positivo
    boolean isPoison = randomWine.isPoison(goldenWatch);

    // Calculamos tP (total Points)
    int tP;
    int rollHieratic = dies[1].roll();
    int rollGraceful1 = dies[0].roll();
    int rollGraceful2 = dies[0].roll();
    int totalRollGraceful = rollGraceful1 + rollGraceful2;

    // aplicar efectos
    if (isPoison) {
      tP = rollHieratic + randomWine.getPoints();
      stamina -= tP;
      System.out.println(name + " the Heretic drinks " + randomWine.getName() + ", rolls the Heretic Die and gets a " + rollHieratic);
    }

    // esperar el tiempo necesario para beber sl siguiente

    // sacar mensaje en consola

  }

  private void waitForTime(float hours) {

  }
}

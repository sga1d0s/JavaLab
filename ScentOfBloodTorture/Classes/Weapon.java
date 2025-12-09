package ScentOfBloodTorture.Classes;

public class Weapon {
  // atributos
  private String name;
  private int points;
  private String type;
  private int durability;
  // private String weapon;

  // constructor 1
  public Weapon(String name, int points, String type) {
    this.name = name;
    this.points = points;
    this.type = type;
    this.durability = 100;
  }

  // constructor 1
  public Weapon(String weapon) {
    String[] weaponData = weapon.split(", ");
    String[] pointsData = weaponData[2].split(" pts");

    this.name = weaponData[0];
    this.type = weaponData[1];
    this.points = Integer.parseInt(pointsData[0]);
    this.durability = 100;
  }

  

}

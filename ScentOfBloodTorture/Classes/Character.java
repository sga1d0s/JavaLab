package ScentOfBloodTorture.Classes;

public class Character {
  // atributos
  private String name;
  private String occupation;
  private int gold;
  private int level;
  private int brawl;
  private int melee;
  private int missile;
  private Weapon weapon;

  // constructor por defecto
  public Character() {
    this.name = "Basilio";
    this.occupation = "coock";
    this.gold = 1;
    this.level = 1;
    this.brawl = 1;
    this.melee = 1;
    this.missile = 1;
    this.weapon = null;
  }

  // constructor con argumentos
  public Character(
      String name,
      String occupation,
      int gold,
      int level,
      int brawl,
      int melee,
      int missile,
      Weapon weapon) {
    this.name = name;
    this.occupation = occupation;
    this.gold = gold;
    this.level = level;
    this.brawl = brawl;
    this.melee = melee;
    this.missile = missile;
    this.weapon = weapon;
  }

  public static void throwWeapon(){
    
  }

}

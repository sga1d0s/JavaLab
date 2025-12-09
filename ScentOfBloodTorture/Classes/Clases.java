package ScentOfBloodTorture.Classes;

public class Clases {
  public static void main(String[] args) {
    // get weapons
    String[] weaponsData = CharactersData.weapons;
    Weapon[] weapons = { null, null, null, null, null };

    // crear armas
    for (int i = 0; i < weaponsData.length; i++) {
      String weapon = weaponsData[i];
      weapons[i] = new Weapon(weapon);
    }

  }
}

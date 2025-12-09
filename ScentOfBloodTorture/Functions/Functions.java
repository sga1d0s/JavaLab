package ScentOfBloodTorture.Functions;

public class Functions {
  public static void main(String[] args) {
    // get character weapon
    String[] charactersWeapons = CharactersData.weapons;
    String[] charactersNames = CharactersData.names;
    int[] characterslevels = CharactersData.levels;
    String weapon = charactersWeapons[4];

    // 1st EXERCISE
    // System.out.println(getWeaponAttributes(weapon));
    // System.out.println();

    // 2nd EXERCISE
    // System.out.println("Weapon List");
    // System.out.println("-----------");
    // printWeaponData(charactersWeapons);
    // System.out.println();

    // 3rd EXERCISE
    // System.out.println(getWeaponPoints(weapon));
    // System.out.println();

    // 4th EXERCISE
    // System.out.println("Weapon List with bonus +");
    // System.out.println("------------------------");
    // printWeaponsWithPositiveBonus(charactersWeapons);

    // 5th EXERCISE
    System.out.println("Characters with level");
    System.out.println("---------------------");
    String names = getCharactersAboveRandomLevel(charactersNames, characterslevels);
    System.out.println(names);

  }

  public static String getWeaponAttributes(String weapon) {
    String weaponData = "";
    String[] weaponValue = weapon.split(", ");
    String[] weaponInfo = {
        "Name: ",
        " - Type: ",
        " - Bonus damage: ",
    };

    for (int i = 0; i < weaponValue.length; i++) {
      weaponData += weaponInfo[i] + weaponValue[i];
    }

    return weaponData;
  }

  public static void printWeaponData(String[] weapons) {
    String[] weaponsDetail;
    String[] weaponInfo = {
        "Name: ",
        " - Type: ",
        " - Bonus damage: ",
    };
    String weaponData = "";

    for (int i = 0; i < weapons.length; i++) {
      // weaponsDetail += weaponInfo[i] + weapons[i] + "\n";
      String value = weapons[i] + "\n";
      weaponsDetail = value.split(", ");

      for (int j = 0; j < weaponsDetail.length; j++) {
        weaponData += weaponInfo[j] + weaponsDetail[j];
      }
      System.out.println();
    }
    System.out.println(weaponData);
  }

  public static int getWeaponPoints(String weapon) {
    int weaponPoints = -1;
    String[] weaponData = weapon.split(", ");
    String data = weaponData[2];

    String[] dataSplit = data.split(" pts");

    weaponPoints = Integer.parseInt(dataSplit[0]);

    return weaponPoints;
  }

  public static void printWeaponsWithPositiveBonus(String[] weapons) {
    String weaponPoints = "";
    String weaponName = "";

    for (int i = 0; i < weapons.length; i++) {
      String[] weapon = weapons[i].split(", ");
      for (int j = 0; j < weapon.length; j++) {
        weaponPoints = weapon[j];
        weaponName = weapon[0] + ": ";
      }
      System.out.println(weaponName + weaponPoints);
    }
  }

  public static String getCharactersAboveRandomLevel(String[] characters, int[] levels) {
    String names = "";
    String name = "";
    int[] die = { 1, 2, 3, 4, 5, 6, 7, 8 };

    int level = -1;
    int value = (int) (Math.random() * die.length) + 1;
    // System.out.println(value);

    for (int j = 0; j < levels.length; j++) {
      name = characters[j];
      level = levels[j];
      if (level >= value) {
        names += name + "\n";
      }
    }
    return names;
  }

}

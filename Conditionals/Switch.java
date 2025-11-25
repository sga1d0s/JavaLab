package Conditionals;

public class Switch {
  public static void main(String[] args) {

    int level = 6;

    String category = null;

    switch (level) {
      case 5:
        category = "Arch";
        break;

      case 4:
        category = "Expert";
        break;

      case 3:
        category = "Skillful";
        break;

      case 2:
        category = "Apprentice";
        break;

      case 1:
        category = "Novice";
        break;

      default: // else
        category = "The category does not exist";
    }

    if (level > 0) {
      System.out.println("Yuri is a " + category + " mage");
    } else {
      System.out.println(category);
    }
  }
}

package LordOfTheWines2;

public class LordOfTheWines {
  public static void main(String[] args) {
    Die dH = new Die("Hieratic");
    Die dG = new Die("Graceful");

    /* ARRAY DE DADOS */
    Die[] dies = { dG, dH };

    System.out.println("Hieratic Die");
    System.out.println("------------");

    rollDieNTimes(dH, 20);

    System.out.println("Graceful Die");
    System.out.println("------------");

    rollDieNTimes(dG, 20);

    Time test = new Time(35, 12, 2);

    // test array de dados
    System.out.println(test.getTime());
    System.out.println(test.passBy(75));
    System.out.println(test.getTime());
    System.out.println(test.getTimeDay());

    /* ARRAY DE VINOW */
    Wine[] wines = {
        new Wine("Opprobrium", 5, "Dusk", 7),
        new Wine("Adventus", 7, "Afternoon", 2),
        new Wine("Chrysalis", 3, "Morning", 3),
        new Wine("Red Wine", 9, "Dawn", 5.5),
    };

    // test array de vinos
    System.out.println();
    System.out.println("Wine List");
    System.out.println("---------");

    for (int i = 0; i < wines.length; i++) {
      System.out.println("Name: " + wines[i].name());
      System.out.println("Points: " + wines[i].points());
      System.out.println("Poison Time: " + wines[i].poisonTime());
      System.out.println("Effect Time: " + wines[i].effectTime());
      System.out.println();
    }

    

  }

  // crear funcion roll para simular las tiradas
  public static void rollDieNTimes(Die die, int n) {
    for (int i = 0; i < n; i++) {
      int value = die.roll();
      System.out.println(value);
    }
  }
}

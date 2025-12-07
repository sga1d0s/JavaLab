// Vamos a simular una tirada de dados de un RPG de mesa. 
// Las tiradas de dados tendrán  la forma siguiente: 

// NDX + M

// siendo: 

// N: Número de dados (1-9) (1 cifra)
// X: Número de caras de un dado (4, 6, 8, 10, 12 o 20)
// M: Modificador(opcional). Puede ir desde -9 a +9. (1 cifra)

package DiceRoll;

public class DiceRoll {
  public static void main(String[] args) {
    // Min: 9
    // Max: 24
    String strRoll = "3D12 - 6";

    System.out.println(strRoll);

    for (int i = 0; i < 100; ++i) {
      int roll = dieRoll(strRoll);
      System.out.println("Roll: " + roll);
    }
  }

  public static int dieRoll(String roll) {
    int rollValue = -1;

    // Fase 1. Extraer elementos N, X e M del string NDX + M
    String rollWithoutSpaces = roll.replaceAll(" ", "");

    // Extraemos la N
    int positionD = rollWithoutSpaces.indexOf("D");
    int numberDies = Integer.parseInt(rollWithoutSpaces.substring(0, positionD));

    // Vemos si hay modificador
    boolean isModifierPlus = rollWithoutSpaces.indexOf("+") != -1;
    boolean isModifierMinus = rollWithoutSpaces.indexOf("-") != -1;

    int positionModifier = -1;
    if (isModifierPlus) {
      positionModifier = rollWithoutSpaces.indexOf("+");
    } else if (isModifierMinus) {
      positionModifier = rollWithoutSpaces.indexOf("-");
    }

    // Extraemos la X: Número de caras del dado
    int dieFaces = -1;

    if (isModifierPlus || isModifierMinus) {
      dieFaces = Integer.parseInt(rollWithoutSpaces.substring(positionD + 1, positionModifier));
    } else {
      dieFaces = Integer.parseInt(rollWithoutSpaces.substring(positionD + 1));
    }

    // M: Modificador
    int modifier;

    if (isModifierPlus) {
      modifier = +Integer.parseInt(rollWithoutSpaces.substring(positionModifier + 1));
    } else if (isModifierMinus) {
      modifier = -Integer.parseInt(rollWithoutSpaces.substring(positionModifier + 1));
    } else {
      modifier = 0;
    }

    // Calculamos el valor de la tirada
    rollValue = calculateRoll(numberDies, dieFaces, modifier);

    return rollValue;
  }

  public static int calculateRoll(int numDies, int numFaces, int modifier) {
    int totalRoll = 0;
    
    for (int i = 0; i < numDies; ++i) {
      // Calculamos la tirada de 1 dado
      int dieRoll = dieRoll(numFaces);
      totalRoll += dieRoll;
    }

    totalRoll += modifier;

    return Math.max(1, totalRoll);
  }

  public static int dieRoll(int numFaces) {
    return (int) Math.floor(Math.random() * numFaces + 1);
  }
}

package SlotMachine;

import java.util.Scanner;

public class SlotMachine {
  public static void main(String[] args) {
    char[] symbols = { '♥', '♠', '♣', '♦' };

    wait(1000);

    System.out.println("SLOT MACHINE SIMULATOR");
    System.out.println("----------------------");
    System.out.println("PRESS s KEY TO START");

    Scanner sc = new Scanner(System.in);

    boolean isStart = false;

    while (!isStart) {
      String startKey = sc.next();
      isStart = startKey.equals("s");
    }

    System.out.println();
    System.out.println("Insert number of credits (1-10)");

    int numCredits = -1;
    while (numCredits < 1 || numCredits > 10) {
      numCredits = sc.nextInt();
    }

    System.out.println("Ready?");
    wait(1000);

    System.out.println("GO!");

    int gameOverState = 0;

    int round = 1;
    char[] currentRoll = new char[4];

    int prize = 0;

    while (gameOverState == 0) {
      int wheelSelected = 0;

      System.out.println("Round: " + round);
      System.out.println("----------");

      // Seleccionar rueda si no estamos en la primera ronda.
      if (round > 1) {
        System.out.println("Press (1-4) to select wheel or 0 to select none");
        wheelSelected = sc.nextInt();
      }

      // Jugar la siguiente ronda
      playRound(currentRoll, wheelSelected, symbols);

      // Comprobar si hay premio
      prize = checkPrizeAndReturn(currentRoll);
      System.out.println("\nNumber of credits: " + numCredits);

      // Actualizar contador de rondas
      round = updateRound(round);

      // Comprueba si el juego ha terminado y cómo ha terminado.
      gameOverState = checkIfGameFinished(numCredits, prize);
    }

    wait(1000);

    // Juego terminado. Imprimir mensaje final
    printGameOverState(gameOverState, prize);
  }

  public static int checkPrizeAndReturn(char[] currentRoll) {
    final int FOUR_DIAMONDS = 0;
    final int FOUR_EQUAL = 1;
    final int THREE_EQUAL_BESIDE = 2;
    final int THREE_EQUAL_NOT_BESIDE = 3;

    // currentRoll[0] = '♣';
    // currentRoll[1] = '♦';
    // currentRoll[2] = '♣';
    // currentRoll[3] = '♣';

    String[] rollPrized = {
        "♦♦♦♦", "♠♠♠♠", "♣♣♣♣", "♥♥♥♥",
        "♦♦♦", "♥♥♥", "♠♠♠", "♣♣♣",
        "♥♥-♥", "♦♦-♦", "♠♠-♠", "♣♣-♣" };
    int[] prizes = { 1000, 500, 500, 500, 500, 500, 500, 500, 200, 200, 200, 200 };

    String strRoll = new String(currentRoll);

    int prize = 0;

    // Miramos si hay 4 iguales
    for (int i = 0; i < THREE_EQUAL_BESIDE; i++) {
      if (rollPrized[i].equals(strRoll)) {
        prize = prizes[i];
        return prize;
      }
    }

    // Miramos si hay 3 iguales seguidos
    for (int i = THREE_EQUAL_BESIDE; i < THREE_EQUAL_NOT_BESIDE; ++i) {
      if (strRoll.indexOf(rollPrized[i]) != -1) {
        prize = prizes[i];
        return prize;
      }
    }

    // Miramos si 3 iguales no seguidos
    for (int i = THREE_EQUAL_NOT_BESIDE; i < rollPrized.length; ++i) {
      String[] prizeParts = rollPrized[i].split("-");

      int indexTwoFigures = strRoll.indexOf(prizeParts[0]);

      // Vemos si hay 2 figuras seguidas
      if (indexTwoFigures != -1) {
        // Las quitamos de la tirada
        String subRoll = strRoll.replaceAll(prizeParts[0], "");

        // Comprobamos si en la cadena queda una figura
        int indexOneFigure = subRoll.indexOf(prizeParts[1]);

        if (indexOneFigure != -1) {
          prize = prizes[i];
          return prize;
        }
      }

    }

    return prize;
  }

  public static boolean areFourDiamonds(char[] currentRoll) {
    final char DIAMOND = '♦';

    boolean areFourDiamonds = true;
    for (int i = 0; i < currentRoll.length; ++i) {
      if (currentRoll[i] != DIAMOND)
        areFourDiamonds = false;
    }

    return areFourDiamonds;
  }

  public static void printGameOverState(int gameState, int prize) {

    if (gameState == 1) {
      System.out.println("GAME OVER!");
    } else // if (gameState == 2)
    {
      System.out.println("YOU WON " + prize + " SILVER CROWNS!!!");
    }
  }

  public static int updateRound(int round) {
    return ++round;
  }

  public static int checkIfGameFinished(int numCredits, int prize) {
    int gameState = 0;

    if (numCredits <= 0) {
      gameState = 1;
    } else if (prize > 0) {
      gameState = 2;
    }

    return gameState;
  }

  public static int updateCreditCount(int credits) {
    return --credits;
  }

  public static void playRound(char[] currentRoll, int wheelSelected, char[] symbols) {
    final int NUM_ROLLS = 10; // milliseconds
    int roll = 0;

    while (roll < NUM_ROLLS) {
      // Generate random roll
      updateRoll(currentRoll, wheelSelected, symbols);

      // Print roll
      printRoll(currentRoll);

      // Increase roll counter
      roll++;

      wait(500);

    }
  }

  public static void updateRoll(char[] currentRoll, int wheelSelected, char[] symbols) {
    for (int i = 0; i < currentRoll.length; ++i) {
      if (wheelSelected != i + 1) {
        currentRoll[i] = symbols[(int) (Math.floor(Math.random() * symbols.length))];
      }
    }
  }

  public static void printRoll(char[] roll) {
    String printLine = "";

    final char HEART = '♥';
    final char SPADE = '♠';
    final char CLUB = '♣';
    final char DIAMOND = '♦';

    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";

    for (int i = 0; i < roll.length; i++) {
      char symbol = roll[i];
      String colorSymbol = "";

      switch (symbol) {
        case HEART:
          colorSymbol = ANSI_RED + symbol;
          break;
        case SPADE:
          colorSymbol = ANSI_GREEN + symbol;
          break;
        case CLUB:
          colorSymbol = ANSI_YELLOW + symbol;
          break;
        case DIAMOND:
          colorSymbol = ANSI_BLUE + symbol;
          break;
      }

      printLine += colorSymbol;
    }

    System.out.print("\r" + printLine);
  }

  public static void wait(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}

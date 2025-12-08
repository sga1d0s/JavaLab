// Clase Combat: se encarga de gestionar un combate entre dos luchadores por turnos.
package FinalTorture;

public class Combat {

  // Atacante y defensor actuales en cada turno.
  Fighter attacker;
  Fighter defender;

  // Constructor: recibe los dos luchadores que participarán en el combate.
  public Combat(Fighter attacker, Fighter defender) {
    this.attacker = attacker;
    this.defender = defender;
  }

  /**
   * Ejecuta el combate por turnos hasta que alguno de los luchadores se queda sin puntos de vida.
   */
  public void execute() {
    // Bucle principal del combate: se repetirá hasta que haya un ganador.
    while (true) {
      // Copiamos las referencias para no perder quién es atacante y defensor en este turno.
      Fighter tmpAttacker = attacker;
      Fighter tmpDefender = defender;

      // El atacante realiza un ataque sobre el defensor.
      tmpAttacker.attack(tmpDefender);

      int hpAttacker = tmpAttacker.getHp();
      int hpDefender = tmpDefender.getHp();

      // Evitamos mostrar puntos de vida negativos por pantalla.
      if (tmpAttacker.getHp() < 0) {
        hpAttacker = 0;
      }

      if (tmpDefender.getHp() < 0) {
        hpDefender = 0;
      }

      // Mostramos el estado de puntos de vida de cada luchador tras el ataque.
      System.out.println(tmpAttacker.getName() + ". HP: " + hpAttacker);
      System.out.println(tmpDefender.getName() + ". HP: " + hpDefender);

      System.out.println("--------------------------------");

      // Comprobamos si alguno de los luchadores ha caído a 0 o menos puntos de vida.
      if (tmpAttacker.getHp() <= 0 || tmpDefender.getHp() <= 0) {
        // Declaramos ganador al atacante del turno en el que termina el combate.
        System.out.println("The Combat is over");
        System.out.println("The winner is " + tmpAttacker.getName());
        break;
      }

      // Preparamos el siguiente turno: el defensor pasa a ser atacante y viceversa.
      System.out.println("Turn to: " + tmpDefender.getName());

      // Intercambiamos los papeles de atacante y defensor para el siguiente ciclo del bucle.
      attacker = tmpDefender;
      defender = tmpAttacker;
    }
  }
}
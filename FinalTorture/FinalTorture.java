// Clase FinalTorture: punto de entrada del programa, monta el escenario y lanza el combate.
package FinalTorture;

public class FinalTorture {
  /**
   * Método main: crea los dados, las armas, los luchadores y ejecuta un combate.
   */
  public static void main(String[] args) {

    // Creamos los distintos dados necesarios para el juego.
    Die die6sides = new Die(6, false);
    Die die12sides = new Die(12, false);
    Die die10sidesUnit = new Die(10, false);
    Die die10sidesTens = new Die(10, true);

    // Bloque de pruebas comentado: se usó para comprobar que los dados funcionaban correctamente.
    /*
     * System.out.println("6 sided die");
     * System.out.println("-----------");
     * 
     * for (int i = 0; i < 20; i++) {
     * System.out.println(die6sides.roll());
     * }
     * 
     * System.out.println("12 sided die");
     * System.out.println("------------");
     * 
     * for (int i = 0; i < 20; i++) {
     * System.out.println(die12sides.roll());
     * }
     * 
     * System.out.println("10 sided die (units)");
     * System.out.println("--------------------");
     * 
     * for (int i = 0; i < 20; i++) {
     * System.out.println(die10sidesUnits.roll());
     * }
     * 
     * System.out.println("10 sided die (tens)");
     * System.out.println("-------------------");
     * 
     * for (int i = 0; i < 20; i++) {
     * System.out.println(die10sidesTens.roll());
     * }
     */

    // Array con todos los dados que usará la clase Roll para resolver tiradas.
    Die[] dies = { die6sides, die12sides, die10sidesUnit, die10sidesTens };

    // Objeto Roll que se apoyará en estos dados.
    Roll roll = new Roll(dies);

    // Bloque de pruebas comentado: ejemplo de varias tiradas con la clase Roll.
    /*
     * String rollString = "1D12+4";
     * 
     * System.out.println("Roll " + rollString);
     * System.out.println("-------------------");
     * 
     * for (int i = 0; i < 20; i++) {
     * int rolled = roll.execute(rollString);
     * System.out.println(rolled);
     * }
     */

    // Creamos varias armas con diferentes tiradas de daño.
    Weapon goldenHack = new Weapon("Golden Hack", "1D12+3");
    Weapon wandOfRetrospective = new Weapon("Wand of Retrospective", "2D6-2");
    Weapon redeeemerOfSouls = new Weapon("Redeemer of souls", "4D6");
    Weapon bleedingScythe = new Weapon("Bleeding Scythe", "1D10-2");

    Weapon[] weapons = { goldenHack, wandOfRetrospective, redeeemerOfSouls, bleedingScythe };

    // Creamos los luchadores (fighters) y les asignamos sus armas.
    Fighter zagys = new Fighter("Zagys", 28, roll);
    zagys.setWeapon(goldenHack);

    Fighter Kriussy = new Fighter("Kriussy", 33, roll);
    Kriussy.setWeapon(wandOfRetrospective);

    // Mostramos por consola los atributos de cada luchador antes del combate.
    System.out.println("Fighter 1 attributes");
    System.out.println("------------------");
    zagys.showAttributes();
    System.out.println("------------------");
    System.out.println("Fighter 2 attributes");
    System.out.println("------------------");
    Kriussy.showAttributes();
    System.out.println("------------------");

    // Creamos el combate entre los dos luchadores y lo ejecutamos.
    Combat combat = new Combat(zagys, Kriussy);

    combat.execute();
  }
}

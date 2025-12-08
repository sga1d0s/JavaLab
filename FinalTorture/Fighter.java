// Clase Fighter: representa a un luchador con nivel, vida, arma activa y capacidad de combate.
package FinalTorture;

public class Fighter {

  // Atributos básicos del luchador.
  private String name;
  private int level;
  private int age;
  private int combat;
  // Objeto Roll que se usará para realizar las tiradas del combate.
  private Roll roll;
  // Arma actualmente equipada por el luchador.
  private Weapon activeWeapon;
  // Puntos de vida (hit points) del luchador.
  private int hp;

  /**
   * Constructor del luchador.
   * Valida edad, nombre y objeto Roll. Calcula nivel, habilidad de combate y puntos de vida.
   */
  public Fighter(String name, int age, Roll roll) {
    // Validación básica: si los datos no son correctos, se marca el objeto como no válido.
    if (age < 15 || name.equals("") || name.equals(" ") || roll == null) {
      this.name = "";
      this.level = -1;
      this.age = -1;
      combat = -1;
      this.roll = null;
      activeWeapon = null;
      return;
    }
    this.name = name;
    this.age = age;
    this.roll = roll;
    // El nivel aumenta con la edad: a partir de 15 años, cada 2 años subes un nivel.
    level = 1 + (age - 15) / 2;

    // Cálculo de la habilidad de combate en función del nivel.
    if (level <= 7) {
      // Para niveles de 1 a 7, la habilidad de combate crece linealmente.
      combat = 10 * level;
    } else {
      // A partir de cierto nivel la habilidad deja de aumentar y puede incluso bajar, con un mínimo.
      combat = 70 - 10 * (level - 7);
      // Nos aseguramos de que la habilidad de combate no baje de 20.
      if (combat < 20) {
        combat = 20;
      }
    }

    // Los puntos de vida son 10 por nivel.
    hp = level * 10;
    activeWeapon = null;
  }

  /**
   * Realiza un ataque contra otro luchador.
   * Primero se hace una tirada de 1D100 para ver si impacta y, si tiene éxito,
   * se calcula el daño usando el arma activa.
   */
  public void attack(Fighter defender) {
    // Tirada de ataque: un dado de 100 caras.
    int rolledDie100Sides = roll.execute("1D100");

    // Si el resultado es mayor o igual que la habilidad de combate, el ataque tiene éxito.
    if (combat <= rolledDie100Sides) {
      System.out.println("Fighter " + name + " rolls a " + rolledDie100Sides + " and successfully attacks");

      // Calculamos el daño usando la tirada asociada al arma (por ejemplo "1D12+3").
      int damage = roll.execute(activeWeapon.getDamage());

      System.out.println(
          "Fighter " + name
              + " use a " + activeWeapon.getName()
              + " (" + activeWeapon.getDamage() + ") "
              + "and deals " + damage + " points of damage");

      defender.hp -= damage;
    } 
    // Si la tirada es menor que la habilidad de combate, el ataque falla.
    else {
      System.out.println("Fighter " + name + " rolls a " + rolledDie100Sides + " and does not attack successfully");
    }
  }

  // Muestra los atributos principales del luchador por consola.
  public void showAttributes() {
    System.out.println("Name: " + name);
    System.out.println("Level: " + level);
    System.out.println("Age: " + age);
    System.out.println("Combat: " + combat);
    System.out.println("Weapon: " + activeWeapon.getName());
  }

  // Asigna un arma activa al luchador.
  public void setWeapon(Weapon weapon) {
    activeWeapon = weapon;
  }

  // Getter correspondiente.
  public String getName() {
    return name;
  }

  // Getter correspondiente.
  public int getLevel() {
    return level;
  }

  // Getter correspondiente.
  public int getAge() {
    return age;
  }

  // Getter correspondiente.
  public Roll getRoll() {
    return roll;
  }

  // Getter correspondiente.
  public int getCombat() {
    return combat;
  }

  // Getter correspondiente.
  public Weapon getActiveWeapon() {
    return activeWeapon;
  }

  // Getter correspondiente.
  public int getHp() {
    return hp;
  }
}

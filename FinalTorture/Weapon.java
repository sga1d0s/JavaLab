// Clase Weapon: representa un arma con nombre y daño expresado como tirada (por ejemplo "1D12+3").
package FinalTorture;

public class Weapon {
  
  // Nombre del arma.
  private String name;
  // Cadena que representa el daño que hace el arma (tirada de dados, p.ej. "2D6-2").
  private String damage;

  // Constructor: inicializa el nombre y la tirada de daño del arma.
  public Weapon(String name, String damage){
    this.name = name;
    this.damage = damage;
  }

  // Devuelve el nombre del arma.
  public String getName(){
    return name;
  }

  // Devuelve la tirada de daño del arma.
  public String getDamage() {
    return damage;
  }
}

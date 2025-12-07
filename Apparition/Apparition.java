package Apparition;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Scanner;

public class Apparition {
    public static void main(String[] args) throws IOException {

        // Creación de personajes
        Path fileHeroe = Path.of("./Apparition/heroe.txt");
        String heroeData = Files.readString(fileHeroe);

        Path fileVillain = Path.of("./Apparition/villain.txt");
        String villainData = Files.readString(fileVillain);

        // Extraemos datos de los personajes
        String[] heroe = heroeData.split(",");
        String[] villain = villainData.split(",");

        String[] names = { heroe[0], villain[0] };
        String[] occupations = { heroe[1], villain[1] };
        int[] strengths = { Integer.parseInt(heroe[2]), Integer.parseInt(villain[2]) };
        int[] armors = { Integer.parseInt(heroe[3]), Integer.parseInt(villain[3]) };
        int[] speeds = { Integer.parseInt(heroe[4]), Integer.parseInt(villain[4]) };

        int[] attacks = new int[2];

        for (int i = 0; i < attacks.length; ++i) {
            int attack = (strengths[i] - armors[i] + speeds[i] * 2) * 5;
            if (attack < 10) {
                attack = 10;
            } else if (attack > 100) {
                attack = 100;
            }
            attacks[i] = attack;
        }

        // Creación de escenarios
        Path fileLevels = Path.of("./Apparition/levels.txt");
        String levelData = Files.readString(fileLevels);
        String[] levels = levelData.split(",");

        // Escenario de comienzo
        String level = levels[rollDice(levels.length) - 1];
        // OTRA FORMA: String level = levels[(int)Math.random()*levels.length];

        System.out.println("Welcome to " + level + "!!!");

        // Muestra de atributos
        for (int i = 0; i < names.length; ++i)
            showCharacter(names[i], occupations[i], strengths[i], armors[i], speeds[i], attacks[i]);

        // FALTA: Press s to start

        // Comienzo de combate
        initCombat(names, occupations, strengths, armors, speeds, attacks);

    }

    public static int rollDice(int faces) {
        return (int) (Math.random() * faces + 1);
    }

    public static void showCharacter(String name, String occupation, int str, int armor, int speed, int attack) {
        System.out.println("---------------------");
        System.out.println(name + " the " + occupation);
        System.out.print("Strength: ");
        for (int i = 0; i < str; ++i) {
            System.out.print('♥');
        }
        System.out.println();
        System.out.print("Armor: ");
        for (int i = 0; i < armor; ++i) {
            System.out.print("♥");
        }
        System.out.println();
        System.out.print("Speed: ");
        for (int i = 0; i < speed; ++i) {
            System.out.print("♥");
        }

        System.out.println();
        System.out.print("Attack: " + attack);
        System.out.println("\n---------------------");
    }

    public static void initCombat(String[] names, String[] occupations, int[] strengths, int[] armors, int[] speeds,
            int[] attacks) {
        // Vemos quién comienza
        int startPlayer = getWhoStarts(speeds);

        int attacker = startPlayer;
        int defender = 1 - startPlayer;

        Scanner sc = new Scanner(System.in);

        int round = 1;

        while (strengths[0] > 0 && strengths[1] > 0) {
            // Pintamos el número de ronda
            System.out
                    .println("Round " + round + ": " + names[attacker] + " the " + occupations[attacker] + " attacks");
            System.out.println("--------------------------------------");

            // 1. ELECCIÓN DE ARMA
            // ---------------------------------------

            // Eleccion de arma
            int weaponId = chooseWeapon(attacker, sc);

            // Obtener nombre de arma
            String weaponName = getWeaponName(weaponId);

            // Mostrar el mensaje de arma
            System.out.println(names[attacker] + " uses " + weaponName);

            // 2. SUCCESS OF FAIL
            boolean succeeded = attackSucceded(names, occupations, attacks, attacker, weaponId);
            if (succeeded) {
                // 3. DAMAGE
                calculateAndApplyDamage(names, occupations, speeds, weaponId, armors, strengths, attacker, defender);

                // 4. EFFECTS
                calculateAndApplyEffects(weaponId, speeds, armors, attacker, defender, names, occupations);

            }

            // 5. SHOW ATTRIBUTES
            for (int i = 0; i < names.length; ++i) {
                showCharacter(names[i], occupations[i], strengths[i], armors[i], speeds[i], attacks[i]);

            }

            // Cambio de turno
            attacker = 1 - attacker;
            defender = 1 - defender;

            // OTRA FORMA:
            // if (attacker == 1)
            // {
            // attacker = 0;
            // defender = 1;
            // }
            // else
            // {
            // attacker = 1;
            // defender = 0;
            // }

            round++;
        }

        sc.close();
    }

    public static void calculateAndApplyDamage(String[] names, String[] occupations, int[] speeds, int weaponId,
            int[] armors, int[] strengths, int attacker, int defender) {
        // Calculamos el daño del arma
        int weaponDamage = calculateWeaponDamage(weaponId, speeds, attacker, names, occupations);

        // Añadir efecto armadura
        int totalDamage = weaponDamage - armors[defender];
        if (totalDamage < 0)
            totalDamage = 0;

        System.out.println(names[defender] + " the " + occupations[defender] + " has " + armors[defender]
                + " armor points so the total damage done is " + totalDamage);

        // Quitamos de la fuerza del defensor el daño realizado
        strengths[defender] -= totalDamage;
    }

    public static int calculateWeaponDamage(int weaponId, int[] speeds, int attacker, String[] names,
            String[] occupations) {
        int damage = -1;
        int roll = -1;

        switch (weaponId) {

            case 1:
                roll = rollDice(4);
                damage = roll;
                break;

            case 2:
                roll = rollDice(8);
                damage = roll + (int) Math.ceil(speeds[attacker] / 4.0);
                break;

            case 3:
                roll = rollDice(10);
                damage = roll + (int) Math.ceil(speeds[attacker] / 6.0);
                break;

            case 4:
                roll = 0;
                damage = 0;
                break;

            default:
                damage = -1;
        }

        System.out.println(names[attacker] + " the " + occupations[attacker] + " rolls a " + roll + " and inflicts "
                + damage + " points of damage");

        return damage;
    }

    public static void calculateAndApplyEffects(int weaponId, int[] speeds, int[] armors, int attacker, int defender,
            String[] names, String[] occupations) {
        int damage = -1;

        switch (weaponId) {

            case 1:
                damage = 0;
                break;

            case 2:
                damage = 1;
                speeds[defender] -= damage;
                System.out.println(
                        names[defender] + " the " + occupations[defender] + " loses " + damage + " speed points");
                break;

            case 3:
                damage = 2;
                armors[defender] -= damage;
                System.out.println(
                        names[defender] + " the " + occupations[defender] + " loses " + damage + " armor points");
                break;

            case 4:
                damage = 1;
                armors[attacker] += damage;
                speeds[attacker] += damage;
                System.out.println(names[attacker] + " the " + occupations[attacker] + " wins " + damage
                        + " points of speed and armor");
                break;

            default:
                damage = -1;
        }
    }

    public static String getWeaponName(int id) {
        String[] weapons = { "Blowing Scythe", "Tiring Poison", "Freezing armor", "Lens of Chaos" };
        return weapons[id - 1];
    }

    public static int getWhoStarts(int[] speeds) {
        int startPlayer = -1;

        if (speeds[0] > speeds[1]) {
            startPlayer = 0;
        } else {
            startPlayer = 1;
        }

        return startPlayer;
    }

    public static int chooseWeapon(int attacker, Scanner sc) {
        int weaponId = -1;

        if (attacker == 0) {
            // Caso de Carl
            while (weaponId < 1 || weaponId > 4) {
                System.out.println(
                        "Select the weapon (1-Blowing Scythe, 2-Tiring poison, 3-Freezing armor, 4-Lens of Wisdom)");
                weaponId = sc.nextInt();
            }
        } else {
            // Caso del villano
            weaponId = rollDice(4);
        }

        return weaponId;
    }

    public static boolean attackSucceded(String[] names, String occupation[], int[] attack, int attacker,
            int idWeapon) {
        // 100 sided dice roll
        int weaponRoll = rollDice(100);

        // int weaponRoll = (int)Math.ceil((double)roll / idWeapon);
        int attackWeapon = (int) Math.ceil(attack[attacker] / (float) idWeapon);

        if (weaponRoll <= attackWeapon) {
            System.out.println(names[attacker] + " the " + occupation[attacker] + " rolled a " + weaponRoll
                    + " and succeeded to attack");
            return true;
        } else {
            System.out.println(names[attacker] + " the " + occupation[attacker] + " rolled a " + weaponRoll
                    + " and failed to attack");
            return false;
        }
    }
}
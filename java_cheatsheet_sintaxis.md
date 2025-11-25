
# Java Cheatsheet Básico (Sintaxis)

## Estructura mínima
```java
// Archivo: Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Java");
    }
}
```

## 1. Tipos básicos y variables

### Tipos primitivos
- byte, short, int, long  
- float, double  
- char, boolean

### Declaración
```java
int edad = 29;
double precio = 19.99;
boolean activo = true;
char letra = 'A';
String nombre = "Ada";
```

## 2. Operadores y condicionales

### if / else / else if
```java
int x = 10;

if (x > 0) {
    System.out.println("positivo");
} else if (x == 0) {
    System.out.println("cero");
} else {
    System.out.println("negativo");
}
```

### switch
```java
int dia = 3;
switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    default:
        System.out.println("Otro día");
}
```

## 3. Bucles

### for
```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

### while / do-while
```java
int i = 0;
while (i < 5) {
    i++;
}

do {
    i--;
} while (i > 0);
```

## 4. Arrays

### Declaración
```java
int[] nums = new int[5];
nums[0] = 10;

String[] nombres = {
    "Ana",
    "Luis"
};
```

### Recorrer
```java
for (int i = 0; i < nombres.length; i++) {
    System.out.println(nombres[i]);
}

for (String n : nombres) {
    System.out.println(n);
}
```

## 5. Métodos
```java
public static int sumar(int a, int b) {
    return a + b;
}

public static void saludar(String nombre) {
    System.out.println("Hola " + nombre);
}
```

## 6. Clases y objetos

```java
public class Heretic {

    // Atributos
    private String name;
    private int age;

    // Constructor
    public Heretic(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

### Crear objetos
```java
Heretic h = new Heretic("X.G", 29);
System.out.println(h.getName());
```

## 7. Modificadores, this, static
```java
public class Ejemplo {
    private int contador;
    public static int totalObjetos = 0;

    public Ejemplo() {
        this.contador = 0;
        totalObjetos++;
    }

    public int getContador() {
        return contador;
    }
}
```

## 8. Collections (básico)

### ArrayList
```java
import java.util.ArrayList;

ArrayList<String> lista = new ArrayList<>();
lista.add("vino");
lista.add("cerveza");
lista.remove(0);
```

### HashMap
```java
import java.util.HashMap;

HashMap<String, Integer> mapa = new HashMap<>();
mapa.put("vida", 100);
int vida = mapa.get("vida");
```

## 9. Excepciones
```java
try {
    int r = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    // Siempre se ejecuta
}
```

## 10. Cosas típicas que exige el compilador
- El nombre del archivo debe coincidir con la `public class` principal.  
- Los tipos deben coincidir (String ≠ int).  
- Variables locales deben inicializarse antes de usarse.  
- Respetar mayúsculas/minúsculas.  
- Usar `this` para distinguir atributos de parámetros.

---

Sugerencia: imprímelo y añade tus notas a mano para memorizarlo mejor.

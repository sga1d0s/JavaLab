# Java Math Cheat Sheet (`java.lang.Math`)

Referencia rápida de las funciones más usadas de `Math` en Java, con ejemplos.

> Nota: `Math` está en el paquete `java.lang`, así que **no hace falta importarlo**.  
> Todas sus funciones y constantes son **estáticas**, se usan como `Math.función(...)`.

---

## 1. Constantes

```java
double pi = Math.PI;     // 3.141592653589793
double e  = Math.E;      // 2.718281828459045
```

Útiles para trigonometría, áreas, exponentes, etc.

---

## 2. Valor absoluto, mínimo y máximo

```java
int a = -5;
int b = 10;

int absA  = Math.abs(a);       // 5
int minAB = Math.min(a, b);    // -5
int maxAB = Math.max(a, b);    // 10

double x = -3.7;
double absX = Math.abs(x);     // 3.7
```

- `Math.abs(...)` → valor absoluto (int, long, float, double).
- `Math.min(x, y)` → menor de los dos.
- `Math.max(x, y)` → mayor de los dos.

---

## 3. Redondeos (`ceil`, `floor`, `round`, `rint`)

### `ceil` y `floor`

```java
double x1 = 3.2;
double x2 = -3.2;

double c1 = Math.ceil(x1);   // 4.0  (sube al entero superior)
double c2 = Math.ceil(x2);   // -3.0

double f1 = Math.floor(x1);  // 3.0  (baja al entero inferior)
double f2 = Math.floor(x2);  // -4.0
```

- `ceil` → **hacia arriba** (al entero mayor o igual).
- `floor` → **hacia abajo** (al entero menor o igual).

### `round` (al entero más cercano)

```java
double y1 = 3.2;
double y2 = 3.6;
double y3 = -3.2;
double y4 = -3.6;

long r1 = Math.round(y1);   // 3
long r2 = Math.round(y2);   // 4
long r3 = Math.round(y3);   // -3
long r4 = Math.round(y4);   // -4

float f = 2.5f;
int rF = Math.round(f);     // 2 (devuelve int si el parámetro es float)
```

- Si pasas `double`, devuelve `long`.
- Si pasas `float`, devuelve `int`.

### `rint` (double al entero más cercano, como double)

```java
double z1 = 3.2;
double z2 = 3.5;

double rint1 = Math.rint(z1);   // 3.0
double rint2 = Math.rint(z2);   // 4.0 (empates se resuelven al par más cercano)
```

---

## 4. Potencias y raíces

### Potencias (`pow`)

```java
double cuadrado = Math.pow(3, 2);    // 9.0
double cubo     = Math.pow(2, 3);    // 8.0
double raiz     = Math.pow(9, 0.5);  // 3.0
```

### Raíz cuadrada (`sqrt`) y cúbica (`cbrt`)

```java
double raiz2 = Math.sqrt(16);   // 4.0
double raiz3 = Math.cbrt(27);   // 3.0

double nan = Math.sqrt(-1);     // NaN (no es un número)
```

---

## 5. Exponenciales y logaritmos

```java
double exp1  = Math.exp(1);     // ≈ e^1
double exp2  = Math.exp(2);     // ≈ e^2

double lnE   = Math.log(Math.E);   // 1.0 (logaritmo neperiano)
double ln10  = Math.log(10);       // ln(10)

double log10 = Math.log10(1000);   // 3.0 (log base 10)
```

> Tip: para otros logaritmos base `b`, usa:  
> `log_b(x) = Math.log(x) / Math.log(b)`

```java
double logBase2De8 = Math.log(8) / Math.log(2);  // 3.0
```

---

## 6. Trigonometría (en radianes)

Todas las funciones trigonométricas de `Math` usan **radianes**, no grados.

### Conversión grados ↔ radianes

```java
double grados = 90.0;
double rad    = Math.toRadians(grados);    // π/2

double rad2   = Math.PI;
double grad2  = Math.toDegrees(rad2);      // 180.0
```

### Seno, coseno y tangente

```java
double angulo = Math.toRadians(30);  // 30° → radianes

double s = Math.sin(angulo);   // 0.5
double c = Math.cos(angulo);   // ≈ 0.8660254
double t = Math.tan(angulo);   // ≈ 0.5773502
```

### Arcos (inversas)

```java
double x = 0.5;

double angSin = Math.asin(x);    // devuelve radianes
double angCos = Math.acos(x);
double angTan = Math.atan(1);    // ≈ π/4
```

### `atan2(y, x)` (ángulo de un vector)

Devuelve el ángulo en radianes del vector `(x, y)` respecto al eje X,
tiene en cuenta el cuadrante.

```java
double y = 1.0;
double x2 = 1.0;

double ang = Math.atan2(y, x2);  // ≈ π/4
```

---

## 7. Raíz hipotenusa (`hypot`)

Calcula `sqrt(x*x + y*y)` de forma más precisa y segura (evita overflow).

```java
double h = Math.hypot(3, 4);   // 5.0
```

Útil para distancias:

```java
double x1 = 1, y1 = 2;
double x2 = 4, y2 = 6;

double dist = Math.hypot(x2 - x1, y2 - y1);  // distancia entre puntos
```

---

## 8. Signo y copia de signo (`signum`, `copySign`)

### `signum`

```java
double s1 = Math.signum(10.0);   // 1.0
double s2 = Math.signum(-3.5);   // -1.0
double s3 = Math.signum(0.0);    // 0.0
```

Devuelve:
- `1.0` si el número es positivo,
- `-1.0` si es negativo,
- `0.0` si es cero.

### `copySign`

Copia el signo de un número a otro:

```java
double r = Math.copySign(5.0, -2.0);  // -5.0
double r2 = Math.copySign(-3.0, 7.0); // 3.0
```

---

## 9. Números pseudoaleatorios (`Math.random()`)

```java
double r = Math.random();  // [0.0, 1.0)

// Entero aleatorio entre 0 y 9
int n0_9 = (int) (Math.random() * 10);

// Entero aleatorio entre min y max (incluidos)
int min = 5;
int max = 15;
int nMinMax = min + (int) (Math.random() * (max - min + 1));
```

> Para cosas más avanzadas es mejor usar `java.util.Random` o `java.util.concurrent.ThreadLocalRandom`,
> pero para el examen suele bastar `Math.random()`.

---

## 10. Desbordes, NaN e infinitos

```java
double infinitoPos = 1.0 / 0.0;       // Infinity
double infinitoNeg = -1.0 / 0.0;      // -Infinity
double nan = 0.0 / 0.0;               // NaN

boolean esNan = Double.isNaN(nan);    // true
boolean esInf = Double.isInfinite(infinitoPos); // true
```

También existen comprobaciones en `Double` y `Float`:

```java
boolean finito = Double.isFinite(3.14);     // true
```

---

## 11. Ejemplo completo

```java
public class MathDemo {
    public static void main(String[] args) {
        // Calcular la longitud de la circunferencia de un círculo
        double radio = 5.0;
        double longitud = 2 * Math.PI * radio;  // 2πr

        // Distancia entre dos puntos (x1, y1) y (x2, y2)
        double x1 = 1, y1 = 2;
        double x2 = 4, y2 = 6;
        double distancia = Math.hypot(x2 - x1, y2 - y1);

        // Redondear un número
        double valor = 3.67;
        long redondeado = Math.round(valor);

        // Generar número aleatorio del 1 al 6 (tipo dado)
        int dado = 1 + (int) (Math.random() * 6);

        System.out.println("Longitud circunferencia: " + longitud);
        System.out.println("Distancia: " + distancia);
        System.out.println("Redondeado: " + redondeado);
        System.out.println("Dado: " + dado);
    }
}
```

---

## 12. Resumen rápido

- **Constantes:** `Math.PI`, `Math.E`
- **Básicos:** `abs`, `min`, `max`
- **Redondeo:** `ceil`, `floor`, `round`, `rint`
- **Potencias/raíces:** `pow`, `sqrt`, `cbrt`
- **Exp/log:** `exp`, `log`, `log10`
- **Trigonometría:** `sin`, `cos`, `tan`, `asin`, `acos`, `atan`, `atan2`, `toRadians`, `toDegrees`
- **Distancias:** `hypot`
- **Signo:** `signum`, `copySign`
- **Aleatorios:** `random`

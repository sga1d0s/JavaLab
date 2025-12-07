package Functions;

public class FunctionsExample {
  public static void main(String[] args) {
    int a = 12;
    int b = 36;

    int result = add(a, b);

    System.out.println("La suma de" + a + " y " + b + " es " + result);
  }

  public static int add(int a, int b) {
    return a + b;
  }
}

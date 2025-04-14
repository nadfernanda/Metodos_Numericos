## Definición
El método de bisección es un procedimiento numérico para encontrar una raíz de una función continua f(x) en un intervalo [a,b] 
donde se cumple que f(a)⋅f(b)<0; es decir, la función cambia de signo, lo que garantiza que hay al menos una raíz en ese intervalo 
(por el teorema del valor intermedio). Este método consiste en dividir el intervalo en dos partes iguales y seleccionar la subparte donde sigue existiendo un cambio de signo, repitiendo el proceso hasta que el intervalo sea lo suficientemente pequeño (es decir, se alcance la precisión deseada).

## Algoritmo
1. Elegir el intervalo inicial $[a, b]$ tal que $f(a) \cdot f(b) < 0$.

2. Calcular el punto medio:
   $$c = \frac{a + b}{2}$$

3. Evaluar $f(c)$:
   * Si $f(c) = 0$, entonces $c$ es la raíz exacta.
   * Si $f(a) \cdot f(c) < 0$, la raíz está en $[a, c]$, entonces se reemplaza $b$ por $c$.
   * Si $f(c) \cdot f(b) < 0$, la raíz está en $[c, b]$, entonces se reemplaza $a$ por $c$.

4. Verificar el criterio de parada:
   * Si el valor de $|b - a| < \epsilon$ (donde $\epsilon$ es la tolerancia o error deseado), detener el proceso. Se considera que la raíz es aproximadamente $c$.
   * Si no, volver al paso 2.

### Implementación en Java
```java
public class MetodoBiseccion {

    // Definimos la función f(x). Puedes cambiar esta función según el problema.
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2; // Ejemplo: f(x) = x^3 - x - 2
    }

    /**
     * Método de Bisección para encontrar una raíz de la función f en el intervalo [a, b]
     *
     * @param a          Límite inferior del intervalo
     * @param b          Límite superior del intervalo
     * @param tolerancia Error máximo permitido (criterio de paro)
     * @param maxIter    Número máximo de iteraciones
     */
    public static void biseccion(double a, double b, double tolerancia, int maxIter) {
        // Verificamos que haya cambio de signo
        if (f(a) * f(b) >= 0) {
            System.out.println("El método no garantiza una raíz en el intervalo dado.");
            return;
        }

        double c = a; // Punto medio
        int iteracion = 0;

        // Repetimos hasta que se cumpla la tolerancia o el número máximo de iteraciones
        while ((b - a) / 2 > tolerancia && iteracion < maxIter) {
            c = (a + b) / 2; // Calculamos el punto medio

            System.out.printf("Iteración %d: a = %.6f, b = %.6f, c = %.6f, f(c) = %.6f\n",
                    iteracion + 1, a, b, c, f(c));

            // Si f(c) es cero, encontramos la raíz exacta
            if (f(c) == 0.0) {
                break;
            }
            // Si hay cambio de signo entre f(a) y f(c), la raíz está en [a, c]
            else if (f(a) * f(c) < 0) {
                b = c;
            }
            // Si no, está en [c, b]
            else {
                a = c;
            }

            iteracion++;
        }

        // Mostramos la raíz aproximada
        System.out.printf("\nRaíz aproximada: %.6f\n", c);
    }

    public static void main(String[] args) {
        double a = 1;              // Límite inferior
        double b = 2;              // Límite superior
        double tolerancia = 1e-6;  // Tolerancia deseada (0.000001)
        int maxIter = 100;         // Número máximo de iteraciones

        biseccion(a, b, tolerancia, maxIter);
    }
}

```

## Ejercicios Prácticos
## Ejercicio 1 

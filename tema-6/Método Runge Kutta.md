## Definición
El Método de Runge-Kutta es una familia de métodos numéricos iterativos, tanto explícitos como implícitos, utilizados para aproximar las soluciones de ecuaciones diferenciales ordinarias (EDOs). Estos métodos son más precisos que el método de Euler y el método de Taylor de bajo orden, y son ampliamente utilizados en la práctica debido a su buen equilibrio entre precisión y complejidad computacional.

En lugar de simplemente usar la pendiente al inicio de un intervalo (como en el método de Euler) o calcular derivadas de orden superior (como en el método de Taylor), los métodos de Runge-Kutta evalúan la función de la derivada $(f(x, y) \text{ en } \frac{dy}{dx} = f(x, y))$ en varios puntos dentro de cada intervalo de paso y luego toman una combinación ponderada de estas evaluaciones para obtener una aproximación más precisa de la pendiente promedio a través del intervalo. Esta pendiente promedio se utiliza para dar el paso hacia el siguiente valor de la solución.

## Algoritmo 
Dado un intervalo $[x_0, x_n]$, un valor inicial $y_0$, y un tamaño de paso $h$:

1. Inicializa los valores:
   - $x = x_0$
   - $y = y_0$

2. Para cada paso: Calcula los siguientes coeficientes:

   $$k_1 = h \cdot f(x_n, y_n)$$

   $$k_2 = h \cdot f(x_n + \frac{h}{2}, y_n + \frac{k_1}{2})$$

   $$k_3 = h \cdot f(x_n + \frac{h}{2}, y_n + \frac{k_2}{2})$$

   $$k_4 = h \cdot f(x_n + h, y_n + k_3)$$

3. Calcula el siguiente valor de $y$:

   $$y_{n+1} = y_n + \frac{1}{6}(k_1 + 2k_2 + 2k_3 + k_4)$$

4. Avanza en $x$:
   $$x_{n+1} = x_n + h$$

5. Repite los pasos 2 a 4 hasta llegar al valor deseado de $x$.
### Implementación en Java
```java
import java.util.function.BiFunction;

public class MetodoRungeKutta {

    /**
     * Método que resuelve una ecuación diferencial usando el método de Runge-Kutta de cuarto orden (RK4).
     *
     * @param f    Función que representa la derivada dy/dx, depende de x e y (por eso BiFunction)
     * @param x0   Valor inicial de x
     * @param y0   Valor inicial de y
     * @param h    Tamaño de paso
     * @param n    Número de pasos a realizar
     */
    public static void rungeKutta(BiFunction<Double, Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.5f\t %.5f%n", x, y);

        for (int i = 1; i <= n; i++) {
            // Calculamos los cuatro k del método de Runge-Kutta
            double k1 = h * f.apply(x, y);
            double k2 = h * f.apply(x + h / 2.0, y + k1 / 2.0);
            double k3 = h * f.apply(x + h / 2.0, y + k2 / 2.0);
            double k4 = h * f.apply(x + h, y + k3);

            // Fórmula para actualizar y
            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;

            // Avanzamos en x
            x = x + h;

            // Imprimimos los valores de cada paso
            System.out.printf("%d\t %.5f\t %.5f%n", i, x, y);
        }
    }

    public static void main(String[] args) {
        // Definimos la derivada dy/dx como una función que depende de x e y
        BiFunction<Double, Double, Double> derivada = (x, y) -> x + y; // Ejemplo: dy/dx = x + y

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Llamamos al método de Runge-Kutta
        rungeKutta(derivada, x0, y0, h, n);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1


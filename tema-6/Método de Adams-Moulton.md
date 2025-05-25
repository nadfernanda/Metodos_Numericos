## Definición
Es un método implícito que utiliza valores pasados y futuros para calcular la solución, ofreciendo mejor estabilidad especialmente en problemas rígidos. Al ser implícito, el cálculo de 
yn + 1 requiere resolver una ecuación, a menudo mediante métodos iterativos. Esto compensa la mayor carga computacional con mayor precisión y estabilidad.

## Algoritmo (Adams-Moulton de 2 pasos):
1. Calcular $y_{n+1}$ mediante:
   $y_{n+1} = y_n + \frac{h}{12}(5f(x_{n+1}, y_{n+1}) + 8f(x_n, y_n) - f(x_{n-1}, y_{n-1}))$

2. Como $y_{n+1}$ aparece en ambos lados, se resuelve mediante iteración (por ejemplo, método de Newton o punto fijo).
   
### Implementación en Java
```java
public class MetodoAdamsMoulton {

    /**
     * Define la función f(x, y) correspondiente a la ecuación diferencial y' = f(x, y)
     */
    public static double f(double x, double y) {
        return x + y; // Ejemplo: y' = x + y
    }

    /**
     * Método de Adams-Moulton implícito de 4 pasos para aproximar y(x)
     * @param x0 valor inicial de x
     * @param y0 valor inicial de y
     * @param h paso
     * @param n número de pasos totales (n * h debe cubrir el intervalo)
     * @return valor aproximado de y en x_n
     */
    public static double adamsMoulton(double x0, double y0, double h, int n) {
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] f = new double[n + 1];

        // Condiciones iniciales
        x[0] = x0;
        y[0] = y0;

        // Usamos Runge-Kutta de orden 4 para obtener los primeros 3 puntos
        for (int i = 0; i < 3; i++) {
            double k1 = h * f(x[i], y[i]);
            double k2 = h * f(x[i] + h / 2, y[i] + k1 / 2);
            double k3 = h * f(x[i] + h / 2, y[i] + k2 / 2);
            double k4 = h * f(x[i] + h, y[i] + k3);
            y[i + 1] = y[i] + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            x[i + 1] = x[i] + h;
        }

        // Calculamos f(x, y) para los primeros 4 valores
        for (int i = 0; i < 4; i++) {
            f[i] = f(x[i], y[i]);
        }

        // Adams-Moulton de orden 4: fórmula implícita corregida con predicción
        for (int i = 3; i < n; i++) {
            x[i + 1] = x[i] + h;

            // Predicción con Adams-Bashforth (orden 4)
            double y_pred = y[i] + (h / 24.0) * (
                    55 * f[i]
                  - 59 * f[i - 1]
                  + 37 * f[i - 2]
                  - 9  * f[i - 3]);

            // Corrección con Adams-Moulton
            double f_pred = f(x[i + 1], y_pred);
            y[i + 1] = y[i] + (h / 24.0) * (
                    9  * f_pred
                  + 19 * f[i]
                  - 5  * f[i - 1]
                  +      f[i - 2]);

            // Guardamos el nuevo f(x, y)
            f[i + 1] = f(x[i + 1], y[i + 1]);
        }

        // Retornamos el valor final
        return y[n];
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        int n = 10;

        double resultado = adamsMoulton(x0, y0, h, n);
        double xn = x0 + n * h;

        System.out.printf("El valor aproximado de y(%.1f) es %.6f\n", xn, resultado);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Resolver la ecuación diferencial $y′=x^2$, con condición inicial y(0)=0 , paso h=0.25 , n=4 y encontrar y(1.0).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Moulton/Ejercicio%201.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

El método logra calcular un valor aproximado para y(1.0) que está muy cerca del valor real, aunque no es exacto. Esto significa que cuando no podemos obtener una solución matemática directa, podemos usar este método para obtener una buena estimación rápida. Es especialmente útil para funciones suaves y cuando usamos pasos adecuados, porque la aproximación mejora mucho en esos casos.

## Ejercicio 2
Resuelve la ecuación diferencial $y′=−y$, con condición inicial y(0)=1, paso h=0.2, n=5, y encontrar y(1.0).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Moulton/Ejercicio%202.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

Este resultado muestra que el método puede manejar problemas donde la función disminuye con el tiempo, como la desintegración o pérdida de energía. El valor calculado es muy parecido al real, lo que indica que el método es bastante preciso y confiable para situaciones prácticas, sin necesidad de hacer cálculos complicados o largos.

## Ejercicio 3
Resuelve la ecuación diferencial $y′=sin(x)$, con condición inicial y(0)=0, paso h=0.1, n=5, y encontrar y(0.5).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Moulton/Ejercicio%203.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

Aunque esta función cambia de forma más compleja y oscilatoria, el método aún consigue una buena aproximación para y(0.5). Esto demuestra que la técnica puede usarse para fenómenos naturales que varían de manera no lineal, siempre y cuando se usen pasos pequeños. Así podemos entender mejor esos procesos sin necesidad de fórmulas exactas difíciles.

## Definición
Es un método explícito que utiliza los valores de la función derivada f en los puntos actuales y anteriores para calcular el siguiente valor de la solución. Este método aprovecha la información histórica para lograr mayor precisión sin tener que recalcular la función en varios puntos del intervalo, a diferencia de métodos de un paso como Runge-Kutta. Sin embargo, al ser explícito puede ser menos estable en algunos casos.

## Algoritmo
Dada la EDO y valores $y_n$, $y_{n-1}$:

1. Calcular:
   $y_{n+1} = y_n + \frac{h}{2}(3f(x_n, y_n) - f(x_{n-1}, y_{n-1}))$

2. Avanzar $n \rightarrow n + 1$ y repetir.

Nota: Para comenzar, se usan métodos de un paso para obtener los primeros valores.

### Implementación en Java
```java
public class MetodoAdamsBashforth {

    /**
     * Define la función f(x, y) de la ecuación diferencial y' = f(x, y)
     */
    public static double f(double x, double y) {
        return x + y;  // Ejemplo: y' = x + y
    }

    /**
     * Método de Adams-Bashforth de 4 pasos
     * @param x0 Valor inicial de x
     * @param y0 Valor inicial de y
     * @param h Paso
     * @param n Número de pasos totales (debe ser >= 4)
     * @return Valor aproximado de y en x_n
     */
    public static double adamsBashforth(double x0, double y0, double h, int n) {
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] f = new double[n + 1];

        // Condiciones iniciales
        x[0] = x0;
        y[0] = y0;

        // Calculamos los primeros 3 valores con Runge-Kutta de orden 4
        for (int i = 0; i < 3; i++) {
            double k1 = h * f(x[i], y[i]);
            double k2 = h * f(x[i] + h / 2, y[i] + k1 / 2);
            double k3 = h * f(x[i] + h / 2, y[i] + k2 / 2);
            double k4 = h * f(x[i] + h, y[i] + k3);
            y[i + 1] = y[i] + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            x[i + 1] = x[i] + h;
        }

        // Calculamos f[i] para los valores iniciales
        for (int i = 0; i < 4; i++) {
            f[i] = f(x[i], y[i]);
        }

        // Aplicamos Adams-Bashforth
        for (int i = 3; i < n; i++) {
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + (h / 24.0) * (
                    55 * f[i]
                  - 59 * f[i - 1]
                  + 37 * f[i - 2]
                  - 9  * f[i - 3]);
            f[i + 1] = f(x[i + 1], y[i + 1]);
        }

        // Retornamos solo el último valor
        return y[n];
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        int n = 10;

        double resultado = adamsBashforth(x0, y0, h, n);
        double xn = x0 + n * h;

        System.out.printf("El valor aproximado de y(%.1f) es %.4f\n", xn, resultado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1
Resolver la ecuación diferencial $y′=x+y$, con condición inicial y(0)=1, usando paso h=0.1 y obtener el valor aproximado de y(1.0).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Bashforth/Ejercicio%201.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

El valor obtenido para y(1.0) fue 3.43645, lo cual indica que el método de Adams-Bashforth aproxima bien, aunque presenta cierta desviación respecto a valores más precisos o exactos. Aun así, el resultado es útil si se necesita una solución rápida sin resolver la ecuación analíticamente, sobre todo cuando se aplica a modelos reales donde un pequeño error es aceptable.

## Ejercicio 2
Resuelve la ecuación diferencial $y′=y−x^2+1$, con condición inicial y(0)=0.5, paso h=0.2, y encontrar y(1.0).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Bashforth/Ejercicio%202.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

El resultado de 2.64105 para y(1.0) nos dice que el método logró dar una buena estimación del valor, aunque no es exacta. Este tipo de método sirve para acercarse a la respuesta cuando resolver la ecuación de forma directa sería muy difícil o largo. Aunque hay un pequeño error, el valor sigue siendo útil y muestra que el método puede funcionar bien incluso con fórmulas un poco más complicadas.

## Ejercicio 3
Resuelve la ecuación diferencial $y′=cos(x)−y$, con y(0)=1, paso h=0.1, y hallar y(0.5).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Bashforth/Ejercicio%203.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

Con un resultado de 0.98177 para y(0.5), se puede observar que la aproximación se aleja un poco del valor exacto esperado, pero mantiene una forma coherente. Este tipo de error es común cuando se trabaja con funciones oscilatorias como el coseno, donde la precisión depende mucho del tamaño del paso y del comportamiento de la función.


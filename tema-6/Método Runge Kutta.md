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

/**
 * Clase que implementa el método de Runge-Kutta de cuarto orden (RK4)
 * para resolver ecuaciones diferenciales ordinarias (EDO) de primer orden.
 */
public class RungeKutta {

    /**
     * Método estático que implementa el algoritmo de Runge-Kutta de cuarto orden.
     * Este método aproxima la solución de una EDO de la forma dy/dx = f(x, y)
     * en un intervalo definido por el número de pasos y el tamaño de paso.
     *
     * @param f    Función que representa la derivada dy/dx, dependiente de x e y
     * @param x0   Valor inicial de x (condición inicial)
     * @param y0   Valor inicial de y (condición inicial)
     * @param h    Tamaño de paso (incremento de x)
     * @param n    Número de pasos a ejecutar
     */
    public static void rungeKutta(BiFunction<Double, Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0; // Inicializa x con el valor inicial
        double y = y0; // Inicializa y con el valor inicial

        // Itera n veces para calcular la aproximación de y en x + n*h
        for (int i = 1; i <= n; i++) {
            // Calcula los coeficientes de Runge-Kutta
            double k1 = h * f.apply(x, y);
            double k2 = h * f.apply(x + h / 2.0, y + k1 / 2.0);
            double k3 = h * f.apply(x + h / 2.0, y + k2 / 2.0);
            double k4 = h * f.apply(x + h, y + k3);

            // Actualiza el valor de y usando los coeficientes
            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;

            // Incrementa el valor de x
            x = x + h;
        }

        // Imprime el resultado final de y en x final
        System.out.printf("Resultado final: y(%.2f) = %.5f%n", x, y);
    }

    /**
     * Método principal para probar la implementación del método de Runge-Kutta.
     * Define la función derivada, condiciones iniciales, tamaño de paso y número de pasos.
     */
    public static void main(String[] args) {
        // Definición de la función derivada dy/dx = x * sqrt(y)
        BiFunction<Double, Double, Double> derivada = (x, y) -> x * Math.sqrt(y);

        // Condiciones iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y

        // Parámetros del método
        double h = 0.2;   // Tamaño de paso
        int n = 5;        // Número de pasos

        // Llamada al método de Runge-Kutta para resolver la EDO
        rungeKutta(derivada, x0, y0, h, n);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Resuelve la ecuación diferencial  
$\frac{dy}{dx}  = x + y$, con condición inicial y(0)=1, usando un paso h = 0.1 y 10 pasos.


**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Runge%20Kutta/Ejercicio%201.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

Este ejercicio muestra cómo el método de Runge-Kutta calcula el crecimiento de una función cuya derivada depende tanto de x como de y. Aunque esperábamos un valor cercano a e, el resultado final 3.43656 indica que la acumulación de y en cada paso provoca un crecimiento más acelerado. El método sigue siendo útil, pero recuerda que el comportamiento depende de cómo la función reacciona a los incrementos, no de un resultado exacto como e.

## Ejercicio 2
Resuelve la ecuación diferencial  
$\frac{dy}{dx}  = = x√(y)$, con condición inicial y(0) = 1, usando h = 0.2 y 5 pasos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Runge%20Kutta/Ejercicio%202.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

Aquí vemos que, con una función que involucra una raíz cuadrada, el método da un resultado final de 1.56250, lo que muestra un crecimiento más suave. Aunque puede parecer más lento que lo esperado, este comportamiento es coherente con el hecho de que la derivada depende de √(y), que crece lentamente. El método sigue capturando correctamente la evolución del sistema, pero sin saltos bruscos.

## Ejercicio 3
Resuelve la ecuación diferencial  
$\frac{dy}{dx}  = y - x^2 + 1$,  con condición inicial y(0) = 0.5, usando h = 0.1 y 10 pasos

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Runge%20Kutta/Ejercicio%203.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

Este resultado final de 2.64086 demuestra que el método de Runge-Kutta maneja muy bien ecuaciones con términos no lineales como -x² + 1. Aunque se esperaba algo más cercano a 1.23, el hecho de que y crezca tanto sugiere que la combinación de los términos produce una pendiente acumulativa mayor. El método sigue siendo confiable, pero nos recuerda que pequeños errores o supuestos pueden alterar significativamente el resultado final.


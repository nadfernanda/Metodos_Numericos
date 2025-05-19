## Definición
El método de Euler es un método numérico de primer orden para aproximar la solución de una ecuación diferencial ordinaria (EDO) con una condición inicial dada. Es el método numérico más básico para resolver este tipo de problemas.

El método de Euler se basa en la idea de que, en un intervalo pequeño, la solución de una EDO puede aproximarse mediante una línea recta cuya pendiente es la derivada al inicio del intervalo. En otras palabras, utiliza la recta tangente a la solución en un punto conocido para estimar el valor de la solución en un punto cercano.

## Algoritmo
1. Definir la ecuación diferencial en la forma: $y' = f(x, y)$
   
2. Establecer las condiciones iniciales: $x_0, y_0$
   
3. Seleccionar el tamaño del paso: $h$
   
4. Calcular los valores sucesivos de $y$ usando la fórmula:

   $$y_{n+1} = y_n + h \cdot f(x_n, y_n)$$

5. Incrementar $x_n = x_n + h$
    
6. Repetir los pasos 4 y 5 hasta alcanzar el valor deseado de $x$
### Implementación en Java
```java
import java.util.function.BiFunction;

public class MetodoEuler {

    /**
     * Método que resuelve una ecuación diferencial usando el método de Euler
     * y muestra solo el resultado final.
     *
     * @param f    Función que representa la derivada dy/dx = f(x, y)
     * @param x0   Valor inicial de x
     * @param y0   Valor inicial de y
     * @param h    Tamaño de paso
     * @param n    Número de pasos
     */
    public static void euler(BiFunction<Double, Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        for (int i = 1; i <= n; i++) {
            y = y + h * f.apply(x, y);
            x = x + h;
        }

         System.out.printf("Resultado final: y(%.3f) = %.3f%n", x, y);
    }

    public static void main(String[] args) {
        // Definimos la derivada dy/dx como una función de x y y
        BiFunction<Double, Double, Double> derivada = (x, y) -> x + 1;

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Llamamos al método de Euler
        euler(derivada, x0, y0, h, n);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Resuelve la EDO:

$$\frac{dy}{dx} = x + 1 \quad \text{con} \quad y(0) = 1, h = 0.1, n = 10$$

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Euler/Ejercicio1.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

El resultado obtenido fue y(1)=2.450, mientras que la solución exacta es y = x^2/2+ x + 1, lo cual da y(1)=2.5. Esto demuestra que el método de Euler proporciona una buena aproximación, aunque ligeramente por debajo del valor real debido a la acumulación del error en cada paso. Al tratarse de una función lineal creciente, el método sigue siendo razonablemente preciso con un tamaño de paso pequeño, como en este caso con h=0.1, pero aún así se nota una pequeña subestimación de la solución exacta.

## Ejercicio 2
Resuelve la EDO:

$$\frac{dy}{dx} = 2x  \quad \text{con} \quad y(0) = 1, h = 0.2, n = 5$$

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Euler/Ejercicio%202.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

Aquí se obtuvo y(1) = 0.800, mientras que la solución exacta es y= x^2 y por lo tanto y(1)=1.0. Este resultado evidencia una subestimación más marcada que en el primer ejercicio. Aunque la derivada es lineal, el valor de y crece de forma cuadrática, y con un paso h=0.2, el método de Euler no logra capturar bien esa aceleración en el crecimiento. Disminuir el tamaño del paso ayudaría a mejorar la aproximación y reducir este error.

## Ejercicio 3
Resuelve la EDO:

$$\frac{dy}{dx} = y  \quad \text{con} \quad y(0) = 1, h = 0.1, n = 10$$

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Euler/Ejercicio%203.png" width="25%" alt="Solución Ejercicio 2">

**Análisis**

El valor final obtenido fue y(1) = 2.594, frente a la solución exacta y = e^x, que da aproximadamente y(1)=2.718. En este caso, Euler también subestima la solución real, aunque con una buena aproximación considerando que la función exponencial crece rápidamente. El método de Euler no sigue bien esa curvatura creciente cuando se mantiene un tamaño de paso constante. Esto resalta la limitación del método para funciones con crecimiento exponencial, aunque sigue siendo útil para obtener una idea general de la tendencia de la solución.


## Ejercicio 4
Resuelve la EDO:

$$\frac{dy}{dx} = cos(x)  \quad \text{con} \quad y(0) = 1, h = 0.1, n = 10$$

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Euler/Ejercicio%204.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

El valor estimado fue y(1) = 0.864, comparado con la solución exacta y = sin(x), que da y(1)≈0.841. Curiosamente, en este caso el método de Euler sobreestima el resultado, lo cual es una excepción entre los ejercicios presentados. Esto se debe a que cos⁡(x) decrece en este intervalo, y Euler usa el valor inicial de la pendiente para proyectar hacia adelante, lo que hace que acumule ligeramente más área bajo la curva de lo que realmente hay. Sin embargo, el error es pequeño y la aproximación es bastante buena.

## Ejercicio 5
Resuelve la EDO:

$$\frac{dy}{dx} = x * y  \quad \text{con} \quad y(0) = 1, h = 0.1, n = 10$$


**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Euler/Ejercicio%205.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

Para este ejercicio, Euler arrojó y(1) = 1.547, mientras que la solución exacta es y = e^x^2/2, lo que da y(1)≈1.649. Nuevamente, se observa una subestimación del resultado real, lo cual es esperable dado que la derivada depende tanto de x como de y, y ambas aumentan con el tiempo. El método de Euler, al tratar con productos de variables crecientes, tiende a acumular errores más rápidamente si el paso no es suficientemente pequeño. Aun así, la diferencia no es demasiado grande y el resultado es aceptable para propósitos de aproximación básica.

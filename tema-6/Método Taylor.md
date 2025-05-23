## Definición
El método de Taylor es una técnica numérica para aproximar la solución de una ecuación diferencial ordinaria (EDO) utilizando la serie de Taylor de la solución alrededor de un punto. A diferencia del método de Euler, que solo usa la primera derivada, el método de Taylor utiliza derivadas de orden superior para lograr una mayor precisión.

Se basa en la expansión de la solución y(x) en una serie de Taylor alrededor de un punto xi donde se conoce la solución (ya sea la condición inicial o un punto previamente calculado). Al incluir más términos de la serie (es decir, derivadas de mayor orden), se obtiene una mejor aproximación de la función en puntos cercanos.

## Algoritmo
1. Definir la EDO:
   $y' = f(x, y)$
   
2. Establecer condiciones iniciales:
   $x_0, y_0$
   
3. Elegir el tamaño de paso $h$ y el orden $n$ del método
   
4. Calcular las derivadas sucesivas de $f$ hasta el orden $n$
   
5. Aplicar la fórmula:
    
   $$y_{n+1} = y_n + h \cdot y'(x_n) + \frac{h^2}{2!} \cdot y''(x_n) + ... + \frac{h^n}{n!} \cdot y^{(n)}(x_n)$$
   
6. Repetir con los nuevos valores

### Implementación en Java
```java
import java.util.function.BiFunction;

/**
 * Clase que implementa el método de Taylor de orden 2
 * para resolver ecuaciones diferenciales ordinarias (EDO).
 */
public class MetodoTaylor {

    /**
     * Método que resuelve una EDO usando el método de Taylor de orden 2.
     *
     * Fórmula: 
     * y(i+1) = y(i) + h*f(x(i), y(i)) + (h^2/2)*f'(x(i), y(i))
     *
     * @param f      Función que representa la derivada primera dy/dx
     * @param df_dx  Función que representa la derivada segunda d²y/dx²
     * @param x0     Valor inicial de x
     * @param y0     Valor inicial de y
     * @param h      Tamaño de paso
     * @param n      Número de pasos a realizar
     */
    public static void taylorOrden2(BiFunction<Double, Double, Double> f,
                                    BiFunction<Double, Double, Double> df_dx,
                                    double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        // Aplicamos la fórmula de Taylor en cada paso
        for (int i = 1; i <= n; i++) {
            double dy = f.apply(x, y);       // Primera derivada
            double d2y = df_dx.apply(x, y);  // Segunda derivada

            y = y + h * dy + (h * h / 2.0) * d2y;
            x = x + h;
        }

        // Mostrar solo el resultado final
        System.out.printf("Resultado final en x = %.5f: y = %.5f%n", x, y);
    }

    public static void main(String[] args) {
        // Ejemplo de funciones para dy/dx = x + y y d²y/dx² = 1 + (x + y)
        BiFunction<Double, Double, Double> derivadaPrimera = (x, y) -> x + y;
        BiFunction<Double, Double, Double> derivadaSegunda = (x, y) -> 1 + (x + y);

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Ejecutamos el método de Taylor
        taylorOrden2(derivadaPrimera, derivadaSegunda, x0, y0, h, n);
    }
}


```
## Ejercicios Prácticos
## Ejercicio 1
Resuelve la ecuación diferencial 

$\frac{dy}{dx} = x + y$

con condición inicial $y(0) = 1$, usando el método de Taylor de orden 2. Usa un tamaño de paso $h = 0.1$ durante 10 pasos. 
La segunda derivada es $\frac{d^2y}{dx^2} = 1 + (x + y)$.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Taylor/Ejercicio%201.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

En esta ecuación, la derivada depende de la suma de x y y, lo que hace que el valor de y crezca muy rápido. El método de Taylor de segundo orden mejora la precisión al usar también la segunda derivada. El valor final y(1) = 3.42816 muestra que la solución sube bastante, como era de esperarse, y el método logra seguir bien ese crecimiento.

## Ejercicio 2
Resuelve la ecuación diferencial 

$\frac{dy}{dx} = x^2 + y$

con condición inicial $y(0) = 2$, usando el método de Taylor de orden 2. Usa un tamaño de paso $h = 0.2$ durante 5 pasos. 
La segunda derivada es $\frac{d^2y}{dx^2} = 2x - (x^2 - y)$.


**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Taylor/Ejercicio%202.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

En este problema, Aquí, la función tiende a bajar al principio porque la derivada es x^2 - y,  al comienzo y es mayor que x^2. El método de Taylor permite ver cómo y baja poco a poco hasta llegar justo a 1 cuando x=1. Es un buen ejemplo donde la solución se estabiliza y el método lo calcula con buena.


## Ejercicio 3
Resuelve la ecuación diferencial 

$\frac{dy}{dx} = cos(x) - y$

con condición inicial $y(0) = 1$, usando el método de Taylor de orden 2. Usa un tamaño de paso $h = 0.1$ durante 10 pasos. 
La segunda derivada es $\frac{d^2y}{dx^2} = - sin(x) - cos(x) - y$.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Taylor/Ejercicio%203.png" width="30%" alt="Solución Ejercicio 2">

**Análisis**

En este caso, la derivada depende de cos⁡(x)−y, lo que hace que yyy baje con el tiempo, ya que se va restando a sí misma. El método de Taylor de segundo orden ayuda a seguir mejor esa bajada al incluir también cómo cambia la derivada. El valor final y(1)=0.87530 muestra que la solución desciende de forma suave desde el valor inicial, y el método lo calcula con buena precisión. Es un buen ejemplo de cómo Taylor funciona bien con funciones que oscilan como el coseno.

## Ejercicio 4
Resuelve la ecuación diferencial 

$\frac{dy}{dx} = x^2 + y$

con condición inicial $y(0) = 1$, usando el método de Taylor de orden 2. Usa un tamaño de paso $h = 0.2$ durante 5 pasos. 
La segunda derivada es $\frac{d^2y}{dx^2} = 2x + (x^2 + y)$.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Taylor/Ejercicio%204.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

La función crece porque se le suma x^2, que siempre es positivo, y también y. Eso hace que el valor de y suba rápidamente. Con el método de Taylor de segundo orden, se logra una mejor aproximación al tener en cuenta cómo cambia la pendiente con la segunda derivada. El resultado final y(1)=3.10812 muestra este crecimiento, y el método logra seguir ese aumento de forma bastante precisa.


## Ejercicio 5
Resuelve la ecuación diferencial 

$\frac{dy}{dx} = x - y$

con condición inicial $y(0) = 1$, usando el método de Taylor de orden 2. Usa un tamaño de paso $h = 0.1$ durante 10 pasos. 
La segunda derivada es $\frac{d^2y}{dx^2} = 1 - (x - y)$.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Taylor/Ejercicio%205.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

En este caso, como la derivada es x−y, el valor de y tiende a disminuir al principio, pero luego el valor de x crece y compensa un poco la caída. El método de Taylor ayuda a reflejar ese comportamiento, mostrando que y baja, pero no tanto como parecía al inicio. El valor final y(1)=0.73708 demuestra una bajada moderada desde el valor inicial, y el método logra capturar bien esa forma de cambiar del sistema.



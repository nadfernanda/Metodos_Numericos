## Definición
El método de Euler modificado o método de Heun es una mejora del método de Euler simple. Mientras que Euler usa solo la pendiente en el inicio del intervalo para aproximar la solución, Heun calcula primero una pendiente preliminar al final del intervalo y luego promedia ambas pendientes para obtener una mejor aproximación. Esto reduce el error y mejora la precisión, sin complicar mucho el cálculo. Es un método explícito y de un paso muy usado cuando se busca un equilibrio entre simplicidad y exactitud.

## Algoritmo
(Dado $y' = f(x, y)$, $y(x_0) = y_0$, paso $h$)

1. Calcular pendiente inicial:
   $k_1 = f(x_n, y_n)$

2. Estimar valor provisional usando Euler:
   $y^* = y_n + hk_1$

3. Calcular pendiente en el extremo final:
   $k_2 = f(x_n + h, y^*)$

4. Calcular siguiente valor con promedio de pendientes:
   $y_{n+1} = y_n + \frac{h}{2}(k_1 + k_2)$

5. Actualizar $x_{n+1} = x_n + h$, repetir.
   
### Implementación en Java
```java
/**
 * Clase que implementa el método de Heun (Euler modificado)
 * para resolver una EDO y mostrar solo el resultado final.
 */
public class Main {

    /**
     * Interfaz funcional para representar la función f(x, y).
     */
    @FunctionalInterface
    public interface Funcion {
        double aplicar(double x, double y);
    }

    /**
     * Aplica el método de Heun para resolver la EDO y retorna el valor final de y.
     *
     * @param f  función f(x, y)
     * @param x0 valor inicial de x
     * @param y0 valor inicial de y
     * @param h  paso
     * @param n  número de pasos
     * @return valor final de y después de n pasos
     */
    public static double heun(Funcion f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        for (int i = 1; i <= n; i++) {
            double k1 = f.aplicar(x, y);
            double k2 = f.aplicar(x + h, y + h * k1);
            y = y + (h / 2.0) * (k1 + k2);
            x = x + h;
        }

        return y;
    }

    /**
     * Método principal con ejemplo de uso.
     * Resuelve dy/dx = y con y(0) = 1, h = 0.2, n = 5
     */
   public static void main(String[] args) {
    // Definición de la función f(x, y) = -3y + 6
    Funcion f = (x, y) -> -3 * y + 6;
    
    // Parámetros iniciales de la EDO
    double x0 = 0.0;  // x inicial
    double y0 = 0.0;  // y inicial
    double h = 0.1;   // paso
    int n = 8;        // número de pasos
    
    // Ejecutar el método de Heun
    double resultadoFinal = heun(f, x0, y0, h, n);
    System.out.printf("Resultado final en x = %.2f: y ≈ %.6f\n", x0 + h * n, resultadoFinal);
}
    }
```
## Ejercicios Prácticos
## Ejercicio 1
Resuelve la ecuación diferencial  
$\frac{dy}{dx} = 2y $, con condición inicial y(0) = 1, usando paso h = 0.2 y 5 iteraciones.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Heun/Ejercicio%201.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

El método de Heun aproxima la solución calculando dos pendientes en cada paso: una al inicio del intervalo y otra al final, luego promedia ambas para obtener una mejor estimación. En este caso, la función dy/dx = 2y genera un crecimiento exponencial donde la tasa de cambio siempre es el doble del valor actual, lo que produce una curva que se acelera constantemente hacia arriba. El resultado numérico y ≈ 7.100821 muestra cómo el método captura eficientemente este comportamiento exponencial mediante aproximaciones lineales sucesivas.

## Ejercicio 2
Resuelve la ecuación diferencial  
$\frac{dy}{dx} = -0.5y + x$, con  condición inicial y(0) = 2, usando paso h = 0.25 y 4 iteraciones.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Heun/Ejercicio%202.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

El método de Heun maneja ecuaciones con múltiples términos evaluando cómo cada componente afecta la pendiente en cada paso. Aquí tenemos un término negativo (-0.5y) que reduce el valor y uno positivo (x) que lo incrementa, creando una competencia entre fuerzas opuestas. El método calcula estas interacciones al inicio y final de cada intervalo, promediando los efectos para lograr mayor precisión. El resultado y ≈ 1.644393 refleja el equilibrio dinámico entre estos dos factores a lo largo del intervalo de integración.

## Ejercicio 3
Resuelve la ecuación diferencial  
$\frac{dy}{dx} = -3y + 6$, con  condición inicial y(0) = 0, usando paso h = 0.1 y 8 iteraciones.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Heun/Ejercicio%203.png" width="30%" alt="Solución Ejercicio 2">

**Análisis** 

El método de Heun rastrea efectivamente sistemas que tienden hacia un valor de equilibrio mediante su técnica de doble evaluación de pendientes. La ecuación dy/dx = -3y + 6 tiene un punto de equilibrio en y = 2, donde la derivada se vuelve cero. Partiendo desde y = 0, el sistema inicialmente crece rápido pero gradualmente se desacelera conforme se acerca al equilibrio. El resultado y ≈ 1.810207 en x = 0.8 muestra que aún no ha alcanzado completamente el valor límite, pero el método captura correctamente esta aproximación asintótica.

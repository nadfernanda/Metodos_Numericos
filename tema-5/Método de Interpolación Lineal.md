## Definición
El método de interpolación lineal es una forma sencilla y directa de estimar un valor desconocido que se encuentra entre dos valores conocidos. La idea principal es asumir que existe una relación lineal (una línea recta) entre los dos puntos de datos conocidos y usar esa línea para predecir el valor en el punto intermedio.

Imagina que tienes dos puntos en una gráfica:

- Punto 1: $(x_0, y_0)$
  
- Punto 2: $(x_1, y_1)$

Si quieres encontrar el valor de $y$ para un valor de $x$ que está entre $x_0$ y $x_1$, la interpolación lineal traza una línea recta que conecta estos dos puntos y luego encuentra el valor de $y$ en esa línea para el $x$ deseado.

## Algoritmo 
1. Toma dos puntos conocidos: $(x_0, y_0)$ y $(x_1, y_1)$.
   
2. Elige un valor de $x$ que esté entre $x_0$ y $x_1$.
   
3. Aplica la fórmula:
   
   $$f(x) = y_0 + \frac{(y_1 - y_0)}{(x_1 - x_0)} \cdot (x - x_0)$$

4. El resultado es una estimación de $f(x)$.

### Implementación en Java
```java
/**
 * Método de Interpolación Lineal
 * 
 * La interpolación lineal estima el valor de una función f(x)
 * dentro de dos puntos conocidos (x0, y0) y (x1, y1).
 * Se asume que el cambio entre los puntos es lineal.
 */
public class InterpolacionLineal {

    /**
     * Calcula la interpolación lineal en un punto x
     * @param x0 Primer valor de x conocido
     * @param y0 Valor de la función en x0
     * @param x1 Segundo valor de x conocido
     * @param y1 Valor de la función en x1
     * @param x Punto donde se desea interpolar
     * @return Valor aproximado de f(x)
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Aplicar la fórmula de interpolación lineal:
        // f(x) = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
        double resultado = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double x0 = 2.0, y0 = 4.0;
        double x1 = 5.0, y1 = 10.0;

        // Punto a interpolar
        double x = 3.5;

        // Cálculo de la interpolación
        double valorInterpolado = interpolar(x0, y0, x1, y1, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1

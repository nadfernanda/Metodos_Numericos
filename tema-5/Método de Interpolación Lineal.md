## Definición
El método de interpolación lineal es una forma sencilla y directa de estimar un valor desconocido que se encuentra entre dos valores conocidos. La idea principal es asumir que existe una relación lineal (una línea recta) entre los dos puntos de datos conocidos y usar esa línea para predecir el valor en el punto intermedio.

## Algoritmo 
1. Toma dos puntos conocidos: $(x_0, y_0)$ y $(x_1, y_1)$.
   
2. Elige un valor de $x$ que esté entre $x_0$ y $x_1$.
   
3. Aplica la fórmula:
   
   $$f(x) = y_0 + \frac{(y_1 - y_0)}{(x_1 - x_0)} \cdot (x - x_0)$$

4. El resultado es una estimación de $f(x)$.

### Implementación en Java
```java
/**
 * Clase que implementa el método de interpolación lineal.
 * Este método aproxima el valor de f(x) con base en dos puntos conocidos (x0, y0) y (x1, y1).
 * Se asume que la función es lineal entre esos dos puntos.
 */
public class InterpolacionLineal {

    /**
     * Calcula la interpolación lineal para un valor x dado.
     *
     * Fórmula utilizada:
     *      f(x) ≈ y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
     *
     * @param x0 Punto conocido en el eje x
     * @param y0 Valor de f(x0)
     * @param x1 Otro punto conocido en el eje x
     * @param y1 Valor de f(x1)
     * @param x  Punto en el que se quiere estimar f(x)
     * @return   Valor estimado de f(x)
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Calculamos la pendiente (y1 - y0) / (x1 - x0)
        // y usamos la fórmula para estimar f(x)
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Valores conocidos
        double x0 = 1.0;
        double y0 = 2.0;
        double x1 = 3.0;
        double y1 = 6.0;
        
        // Valor de x para el que se quiere estimar f(x)
        double x = 2.0;
        
        // Aplicar la interpolación
        double resultado = interpolar(x0, y0, x1, y1, x);
        
        // Mostrar el resultado
        System.out.printf("El valor estimado de f(%.2f) es: %.4f\n", x, resultado);  
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1

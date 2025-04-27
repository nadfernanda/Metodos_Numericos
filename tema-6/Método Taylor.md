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

public class MetodoTaylor {

    /**
     * Método que resuelve una ecuación diferencial usando el método de Taylor de orden 2.
     *
     * @param f     Función que representa la derivada primera dy/dx
     * @param df_dx Función que representa la derivada segunda d²y/dx²
     * @param x0    Valor inicial de x
     * @param y0    Valor inicial de y
     * @param h     Tamaño de paso
     * @param n     Número de pasos a realizar
     */
    public static void taylorOrden2(BiFunction<Double, Double, Double> f, 
                                    BiFunction<Double, Double, Double> df_dx, 
                                    double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.5f\t %.5f%n", x, y);

        for (int i = 1; i <= n; i++) {
            // Fórmula de Taylor de orden 2:
            // y(i+1) = y(i) + h * f(x(i), y(i)) + (h^2 / 2) * d²y/dx²(x(i), y(i))
            double dy = f.apply(x, y);
            double d2y = df_dx.apply(x, y);

            y = y + h * dy + (h * h / 2.0) * d2y;
            x = x + h;

            // Imprimimos el resultado de cada paso
            System.out.printf("%d\t %.5f\t %.5f%n", i, x, y);
        }
    }

    public static void main(String[] args) {
        // Definimos la primera derivada dy/dx como función
        BiFunction<Double, Double, Double> derivadaPrimera = (x, y) -> x + y; // Ejemplo: dy/dx = x + y

        // Definimos la segunda derivada d²y/dx²
        BiFunction<Double, Double, Double> derivadaSegunda = (x, y) -> 1 + (x + y); 
        // Para el ejemplo: d²y/dx² = 1 + (x + y) (esto depende del problema)

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Llamamos al método de Taylor
        taylorOrden2(derivadaPrimera, derivadaSegunda, x0, y0, h, n);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1

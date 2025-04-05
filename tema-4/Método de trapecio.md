## Definición
La regla del trapecio es un método de integración numérica que sirve para aproximar el valor de 
una integral definida. Se basa en reemplazar la curva de la función por segmentos de línea recta que
forman trapecios, y luego calcula el área de esos trapecios.
Para una función f(x) definida en el intervalo [a,b], la integral aproximada se calcula como el promedio
de los valores de la función en los extremos multiplicado por el ancho del intervalo:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla%20trapecio%201.png" width="30%" alt="Fórmula simple">

Si el intervalo [a,b] se divide en n subintervalos de igual tamaño h=b-a/n, la fórmula generalizada es:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla%20trapecio%20compuesta.png" width="30%" alt="Fórmula compuesta">
donde xi = a + i * h para i = 0,1,…,n.

## Algoritmo 
Claro, aquí tienes el texto sin saltos de renglón innecesarios, fácil de copiar y pegar:

**Algoritmo (Pasos)**

**Para la regla del trapecio compuesta:**
1. Definir los valores de $a$, $b$, y el número de subintervalos $n$.
2. Calcular la longitud del paso: $h = \frac{b-a}{n}$.
3. Calcular los puntos $x_i = a + i h$ para $i = 0, 1, \ldots, n$.
4. Evaluar la función $f(x)$ en cada $x_i$.
5. Aplicar la fórmula del trapecio compuesta:
   Aproximación $= \frac{h}{2} [f(x_0) + 2(f(x_1) + f(x_2) + \cdots + f(x_{n-1})) + f(x_n)]$
6. Mostrar el resultado como la aproximación de la integral.

### Implementación en Java
```java
public class ReglaTrapecio {

    /**
     * Representa la función a integrar: f(x) = e^(-x^2)
     * 
     * @param x valor en el que se evalúa la función
     * @return resultado de f(x)
     */
    public static double funcion(double x) {
        return Math.exp(-Math.pow(x, 2));
    }

    /**
     * Aplica la regla del trapecio compuesta para aproximar la integral definida
     * 
     * Fórmula: (h/2) * [f(x0) + 2*f(x1) + 2*f(x2) + ... + 2*f(x_{n-1}) + f(xn)]
     * 
     * @param a límite inferior del intervalo
     * @param b límite superior del intervalo
     * @param n número de subintervalos
     * @return aproximación de la integral
     */
    public static double reglaTrapecioCompuesta(double a, double b, int n) {
        double h = (b - a) / n; // Tamaño de cada subintervalo
        double suma = funcion(a) + funcion(b); // f(x0) + f(xn)

        // Suma de los términos con coeficiente 2: f(x1), f(x2), ..., f(x_{n-1})
        for (int i = 1; i < n; i++) {
            double xi = a + i * h; // Punto xi dentro del intervalo
            suma += 2 * funcion(xi);
        }

        return (h / 2) * suma; // Aplicación final de la fórmula
    }

    public static void main(String[] args) {
        double a = 0;    // Límite inferior de integración
        double b = 1;    // Límite superior de integración
        int n = 6;       // Número de subintervalos

        // Calculamos la aproximación usando la regla del trapecio compuesta
        double resultado = reglaTrapecioCompuesta(a, b, n);

        // Imprimimos el resultado con 4 decimales
        System.out.printf("Aproximación de la integral: %.4f%n", resultado);
    }
}
```

## Ejercicios Prácticos



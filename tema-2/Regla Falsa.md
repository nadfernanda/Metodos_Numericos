## Definición
es una técnica numérica que se utiliza para encontrar las raíces de una ecuación no lineal. Este método es una mejora del método de 
bisección y combina características del método de secantes y de bisección, buscando acortar el intervalo donde se encuentra la raíz.
se basa en el principio de que, dado un intervalo [a,b] tal que la función f(x) cambia de signo en los extremos (es decir, f(a)⋅f(b)<0), entonces existe al menos una raíz en el intervalo. El algoritmo mejora el método de bisección al calcular una aproximación a la raíz usando una línea recta (la secante) en lugar de un punto medio.

## Algoritmo
1. **Inicialización:**

Se toma un intervalo $[a, b]$ tal que $f(a) \cdot f(b) < 0$. Si esto no se cumple, no se puede aplicar el método.

2. **Cálculo del punto de intersección:**
   
Calculamos el valor de la raíz aproximada $c$ utilizando la fórmula de la secante:
   
   $$c = b - \frac{f(b) \cdot (b - a)}{f(b) - f(a)}$$
   
   Aquí, $c$ es el valor en el que la secante cruza el eje $x$.

3. **Evaluación de la función en $c$:**
   
 Se evalúa la función $f(c)$.

4. **Comprobación de convergencia:**
   
   * Si $f(c) = 0$, entonces $c$ es la raíz exacta y el proceso termina.
     
   * Si $|f(c)| < \epsilon$, donde $\epsilon$ es la tolerancia deseada, se considera que se ha alcanzado una aproximación suficientemente precisa y el algoritmo termina.

5. **Actualización del intervalo:**
   
   * Si $f(a) \cdot f(c) < 0$, entonces la raíz está en el intervalo $[a, c]$, por lo que se actualiza $b = c$.
     
   * Si $f(c) \cdot f(b) < 0$, entonces la raíz está en el intervalo $[c, b]$, por lo que se actualiza $a = c$.

6. **Repetir:**
Se repiten los pasos 2 a 5 hasta que se cumpla una de las condiciones de terminación (como la convergencia).
   
### Implementación en Java
```java
public class ReglaFalsa {

    /**
     * Función matemática a evaluar.
     * Puedes cambiar esta función para probar con diferentes ejercicios.
     * Ejemplo actual: f(x) = x^3 - x - 2
     */
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    public static void main(String[] args) {
        // Limites del intervalo
        double a = 1;   // Límite inferior
        double b = 2;   // Límite superior

        // Tolerancia para el valor de la raíz
        double tolerancia = 0.0001;

        // Número máximo de iteraciones para evitar bucles infinitos
        int maxIteraciones = 100;

        // Variable para contar las iteraciones
        int iteraciones = 0;

        // Variable para almacenar el punto medio (estimación de la raíz)
        double c = a;

        // Verificar si el método se puede aplicar: debe haber cambio de signo en f(a) y f(b)
        if (f(a) * f(b) >= 0) {
            System.out.println("No se puede aplicar el método: no hay cambio de signo en el intervalo.");
            return; // Terminar el programa si no se puede aplicar
        }

        // Bucle principal del método de la regla falsa
        while (Math.abs(f(c)) > tolerancia && iteraciones < maxIteraciones) {

            // Aplicamos la fórmula de la regla falsa:
            // c = b - f(b) * (a - b) / (f(a) - f(b))
            c = b - (f(b) * (a - b)) / (f(a) - f(b));

            // Reemplazamos uno de los extremos del intervalo dependiendo del signo
            if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }

            // Aumentamos el contador de iteraciones
            iteraciones++;
        }

        // Imprimir la raíz aproximada con 4 decimales
        System.out.printf("Raíz aproximada: %.4f\n", c);
        System.out.println("Iteraciones realizadas: " + iteraciones);
    }
}
```

## Ejercicios Prácticos
## Ejercicio 1 
Dada la función:

f(x) = x^2 - 4  en el intervalo [0,3]

**Solución con algoritmo de java**

<img src="aaa" width="35%" alt="Solución Ejercicio 1">

**Análisis**


## Ejercicio 2
Dada la función:

f(x) = x^3 - x - 2  en el intervalo [1,2]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Bisecci%C3%B3n/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

La función $f(x) = \cos(x) - x$ es continua y suave en el intervalo $[0, 1]$, y tiene la propiedad de que sus valores cambian de signo en este intervalo. Evaluando la función, encontramos que $f(0) = 1$ y $f(1) = -0.459$, lo que garantiza, de acuerdo con el teorema de Bolzano, la existencia de una raíz en el intervalo $[0, 1]$. Esta raíz es la solución de la ecuación $\cos(x) = x$, que es conocida y se encuentra en torno a 0.7391. El método de bisección es adecuado para este tipo de problemas, ya que logra una aproximación precisa a la solución deseada mediante la iteración y el ajuste del intervalo de búsqueda.

## Ejercicio 3
Dada la función:

f(x) = x^2 - 4  en el intervalo [0,3]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Bisecci%C3%B3n/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

La función $f(x) = x^2 - 4$ es un polinomio cuadrático, lo que significa que es continua y diferenciable en todo su dominio. En el intervalo $[0, 3]$, se evalúa que $f(0) = -4$ y $f(3) = 5$, lo que implica que existe un cambio de signo entre estos dos puntos, garantizando la presencia de una raíz real en este intervalo. La raíz de esta ecuación es conocida y se encuentra en $x = 2$, lo que convierte a este ejercicio en un caso simple y claro para el método de bisección. Al aplicar el algoritmo, el programa debería encontrar la raíz con gran precisión, cercana a 2.0000.

## Ejercicio 4
Dada la función:

f(x) = e^-x - x  en el intervalo [0,1]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Bisecci%C3%B3n/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**


## Ejercicio 5 (sin solución)
Dada la función:

f(x) = x^2 + 4  en el intervalo [-2,2]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Bisecci%C3%B3n/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

La función $f(x) = x^2 + 4$ nunca cambia de signo en el intervalo $[-2, 2]$, ya que siempre es positiva para cualquier valor de $x$. Es una parábola que se abre hacia arriba con un valor mínimo de 4 en $x = 0$. Por lo tanto, no existe ninguna raíz real en el intervalo, ya que la función no cruza el eje $x$. Al intentar aplicar el método de bisección, el algoritmo detectará que no hay un cambio de signo entre $f(-2) = 8$ y $f(2) = 8$, lo que indica que no se puede aplicar el método en este caso. La salida del programa reflejará correctamente que no es posible realizar la búsqueda de la raíz.

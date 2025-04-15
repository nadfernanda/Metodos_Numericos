## Definición
El método de la regla falsa (también conocido como método de la falsi) es una técnica numérica que se utiliza para encontrar las raíces de una ecuación no lineal. Este método es una mejora del método de bisección y combina características del método de secantes y de bisección, buscando acortar el intervalo donde se encuentra la raíz. Se basa en el principio de que, dado un intervalo [a,b] tal que la función f(x) cambia de signo en los extremos (es decir, f(a)⋅f(b)<0), entonces existe al menos una raíz en el intervalo. El algoritmo mejora el método de bisección al calcular una aproximación a la raíz usando una línea recta (la secante) en lugar de un punto medio.

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

f(x) = f(x) = x^3 - 2x - 5  en el intervalo [2,3]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Regla%20Falsa/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

Este es un caso clásico con una función cúbica que cruza el eje x exactamente una vez en ese intervalo. Como la función es continua y cambia de signo entre 2 y 3, el método converge rápidamente. En solo 6 iteraciones, se alcanza una raíz aproximada de 2.0945, lo que es bastante eficiente.
El comportamiento de la función favorece a la regla falsa, ya que la pendiente de la línea secante no se aplana demasiado rápido. La convergencia es suave y progresiva porque la raíz está centrada dentro del intervalo.


## Ejercicio 2
Dada la función:

f(x) = cos(x) - x en el intervalo [0,1]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Regla%20Falsa/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

Esta función es conocida por tener una raíz cerca de 0.7391, el punto fijo de cos(x). La curva es bastante suave y casi lineal en ese tramo, lo cual beneficia mucho al método de la regla falsa, que depende de líneas secantes.
La convergencia es rápida (solo 4 iteraciones), en parte porque el punto de corte de la secante se aproxima bien desde el inicio. Esto lo convierte en un ejemplo ideal de una función no polinómica donde el método también se desempeña de forma excelente.

## Ejercicio 3
Dada la función:

f(x) = e^x - 3x en el intervalo [0,1]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Regla%20Falsa/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

Aquí la función combina crecimiento exponencial y decrecimiento lineal. La raíz cerca de 0.6191 es un buen ejemplo de una intersección entre una curva creciente y una recta.
El método funciona bien porque la función tiene un cambio de curvatura suave, y la secante corta al eje con bastante precisión desde las primeras iteraciones. Nuevamente, en 8 pasos se alcanza la tolerancia deseada. Esto demuestra que la regla falsa es eficaz incluso en funciones con exponentes, siempre que no haya comportamientos extremos (como asintotas o curvas muy planas).

## Ejercicio 4 
Dada la función:

f(x) = x^2 - 9  en el intervalo [2,4]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Regla%20Falsa/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**

Este ejercicio es bastante sencillo y directo. La función f(x) = x² - 9 es una parábola que corta el eje x en x = 3. El intervalo 2,4 está centrado alrededor de esa raíz. El método de la regla falsa se desempeña muy bien aquí. Al ser una función cuadrática, el cambio de signo entre los valores de f(2) = -5 y f(4) = 7 es claro, y la secante converge rápidamente hacia la raíz. Solo son necesarias 6 iteraciones para encontrar la raíz aproximada de 3.0000, lo que muestra que el método es eficaz y preciso en este caso.
La convergencia es rápida porque la función no tiene ninguna complejidad, es una parábola simple con una única raíz real dentro del intervalo. La secante mueve el intervalo con rapidez hacia el valor de la raíz, lo que demuestra la efectividad de este método para funciones polinómicas sencillas.

## Ejercicio 5 (sin solución)
Dada la función:

f(x) = x^2 + 4 en el intervalo [1,3]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Regla%20Falsa/Ejercicio%205.png" width="50%" alt="Solución Ejercicio 5">

**Análisis**

Este ejercicio es un ejemplo clave de un caso sin solución real en el intervalo. La función f(x) = x² + 4 no tiene raíces reales, ya que siempre produce valores positivos para cualquier x. En este caso específico, f(1) = 5 y f(3) = 13, ambos positivos, por lo que no hay cambio de signo entre los valores de f(a) y f(b). Cuando el método de la regla falsa se ejecuta, verifica si hay un cambio de signo entre f(a) y f(b). Como no hay tal cambio de signo en este caso, el programa detiene su ejecución y muestra el mensaje de que no hay solución, gracias a la modificación que agregamos en el código. Esto es precisamente lo que debería ocurrir, ya que no se puede aplicar el método si no se cumple la condición de cambio de signo, lo que significa que no se puede encontrar una raíz en el intervalo dado.

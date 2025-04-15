## Definición
El método de la secante es un algoritmo numérico utilizado para encontrar una raíz real de una función f(x). A diferencia del método de Newton-Raphson, no requiere el cálculo de la derivada de la función, lo que lo hace útil cuando la derivada es difícil de obtener.
En lugar de usar la tangente (como en Newton), este método aproxima la derivada utilizando una secante que pasa por dos puntos cercanos en la curva de la función.

## Algoritmo
1. **Elegir dos puntos iniciales** $x_0$ y $x_1$ cercanos a la raíz buscada.
   
2. **Calcular la función** en esos puntos: $f(x_0)$ y $f(x_1)$.
   
3. **Aplicar la fórmula** de iteración para obtener una nueva aproximación $x_{n+1}$:
   
   $$x_{n+1} = x_n - \frac{f(x_n)(x_n - x_{n-1})}{f(x_n) - f(x_{n-1})}$$

   (Esta fórmula surge de aproximar la derivada usando diferencias finitas).
   
4. **Verificar** el criterio de parada:
   
   - Si $|x_{n+1} - x_n| < \text{tolerancia}$ o $|f(x_{n+1})| < \text{tolerancia}$, se detiene.
     
   - Si no, se repite el proceso con $x_n$ y $x_{n+1}$.

### Implementación en Java
```java
public class MetodoSecante {

    /**
     * Función f(x) para la cual se busca la raíz.
     * 
     * @param x El valor de entrada para la función.
     * @return El valor de la función evaluada en x.
     */
    public static double f(double x) {
        return x * x - 4; // Modifica esta línea con la función que deseas
    }

    /**
     * Implementación del método de la secante para encontrar la raíz de la función f(x).
     * 
     * @param x0 El primer valor inicial.
     * @param x1 El segundo valor inicial.
     * @param epsilon El umbral de tolerancia para determinar la convergencia.
     * @param maxIter El número máximo de iteraciones permitidas.
     */
    public static void metodoSecante(double x0, double x1, double epsilon, int maxIter) {
        double x2;  // Variable para almacenar el valor de la nueva aproximación de la raíz.
        int iter = 0;  // Contador de iteraciones.

        // Bucle para realizar las iteraciones del método de la secante
        while (iter < maxIter) {
            // Evaluar la función f(x) en los valores actuales x0 y x1
            double f0 = f(x0);
            double f1 = f(x1);

            // Calcular el siguiente valor de la raíz usando la fórmula de la secante
            x2 = x1 - f1 * (x1 - x0) / (f1 - f0);

            // Verificar si la diferencia entre las dos iteraciones consecutivas es menor que epsilon
            // Si la diferencia es suficientemente pequeña, se considera que se ha encontrado la raíz
            if (Math.abs(x2 - x1) < epsilon) {
                System.out.printf("Raíz aproximada: %.4f\n", x2);
                System.out.printf("Número de iteraciones: %d\n", iter + 1);
                return;  // Se termina el algoritmo ya que la convergencia se ha alcanzado.
            }

            // Actualizar los valores de x0 y x1 para la siguiente iteración
            x0 = x1;
            x1 = x2;

            // Incrementar el contador de iteraciones
            iter++;
        }

        // Si se llega al máximo número de iteraciones sin haber encontrado la raíz, mostrar mensaje de error
        System.out.println("El método no convergió en el número máximo de iteraciones.");
    }

    /**
     * Función principal que inicia el proceso del método de la secante.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Valores iniciales
        double x0 = 1.0;  // Primer valor inicial
        double x1 = 2.0;  // Segundo valor inicial
        double epsilon = 1e-6;  // Tolerancia para la convergencia
        int maxIter = 100;  // Número máximo de iteraciones

        // Llamar al método de la secante para encontrar la raíz de la función
        metodoSecante(x0, x1, epsilon, maxIter);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1 
Dada la función:

f(x) = e^(-x) - x

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Secante/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

La función exponencial f(x) = e^(-x) - x combina el decaimiento exponencial con una función lineal, creando un único punto de intersección con el eje x. Este tipo de funciones aparece frecuentemente en modelos de crecimiento poblacional y fenómenos de decaimiento. Con valores iniciales x₀ = 0.0 y x₁ = 1.0, el método de la secante converge a la raíz x ≈ 0.5671 en aproximadamente 5 iteraciones. El método funciona particularmente bien para esta función debido a su comportamiento suave y monótono, con una derivada que varía gradualmente, permitiendo que las aproximaciones lineales de la secante sean bastante precisas en cada iteración.

## Ejercicio 2
Dada la función:

f(x) = cos(x) - x

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Secante/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

La función trigonométrica f(x) = cos(x) - x presenta un desafío interesante al método de la secante al buscar el punto fijo de la función coseno. Este problema tiene importantes aplicaciones en análisis numérico y teoría de sistemas dinámicos. Usando x₀ = 0.5 y x₁ = 1.0 como valores iniciales, el método converge eficientemente a la raíz x ≈ 0.7391 en aproximadamente 5 iteraciones. La eficacia del método en este caso se debe a que la función es suave, tiene una derivada bien comportada cerca de la raíz, y los valores iniciales elegidos proporcionan una buena aproximación inicial de la pendiente en la región de interés.

## Ejercicio 3
Dada la función:

f(x) = x^3 - 2x - 5

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Secante/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

La función cúbica f(x) = x³ - 2x - 5 representa un caso ideal para el método de la secante debido a su comportamiento continuo y monótono en la región de interés. Con valores iniciales de x₀ = 2.0 y x₁ = 3.0, el método aprovecha la buena aproximación lineal que proporciona la secante entre estos puntos, permitiendo converger rápidamente a la raíz x ≈ 2.0946 en aproximadamente 6 iteraciones. El éxito en este caso se debe a la combinación de una función suave con derivada siempre creciente cerca de la raíz y valores iniciales adecuadamente posicionados a ambos lados de la solución.

## Ejercicio 4
Dada la función:

f(x) = (x² - 4)/(x - 3)

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Secante/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**

 La función racional f(x) = (x² - 4)/(x - 3) representa un caso instructivo para el método de la secante debido a su estructura algebraica particular. Esta función puede ser simplificada a f(x) = x + 3 para todo x ≠ 3, lo que revela su raíz exacta en x = -2. Con valores iniciales x₀ = -3.0 y x₁ = -2.0, el método converge rápidamente en aproximadamente 4 iteraciones. Lo interesante de este ejercicio es que introduce una discontinuidad removible en x = 3, donde la función no está definida, ilustrando la importancia de seleccionar adecuadamente los valores iniciales lejos de singularidades. Este caso demuestra cómo el método de la secante puede ser efectivo incluso para funciones racionales cuando se analizan correctamente sus propiedades analíticas y se eligen puntos de partida apropiados.

## Ejercicio 5 (sin solución)
Dada la función:

f(x) = x^2 + 1

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Secante/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

La función f(x) = x² + 1 ilustra una limitación fundamental del método de la secante, ya que intenta encontrar un valor de x donde f(x) = 0, pero esta función siempre es positiva con un valor mínimo de 1 cuando x = 0. El método intentará sistemáticamente aproximarse a una raíz inexistente, oscilando entre diferentes valores o alejándose progresivamente, sin poder converger. Este comportamiento es típico cuando se aplican métodos de búsqueda de raíces a funciones que no cruzan el eje x, demostrando la importancia de analizar previamente si el problema matemático tiene solución antes de aplicar algoritmos iterativos.

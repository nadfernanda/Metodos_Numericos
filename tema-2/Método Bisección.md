## Definición
El método de bisección es un procedimiento numérico para encontrar una raíz de una función continua f(x) en un intervalo [a,b] 
donde se cumple que f(a)⋅f(b)<0; es decir, la función cambia de signo, lo que garantiza que hay al menos una raíz en ese intervalo 
(por el teorema del valor intermedio). Este método consiste en dividir el intervalo en dos partes iguales y seleccionar la subparte donde sigue existiendo un cambio de signo, repitiendo el proceso hasta que el intervalo sea lo suficientemente pequeño (es decir, se alcance la precisión deseada).

## Algoritmo
1. **Elegir el intervalo inicial** $[a, b]$ tal que $f(a) \cdot f(b) < 0$.

2. **Calcular el punto medio:**

   $$c = \frac{a + b}{2}$$

3. **Evaluar $f(c)$:**
   
   * Si $f(c) = 0$, entonces $c$ es la raíz exacta.
     
   * Si $f(a) \cdot f(c) < 0$, la raíz está en $[a, c]$, entonces se reemplaza $b$ por $c$.
     
   * Si $f(c) \cdot f(b) < 0$, la raíz está en $[c, b]$, entonces se reemplaza $a$ por $c$.

4. **Verificar el criterio de parada:**
   
   * Si el valor de $|b - a| < \epsilon$ (donde $\epsilon$ es la tolerancia o error deseado), detener el proceso. Se considera que la raíz es aproximadamente $c$.
     
   * Si no, volver al paso 2.

### Implementación en Java
```java
public class MetodoBiseccion {

    /**
     * Función que queremos encontrar la raíz.
     * Puedes cambiar esta función para probar con otros ejercicios.
     * Ejemplo actual: f(x) = x^3 - x - 2
     */
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que aplica el algoritmo de bisección.
     * @param a          Límite inferior del intervalo
     * @param b          Límite superior del intervalo
     * @param tolerancia Error máximo permitido (cuán precisa queremos la raíz)
     * @param maxIter    Número máximo de iteraciones permitidas
     */
    public static void biseccion(double a, double b, double tolerancia, int maxIter) {
        // Verificar si hay cambio de signo: f(a) * f(b) debe ser negativo
        if (f(a) * f(b) >= 0) {
            System.out.println("No se puede aplicar el método: no hay cambio de signo en el intervalo.");
            return; // Termina el método porque no hay garantía de raíz
        }

        double c = a; // Variable para almacenar el punto medio
        int iteracion = 0; // Contador de iteraciones

        // Repetimos hasta alcanzar la tolerancia deseada o llegar al límite de iteraciones
        while ((b - a) / 2 > tolerancia && iteracion < maxIter) {
            c = (a + b) / 2; // Calcular punto medio del intervalo

            // Si f(c) es cero exacto, encontramos la raíz
            if (f(c) == 0.0) {
                break;
            }
            // Si f(c) tiene signo distinto a f(a), la raíz está en [a, c]
            else if (f(a) * f(c) < 0) {
                b = c;
            }
            // Si no, la raíz está en [c, b]
            else {
                a = c;
            }

            iteracion++; // Aumentamos el número de iteraciones
        }

        // Mostrar el resultado con 4 decimales
        System.out.printf("Raíz aproximada: %.4f\n", c);
        System.out.println("Iteraciones realizadas: " + iteracion);
    }

    public static void main(String[] args) {
        // Definimos el intervalo donde buscamos la raíz
        double a = 1;              // Límite inferior
        double b = 2;              // Límite superior

        // Precisión deseada: mientras más pequeña, más precisa
        double tolerancia = 1e-6;

        // Número máximo de intentos para encontrar la raíz
        int maxIter = 100;

        // Llamamos al método de bisección
        biseccion(a, b, tolerancia, maxIter);
    }
}
```

## Ejercicios Prácticos
## Ejercicio 1 
Dada la función:

f(x) = x^3 - x + 2  en el intervalo [1,2]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Bisecci%C3%B3n/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

La función $f(x) = x^3 - x - 2$ es un polinomio de tercer grado, lo que garantiza su continuidad en todo su dominio. En el intervalo $[1, 2]$, evaluamos $f(1) = -2$ y $f(2) = 4$, lo que indica que el valor de la función cambia de signo entre estos dos puntos, y por lo tanto, según el teorema de Bolzano, existe al menos una raíz en este intervalo. El método de bisección es apropiado porque funciona con funciones continuas que cambian de signo. A medida que se divide el intervalo repetidamente, se acercará cada vez más a la raíz real, que se encuentra cerca de 1.5214.

## Ejercicio 2
Dada la función:

f(x) = cos(x) - x2  en el intervalo [0,1]

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

La función $f(x) = e^{-x} - x$ es continua y suavemente decreciente en el intervalo $[0, 1]$, lo que asegura que la búsqueda de la raíz a través de la bisección será efectiva. Evaluando en los extremos, tenemos $f(0) = 1$ y $f(1) \approx -0.632$, lo que indica un cambio de signo entre estos puntos y, por lo tanto, la existencia de una raíz en el intervalo. Esta raíz es la solución de la ecuación $e^{-x} = x$, un problema clásico de matemáticas aplicadas. Al aplicar el método de bisección, el valor de la raíz se encontrará en torno a 0.5671, con una convergencia rápida debido a la suavidad de la función.

## Ejercicio 5 (sin solución)
Dada la función:

f(x) = x^2 + 4  en el intervalo [-2,2]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Bisecci%C3%B3n/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

La función $f(x) = x^2 + 4$ nunca cambia de signo en el intervalo $[-2, 2]$, ya que siempre es positiva para cualquier valor de $x$. Es una parábola que se abre hacia arriba con un valor mínimo de 4 en $x = 0$. Por lo tanto, no existe ninguna raíz real en el intervalo, ya que la función no cruza el eje $x$. Al intentar aplicar el método de bisección, el algoritmo detectará que no hay un cambio de signo entre $f(-2) = 8$ y $f(2) = 8$, lo que indica que no se puede aplicar el método en este caso. La salida del programa reflejará correctamente que no es posible realizar la búsqueda de la raíz.

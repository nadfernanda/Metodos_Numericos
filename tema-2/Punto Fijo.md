## Definición
El método de punto fijo es un algoritmo iterativo utilizado para encontrar una solución (raíz) de una ecuación no lineal de la forma $f(x) = 0$, reformulándola como $x = g(x)$, donde $g$ es una función de iteración. Un punto fijo $p$ satisface $p = g(p)$, lo que implica que $f(p) = 0$.

## Algoritmo
1. **Transformar la ecuación** $f(x) = 0$ en $x = g(x)$.
   
2. **Elegir un valor inicial** $x_0$ (una aproximación inicial).
   
3. **Establecer un criterio de parada**, como una tolerancia $\epsilon$ o un número máximo de iteraciones.
   
4. **Repetir** los siguientes pasos:
   
   - Calcular $x_{n+1} = g(x_n)$
     
   - Calcular el error: $|x_{n+1} - x_n|$
     
   - Si el error es menor que la tolerancia $\epsilon$, detener.
     
5. **Reportar el resultado** como la raíz aproximada.

### Implementación en Java
```java
public class PuntoFijo {

    /**
     * Función g(x) que define la ecuación en forma de punto fijo: x = 1 - x^3
     * Esta función se obtiene a partir de f(x) = x^3 + x - 1
     */
    public static double g(double x) {
        return 1 - Math.pow(x, 3);
    }

    public static void main(String[] args) {

        // Valor inicial de x
        double x0 = 0.5;

        // Tolerancia o margen de error aceptable
        double tolerancia = 1e-6;

        // Número máximo de iteraciones permitidas
        int maxIteraciones = 100;

        // Variable para guardar el nuevo valor calculado en cada iteración
        double x1;

        // Contador de iteraciones
        int iteracion = 0;

        // Bucle principal del método de punto fijo
        do {
            // Calcular el nuevo valor usando la función g(x)
            x1 = g(x0);
            iteracion++;

            // Verificar si el error entre la iteración actual y la anterior es menor que la tolerancia
            if (Math.abs(x1 - x0) < tolerancia) {
                // Si cumple la condición de convergencia, mostrar resultados
                System.out.printf("Raíz aproximada: %.4f\n", x1);
                System.out.println("Iteración: " + iteracion);
                break;
            }

            // Actualizar el valor de x0 para la siguiente iteración
            x0 = x1;

        } while (iteracion < maxIteraciones);

        // Si se llegó al máximo de iteraciones sin converger
        if (iteracion == maxIteraciones) {
            System.out.println("No se encontró convergencia en " + maxIteraciones + " iteraciones.");
        }
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1 
Dada la ecuación:

 f(x) = cos(x) - x  

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 1">

**Análisis**

La ecuación f(x) = cos(x) - x transformada a x = cos(x) muestra una convergencia relativamente lenta porque la derivada g'(x) = -sin(x) tiene un valor absoluto cercano a 1 en la región de la solución (aproximadamente 0.67 en x ≈ 0.739). Esto hace que cada iteración proporcione una mejora pequeña hacia la solución, requiriendo unas 34 iteraciones para alcanzar la precisión deseada. La función oscila suavemente hacia la solución, con un comportamiento estable pero no rápido.

## Ejercicio 2
Dada la ecuación:

f(x) = x^2 - 5  

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis**

La ecuación f(x) = x² - 5 convertida a x = √5 muestra una convergencia extremadamente rápida porque g(x) = √5 es una función constante con derivada g'(x) = 0, lo que garantiza convergencia inmediata independientemente del valor inicial (siempre que sea razonable). La solución exacta x = 2.2361 se alcanza en solo 2 iteraciones porque cada aplicación de la función siempre devuelve el mismo valor √5, eliminando cualquier error tras la primera iteración. Esta es la convergencia óptima para el método de punto fijo.

## Ejercicio 3 
Dada la ecuación:

f(x) = x^2 - 3x^2 + 2  

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 3">

**Análisis**

La ecuación f(x) = x² - 3x + 2 transformada a x = (x² + 2)/3 converge a la solución x = 1 con velocidad moderada. La derivada g'(x) = 2x/3 tiene valor absoluto |g'(1)| = 2/3 < 1 en la solución, cumpliendo la condición necesaria para convergencia. Este valor, al estar moderadamente alejado de 1, permite una convergencia ni demasiado lenta ni extremadamente rápida, requiriendo aproximadamente 12 iteraciones para alcanzar la precisión deseada. La función se aproxima gradualmente a la solución sin oscilaciones bruscas.

## Ejercicio 4 
Dada la ecuación:

f(x) = x^4 - 7

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 4">

**Análisis**

La ecuación f(x) = x⁴ - 7 convertida a x = ⁷√7 muestra una convergencia instantánea similar al Ejercicio 3. La función g(x) = ⁷√7 es constante con derivada g'(x) = 0, lo que garantiza convergencia en solo 2 iteraciones independientemente del valor inicial (siempre que sea razonable). Al ser una función constante, cada aplicación produce exactamente el mismo valor aproximado 1.6266, eliminando cualquier error después de la primera iteración. Esta es la formulación de punto fijo óptima posible.

## Ejercicio 5 (sin solución)
Dada la ecuación:

f(x) = x^2 + 2 

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 1">

**Análisis**

Esta ecuación no tiene solución real, ya que x² + 2 > 0 para todo valor real de x. La formulación de punto fijo g(x) = √(x² + 2) no puede converger a un punto fijo porque cada iteración produce un valor cada vez mayor. La derivada g'(x) = x/√(x² + 2) se acerca a 1 para valores grandes de x, haciendo que la función se aleje cada vez más lentamente, pero constantemente, de cualquier punto inicial. El método seguirá produciendo una secuencia creciente de valores sin llegar nunca a converger dentro del número máximo de iteraciones establecido.

## Definición
El error iterativo es un concepto utilizado en los métodos numéricos iterativos, donde se estima la diferencia entre dos aproximaciones sucesivas de una solución. En cada paso de la iteración, el error es la diferencia entre el valor calculado en la iteración anterior y el valor calculado en la iteración actual.

Este error se utiliza para determinar cuándo se ha alcanzado una solución suficientemente precisa y cuándo se debe detener el proceso iterativo. El objetivo es minimizar este error en cada iteración hasta que cumpla con un criterio de convergencia predefinido (por ejemplo, cuando el error sea menor que un valor umbral).

## Algoritmo
1. Definir la tolerancia ($\epsilon$): Límite aceptable para el error.
   
2. Obtener $x_n$ y $x_{n-1}$: Valores de la iteración actual y anterior.
   
3. Calcular el error: Usar una de las fórmulas anteriores.
   
4. Verificar convergencia: Si $E < \epsilon$, se detiene el proceso.

### Implementación en Java
```java
/**
 * Clase para calcular el error iterativo en métodos numéricos.
 * Incluye errores absoluto, relativo y porcentual entre iteraciones.
 */
public class ErrorIterativo {

    /**
     * Calcula el error absoluto iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error absoluto iterativo.
     */
    public static double errorAbsolutoIterativo(double xActual, double xAnterior) {
        return Math.abs(xActual - xAnterior);
    }

    /**
     * Calcula el error relativo iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error relativo iterativo.
     * @throws IllegalArgumentException Si xActual es cero (para evitar división por cero).
     */
    public static double errorRelativoIterativo(double xActual, double xAnterior) {
        if (xActual == 0) {
            throw new IllegalArgumentException("xActual no puede ser cero en el error relativo.");
        }
        return Math.abs(xActual - xAnterior) / Math.abs(xActual);
    }

    /**
     * Calcula el error relativo porcentual iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error relativo porcentual iterativo.
     */
    public static double errorPorcentualIterativo(double xActual, double xAnterior) {
        return errorRelativoIterativo(xActual, xAnterior) * 100;
    }

    /**
     * Ejemplo de uso: Aproximación de la raíz cuadrada de 2 usando el método de Newton-Raphson.
     */
    public static void main(String[] args) {
        double tolerancia = 0.0001; // Tolerancia del 0.01%
        double xAnterior = 2.0; // Valor inicial (puede ser cualquier aproximación)
        double xActual = 1.5; // Primera iteración manual

        int iteracion = 1;
        double errorRelPerc;

        System.out.println("Iteración\tAproximación\tError Relativo %");
        System.out.printf("%d\t\t%.6f\t\t-\n", iteracion, xAnterior);

        do {
            iteracion++;
            xAnterior = xActual;
            xActual = (xAnterior + 2.0 / xAnterior) / 2; // Fórmula de Newton-Raphson para √2

            errorRelPerc = errorPorcentualIterativo(xActual, xAnterior);

            System.out.printf("%d\t\t%.6f\t\t%.6f%%\n", iteracion, xActual, errorRelPerc);
        } while (errorRelPerc > tolerancia);

        System.out.printf("\nResultado final: √2 ≈ %.6f (con error < %.4f%%)", xActual, tolerancia);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1 
Queremos sumar 0.1 diez veces y comparar el resultado con el valor esperado (1.0). Calcula el error absoluto en cada paso.

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

El error disminuye a medida que nos acercamos al valor real (1.0).
En la última iteración, el error es 0.0 porque la suma coincide con el valor esperado.

## Ejercicio 2
Aproxima el valor de π (3.1416) usando la fracción 22/7. Calcula el error relativo porcentual.

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

## Ejercicio 3
Usa el método de bisección para aproximar $\sqrt{2}$ (raíz de $f(x) = x^2 - 2$) en el intervalo $[1, 2]$. Calcula el error relativo porcentual en cada iteración hasta que sea menor al $0.1\%$.

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

## Ejercicio 4
Usa el método de bisección para aproximar $\sqrt{2}$ (raíz de $f(x) = x^2 - 2$) en el intervalo $[1, 2]$. Calcula el error relativo porcentual en cada iteración hasta que sea menor al $0.1\%$.

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

## Ejercicio 5
Usa el método de bisección para aproximar $\sqrt{2}$ (raíz de $f(x) = x^2 - 2$) en el intervalo $[1, 2]$. Calcula el error relativo porcentual en cada iteración hasta que sea menor al $0.1\%$.

**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

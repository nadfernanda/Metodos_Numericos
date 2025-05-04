## Definición
El Método de Interpolación de Lagrange es una técnica muy útil para encontrar un polinomio que pasa exactamente por un conjunto de puntos de datos dados. A diferencia de otros métodos de interpolación, como el de Newton con diferencias divididas, la fórmula de Lagrange construye el polinomio directamente a partir de los puntos, sin necesidad de calcular diferencias.

La idea principal detrás del método de Lagrange es construir una serie de polinomios "base", uno para cada punto de dato. Cada uno de estos polinomios base tiene la propiedad de ser igual a 1 en su correspondiente punto de dato y 0 en todos los demás puntos de dato. Al combinar estos polinomios base de manera adecuada, ponderados por los valores de y de los puntos de dato, se obtiene el polinomio interpolante final.

## Algoritmo 
1. Toma $n$ puntos: $(x_0, y_0), (x_1, y_1), ..., (x_{n-1}, y_{n-1})$.

2. Para cada punto $i$, construye su polinomio base de Lagrange:

   $$L_i(x) = \prod_{j=0, j \neq i}^{n-1} \frac{(x - x_j)}{(x_i - x_j)}$$

3. Calcula:

   $$P(x) = \sum_{i=0}^{n-1} y_i \cdot L_i(x)$$

4. Evalúa $P(x)$ para obtener el resultado.

### Implementación en Java
```java
/**
 * Método de Interpolación de Lagrange
 * 
 * Este método construye un polinomio que pasa exactamente por todos los puntos dados.
 * Aproxima el valor de una función f(x) para un valor específico de x
 * usando los puntos conocidos (xi, yi).
 */
public class InterpolacionLagrange {

    /**
     * Calcula la interpolación de Lagrange en un punto x
     * @param xPuntos Arreglo con los valores de x conocidos
     * @param yPuntos Arreglo con los valores de f(x) correspondientes a cada x
     * @param x Valor en el cual se desea interpolar
     * @return Valor aproximado de f(x) usando el polinomio de Lagrange
     */
    public static double interpolar(double[] xPuntos, double[] yPuntos, double x) {
        int n = xPuntos.length;
        double resultado = 0.0;

        // Recorrer cada término del polinomio de Lagrange
        for (int i = 0; i < n; i++) {
            double termino = yPuntos[i]; // Comenzamos con yi
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    // Multiplicamos (x - xj) / (xi - xj)
                    termino *= (x - xPuntos[j]) / (xPuntos[i] - xPuntos[j]);
                }
            }
            resultado += termino; // Sumamos el término al resultado
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double[] xPuntos = {1.0, 2.0, 4.0};
        double[] yPuntos = {2.0, 3.0, 5.0};

        // Punto a interpolar
        double x = 3.0;

        // Cálculo de la interpolación
        double valorInterpolado = interpolar(xPuntos, yPuntos, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 2


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 3


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 4


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 5(sin solución)


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 







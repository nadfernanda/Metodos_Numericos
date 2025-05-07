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
Dada la función que pasa por los puntos (1, 2), (2, 3) y (4, 5), utiliza interpolación de Lagrange para estimar el valor de f(3).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis** 

Este conjunto de puntos muestra un crecimiento moderado y casi lineal. Al interpolar en x=3, que se encuentra entre 
x=2 y x=4, el valor interpolado es 4.0, lo cual es coherente con el patrón de crecimiento entre los puntos dados. Esto indica que el polinomio de Lagrange se comporta de forma suave entre los valores intermedios, sin oscilaciones notables.

## Ejercicio 2
Se conocen los valores de una función en los puntos (0, 1), (1, 3), y (2, 2). Usa interpolación de Lagrange para calcular f(1.5).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Los valores de y no siguen un patrón lineal, sino que aumentan y luego disminuyen. El valor de interpolación en x=1.5 cae entre 
x=1 y x=2, en la zona de transición del aumento al descenso. El resultado 2.875 muestra que el polinomio capta ese cambio de dirección, lo que indica un pequeño pico en la curva. Este ejercicio demuestra que el método de Lagrange también puede capturar curvas suaves, no solo líneas rectas.

## Ejercicio 3
Interpola el valor de f(2.5) usando los puntos (1, 2), (2, 4), y (3, 3).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Aquí, la función aumenta de 2 a 4, y luego baja a 3. Esto sugiere un pequeño máximo alrededor de 
x=2. Al interpolar en x=2.5, el valor se acerca más a 3 (último punto), pero aún conserva la influencia de los otros valores. El valor 3.875 refleja una transición suave de esa “curva en forma de colina” que se forma entre los puntos, sin oscilaciones drásticas.

## Ejercicio 4
Se tienen los puntos (2, 8), (3, 27), y (5, 125), que pertenecen a la función f(x) = x³. Estima el valor de f(4) mediante interpolación de Lagrange.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Estos puntos representan la función cúbica f(x)=x^3. El valor interpolado cae justo en el medio entre x=3 y  x=5, y el resultado 66.0 está bastante cerca de 4^3 = 64, que sería el valor exacto si la función fuera exactamente cúbica. Esto confirma que la interpolación de Lagrange es muy precisa cuando los puntos siguen un patrón polinomial del mismo grado que el número de puntos menos uno (en este caso, grado 2 para 3 puntos).

## Ejercicio 5 (utilizando dos métodos)

Dado el siguiente conjunto de puntos:

(1.0, 2.0)

(2.0, 3.0)

(4.0, 5.0)

Interpola el valor de f(3.0) utilizando:

- El método de interpolación de Lagrange

- El método de interpolación de Newton

**Solución con algoritmo de java**

**Solución con el método de Lagrange**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Lagrange.png" width="35%" alt="Solución Newton">

**Solución con el método de Newton**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Newton.png" width="35%" alt="Solución Lagrange">

**Análisis** 

Ambos métodos de interpolación, Lagrange y Newton, permiten estimar el valor de una función a partir de un conjunto de puntos conocidos. En este caso, al interpolar el valor de f(3.0) con los puntos (1.0,2.0), (2.0,3.0) y (4.0,5.0), ambos métodos arrojaron el mismo resultado:f(3.0)=4.0. Esto confirma que, aunque las técnicas y procedimientos son distintos, la interpolación conduce a una misma solución si se aplican correctamente. El método de Lagrange es más sencillo de implementar en problemas pequeños, mientras que el método de Newton resulta más eficiente cuando se deben realizar varias evaluaciones o agregar nuevos puntos, gracias a su uso de diferencias divididas. En conclusión, ambos métodos son herramientas confiables y útiles para la estimación de valores intermedios en funciones discretas.

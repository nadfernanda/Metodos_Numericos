## Definición
El método de correlación mide la fuerza y dirección de la relación lineal entre dos variables cuantitativas, normalmente llamadas X y Y.
El resultado se expresa con el coeficiente de correlación de Pearson (r), que toma valores entre -1 y 1:

r = 1: correlación positiva perfecta

r = -1: correlación negativa perfecta

r = 0: no hay correlación lineal

Este método no implica causalidad, solo asociación.

## Algoritmo 
1. Ingresar los datos de las dos variables (X e Y) en pares ordenados.
2. Calcular:
   
   - $\sum X$
     
   - $\sum Y$
     
   - $\sum XY$
     
   - $\sum X^2$
     
   - $\sum Y^2$
     
3. Aplicar la fórmula del coeficiente de correlación $r$ usando los valores anteriores.
   
4. Interpretar el valor de r:

Cerca de 1: fuerte correlación positiva

Cerca de -1: fuerte correlación negativa

Cerca de 0: débil o nula correlación

### Implementación en Java
```java
/**
 * Clase Correlacion
 *
 * Este programa implementa un método para calcular el coeficiente de correlación de Pearson
 * entre dos conjuntos de datos. Este coeficiente mide la fuerza y dirección de una relación
 * lineal entre dos variables.
 */
public class Correlacion {

    /**
     * Método que calcula el coeficiente de correlación de Pearson entre dos conjuntos de datos.
     *
     * @param x Arreglo con los valores de la primera variable.
     * @param y Arreglo con los valores de la segunda variable.
     * @return El coeficiente de correlación de Pearson, un valor entre -1 y 1.
     *         - 1 indica correlación positiva perfecta.
     *         - -1 indica correlación negativa perfecta.
     *         - 0 indica ausencia de correlación lineal.
     */
    public static double calcularCorrelacion(double[] x, double[] y) {
        int n = x.length;  // Número de elementos (se asume que x e y tienen la misma longitud)

        // Inicialización de variables para las sumatorias requeridas
        double sumX = 0;     // Suma de los valores de x
        double sumY = 0;     // Suma de los valores de y
        double sumXY = 0;    // Suma del producto x[i] * y[i]
        double sumX2 = 0;    // Suma de los cuadrados de x[i]
        double sumY2 = 0;    // Suma de los cuadrados de y[i]

        // Recorrido de los datos para calcular las sumatorias
        for (int i = 0; i < n; i++) {
            sumX += x[i];               // Acumula la suma de x
            sumY += y[i];               // Acumula la suma de y
            sumXY += x[i] * y[i];       // Acumula la suma de x*y
            sumX2 += x[i] * x[i];       // Acumula la suma de x^2
            sumY2 += y[i] * y[i];       // Acumula la suma de y^2
        }

        // Cálculo del numerador de la fórmula de Pearson
        double numerador = n * sumXY - sumX * sumY;

        // Cálculo del denominador de la fórmula de Pearson
        double denominador = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        // Retorna el valor del coeficiente de correlación
        return numerador / denominador;
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Halla la correlación entre x y y, dado :

x = {1, 2, 3, 4, 5} 

y = {2, 4, 6, 8, 10}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Correlaci%C3%B3n/Ejercicio%201.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Los datos presentan una relación perfectamente lineal positiva: a medida que los valores de x aumentan, los de y también lo hacen de forma proporcional. Esto da como resultado un coeficiente de correlación de 1.0000, lo cual indica una correlación positiva perfecta.

## Ejercicio 2
Halla la correlación entre x y y, dado :

x = {1, 2, 3, 4, 5} 

y = {10, 8, 6, 4, 2} 

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Correlaci%C3%B3n/Ejercicio%202.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Los valores de x aumentan mientras que los de y disminuyen de manera perfectamente proporcional. Esta relación inversa produce un coeficiente de correlación de -1.0000, lo que representa una correlación negativa perfecta.

## Ejercicio 3
Halla la correlación entre x y y, dado :

x = {1, 3, 5, 7} 

y = {2, 2, 2, 2}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Correlaci%C3%B3n/Ejercicio%203.png" width="20%" alt="Solución Ejercicio 2">

**Análisis**

Aunque los valores de x cambian, los de y permanecen constantes. En este caso, no existe relación alguna entre ambas variables, por lo que el coeficiente de correlación es 0.0000, reflejando ausencia total de correlación.

## Ejercicio 4
Halla la correlación entre x y y, dado :

x = {1, 2, 3, 4, 5} 

y = {2.1, 4.2, 6.1, 8.3, 10.1}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Correlaci%C3%B3n/Ejercicio%204.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Existe una fuerte relación lineal positiva entre x e y, aunque no perfectamente exacta. Los valores de y siguen creciendo con x, pero con pequeñas desviaciones, lo que produce un coeficiente de correlación muy cercano a 1 (≈ 0.9994), indicando una correlación positiva muy alta.

## Ejercicio 5
Halla la correlación entre x y y, dado :

x = {1, 2, 3, 4, 5} 

y = {10, 11, 13, 14, 16} 

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Correlaci%C3%B3n/Ejercicio%205.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Los datos muestran una tendencia lineal positiva clara, aunque con algunas irregularidades leves. Los incrementos en y no son exactamente constantes, pero siguen un patrón ascendente que resulta en un coeficiente de correlación alto (≈ 0.9872), señal de una relación positiva fuerte.



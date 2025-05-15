## Definición
El **método de mínimos cuadrados** es una técnica estadística utilizada para ajustar una función a un conjunto de datos minimizando la suma de los cuadrados de las diferencias entre los valores observados y los valores estimados por la función.
En el caso lineal, este método es el mismo que la regresión lineal: encuentra la recta \( y = a + bx \) que mejor se ajusta a los datos.

## Algoritmo 
1. Obtener los datos: \( x_1, x_2, ..., x_n \) y \( y_1, y_2, ..., y_n \)

2. Calcular:
   - \( \sum x \), \( \sum y \), \( \sum x^2 \), \( \sum xy \)

3. Resolver el sistema de ecuaciones normales para obtener \( a \) y \( b \):

\[
b = \frac{n \sum(xy) - \sum x \sum y}{n \sum x^2 - (\sum x)^2}
\]
\[
a = \frac{\sum y - b \sum x}{n}
\]

4. Generar la función estimada \( y = a + bx \)
5. 
### Implementación en Java
```java
/**
 * Clase Minimos
 * 
 * Este programa realiza un ajuste de datos mediante el método de los mínimos cuadrados.
 * Calcula la recta de mejor ajuste (y = a + b*x) para un conjunto de puntos (x, y),
 * e imprime la ecuación obtenida junto con el error cuadrático medio (MSE).
 */
public class Minimos {
    public static void main(String[] args) {
        
        // Datos de entrada: arreglos que representan pares de valores (x, y)
        double[] x = {1, 2, 3, 4, 5};  // Valores de la variable independiente
        double[] y = {2, 4, 5, 4, 5};  // Valores de la variable dependiente
        int n = x.length;             // Número de puntos o datos

        // Inicialización de variables para las sumatorias necesarias
        double sumX = 0;    // Suma de los valores de x
        double sumY = 0;    // Suma de los valores de y
        double sumXY = 0;   // Suma del producto x*y
        double sumX2 = 0;   // Suma del cuadrado de x

        // Cálculo de las sumatorias necesarias para la fórmula de regresión lineal
        for (int i = 0; i < n; i++) {
            sumX += x[i];               // Acumula la suma de x
            sumY += y[i];               // Acumula la suma de y
            sumXY += x[i] * y[i];       // Acumula la suma de x*y
            sumX2 += x[i] * x[i];       // Acumula la suma de x^2
        }

        // Cálculo de la pendiente (b) de la recta de regresión
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);

        // Cálculo del intercepto (a) de la recta con el eje y
        double a = (sumY - b * sumX) / n;

        // Imprimir la ecuación de la recta ajustada: y = a + b*x
        System.out.printf("Ecuación de la recta: y = %.4f + %.4fx\n", a, b);

    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Ajusta una recta a los siguientes datos: 

x = {1, 2, 3, 4} 

y = {3, 5, 7, 9} 

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/M%C3%ADnimos_Cuadrados/Ejercicio%201.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Los puntos siguen una línea recta con incremento constante, lo que permite que el modelo de mínimos cuadrados ajuste una línea que coincide perfectamente con los datos. El comportamiento lineal simple facilita una predicción exacta.

## Ejercicio 2
Ajusta una recta a los siguientes datos: 

x = {2, 4, 6, 8} 

y = {5, 9, 13, 17}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/M%C3%ADnimos_Cuadrados/Ejercicio%202.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Existe una relación inversa y perfectamente lineal entre las variables, lo cual se traduce en una línea de ajuste descendente que representa con exactitud la tendencia de los datos. La regularidad entre los puntos permite una línea ajustada precisa.

## Ejercicio 3
Ajusta una recta a los siguientes datos: 

x = {1, 2, 3, 4, 5} 

y = {2, 4.1, 5.9, 8.2, 10}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/M%C3%ADnimos_Cuadrados/Ejercicio%203.png" width="20%" alt="Solución Ejercicio 2">

**Análisis**

Los valores de y permanecen iguales sin importar el valor de x, lo que indica que no hay relación entre las variables. El modelo ajusta una línea horizontal, lo cual es coherente con la ausencia de variación en la variable dependiente.

## Ejercicio 4
Ajusta una recta a los siguientes datos: 

x = {1, 2, 3, 4} 

y = {10, 20, 30, 40}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/M%C3%ADnimos_Cuadrados/Ejercicio%204.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Aunque los valores de y siguen una tendencia creciente, presentan leves fluctuaciones alrededor de una trayectoria lineal. El modelo logra captar esa dirección general ascendente, representando adecuadamente el comportamiento del conjunto de datos.

## Ejercicio 5
Ajusta una recta a los siguientes datos: 

x = {1, 2, 3, 4} 

y = {12, 15, 18, 20}

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/M%C3%ADnimos_Cuadrados/Ejercicio%205.png" width="20%" alt="Solución Ejercicio 2">

**Análisis** 

Los datos muestran una relación positiva clara pero no perfectamente uniforme. La línea ajustada refleja fielmente la dirección de crecimiento de y con respecto a x, adaptándose al patrón general con buena precisión pese a ligeras variaciones.


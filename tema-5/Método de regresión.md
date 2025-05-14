## Definición
El método de regresión lineal se utiliza para encontrar la mejor línea recta que se ajusta a un conjunto de datos (x, y). La ecuación de esa recta es:
y=a+bx

Donde:
a: ordenada al origen (intersección con eje y)
b: pendiente de la recta

Se basa en minimizar la suma de los errores cuadrados entre los valores reales y los valores estimados por la recta.

## Algoritmo 
1. Calcular las siguientes sumatorias:
   - $\sum x$
   - $\sum y$
   - $\sum xy$
   - $\sum x^2$

2. Calcular la pendiente $b$:
   $$b = \frac{n \sum (xy) - \sum x \sum y}{n \sum x^2 - (\sum x)^2}$$

3. Calcular la ordenada al origen $a$:
   $$a = \frac{\sum y - b \sum x}{n}$$
   
4. Sustituir los valores en la ecuación $y = a + bx$
   
5. Para cada valor $x_i$, calcular el valor estimado $y'_i = a + bx_i$
   
6. Calcular el error cuadrático medio (ECM o MSE):
   $$ECM = \frac{1}{n} \sum (y_i - y'_i)^2$$

### Implementación en Java
```java
/**
 * Clase Regresion
 * 
 * Este programa realiza una regresión lineal simple sobre un conjunto de datos (x, y).
 * Calcula la ecuación de la recta de mejor ajuste (y = a + b*x) y el error cuadrático medio (MSE).
 */
public class Regresion {
    public static void main(String[] args) {
        
        // Datos de entrada: arreglos que representan los valores de x e y
        double[] x = {1, 2, 3, 4, 5};  // Valores independientes (x)
        double[] y = {2, 4, 5, 4, 5};  // Valores dependientes (y)
        int n = x.length;             // Número de datos

        // Variables para almacenar sumas necesarias para los cálculos
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Cálculo de sumatorias: sumX, sumY, sumXY y sumX²
        for (int i = 0; i < n; i++) {
            sumX += x[i];               // Suma de todos los valores de x
            sumY += y[i];               // Suma de todos los valores de y
            sumXY += x[i] * y[i];       // Suma del producto de x*y
            sumX2 += x[i] * x[i];       // Suma del cuadrado de x
        }

        // Cálculo de la pendiente (b) de la recta de regresión
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        
        // Cálculo de la intersección (a) con el eje y
        double a = (sumY - b * sumX) / n;

        // Mostrar la ecuación de la recta de regresión
        System.out.printf("Ecuación de la recta: y = %.4f + %.4fx\n", a, b);

        // Cálculo del Error Cuadrático Medio (Mean Squared Error - MSE)
        double mse = 0;
        for (int i = 0; i < n; i++) {
            double yEst = a + b * x[i];           // Valor estimado de y usando la recta
            mse += Math.pow(y[i] - yEst, 2);      // Error al cuadrado (real - estimado)
        }

        mse /= n;  // Promedio de los errores al cuadrado

        // Mostrar el valor del MSE
        System.out.printf("Error cuadrático medio: %.4f\n", mse);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Dado el conjunto de datos:
x = [1, 2, 3, 4, 5]
y = [2.2, 2.8, 3.6, 4.5, 5.1]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Regresi%C3%B3n/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Los datos presentan una relación perfectamente lineal positiva: a medida que los valores de x aumentan, los de y también lo hacen de forma proporcional. Esto da como resultado un coeficiente de correlación de 1.0000, lo cual indica una correlación positiva perfecta.

## Ejercicio 2
Dado el conjunto de datos:
x = [10, 20, 30, 40, 50]
y = [15, 25, 35, 45, 55]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Regresi%C3%B3n/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Los valores de x aumentan mientras que los de y disminuyen de manera perfectamente proporcional. Esta relación inversa produce un coeficiente de correlación de -1.0000, lo que representa una correlación negativa perfecta.

## Ejercicio 3
Dado el conjunto de datos:
x = [1, 2, 3, 4, 5]
y = [5, 4, 3, 2, 1]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Regresi%C3%B3n/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

Aunque los valores de x cambian, los de y permanecen constantes. En este caso, no existe relación alguna entre ambas variables, por lo que el coeficiente de correlación es 0.0000, reflejando ausencia total de correlación.

## Ejercicio 4
Dado el conjunto de datos:
x = [0, 1, 2, 3, 4]
y = [1, 3, 7, 13, 21]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Regresi%C3%B3n/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Existe una fuerte relación lineal positiva entre x e y, aunque no perfectamente exacta. Los valores de y siguen creciendo con x, pero con pequeñas desviaciones, lo que produce un coeficiente de correlación muy cercano a 1 (≈ 0.9994), indicando una correlación positiva muy alta.

## Ejercicio 5
Dado el conjunto de datos:
x = [1, 2, 3, 4, 5]
y = [1, 1, 2, 3, 5]

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Regresi%C3%B3n/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Los datos muestran una tendencia lineal positiva clara, aunque con algunas irregularidades leves. Los incrementos en y no son exactamente constantes, pero siguen un patrón ascendente que resulta en un coeficiente de correlación alto (≈ 0.9872), señal de una relación positiva fuerte.


## Definición
El método de interpolación cuadrática es una técnica de interpolación que utiliza un polinomio de segundo grado (una parábola) para aproximar una función o un conjunto de puntos de datos. El objetivo es encontrar una parábola que pase exactamente por tres puntos dados, y luego usar esa parábola para estimar el valor de la función en otros puntos dentro del rango de los datos conocidos.

La idea principal es que si tienes tres puntos $(x_0, y_0)$, $(x_1, y_1)$ y $(x_2, y_2)$, puedes encontrar un polinomio cuadrático de la forma:

$$P(x) = ax^2 + bx + c$$

que satisface las siguientes condiciones:

- $P(x_0) = y_0$
- $P(x_1) = y_1$
- $P(x_2) = y_2$

Al tener tres condiciones y tres incógnitas ($a, b, c$), generalmente existe una única solución para estos coeficientes, lo que define la parábola que interpola los tres puntos.

## Algoritmo 
1. Escoge tres puntos: $(x_0, y_0)$, $(x_1, y_1)$, $(x_2, y_2)$.

2. Calcula los términos del polinomio:

   $$P(x) = a(x - x_1)(x - x_2) + b(x - x_0)(x - x_2) + c(x - x_0)(x - x_1)$$

   donde:

   - $a = \frac{y_0}{(x_0 - x_1)(x_0 - x_2)}$

   - $b = \frac{y_1}{(x_1 - x_0)(x_1 - x_2)}$

   - $c = \frac{y_2}{(x_2 - x_0)(x_2 - x_1)}$

3. Sustituye el valor deseado de $x$ en el polinomio.
   
4. Calcula P(x) y ese será el resultado.

### Implementación en Java
```java
/**
 * Método de Interpolación Cuadrática
 * Dado tres puntos (x0, y0), (x1, y1), (x2, y2),
 * este método aproxima el valor de la función en un punto x
 * utilizando un polinomio de segundo grado.
 */
public class InterpolacionCuadratica {

    /**
     * Calcula la interpolación cuadrática en el punto x
     * @param x0 Primer valor de x conocido
     * @param y0 Valor de la función en x0
     * @param x1 Segundo valor de x conocido
     * @param y1 Valor de la función en x1
     * @param x2 Tercer valor de x conocido
     * @param y2 Valor de la función en x2
     * @param x  Punto donde se desea interpolar
     * @return Aproximación de f(x) usando interpolación cuadrática
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x2, double y2, double x) {
        // Cálculo de las diferencias divididas
        double f01 = (y1 - y0) / (x1 - x0);
        double f12 = (y2 - y1) / (x2 - x1);
        double f012 = (f12 - f01) / (x2 - x0);

        // Fórmula de interpolación cuadrática de Newton
        double resultado = y0 + f01 * (x - x0) + f012 * (x - x0) * (x - x1);
        return resultado;
    }

    public static void main(String[] args) {
        // Valores conocidos
        double x0 = 1.0, y0 = 2.0;
        double x1 = 2.0, y1 = 3.0;
        double x2 = 4.0, y2 = 5.0;
        
        // Punto a interpolar
        double x = 3.0;
        
        // Cálculo de la interpolación
        double valorInterpolado = interpolar(x0, y0, x1, y1, x2, y2, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1
Usa interpolación cuadrática para estimar el valor de la función en \( x = 2.5 \), a partir de los siguientes puntos:  
- \( (1, 3) \)  
- \( (2, 6) \)  
- \( (4, 3) \)

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Cuadr%C3%A1tica/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

En este ejercicio se observa un comportamiento no lineal de la función: sube desde \( y = 3 \) a \( y = 6 \) y luego baja nuevamente a \( y = 3 \). El resultado interpolado fue 6.375, que supera incluso el valor máximo conocido. Esto indica que la parábola generada por la interpolación tiene un vértice en ese punto, lo cual es coherente con la forma curva esperada.


## Ejercicio 2
Usa interpolación cuadrática para estimar el valor de \( f(1.5) \), usando los puntos:  
- \( (0, 1) \)  
- \( (1, 3) \)  
- \( (2, 2) \)

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Cuadr%C3%A1tica/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

En este caso, la función crece y luego desciende, y el valor a interpolar está entre ambos comportamientos. El resultado de 2.875 es lógico: muestra una caída desde el máximo en \( x = 1 \). La parábola generada por la interpolación refleja correctamente esta variación suave.

## Ejercicio 3
Estima el valor de \( f(4.0) \) con los siguientes puntos:  
- \( (2, 4) \)  
- \( (3, 5) \)  
- \( (5, 1) \)
  
**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Cuadr%C3%A1tica/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

Este ejercicio tiene un punto medio alto seguido de una bajada. El valor interpolado cae exactamente en 4.0, lo cual es consistente con una curva que desciende después del punto máximo. El método refleja bien el cambio de pendiente y la simetría de la parábola en ese intervalo.

## Ejercicio 4
Estima el valor de \( f(1.5) \) usando interpolación cuadrática con los puntos:  
- \( (0, 0) \)  
- \( (1, 1) \)  
- \( (2, 4) \)
  
**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Cuadr%C3%A1tica/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**
Aquí los puntos siguen la función cuadrática exacta \( y = x^2 \). El resultado coincide con \( 1.5^2 \), es decir, 2.25. Este ejercicio demuestra que la interpolación cuadrática reproduce con exactitud funciones cuadráticas cuando los datos provienen de dicha función.

## Ejercicio 5(sin solución)

Usa interpolación cuadrática para estimar el valor de la función en \( x = 2.0 \), utilizando los puntos:  
- \( (2.0, 4.0) \)  
- \( (2.0, 5.0) \)  
- \( (2.0, 6.0) \)
  
**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Cuadr%C3%A1tica/Ejercicio%205.png" width="40%" alt="Solución Ejercicio 1">

**Análisis**
Este ejercicio presenta una situación inválida para la interpolación cuadrática. Los tres puntos tienen la misma coordenada \( x = 2.0 \), lo que causa divisiones por cero al calcular las diferencias divididas necesarias para construir el polinomio de interpolación. Esto se debe a que el método requiere puntos con **valores de \( x \) distintos** para poder formar una parábola. En la práctica, este tipo de error es útil para resaltar la importancia de validar los datos de entrada antes de aplicar métodos numéricos. El resultado fue una excepción de ejecución, lo cual es coherente con un problema matemáticamente mal planteado.



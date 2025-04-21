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
```
## Ejercicios Prácticos
## Ejercicio 1

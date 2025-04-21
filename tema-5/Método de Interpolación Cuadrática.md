## Definición
La interpolación cuadrática es una técnica para estimar nuevos puntos de datos dentro del rango de 
un conjunto discreto de puntos de datos conocidos. A diferencia de la interpolación lineal, que conecta dos puntos 
con una línea recta, la interpolación cuadrática ajusta un polinomio de segundo grado (una parábola) a tres puntos de datos conocidos.

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

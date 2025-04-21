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
```
## Ejercicios Prácticos
## Ejercicio 1


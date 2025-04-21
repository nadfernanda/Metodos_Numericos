## Definición
El Método de Interpolación de Lagrange es una técnica muy útil para encontrar un polinomio que pasa exactamente por un conjunto de puntos de datos dados. A diferencia de otros métodos de interpolación, como el de Newton con diferencias divididas,
la fórmula de Lagrange construye el polinomio directamente a partir de los puntos, sin necesidad de calcular diferencias.

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


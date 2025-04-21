## Definición
El Método de Interpolación de Newton es otra técnica fundamental para encontrar un polinomio que pasa por un conjunto
de puntos de datos dados. A diferencia del método de Lagrange, el método de Newton construye el polinomio interpolante de forma incremental, añadiendo un término a la vez a medida que se consideran más puntos. Esto lo hace particularmente útil cuando no se sabe de antemano cuántos puntos serán necesarios para alcanzar una precisión deseada.
La idea central del método de Newton se basa en el concepto de diferencias divididas. Estas diferencias divididas nos ayudan a determinar los coeficientes del polinomio interpolante.

## Algoritmo 
1. Elige varios puntos: $(x_0, y_0), (x_1, y_1), ..., (x_n, y_n)$.
   
2. Crea una tabla de diferencias divididas:
   
   - Primera columna: $y_0, y_1, ..., y_n$.
     
   - Luego calcula:
     
     $$f[x_i, x_{i+1}] = \frac{f(x_{i+1}) - f(x_i)}{x_{i+1} - x_i}$$

     y así sucesivamente.
    
3. Forma el polinomio:
   
   $$P(x) = f[x_0] + f[x_0, x_1](x - x_0) + f[x_0, x_1, x_2](x - x_0)(x - x_1) + ...$$
   
4. Sustituye el valor de x y calcula el resultado.

### Implementación en Java
```java
```
## Ejercicios Prácticos
## Ejercicio 1

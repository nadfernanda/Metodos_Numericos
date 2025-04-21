## Definición
El método de Taylor es una técnica numérica para aproximar la solución de una ecuación diferencial ordinaria (EDO) utilizando la serie de Taylor de la solución alrededor de un punto. A diferencia del método de Euler, que solo usa la primera derivada, el método de Taylor utiliza derivadas de orden superior para lograr una mayor precisión.

Se basa en la expansión de la solución y(x) en una serie de Taylor alrededor de un punto xi donde se conoce la solución (ya sea la condición inicial o un punto previamente calculado). Al incluir más términos de la serie (es decir, derivadas de mayor orden), se obtiene una mejor aproximación de la función en puntos cercanos.

## Algoritmo
1. Definir la EDO:
   $y' = f(x, y)$
   
2. Establecer condiciones iniciales:
   $x_0, y_0$
   
3. Elegir el tamaño de paso $h$ y el orden $n$ del método
   
4. Calcular las derivadas sucesivas de $f$ hasta el orden $n$
   
5. Aplicar la fórmula:
    
   $$y_{n+1} = y_n + h \cdot y'(x_n) + \frac{h^2}{2!} \cdot y''(x_n) + ... + \frac{h^n}{n!} \cdot y^{(n)}(x_n)$$
   
6. Repetir con los nuevos valores

### Implementación en Java
```java
```
## Ejercicios Prácticos
## Ejercicio 1

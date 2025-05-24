## Definición
Es un método implícito que utiliza valores pasados y futuros para calcular la solución, ofreciendo mejor estabilidad especialmente en problemas rígidos. Al ser implícito, el cálculo de 
yn + 1 requiere resolver una ecuación, a menudo mediante métodos iterativos. Esto compensa la mayor carga computacional con mayor precisión y estabilidad.

## Algoritmo (Adams-Moulton de 2 pasos):
1. Calcular $y_{n+1}$ mediante:
   $y_{n+1} = y_n + \frac{h}{12}(5f(x_{n+1}, y_{n+1}) + 8f(x_n, y_n) - f(x_{n-1}, y_{n-1}))$

2. Como $y_{n+1}$ aparece en ambos lados, se resuelve mediante iteración (por ejemplo, método de Newton o punto fijo).
   
### Implementación en Java
```java

```
## Ejercicios Prácticos
## Ejercicio 1


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 2


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 3


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

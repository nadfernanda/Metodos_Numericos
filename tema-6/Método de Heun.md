## Definición
El método de Euler modificado o método de Heun es una mejora del método de Euler simple. Mientras que Euler usa solo la pendiente en el inicio del intervalo para aproximar la solución, Heun calcula primero una pendiente preliminar al final del intervalo y luego promedia ambas pendientes para obtener una mejor aproximación. Esto reduce el error y mejora la precisión, sin complicar mucho el cálculo. Es un método explícito y de un paso muy usado cuando se busca un equilibrio entre simplicidad y exactitud.

## Algoritmo

(Dado $y' = f(x, y)$, $y(x_0) = y_0$, paso $h$)

1. Calcular pendiente inicial:
   $k_1 = f(x_n, y_n)$

2. Estimar valor provisional usando Euler:
   $y^* = y_n + hk_1$

3. Calcular pendiente en el extremo final:
   $k_2 = f(x_n + h, y^*)$

4. Calcular siguiente valor con promedio de pendientes:
   $y_{n+1} = y_n + \frac{h}{2}(k_1 + k_2)$

5. Actualizar $x_{n+1} = x_n + h$, repetir.
   
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

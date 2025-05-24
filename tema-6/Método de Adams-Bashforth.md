## Definición
Es un método explícito que utiliza los valores de la función derivada f en los puntos actuales y anteriores para calcular el siguiente valor de la solución. Este método aprovecha la información histórica para lograr mayor precisión sin tener que recalcular la función en varios puntos del intervalo, a diferencia de métodos de un paso como Runge-Kutta. Sin embargo, al ser explícito puede ser menos estable en algunos casos.

## Algoritmo
Dada la EDO y valores $y_n$, $y_{n-1}$:

1. Calcular:
   $y_{n+1} = y_n + \frac{h}{2}(3f(x_n, y_n) - f(x_{n-1}, y_{n-1}))$

2. Avanzar $n \rightarrow n + 1$ y repetir.

Nota: Para comenzar, se usan métodos de un paso para obtener los primeros valores.

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

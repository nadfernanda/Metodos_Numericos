## Definición
El Método de Gauss-Seidel es un algoritmo iterativo utilizado para resolver sistemas de ecuaciones lineales.
Es una mejora del método de Jacobi y se utiliza para encontrar soluciones aproximadas a sistemas de la
forma Ax=b, donde A es una matriz cuadrada, x es el vector de incógnitas y b es el vector de términos independientes.

## Algoritmo 
1.Despeja cada incógnita:
De cada ecuación, despeja una variable en términos de las demás.

2.Inicia con un vector de solución:
Elige valores iniciales para todas las incógnitas (pueden ser ceros o estimaciones).

3.Actualiza las variables iterativamente:
Usa los valores más recientes de las variables para calcular las nuevas aproximaciones.

En cada paso, actualiza una variable a la vez usando los valores ya calculados.

4.Verifica la convergencia:
Repite el proceso hasta que la diferencia entre dos iteraciones sea muy pequeña (tolerancia)
o hasta alcanzar un número máximo de iteraciones.

5.Obtén la solución:
El último vector calculado es la aproximación a la solución del sistema.

### Implementación en Java
```python
codigo xd
```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Seidel.
### Ejercicio 1: 
Resuelve el siguiente sistema de ecuaciones en 11 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%201.png" width="20%" alt="Ejercicio 1">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E1.png" width="30%" alt="Solución Ejercicio 1">

### Ejercicio 2:
Resuelve el siguiente sistema de ecuaciones en 12 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%202.png" width="20%" alt="Ejercicio 2">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E2.png" width="30%" alt="Solución Ejercicio 2">

### Ejercicio 3:
Resuelve el siguiente sistema de ecuaciones en 13 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%203.png" width="20%" alt="Ejercicio 3">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E3.png" width="30%" alt="Solución Ejercicio 4">

### Ejercicio 4:
Resuelve el siguiente sistema de ecuaciones en 8 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%204.png" width="20%" alt="Ejercicio 4">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E4.png" width="30%" alt="Solución Ejercicio 4">

Los resultados obtenidos con el método de Gauss-Seidel para el sistema propuesto son correctos. La solución encontrada (x = 1.299980, y = 2.868074, z = 2.698194) satisface perfectamente las tres ecuaciones del sistema cuando se sustituyen estos valores, y el método ha convergido en exactamente 8 iteraciones como se esperaba debido a la fuerte dominancia diagonal de la matriz de coeficientes. Esto demuestra que el algoritmo implementado funciona adecuadamente y es capaz de encontrar soluciones precisas en un número predecible de iteraciones para sistemas con buenas propiedades de convergencia.

### Ejercicio 5:(Sin solución)
Resuelve el siguiente sistema de ecuaciones en 101 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%205.png" width="20%" alt="Ejercicio 5">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E5.png" width="40%" alt="Solución Ejercicio 5">

Este sistema no debería converger con el método de Gauss-Seidel porque no cumple con el criterio de dominancia diagonal. Para cada fila, el elemento en la diagonal principal debería ser mayor que la suma de los valores absolutos de los demás elementos en esa fila, lo cual no ocurre aquí.



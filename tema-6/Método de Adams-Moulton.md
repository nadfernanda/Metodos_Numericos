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
Resolver la ecuación diferencial $y′=x^2$, con condición inicial y(0)=0 , paso h=0.25 , n=4 y encontrar y(1.0).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Moulton/Ejercicio%201.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

El método logra calcular un valor aproximado para y(1.0) que está muy cerca del valor real, aunque no es exacto. Esto significa que cuando no podemos obtener una solución matemática directa, podemos usar este método para obtener una buena estimación rápida. Es especialmente útil para funciones suaves y cuando usamos pasos adecuados, porque la aproximación mejora mucho en esos casos.

## Ejercicio 2
Resuelve la ecuación diferencial $y′=−y$, con condición inicial y(0)=1, paso h=0.2, n=5, y encontrar y(1.0).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Moulton/Ejercicio%202.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

Este resultado muestra que el método puede manejar problemas donde la función disminuye con el tiempo, como la desintegración o pérdida de energía. El valor calculado es muy parecido al real, lo que indica que el método es bastante preciso y confiable para situaciones prácticas, sin necesidad de hacer cálculos complicados o largos.

## Ejercicio 3
Resuelve la ecuación diferencial $y′=sin(x)$, con condición inicial y(0)=0, paso h=0.1, n=5, y encontrar y(0.5).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-6/imagenes/M%C3%A9todo%20de%20Adams%20Moulton/Ejercicio%203.png" width="32%" alt="Solución Ejercicio 2">

**Análisis** 

Aunque esta función cambia de forma más compleja y oscilatoria, el método aún consigue una buena aproximación para y(0.5). Esto demuestra que la técnica puede usarse para fenómenos naturales que varían de manera no lineal, siempre y cuando se usen pasos pequeños. Así podemos entender mejor esos procesos sin necesidad de fórmulas exactas difíciles.

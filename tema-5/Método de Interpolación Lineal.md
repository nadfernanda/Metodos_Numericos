## Definición
El método de interpolación lineal es una forma sencilla y directa de estimar un valor desconocido que se encuentra entre dos valores conocidos. La idea principal es asumir que existe una relación lineal (una línea recta) entre los dos puntos de datos conocidos y usar esa línea para predecir el valor en el punto intermedio.

Imagina que tienes dos puntos en una gráfica:

- Punto 1: $(x_0, y_0)$
  
- Punto 2: $(x_1, y_1)$

Si quieres encontrar el valor de $y$ para un valor de $x$ que está entre $x_0$ y $x_1$, la interpolación lineal traza una línea recta que conecta estos dos puntos y luego encuentra el valor de $y$ en esa línea para el $x$ deseado.

## Algoritmo 
1. Toma dos puntos conocidos: $(x_0, y_0)$ y $(x_1, y_1)$.
   
2. Elige un valor de $x$ que esté entre $x_0$ y $x_1$.
   
3. Aplica la fórmula:
   
   $$f(x) = y_0 + \frac{(y_1 - y_0)}{(x_1 - x_0)} \cdot (x - x_0)$$

4. El resultado es una estimación de $f(x)$.

### Implementación en Java
```java

```
## Ejercicios Prácticos
## Ejercicio 1

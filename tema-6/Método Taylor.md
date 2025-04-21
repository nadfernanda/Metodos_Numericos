## Definición
El método de Taylor consiste en aproximar la solución de una ecuación diferencial utilizando la serie de Taylor alrededor de un punto inicial. A mayor orden del polinomio de Taylor, mayor precisión se obtiene en la solución.

## Algoritmo
1. Definir la EDO: y' = f(x, y)
   
2. Establecer condiciones iniciales: x₀, y₀
   
3. Elegir el paso h y el orden n del método
   
4. Calcular derivadas sucesivas de f necesarias hasta el orden n
   
5. Aplicar la fórmula de Taylor:
    
   yₙ₊₁ = yₙ + h*y'(xₙ) + (h²/2!)*y''(xₙ) + ... + (hⁿ/n!)*y⁽ⁿ⁾(xₙ)
  
6. Repetir el cálculo con los nuevos valores

### Implementación en Java
```java
```
## Ejercicios Prácticos
## Ejercicio 1

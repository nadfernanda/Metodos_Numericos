## Definición

El método de Euler es una técnica numérica de primer orden para aproximar soluciones de ecuaciones diferenciales ordinarias (EDO). Parte de una pendiente inicial y avanza en pasos incrementales utilizando la derivada conocida de la función.

## Algoritmo
1. Definir la ecuación diferencial en la forma: y' = f(x, y)
   
2. Establecer las condiciones iniciales: x₀, y₀
   
3. Seleccionar el tamaño del paso: h
   
4. Calcular los valores sucesivos de y usando la fórmula:
   
   yₙ₊₁ = yₙ + h * f(xₙ, yₙ)
  
5. Incrementar xₙ = xₙ + h
   
6. Repetir los pasos 4 y 5 hasta alcanzar el valor deseado de x
   
### Implementación en Java
```java
```
## Ejercicios Prácticos
## Ejercicio 1


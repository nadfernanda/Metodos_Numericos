## Definición

El método de Runge-Kutta, especialmente su versión de cuarto orden, es un método numérico para resolver EDOs que proporciona una buena aproximación sin requerir el cálculo de derivadas superiores, como el método de Taylor.

## Algoritmo (Runge-Kutta de 4to orden)

1. Definir la ecuación: y' = f(x, y)
2. Establecer condiciones iniciales: x₀, y₀
3. Seleccionar el tamaño del paso: h
4. Calcular:
   k₁ = h * f(xₙ, yₙ)  
   k₂ = h * f(xₙ + h/2, yₙ + k₁/2)  
   k₃ = h * f(xₙ + h/2, yₙ + k₂/2)  
   k₄ = h * f(xₙ + h, yₙ + k₃)
5. Calcular:
   yₙ₊₁ = yₙ + (1/6)*(k₁ + 2*k₂ + 2*k₃ + k₄)
6. Incrementar xₙ = xₙ + h
7. Repetir los pasos 4 a 6 hasta alcanzar el valor deseado de x


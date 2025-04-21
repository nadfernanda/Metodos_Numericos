## Definición
El Método de Runge-Kutta es una familia de métodos numéricos iterativos, tanto explícitos como implícitos, utilizados para aproximar las soluciones de ecuaciones diferenciales ordinarias (EDOs). Estos métodos son más precisos que el método de Euler y el método de Taylor de bajo orden, y son ampliamente utilizados en la práctica debido a su buen equilibrio entre precisión y complejidad computacional.

En lugar de simplemente usar la pendiente al inicio de un intervalo (como en el método de Euler) o calcular derivadas de orden superior (como en el método de Taylor), los métodos de Runge-Kutta evalúan la función de la derivada ($f(x, y)$ en $\frac{dy}{dx} = f(x, y)$) en varios puntos dentro de cada intervalo de paso y luego toman una combinación ponderada de estas evaluaciones para obtener una aproximación más precisa de la pendiente promedio a través del intervalo. Esta pendiente promedio se utiliza para dar el paso hacia el siguiente valor de la solución.

## Algoritmo 
1. Definir la ecuación:
   $y' = f(x, y)$

2. Establecer condiciones iniciales:
   $x_0, y_0$

3. Seleccionar el paso:
   $h$

4. Calcular:

   - $k_1 = h \cdot f(x_n, y_n)$

   - $k_2 = h \cdot f(x_n + h/2, y_n + k_1/2)$

   - $k_3 = h \cdot f(x_n + h/2, y_n + k_2/2)$

   - $k_4 = h \cdot f(x_n + h, y_n + k_3)$

5. Estimar el siguiente valor:

   $$y_{n+1} = y_n + \frac{1}{6} \cdot (k_1 + 2 \cdot k_2 + 2 \cdot k_3 + k_4)$$

6. Actualizar:

   $$x_{n+1} = x_n + h$$

7. Repetir los pasos 4 a 6

### Implementación en Java
```java
```
## Ejercicios Prácticos
## Ejercicio 1


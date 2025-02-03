# Error de Redondeo
## Definición
El **error de redondeo** es la diferencia entre el valor aproximado de un número y su valor exacto. Este error ocurre cuando se redondea un número a un cierto número de decimales o dígitos significativos. Es común en cálculos numéricos, especialmente cuando se trabaja con números de punto flotante en computadoras, donde la precisión es limitada.  
---

## Algoritmo  
1. **Definir la función f(x)** a evaluar.
2. **Especificar el intervalo** de evaluación [a, b].
3. **Dividir el intervalo** en `n` subintervalos de tamaño `h = (b - a) / n`.
4. **Evaluar la función** en cada punto `x_i = a + i * h` para `i = 0, 1, 2, ..., n`.
5. **Redondear** los resultados a un número fijo de decimales o dígitos significativos.
6. **Calcular el error** en cada punto como `| Valor exacto - Valor redondeado |`.
7. **Calcular el error total** (suma de los errores) o el **error máximo**.
---

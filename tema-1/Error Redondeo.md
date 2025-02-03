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

## Ejemplo en Python  
Evaluación del error de redondeo para \( f(x) = e^x \) en \([0, 1]\) con 10 subintervalos:  

```python
import numpy as np

def calcular_error_redondeo(f, a, b, n, precision):
    """
    Calcula el error de redondeo para una función en un intervalo.
    
    Parámetros:
    f (function): Función a evaluar.
    a (float): Límite inferior del intervalo.
    b (float): Límite superior del intervalo.
    n (int): Número de subintervalos.
    precision (int): Decimales para redondear.
    """
    x_values = np.linspace(a, b, n)
    errores = []
    
    for x in x_values:
        exacto = f(x)
        redondeado = round(exacto, precision)
        errores.append(abs(exacto - redondeado))
    
    return errores

# Configuración
f = lambda x: np.exp(x)
a, b = 0, 1
n = 10
precision = 4

# Cálculo
errores = calcular_error_redondeo(f, a, b, n, precision)

# Resultados
print("Punto\tValor Exacto\tValor Redondeado\tError")
for i, (x, error) in enumerate(zip(np.linspace(a, b, n), errores)):
    exacto = np.exp(x)
    redondeado = round(exacto, precision)
    print(f"{i+1}\t{exacto:.6f}\t{redondeado:.4f}\t\t{error:.6f}")

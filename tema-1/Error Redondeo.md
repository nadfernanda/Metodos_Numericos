# Error de Redondeo
## Definición
El **error de redondeo** es la diferencia entre el valor numérico exacto y su aproximación debido a la limitación en la representación de números en sistemas de cómputo.
**Ejemplo:**  
- Número original: \( 0.3864 \times 10^4 = 3846 \)  
- Redondeado a 2 decimales: \( 3846.00 \)
---

## Algoritmo
A continuación, se describe un algoritmo para evaluar el error de redondeo en una función \( f(x) \):
1. **Definir la función** \( f(x) \) cuya evaluación puede introducir errores de redondeo.  
2. **Especificar el intervalo** de evaluación \([a, b]\).  
3. **Dividir el intervalo** \([a, b]\) en \( n \) subintervalos de igual tamaño.  
4. **Evaluar la función** en cada punto del intervalo, aplicando redondeo según la precisión deseada.  
5. **Calcular el error** comparando el valor exacto con el valor redondeado.

---

## Ejemplo en Python  
A continuación, se muestra un ejemplo de código en Python para evaluar el error de redondeo en la función \( f(x) = e^x \) en el intervalo \([0, 1]\):  

```python
import numpy as np

def calcular_error_redondeo(f, a, b, n, precision):
    """
    Función para calcular el error de redondeo en la evaluación de una función f(x) en el intervalo [a, b].

    Parámetros:
    f (function): Función a evaluar.
    a (float): Límite inferior del intervalo.
    b (float): Límite superior del intervalo.
    n (int): Número de subintervalos.
    precision (int): Número de decimales para la aproximación.
    """
    x_values = np.linspace(a, b, n)
    errores = []

    for x in x_values:
        valor_exacto = f(x)
        valor_redondeado = round(valor_exacto, precision)
        error = abs(valor_exacto - valor_redondeado)
        errores.append(error)

    return errores

# Ejemplo de uso
f = lambda x: np.exp(x)  # Función f(x) = e^x
a, b = 0, 1              # Intervalo [0, 1]
n = 10                   # Número de subintervalos
precision = 4            # Precisión de 4 decimales

errores = calcular_error_redondeo(f, a, b, n, precision)
print("Errores de redondeo en cada punto:", errores)-

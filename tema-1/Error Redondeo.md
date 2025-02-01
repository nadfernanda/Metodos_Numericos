# Error de Redondeo
## Definición
El **error de redondeo** es la diferencia entre el valor numérico exacto y su aproximación debido a la limitación en la representación de números en sistemas de cómputo. Este error surge cuando números con infinitos decimales (como \( \pi \) o \( \frac{1}{3} \)) se redondean a una cantidad finita de dígitos para su almacenamiento o cálculo.  

**Ejemplo:**  
\[
0.3864 \times 10^4 = 3846 \quad \text{(valor exacto)}  
\]
\[
\text{Redondeado a 2 decimales: } 3846.00 \quad \text{(valor aproximado)}  
\]

---

## Algoritmo  
Pasos para evaluar el error de redondeo en una función \( f(x) \):  

1. **Definir la función** \( f(x) \) a evaluar.  
2. **Especificar el intervalo** de evaluación \([a, b]\).  
3. **Dividir el intervalo** en \( n \) subintervalos de tamaño \( h = \frac{b - a}{n} \).  
4. **Evaluar la función** en cada punto \( x_i = a + i \cdot h \).  
5. **Redondear** los resultados a la precisión deseada.  
6. **Calcular el error** como \( | \text{Valor exacto} - \text{Valor redondeado} | \).  

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

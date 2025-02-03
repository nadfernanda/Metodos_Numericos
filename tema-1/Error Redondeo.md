## Definición
El **error de redondeo** es la diferencia entre el valor aproximado de un número y su valor exacto. Este error ocurre cuando se redondea un número a un cierto número de decimales o dígitos significativos. Es común en cálculos numéricos, especialmente cuando se trabaja con números de punto flotante en computadoras, donde la precisión es limitada.  

## Algoritmo  
1. **Definir la función f(x)** a evaluar.
2. **Especificar el intervalo** de evaluación [a, b].
3. **Dividir el intervalo** en `n` subintervalos de tamaño `h = (b - a) / n`.
4. **Evaluar la función** en cada punto `x_i = a + i * h` para `i = 0, 1, 2, ..., n`.
5. **Redondear** los resultados a un número fijo de decimales o dígitos significativos.
6. **Calcular el error** en cada punto como `| Valor exacto - Valor redondeado |`.
7. **Calcular el error total** (suma de los errores) o el **error máximo**.

### Implementación en Python
```python
def calcular_error_redondeo(valor_exacto, valor_aproximado):
    """
    Calcula el error de redondeo entre un valor exacto y su aproximación.
    
    Parámetros:
    valor_exacto (float): El valor exacto.
    valor_aproximado (float): El valor aproximado.
    
    Retorna:
    float: El error de redondeo.
    """
    return abs(valor_exacto - valor_aproximado)
```
## Ejercicios Prácticos

### Ejercicio 1:  Redondeo en Cálculos Científicos

**Enunciado:**  
La constante física de Planck es aproximadamente 6.62607015e-34 J·s.
Redondéala a 3 decimales y calcula el error de redondeo.

**Solución en Python:**
```python
# Valor exacto y parámetros
planck_exacto = 6.62607015e-34
decimales = 3

# Calcular error
valor_redondeado, error = error_redondeo(planck_exacto, decimales)

print(f"Valor exacto: {planck_exacto}")
print(f"Valor redondeado: {valor_redondeado}")
print(f"Error de redondeo: {error:.2e}")
```
## Análisis:
Resultado:
Valor redondeado = 6.626e-34, Error = 7.15e-37.
Aunque el error absoluto es pequeño (~1e-37), en física cuántica este error podría ser significativo al trabajar con mediciones ultra-precisas. El redondeo a 3 decimales es insuficiente para aplicaciones de alta precisión.

### Ejercicio 2: Redondeo en Finanzas

**Enunciado:**  
Un préstamo de $10,000 con una tasa de interés anual del `7.8567%` genera un interés exacto de `$785.67`.  
Redondea la tasa de interés a **2 decimales** y calcula el error en el interés generado.

**Solución en Python:**
```python
def error_redondeo(valor_exacto, decimales):
    valor_redondeado = round(valor_exacto, decimales)
    error = abs(valor_exacto - valor_redondeado)
    return valor_redondeado, error

# Valores iniciales
monto_prestamo = 10_000  # $10,000
tasa_exacta = 7.8567 / 100  # 7.8567% → 0.078567

# Redondear tasa a 2 decimales (equivalente a 4 decimales en forma decimal)
tasa_redondeada, error_tasa = error_redondeo(tasa_exacta, 4)  # 0.0786

# Calcular interés exacto y redondeado
interes_exacto = monto_prestamo * tasa_exacta  # $785.67
interes_redondeado = monto_prestamo * tasa_redondeada  # $786.00

# Error en el interés
error_interes = abs(interes_exacto - interes_redondeado)

print(f"Tasa exacta: {tasa_exacta:.6f}")
print(f"Tasa redondeada: {tasa_redondeada:.4f}")
print(f"Interés exacto: ${interes_exacto:.2f}")
print(f"Interés redondeado: ${interes_redondeado:.2f}")
print(f"Error en el interés: ${error_interes:.2f}")
```
## Análisis:
Tasa redondeada: 0.0786 (equivalente a 7.86%).
Error en la tasa: 0.000033 (diferencia entre 0.078567 y 0.0786).
Error en el interés: $0.33 (diferencia entre $785.67 y $786.00).
Aunque el error parece pequeño ($0.33), en contextos financieros con montos más grandes (ej: millones de dólares), este error se acumularía significativamente. Por ejemplo:
Para un préstamo de $1,000,000, el error sería de $33,000.
Por ello, instituciones financieras usan estándares estrictos (ej: redondeo a 6 decimales en hipotecas).

## Definición
El **error absoluto** es la diferencia entre el valor exacto (o teórico) de una magnitud y su valor aproximado (o medido). Se define matemáticamente como:
Error Absoluto = |Valor Exacto - Valor Aproximado|
Donde:
- `| |` representa el valor absoluto (siempre positivo).
- **Valor Exacto**: El valor teórico o real.
- **Valor Aproximado**: El valor obtenido mediante medición o cálculo.
- Es una medida de la precisión de una aproximación o medición. A diferencia del error relativo, no considera la magnitud del valor exacto.
  
## Algoritmo 
1. **Obtener el valor exacto** y el **valor aproximado**.
2. **Calcular la diferencia** entre ambos valores.
3. **Tomar el valor absoluto** de la diferencia.

### Implementación en Python
```python
def calcular_error_absoluto(valor_exacto, valor_aproximado):
    """
    Calcula el error absoluto entre un valor exacto y su aproximación.
    
    Parámetros:
    valor_exacto (float): El valor exacto.
    valor_aproximado (float): El valor aproximado.
    
    Retorna:
    float: El error absoluto.
    """
    return abs(valor_exacto - valor_aproximado)
```
## Ejercicios Prácticos
-----
### Ejercicio 1: Error en una Aproximación de π

**Enunciado:**  
El valor exacto de π es `3.141592653589793`. Si aproximamos π como `3.14`, calcula el error absoluto.
**Solución en Python:**
```python
# Función para calcular el error absoluto
def calcular_error_absoluto(valor_exacto, valor_aproximado):
    return abs(valor_exacto - valor_aproximado)

# Valores
valor_exacto = 3.141592653589793
valor_aproximado = 3.14

# Cálculo del error
error_absoluto = calcular_error_absoluto(valor_exacto, valor_aproximado)

# Resultados
print(f"Valor exacto de π: {valor_exacto}")
print(f"Valor aproximado: {valor_aproximado}")
print(f"Error absoluto: {error_absoluto}")
```
## Análisis:
El error absoluto calculado es 0.001592653589793.
Este error surge al truncar π a dos decimales, una práctica común en cálculos rápidos.
Aunque pequeño, este error puede ser significativo en aplicaciones de alta precisión (e.g., ingeniería aeroespacial).
La aproximación 3.14 subestima π en aproximadamente 0.0016. Es adecuada para uso cotidiano, pero no en contextos científicos.

### Ejercicio 2: Error en Mediciones Físicas
** Enunciado: **
Un estudiante mide la longitud de una mesa 5 veces y obtiene:
[2.5 m, 2.7 m, 2.6 m, 2.4 m, 2.5 m].
Si la longitud real es 2.55 m, calcula el error absoluto de cada medición y el error máximo.

**Solución en Python:**
```python
# Función para calcular el error absoluto
def calcular_error_absoluto(valor_exacto, valor_aproximado):
    return abs(valor_exacto - valor_aproximado)

# Valores
longitud_real = 2.55
mediciones = [2.5, 2.7, 2.6, 2.4, 2.5]

# Calcular errores
errores = [calcular_error_absoluto(longitud_real, m) for m in mediciones]
error_maximo = max(errores)

# Resultados
print(f"Errores absolutos: {errores}")
print(f"Error máximo: {error_maximo}")
```
## Análisis:
Errores calculados: [0.05, 0.15, 0.05, 0.15, 0.05].
El error máximo (0.15 m) ocurre en las mediciones 2.7 m y 2.4 m.
Esto sugiere inconsistencia en el instrumento de medición o técnica del estudiante.
El error máximo de 0.15 m es significativo. Para mejorar la precisión, es recomendable:usar un instrumento de medición más exacto, o repetir las mediciones en condiciones controladas.

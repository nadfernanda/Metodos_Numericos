## Definición
El **error relativo** es una medida de la precisión de una aproximación en relación con el valor exacto. Se define como el cociente entre el error absoluto y el valor exacto:
Error Relativo = |Valor Exacto - Valor Aproximado| / |Valor Exacto|

## Algoritmo 
1. **Obtener el valor exacto** y el **valor aproximado**.
2. **Calcular el error absoluto**: `|Valor Exacto - Valor Aproximado|`.
3. **Calcular el error relativo**: `Error Absoluto / |Valor Exacto|`.
4. **Opcional**: Convertir a porcentaje multiplicando por 100.

### Implementación en Python
```python
def calcular_error_relativo(valor_exacto, valor_aproximado):
    """
    Calcula el error relativo entre un valor exacto y su aproximación.
    
    Parámetros:
    valor_exacto (float): El valor exacto.
    valor_aproximado (float): El valor aproximado.
    
    Retorna:
    float: El error relativo (en decimal).
    """
    if valor_exacto == 0:
        raise ValueError("El valor exacto no puede ser cero.")
    error_absoluto = abs(valor_exacto - valor_aproximado)
    return error_absoluto / abs(valor_exacto)
```
## Ejercicios Prácticos

### Ejercicio 1: Error en la Medición de una Longitud
**Enunciado:**  
La longitud exacta de un objeto es 5.0 cm. Un estudiante mide 4.8 cm. Calcula el error relativo.
**Solución en Python:**
```python
# Valores
longitud_exacta = 5.0
longitud_medida = 4.8

# Cálculo del error relativo
error_relativo = calcular_error_relativo(longitud_exacta, longitud_medida)
error_porcentual = error_relativo * 100

print(f"Error relativo: {error_relativo:.4f} ({error_porcentual:.2f}%)")
```
## Análisis:
Error absoluto: 0.2 cm.
Error relativo: 0.04 (o 4%).
Aunque el error absoluto es pequeño (0.2 cm), el error relativo del 4% indica una desviación significativa en relación con el tamaño del objeto.
En mediciones de magnitudes pequeñas, un error absoluto reducido puede traducirse en un error relativo alto. Es crítico usar instrumentos precisos en estos casos.

### Ejercicio 2: Error en Mediciones Físicas
**Enunciado:**
La población exacta de una ciudad es 1,000,000 habitantes. Un censo aproximado reporta 980,000 habitantes. Calcula el error relativo.
**Solución en Python:**
```python
# Valores
poblacion_exacta = 1_000_000
poblacion_aproximada = 980_000

# Cálculo del error relativo
error_relativo = calcular_error_relativo(poblacion_exacta, poblacion_aproximada)
error_porcentual = error_relativo * 100

print(f"Error relativo: {error_relativo:.4f} ({error_porcentual:.2f}%)")
```
## Análisis:
Error absoluto: 20,000 habitantes.
Error relativo: 0.02 (o 2%).
Aunque el error absoluto es grande (20,000), el error relativo es bajo (2%), lo que indica una buena precisión relativa.
En magnitudes grandes, un error absoluto elevado puede tener un impacto relativo pequeño. El error relativo contextualiza la precisión de la medición.

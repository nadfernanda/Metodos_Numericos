## Definición
El método de Eliminación de Gauss (o Gauss Simple) es una técnica para resolver sistemas
de ecuaciones lineales. Consiste en transformar el sistema original en un sistema equivalente
con forma triangular superior, para luego resolverlo mediante sustitución hacia atrás.

## Algoritmo 
1. **Formar la matriz aumentada [A|b]** que combina la matriz de coeficientes con el vector de términos independientes.

2. **Eliminación hacia adelante**:
   
- Para cada fila i (desde arriba):

- Seleccionar el mayor valor en la columna como pivote (pivoteo parcial)

- Para cada fila j debajo:
  
- Calcular factor = A[j,i] / A[i,i]
  
- Restar de la fila j el factor multiplicado por la fila i

3. **Sustitución hacia atrás**:
   
   - Empezar con la última ecuación para hallar la última variable
     
   - Ir hacia arriba usando los valores ya encontrados
     
   - Para cada fila i (desde abajo):
     
   - x[i] = (b[i] - suma(A[i,j] * x[j])) / A[i,i]

Este método transforma el sistema original en uno triangular superior y luego resuelve las incógnitas
una por una desde la última hasta la primera.

### Implementación en Python
```python
import numpy as np

def eliminacion_gauss_simple(A, b):
    """
    Método de Eliminación de Gauss Simple para resolver sistemas de ecuaciones lineales
    
    Parámetros:
    A: matriz de coeficientes (numpy array)
    b: vector de términos independientes (numpy array)
    
    Retorna:
    x: solución del sistema
    """
    # Crear una copia de A y b para no modificar los originales
    n = len(b)
    A_aumentada = np.column_stack((A, b))  # Matriz aumentada [A|b]
    
    # Fase de eliminación hacia adelante
    for i in range(n):
        # Pivoteo parcial (buscar el valor máximo en la columna)
        max_fila = i
        for k in range(i + 1, n):
            if abs(A_aumentada[k, i]) > abs(A_aumentada[max_fila, i]):
                max_fila = k
        
        # Intercambiar filas
        if max_fila != i:
            A_aumentada[[i, max_fila]] = A_aumentada[[max_fila, i]]
        
        # Eliminación
        for j in range(i + 1, n):
            factor = A_aumentada[j, i] / A_aumentada[i, i]
            A_aumentada[j, i:] = A_aumentada[j, i:] - factor * A_aumentada[i, i:]
    
    # Fase de sustitución hacia atrás
    x = np.zeros(n)
    for i in range(n - 1, -1, -1):
        x[i] = A_aumentada[i, -1]
        for j in range(i + 1, n):
            x[i] = x[i] - A_aumentada[i, j] * x[j]
        x[i] = x[i] / A_aumentada[i, i]
    
    return x

# Ejemplo de uso
if __name__ == "__main__":
    # Sistema de ejemplo: 
    # 2x + y - z = 8
    # -3x - y + 2z = -11
    # -2x + y + 2z = -3
    A = np.array([
        [2, 1, -1],
        [-3, -1, 2],
        [-2, 1, 2]
    ])
    
    b = np.array([8, -11, -3])
    
    # Resolver usando Eliminación de Gauss
    solucion = eliminacion_gauss_simple(A, b)
    
    print("Solución:")
    for i, valor in enumerate(solucion):
        print(f"x{i+1} = {valor}")
    
    # Verificar la solución
    print("\nVerificación:")
    resultado = A @ solucion
    print("A * x =", resultado)
    print("b =", b)
    print("Error =", np.linalg.norm(resultado - b))
```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Simple.
### Ejercicio 1:
### Ejercicio 2:
### Ejercicio 3:
### Ejercicio 4:
### Ejercicio 5:(cuando no existe una solución)

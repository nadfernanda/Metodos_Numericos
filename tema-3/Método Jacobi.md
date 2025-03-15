## Definición
El método de Jacobi es una técnica de resolución de sistemas de ecuaciones lineales que genera una sucesión
de aproximaciones a la solución exacta. Funciona especialmente bien cuando la matriz A es diagonalmente
dominante (es decir, cuando el valor absoluto de cada elemento diagonal es mayor que la suma de los valores
absolutos de los demás elementos en su fila).

## Algoritmo 
# Pasos del Método de Jacobi

1. **Despejar** cada variable xi de su ecuación correspondiente:
   xi = (bi - suma de aij·xj para j≠i) / aii

2. **Elegir** valores iniciales para todas las variables x₁⁽⁰⁾, x₂⁽⁰⁾, ..., xₙ⁽⁰⁾

3. **Calcular** nuevos valores usando la fórmula:
   xi⁽ᵏ⁺¹⁾ = (bi - suma de aij·xj⁽ᵏ⁾ para j≠i) / aii

4. **Repetir** el paso 3 hasta que |xi⁽ᵏ⁺¹⁾ - xi⁽ᵏ⁾| < ε para todas las variables

5. **Verificar** que la solución obtenida satisface el sistema original

### Implementación en Python
```python
import numpy as np

def jacobi_method(A, b, tolerance=1e-10, max_iterations=100):
    """
    Implementación del método de Jacobi para resolver sistemas de ecuaciones lineales Ax = b
    
    Parámetros:
    - A: matriz de coeficientes (numpy array)
    - b: vector de términos independientes (numpy array)
    - tolerance: criterio de convergencia
    - max_iterations: número máximo de iteraciones
    
    Retorna:
    - x: solución aproximada del sistema
    - iterations: número de iteraciones realizadas
    - error_history: lista con los errores en cada iteración
    """
    # Tamaño del sistema
    n = len(b)
    
    # Vector inicial (todos ceros)
    x = np.zeros(n)
    
    # Vector para almacenar la nueva aproximación
    x_new = np.zeros(n)
    
    # Para almacenar el historial de errores
    error_history = []
    
    # Iteraciones
    for iteration in range(max_iterations):
        # Cálculo de la nueva aproximación
        for i in range(n):
            # Suma de los productos a_ij * x_j para j != i
            suma = 0
            for j in range(n):
                if j != i:
                    suma += A[i, j] * x[j]
            
            # Nueva aproximación para x_i
            x_new[i] = (b[i] - suma) / A[i, i]
        
        # Cálculo del error (norma de la diferencia)
        error = np.linalg.norm(x_new - x)
        error_history.append(error)
        
        # Verificar convergencia
        if error < tolerance:
            return x_new, iteration + 1, error_history
        
        # Actualizar x para la siguiente iteración
        x = np.copy(x_new)
    
    # Si se alcanza el número máximo de iteraciones sin convergencia
    return x, max_iterations, error_history

# Ejemplo de uso
if __name__ == "__main__":
    # Sistema de ejemplo
    A = np.array([
        [4, -1, 0],
        [-1, 4, -1],
        [0, -1, 4]
    ])
    
    b = np.array([15, 10, 10])
    
    # Resolver usando el método de Jacobi
    solution, iterations, errors = jacobi_method(A, b)
    
    print("Solución:", solution)
    print("Iteraciones realizadas:", iterations)
    print("Error final:", errors[-1])
    
    # Verificación
    print("Verificación Ax - b:", np.linalg.norm(A @ solution - b))
```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Seidel.
### Ejercicio 1:
### Ejercicio 2:
### Ejercicio 3:
### Ejercicio 4:
### Ejercicio 5:(cuando no existe una solución)

## Definición
El método de Gauss, también conocido como **eliminación gaussiana**, es un algoritmo utilizado para resolver
sistemas de ecuaciones lineales. Consiste en transformar el sistema original en un sistema equivalente más sencillo,
mediante operaciones elementales sobre las filas de la matriz aumentada del sistema. El objetivo es obtener una matriz
triangular superior (o una forma escalonada), a partir de la cual se pueden encontrar las soluciones mediante sustitución hacia atrás.

## Algoritmo 
1. Escribe la matriz aumentada [A B] del sistema de ecuaciones.
   
3. Aplica operaciones elementales para convertir la matriz en una forma escalonada (triangular superior):
  -Haz ceros debajo de los pivotes (primer elemento no nulo de cada fila).
  -Usa: intercambio de filas, multiplicación de filas por escalares, y suma/resta de filas.
4. Verifica la consistencia:
   -Si hay una fila [00…0∣c] con C ≠  0, no hay solución.
   -Si no, sigue adelante.
   
5. Obtén la solución:
   -Si la matriz es cuadrada y tiene pivotes en todas las filas, el sistema tiene solución única.
   -Si hay filas de ceros, el sistema tiene infinitas soluciones.
   
6. Resuelve por sustitución hacia atrás:
Despeja las incógnitas comenzando desde la última fila hacia arriba.

### Implementación en Python
```python
import numpy as np

def gauss_elimination(A, b):
    """
    Resuelve un sistema de ecuaciones lineales mediante el método de eliminación de Gauss.

    Parámetros:
    A (numpy.ndarray): Matriz de coeficientes del sistema.
    b (numpy.ndarray): Vector de términos independientes.

    Devuelve:
    numpy.ndarray: Vector de soluciones del sistema si hay solución única.
    """
    n = len(b)
    A = A.astype(float)  
    b = b.astype(float)

    # Crear matriz aumentada [A|b]
    Ab = np.hstack([A, b.reshape(-1, 1)])

    # Convertir la matriz en forma escalonada
    for i in range(n):
        if Ab[i, i] == 0:
            for k in range(i+1, n):
                if Ab[k, i] != 0:
                    Ab[[i, k]] = Ab[[k, i]]  # Intercambio de filas
                    break
        
        for j in range(i+1, n):
            if Ab[i, i] == 0:
                continue
            factor = Ab[j, i] / Ab[i, i]
            Ab[j, i:] -= factor * Ab[i, i:]

    # Verificar consistencia
    for i in range(n):
        if np.all(Ab[i, :-1] == 0) and Ab[i, -1] != 0:
            print("El sistema no tiene solución.")
            return None
    
    # Sustitución hacia atrás
    x = np.zeros(n)
    for i in range(n-1, -1, -1):
        if Ab[i, i] == 0:
            print("El sistema tiene infinitas soluciones o no tiene solución.")
            return None
        x[i] = (Ab[i, -1] - np.dot(Ab[i, i+1:n], x[i+1:n])) / Ab[i, i]

    # Mostrar solo la solución de x, y, z
    for i, val in enumerate(x):
        print(f"{['x', 'y', 'z'][i]} = {val:.6f}")

    return x

# Definir el sistema de ecuaciones 
A = np.array([[2, -1, 1],
              [4, 1, -2],
              [-2, 2, 4]], dtype=float)
b = np.array([3, -1, 7], dtype=float)

# Ejecutar el método de Gauss
solucion = gauss_elimination(A, b)
```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss.
### Ejercicio 1:
Sistema de ecuaciones:
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%201.png" width="60%" alt="sistemas de ecuaciones ejemplo1">
Resultado con python:
<img src="(https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E1.png)" width="60%" alt="Solucion E1">

### Ejercicio 2:
Sistema de ecuaciones:
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%202.png" width="60%" alt="sistemas de ecuaciones ejemplo2">
Resultado con python:
<img src="" width="60%" alt="Solucion E2">

### Ejercicio 3:

### Ejercicio 4:

### Ejercicio 5 (cuando no existe una solución):

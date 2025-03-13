import numpy as np

def gauss_elimination(A, b):
    """
    Resuelve un sistema de ecuaciones lineales utilizando el Método de Eliminación de Gauss.

    Parámetros:
    A (numpy.ndarray): Matriz de coeficientes del sistema.
    b (numpy.ndarray): Vector de términos independientes.

    Devuelve:
    numpy.ndarray: Vector de soluciones del sistema.
    """
    n = len(b)  # Número de ecuaciones
    
    # Fase de eliminación
    for i in range(n):
        for j in range(i+1, n):
            # Calcula el factor de eliminación para la fila j
            factor = A[j, i] / A[i, i]
            
            # Modifica la fila j restando un múltiplo de la fila i
            b[j] -= factor * b[i]  # Ajusta el término independiente
            A[j, i:] -= factor * A[i, i:]  # Ajusta los coeficientes de la fila
    
    # Fase de sustitución hacia atrás
    x = np.zeros(n)  # Vector para almacenar las soluciones
    for i in range(n-1, -1, -1):  # Recorre las ecuaciones desde la última hasta la primera
        x[i] = (b[i] - np.dot(A[i, i+1:], x[i+1:])) / A[i, i]
    
    return x

# Definición del sistema de ecuaciones lineales
A = np.array([[2, -1, 1],
              [3, 3, 9],
              [3, 3, 5]], dtype=float)
b = np.array([2, 15, 10], dtype=float)

# Resolver el sistema utilizando el método de Gauss
solucion = gauss_elimination(A, b)

# Imprimir la solución encontrada
print("Solución encontrada:", solucion)


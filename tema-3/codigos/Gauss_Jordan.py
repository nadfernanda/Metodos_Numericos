import numpy as np

def gauss_jordan(a, b, tol=1.0e-12):
    """
    Resuelve el sistema de ecuaciones lineales Ax = b utilizando el método de Gauss-Jordan.

    Parámetros:
    a (ndarray): Matriz de coeficientes del sistema (n x n).
    b (ndarray): Vector de términos independientes (n).
    tol (float): Tolerancia para detectar singularidad (valores cercanos a cero).

    Devuelve:
    ndarray: Solución del sistema de ecuaciones.
    """
    n = len(b)
    
    # Crear la matriz aumentada concatenando la matriz de coeficientes con el vector de términos independientes
    aug_matrix = np.hstack((a, b.reshape(-1, 1)))

    # Aplicar el método de eliminación Gauss-Jordan
    for i in range(n):
        # Encontrar la fila con el máximo valor absoluto en la columna actual para evitar divisiones por valores pequeños
        max_row = np.argmax(np.abs(aug_matrix[i:n, i])) + i
        
        # Intercambiar la fila actual con la fila que tiene el valor máximo en la columna i
        aug_matrix[[i, max_row]] = aug_matrix[[max_row, i]]

        # Verificar si el elemento diagonal es menor que la tolerancia, indicando una posible singularidad
        if np.abs(aug_matrix[i, i]) < tol:
            raise ValueError("La matriz es singular y no puede resolverse")

        # Normalizar la fila dividiéndola por el elemento diagonal para hacer que el pivote sea 1
        aug_matrix[i] = aug_matrix[i] / aug_matrix[i, i]

        # Eliminar los demás elementos de la columna i para obtener la forma escalonada reducida
        for j in range(n):
            if j != i:
                aug_matrix[j] -= aug_matrix[j, i] * aug_matrix[i]

    # Extraer la solución del sistema desde la última columna de la matriz aumentada
    x = aug_matrix[:, -1]
    return x

# Ejemplo de uso
# Definir la matriz de coeficientes (A) y el vector de términos independientes (b)
a = np.array([[2, 1, -1],
              [-3, -1, 2],
              [-2, 1, 2]], dtype=float)
b = np.array([8, -11, -3], dtype=float)

# Resolver el sistema utilizando el método de Gauss-Jordan
solucion = gauss_jordan(a, b)

# Imprimir la solución del sistema
print("Solución del sistema:")
print(solucion)

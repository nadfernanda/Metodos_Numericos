import numpy as np

def gauss_jordan(a, b, tol=1.0e-12):
    """
    Función para resolver el sistema de ecuaciones lineales Ax = b utilizando el método de Gauss-Jordan.

    Parámetros:
    a (ndarray): Matriz de coeficientes del sistema (n x n).
    b (ndarray): Vector de términos independientes (n).
    tol (float): Tolerancia para detectar singularidad.

    Devuelve:
    ndarray: Solución del sistema.
    """
    n = len(b)
    # Crear la matriz aumentada
    aug_matrix = np.hstack((a, b.reshape(-1, 1)))

    # Aplicar eliminación Gauss-Jordan
    for i in range(n):
        # Buscar el máximo elemento en la columna i
        max_row = np.argmax(np.abs(aug_matrix[i:n, i])) + i
        aug_matrix[[i, max_row]] = aug_matrix[[max_row, i]]

        # Verificar si la matriz es singular
        if np.abs(aug_matrix[i, i]) < tol:
            raise ValueError("La matriz es singular y no puede resolverse")

        # Hacer que el elemento diagonal sea 1
        aug_matrix[i] = aug_matrix[i] / aug_matrix[i, i]

        # Eliminar los demás elementos de la columna
        for j in range(n):
            if j != i:
                aug_matrix[j] -= aug_matrix[j, i] * aug_matrix[i]

    # La solución está en la última columna de la matriz aumentada
    x = aug_matrix[:, -1]
    return x

# Ejemplo de uso
# Definición de la matriz de coeficientes y el vector de términos independientes
a = np.array([[2, 1, -1],
              [-3, -1, 2],
              [-2, 1, 2]], dtype=float)
b = np.array([8, -11, -3], dtype=float)

# Aplicar el método de Gauss-Jordan
solucion = gauss_jordan(a, b)

# Imprimir la solución
print("Solución del sistema:")
print(solucion)
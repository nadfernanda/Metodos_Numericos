import numpy as np

def eliminacion_gauss_simple(A, b):
    """
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
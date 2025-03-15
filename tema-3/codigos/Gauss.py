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
    n = len(b)  # Número de ecuaciones (filas de la matriz A)
    A = A.astype(float)  # Convertir la matriz A a tipo float para garantizar la precisión en las operaciones
    b = b.astype(float)  # Convertir el vector b a tipo float para garantizar la precisión

    # Crear la matriz aumentada [A|b], uniendo la matriz A y el vector b
    Ab = np.hstack([A, b.reshape(-1, 1)])

    # Fase de eliminación (convertir la matriz a forma escalonada)
    for i in range(n):
        if Ab[i, i] == 0:  # Si el pivote es 0, buscamos una fila con un elemento no nulo
            for k in range(i+1, n):
                if Ab[k, i] != 0:  # Encontramos una fila con un valor no nulo en la columna i
                    Ab[[i, k]] = Ab[[k, i]]  # Intercambiamos las filas
                    break
        
        # Realizamos la eliminación de Gauss (hacemos ceros debajo del pivote)
        for j in range(i+1, n):
            if Ab[i, i] == 0:  # Si el pivote sigue siendo 0, continuamos con la siguiente columna
                continue
            factor = Ab[j, i] / Ab[i, i]  # Calculamos el factor para hacer ceros debajo del pivote
            Ab[j, i:] -= factor * Ab[i, i:]  # Restamos el factor multiplicado por la fila pivote de la fila j

    # Verificación de consistencia: Si hay una fila con todos ceros en A pero no en b, no hay solución
    for i in range(n):
        if np.all(Ab[i, :-1] == 0) and Ab[i, -1] != 0:
            print("El sistema no tiene solución.")
            return None
    
    # Fase de sustitución hacia atrás (obtenemos las soluciones)
    x = np.zeros(n)  # Inicializamos el vector de soluciones
    for i in range(n-1, -1, -1):  # Comenzamos desde la última fila y vamos hacia arriba
        if Ab[i, i] == 0:  # Si el pivote es 0, el sistema tiene infinitas soluciones o no tiene solución
            print("El sistema tiene infinitas soluciones o no tiene solución.")
            return None
        # Calculamos la solución para la variable correspondiente
        x[i] = (Ab[i, -1] - np.dot(Ab[i, i+1:n], x[i+1:n])) / Ab[i, i]

    # Mostrar la solución con los nombres de las variables (x, y, z)
    print("\nSolución del sistema:")
    variables = ['x', 'y', 'z']  # Definimos los nombres de las variables
    for i, val in enumerate(x):
        print(f"{variables[i]} = {val:.6f}")  # Imprimimos el valor de cada variable con 6 decimales

    return x  # Retornamos el vector con las soluciones

# Definir el sistema de ecuaciones (Ejercicio 1)
A = np.array([[2, -1, 1],   # Matriz de coeficientes A
              [4, 1, -2],
              [-2, 2, 4]], dtype=float)
b = np.array([3, -1, 7], dtype=float)  # Vector de términos independientes b

# Ejecutar el método de Gauss
solucion = gauss_elimination(A, b)

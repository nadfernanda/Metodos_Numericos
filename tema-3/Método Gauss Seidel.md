## Definición
El Método de Gauss-Seidel es un algoritmo iterativo utilizado para resolver sistemas de ecuaciones lineales.
Es una mejora del método de Jacobi y se utiliza para encontrar soluciones aproximadas a sistemas de la
forma Ax=b, donde A es una matriz cuadrada, x es el vector de incógnitas y b es el vector de términos independientes.

## Algoritmo 
1.Despeja cada incógnita:
De cada ecuación, despeja una variable en términos de las demás.

2.Inicia con un vector de solución:
Elige valores iniciales para todas las incógnitas (pueden ser ceros o estimaciones).

3.Actualiza las variables iterativamente:
Usa los valores más recientes de las variables para calcular las nuevas aproximaciones.

En cada paso, actualiza una variable a la vez usando los valores ya calculados.

4.Verifica la convergencia:
Repite el proceso hasta que la diferencia entre dos iteraciones sea muy pequeña (tolerancia)
o hasta alcanzar un número máximo de iteraciones.

5.Obtén la solución:
El último vector calculado es la aproximación a la solución del sistema.

### Implementación en Python
```python
import numpy as np

def gauss_seidel(A, b, x0, tol, Nmax):
    """
    Función para resolver un sistema de ecuaciones lineales utilizando el método de Gauss-Seidel.

    Parámetros:
    A (numpy.ndarray): Matriz de coeficientes del sistema.
    b (numpy.ndarray): Vector de términos independientes.
    x0 (numpy.ndarray): Vector de soluciones inicial.
    tol (float): Tolerancia para la convergencia.
    Nmax (int): Número máximo de iteraciones.

    Devuelve:
    numpy.ndarray: Vector de soluciones aproximado.
    int: Número de iteraciones realizadas.
    bool: Indicador de convergencia.
    """
    n = len(b)
    x = x0.copy()
    convergencia = False

    for k in range(Nmax):
        x_ant = x.copy()
        for i in range(n):
            suma = 0
            for j in range(n):
                if j != i:
                    suma += A[i, j] * x[j]
            x[i] = (b[i] - suma) / A[i, i]
        
        # Criterio de convergencia
        if np.linalg.norm(x - x_ant) < tol:
            convergencia = True
            break
    
    return x, k+1, convergencia

# Ejemplo de sistema de ecuaciones lineales
A = np.array([[4, 1, 1],
              [2, 7, 2],
              [1, 2, 4]], dtype=float)
b = np.array([2, 5, 3], dtype=float)
x0 = np.zeros_like(b)
tol = 1e-6
Nmax = 100

# Aplicar el método de Gauss-Seidel
solucion, iteraciones, convergencia = gauss_seidel(A, b, x0, tol, Nmax)

# Imprimir resultados
if convergencia:
    print(f"Solución encontrada: {solucion} en {iteraciones} iteraciones")
else:
    print(f"No se alcanzó la convergencia en {iteraciones} iteraciones")
```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Seidel.
### Ejercicio 1:
### Ejercicio 1:

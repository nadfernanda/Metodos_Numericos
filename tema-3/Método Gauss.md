## Definición
El método de Gauss, también conocido como **eliminación gaussiana**, es un algoritmo utilizado para resolver
sistemas de ecuaciones lineales. Consiste en transformar el sistema original en un sistema equivalente más sencillo,
mediante operaciones elementales sobre las filas de la matriz aumentada del sistema. El objetivo es obtener una matriz
triangular superior (o una forma escalonada), a partir de la cual se pueden encontrar las soluciones mediante sustitución hacia atrás.

## Algoritmo 
1. Escribe la matriz aumentada [A B] del sistema de ecuaciones.
   
2. Aplica operaciones elementales para convertir la matriz en una forma escalonada (triangular superior):
   
   -Haz ceros debajo de los pivotes (primer elemento no nulo de cada fila).

   -Usa: intercambio de filas, multiplicación de filas por escalares, y suma/resta de filas.

3. Verifica la consistencia:
   
   -Si hay una fila [00…0∣c] con C ≠  0, no hay solución.
   
   -Si no, sigue adelante.
   
4. Obtén la solución:
   
   -Si la matriz es cuadrada y tiene pivotes en todas las filas, el sistema tiene solución única.
   
   -Si hay filas de ceros, el sistema tiene infinitas soluciones.
   
5. Resuelve por sustitución hacia atrás:
   
   Despeja las incógnitas comenzando desde la última fila hacia arriba.

### Implementación en Java
```java
public class GaussElimination {

    /**
     * Resuelve un sistema de ecuaciones lineales mediante el método de eliminación de Gauss.
     *
     * @param A Matriz de coeficientes del sistema (n x n)
     * @param b Vector de términos independientes (n)
     * @return Vector de soluciones del sistema si hay solución única; null si no hay solución o hay infinitas soluciones.
     */
    public static double[] gaussElimination(double[][] A, double[] b) {
        int n = b.length;

        // Crear la matriz aumentada Ab = [A | b]
        double[][] Ab = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            // Copiar los coeficientes de A a Ab
            System.arraycopy(A[i], 0, Ab[i], 0, n);
            // Añadir el término independiente b a la última columna
            Ab[i][n] = b[i];
        }

        // Fase 1: Convertir Ab a forma escalonada mediante eliminación de Gauss
        for (int i = 0; i < n; i++) {
            // Verificar que el pivote no sea cero. Si es cero, intentar intercambiar con una fila inferior
            if (Math.abs(Ab[i][i]) < 1e-9) {
                for (int k = i + 1; k < n; k++) {
                    if (Math.abs(Ab[k][i]) > 1e-9) {
                        // Intercambio de filas i y k
                        double[] temp = Ab[i];
                        Ab[i] = Ab[k];
                        Ab[k] = temp;
                        break;
                    }
                }
            }

            // Eliminar los elementos debajo del pivote actual
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(Ab[i][i]) < 1e-9) {
                    continue; // No se puede dividir entre cero
                }
                double factor = Ab[j][i] / Ab[i][i];
                for (int k = i; k <= n; k++) {
                    Ab[j][k] -= factor * Ab[i][k];
                }
            }
        }

        // Fase 2: Verificar si el sistema es inconsistente (no tiene solución)
        for (int i = 0; i < n; i++) {
            boolean allZero = true;
            for (int j = 0; j < n; j++) {
                if (Math.abs(Ab[i][j]) > 1e-9) {
                    allZero = false;
                    break;
                }
            }
            // Si toda la fila de coeficientes es 0 pero el término independiente no es 0
            if (allZero && Math.abs(Ab[i][n]) > 1e-9) {
                System.out.println("El sistema no tiene solución.");
                return null;
            }
        }

        // Fase 3: Sustitución hacia atrás para encontrar las soluciones
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(Ab[i][i]) < 1e-9) {
                System.out.println("El sistema tiene infinitas soluciones o no tiene solución.");
                return null;
            }
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += Ab[i][j] * x[j];
            }
            x[i] = (Ab[i][n] - sum) / Ab[i][i];
        }

        // Mostrar la solución (x, y, z)
        String[] vars = {"x", "y", "z"};
        for (int i = 0; i < n; i++) {
            String var = (i < 3) ? vars[i] : "x" + (i + 1); // Manejo para más de 3 variables
            System.out.printf("%s = %.4f%n", var, x[i]);
        }

        return x;
    }

    public static void main(String[] args) {
        // Definir la matriz de coeficientes A y el vector de términos independientes b
        double[][] A = {
            {2, -1, 1},
            {4, 1, -2},
            {-2, 2, 4}
        };
        double[] b = {3, -1, 7};

        // Ejecutar el método de Gauss
        double[] solucion = gaussElimination(A, b);
    }
}

```
## Ejercicios Prácticos
### Ejercicio 1
Sistema de ecuaciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%201.png" width="30%" alt="sistemas de ecuaciones ejemplo1">

## Solución con algoritmo de java

<img src="(https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E1.png)" width="30%" alt="Solucion E1">

### Ejercicio 2
Sistema de ecuaciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%202.png" width="30%" alt="sistemas de ecuaciones ejemplo2">

## Solución con algoritmo de java

<img src="" width="30%" alt="Solucion E2">

### Ejercicio 3:

### Ejercicio 4:

### Ejercicio 5 (cuando no existe una solución):

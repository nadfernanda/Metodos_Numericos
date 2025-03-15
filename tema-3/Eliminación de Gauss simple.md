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

### Implementación en Java
```java
import java.util.Arrays;

/**
 * Clase que implementa el método de eliminación de Gauss para resolver sistemas de ecuaciones lineales.
 */
public class GaussElimination {
    
    /**
     * Aplica el método de eliminación de Gauss para resolver un sistema de ecuaciones lineales.
     * @param A Matriz de coeficientes del sistema.
     * @param b Vector de términos independientes.
     * @return Vector con la solución del sistema.
     */
    public static double[] eliminacionGaussSimple(double[][] A, double[] b) {
        int n = b.length;
        double[][] A_aumentada = new double[n][n + 1];
        
        // Construir la matriz aumentada [A|b]
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, A_aumentada[i], 0, n);
            A_aumentada[i][n] = b[i];
        }
        
        // Fase de eliminación hacia adelante
        for (int i = 0; i < n; i++) {
            // Pivoteo parcial: encontrar la fila con el mayor valor absoluto en la columna actual
            int maxFila = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A_aumentada[k][i]) > Math.abs(A_aumentada[maxFila][i])) {
                    maxFila = k;
                }
            }
            
            // Intercambiar filas si es necesario
            if (maxFila != i) {
                double[] temp = A_aumentada[i];
                A_aumentada[i] = A_aumentada[maxFila];
                A_aumentada[maxFila] = temp;
            }
            
            // Eliminación de los elementos por debajo del pivote
            for (int j = i + 1; j < n; j++) {
                double factor = A_aumentada[j][i] / A_aumentada[i][i];
                for (int k = i; k <= n; k++) {
                    A_aumentada[j][k] -= factor * A_aumentada[i][k];
                }
            }
        }
        
        // Fase de sustitución hacia atrás para encontrar la solución
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = A_aumentada[i][n];
            for (int j = i + 1; j < n; j++) {
                x[i] -= A_aumentada[i][j] * x[j];
            }
            x[i] /= A_aumentada[i][i];
        }
        
        return x;
    }
    
    /**
     * Método principal que prueba la eliminación de Gauss con un sistema de ejemplo.
     * Imprime la solución del sistema en la consola.
     */
    public static void main(String[] args) {
        // Definición de la matriz de coeficientes A
        double[][] A = {
            {2, 1, -1},
            {-3, -1, 2},
            {-2, 1, 2}
        };
        
        // Definición del vector de términos independientes b
        double[] b = {8, -11, -3};
        
        // Resolver el sistema usando Eliminación de Gauss
        double[] solucion = eliminacionGaussSimple(A, b);
        
        // Imprimir la solución
        char[] variables = {'x', 'y', 'z'};
        System.out.println("Solución:");
        for (int i = 0; i < solucion.length; i++) {
            System.out.printf("%c = %.6f\n", variables[i], solucion[i]);
        }
    }
}
```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Simple.
### Ejercicio 1: Sistema con solución única
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%201.png" width="15%" alt="Ejercicio 1">

**Solución con algoritmo de java**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E1.png" width="15%" alt="Solución Ejercicio 1">

### Ejercicio 2: Sistema con solución única

### Ejercicio 3: Sistema sin solución

### Ejercicio 4: Sistema con solución única

### Ejercicio 5: Sistema con solución única

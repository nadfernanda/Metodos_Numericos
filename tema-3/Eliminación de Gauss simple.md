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
### Ejercicio 1
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%201.png" width="20%" alt="Ejercicio 1">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E1.png" width="20%" alt="Solución Ejercicio 1">

**Análisis**

El sistema de ecuaciones lineales fue resuelto correctamente usando el método de eliminación de Gauss simple, obteniendo la solución:
x=3.000000,y=1.000000,z=1.000000
La verificación al sustituir estos valores en las tres ecuaciones demuestra que satisfacen el sistema, por lo tanto, la solución es correcta.
El método de eliminación de Gauss permitió transformar el sistema en una forma escalonada y despejar las variables de manera eficiente, lo que confirma que el sistema es compatible determinado, es decir, tiene una única solución.
Geométricamente, esto significa que los tres planos representados por las ecuaciones se intersecan en un solo punto, el cual es (3,1,1). La solución presenta buena precisión, expresada con seis cifras decimales.

### Ejercicio 2
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%202.png" width="20%" alt="Ejercicio 2">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E2.png" width="20%" alt="Solución Ejercicio 2">

**Análisis**

El sistema de ecuaciones lineales fue resuelto utilizando el método de eliminación de Gauss simple, obteniendo como resultado:
x=1.000000,y=1.000000,z=1.000000
Al verificar esta solución en las ecuaciones dadas, se confirma que cumple con todas ellas, lo que garantiza que la solución es correcta.
El método de eliminación de Gauss permitió reducir el sistema a una forma escalonada que facilitó el cálculo de las variables, mostrando que el sistema es compatible determinado (tiene una única solución).
Desde una perspectiva geométrica, las tres ecuaciones representan planos que se intersecan en un único punto en el espacio tridimensional, el punto (1,1,1). La solución tiene una buena precisión, expresada con seis cifras decimales.

### Ejercicio 3 (sin solución)
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%203.png" width="20%" alt="Ejercicio 3">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E3.png" width="20%" alt="Solución Ejercicio 3">

**Análisis**

Este sistema no tiene solución porque sus filas son linealmente dependientes. Las filas 2 y 3 son múltiplos de la fila 1, lo que implica una contradicción en los términos independientes. Por ejemplo, al multiplicar la primera ecuación por 3, obtenemos 3x + 3y + 3z = 18, lo cual contradice la tercera ecuación, que es 3x + 3y + 3z = 15. Debido a esta inconsistencia, el algoritmo de Gauss fallará o generará resultados incorrectos, posiblemente por una división por cero.

### Ejercicio 4
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%204.png" width="20%" alt="Ejercicio 4">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E4.png" width="20%" alt="Solución Ejercicio 4">

**Análisis**

El sistema de ecuaciones lineales fue resuelto utilizando el método de eliminación de Gauss simple, obteniendo como resultado:
x=2.000000,y=3.000000,z=1.000000
Al verificar esta solución en las ecuaciones dadas, se confirma que cumple con todas ellas, lo que garantiza que la solución es correcta.
El método de eliminación de Gauss permitió reducir el sistema a una forma escalonada que facilitó el cálculo de las variables, mostrando que el sistema es compatible determinado (tiene una única solución).
Desde una perspectiva geométrica, las tres ecuaciones representan planos que se intersecan en un único punto en el espacio tridimensional, el punto (2,3,1). La solución tiene una buena precisión, expresada con seis cifras decimales.

### Ejercicio 5
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Ejercicio%205.png" width="20%" alt="Ejercicio 5">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss/Solucion%20E5.png" width="20%" alt="Solución Ejercicio 5">

**Análisis**

El sistema de ecuaciones lineales fue resuelto utilizando el método de eliminación de Gauss simple, obteniendo como resultado:
x=2.000000,y=1.000000,z=2.000000
Al verificar esta solución en las ecuaciones dadas, se confirma que cumple con todas ellas, lo que garantiza que la solución es correcta.
El método de eliminación de Gauss permitió reducir el sistema a una forma escalonada que facilitó el cálculo de las variables, mostrando que el sistema es compatible determinado (tiene una única solución).
Desde una perspectiva geométrica, las tres ecuaciones representan planos que se intersecan en un único punto en el espacio tridimensional, el punto (2,1,2). La solución tiene una buena precisión, expresada con seis cifras decimales.

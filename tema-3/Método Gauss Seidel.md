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

### Implementación en Java
```java
import java.util.Arrays;

public class GaussSeidel{ 
    /** 
     * @param A     Matriz de coeficientes del sistema.
     * @param b     Vector de términos independientes.
     * @param x0    Vector de soluciones inicial.
     * @param tol   Tolerancia para la convergencia.
     * @param Nmax  Número máximo de iteraciones.
     * @return      Un arreglo que contiene: [Vector de soluciones aproximado, Número de iteraciones, Indicador de convergencia]
     */

     public static Object [] gaussSeidel(double[][] A, double[] b, double[] x0, double tol, int Nmax) {
        int n = b.length; // Número de incógnitas
        double[] x = Arrays.copyOf(x0, n);// Copia del vector inicial para no modificar el original
        boolean convergencia = false;// Indicador de si el método convergió
        int k;//Contador de interaciones
        
        // Iteración principal de Gauss Seidel
        for (k = 0; k < Nmax; k++) {
            double[] x_ant = Arrays.copyOf(x, n); // Guardar la solución anterior para comparar
            
            for (int i = 0; i < n; i++) {
                double suma = 0;
                  // Suma de A[i][j] * x[j], excepto cuando j = i
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }
                 // Actualización de la solución para la variable i
                x[i] = (b[i] - suma) / A[i][i];
            }
            
            // Verificación del criterio de convergencia: norma de la diferencia < tolerancia
            if (norma(restaVectores(x, x_ant)) < tol) {
                convergencia = true;
                break; // Salir del ciclo si se alcanzó la tolerancia
            }
        }
        
        return new Object[]{x, k + 1, convergencia};
    }
/**
     * Calcula la norma euclidiana de un vector.
     * 
     * @param vector Vector para calcular la norma.
     * @return Norma euclidiana del vector.
     */
    private static double norma(double[] vector) {
        double suma = 0;
        for (double v : vector) {
            suma += v * v;// Suma de cuadrados de los elementos
        }
        return Math.sqrt(suma);// Raíz cuadrada de la suma
    }
    
    /**
     * Resta de dos vectores (a - b).
     * 
     * @param a Primer vector.
     * @param b Segundo vector.
     * @return Vector resultado de la resta.
     */
    private static double[] restaVectores(double[] a, double[] b) {
        double[] resultado = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            resultado[i] = a[i] - b[i];
        }
        return resultado;
    }
     /**
     * Método principal para ejecutar un ejemplo del método de Gauss-Seidel.
     */
    public static void main(String[] args) {
        // Definición del sistema de ecuaciones lineales
        double[][] A = {
            {5, 1, 1},
            {1, 4, 1},
            {1, 1, 6}
        };
        double[] b = {7, 6, 8};
        // Vector inicial x0 (se asume [0, 0, 0])
        double[] x0 = new double[b.length]; // Inicializado con ceros
        double tol = 1e-10; // Tolerancia deseada para la convergencia
        int Nmax = 100;// Máximo número de iteraciones permitidas
        
        // Aplicar el método de Gauss-Seidel
        Object[] resultado = gaussSeidel(A, b, x0, tol, Nmax);
        double[] solucion = (double[]) resultado[0];
        int iteraciones = (int) resultado[1];
        boolean convergencia = (boolean) resultado[2];
        
        // Imprimir resultados
        if (convergencia) {
            System.out.println("Solución encontrada en " + iteraciones + " iteraciones:");
            System.out.println("x = " + String.format("%.6f", solucion[0]));
            System.out.println("y = " + String.format("%.6f", solucion[1]));
            System.out.println("z = " + String.format("%.6f", solucion[2]));
        } else {
            System.out.println("No se alcanzó la convergencia en " + iteraciones + " iteraciones");
        }

    }
}


```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Seidel.
### Ejercicio 1: 
Resuelve el siguiente sistema de ecuaciones en 11 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%201.png" width="20%" alt="Ejercicio 1">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E1.png" width="30%" alt="Solución Ejercicio 1">

**Análisis**
El método de Gauss-Seidel permitió resolver el sistema de ecuaciones de manera iterativa, aproximando los valores de las variables mediante sucesivas correcciones hasta alcanzar la convergencia.
El sistema es compatible determinado, ya que tiene una única solución en el punto:
x=1,y=2,z=0
Después de 11 iteraciones, el algoritmo alcanzó una solución precisa, mostrando los valores con seis cifras decimales. Esto indica que el método logró una convergencia estable y rápida hacia el resultado correcto.
La precisión de los resultados obtenidos es adecuada, reflejada en el número de cifras decimales mostradas y en la estabilidad de la convergencia. La solución obtenida es exacta y coherente con el sistema original, lo que confirma que el método de Gauss-Seidel fue eficiente y adecuado para resolver este sistema lineal.

### Ejercicio 2:
Resuelve el siguiente sistema de ecuaciones en 12 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%202.png" width="20%" alt="Ejercicio 2">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E2.png" width="30%" alt="Solución Ejercicio 2">

**Análisis**
El método de Gauss-Seidel permitió resolver el sistema de ecuaciones mediante aproximaciones sucesivas, corrigiendo los valores de las variables hasta alcanzar la solución.
El sistema es compatible determinado, ya que tiene una única solución en el punto:
x=1,y=1,z=1
El algoritmo encontró esta solución después de 12 iteraciones, mostrando valores consistentes y exactos con seis cifras decimales, lo que demuestra que el proceso de iteración fue efectivo y preciso.
La solución obtenida es coherente con el sistema original y refleja una convergencia estable, lo que confirma que el método de Gauss-Seidel fue eficiente y adecuado para resolver este sistema lineal.

### Ejercicio 3:
Resuelve el siguiente sistema de ecuaciones en 13 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%203.png" width="20%" alt="Ejercicio 3">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E3.png" width="30%" alt="Solución Ejercicio 4">

**Análisis**
Se comprueba que la solución del sistema:
x=1.000000,y=−2.000000,z=−2.000000
es correcta, ya que al sustituir estos valores en las ecuaciones originales, se satisfacen todas ellas.
El método de Gauss-Jordan permitió llevar la matriz aumentada del sistema a su forma reducida por filas, facilitando la obtención directa de los valores de las variables sin necesidad de sustitución hacia atrás.
El sistema es compatible determinado, es decir, tiene una única solución, y los planos representados por las ecuaciones se intersecan en el punto (1, -2, -2). La precisión de los resultados es adecuada, mostrada con seis cifras decimales.
En conclusión, la solución obtenida es exacta y coherente con el sistema original, y el método de Gauss-Jordan fue eficiente y adecuado para resolverlo.

### Ejercicio 4:
Resuelve el siguiente sistema de ecuaciones en 8 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%204.png" width="20%" alt="Ejercicio 4">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E4.png" width="30%" alt="Solución Ejercicio 4">

**Análisis**
Los resultados obtenidos con el método de Gauss-Seidel para el sistema propuesto son correctos. La solución encontrada (x = 1.299980, y = 2.868074, z = 2.698194) satisface perfectamente las tres ecuaciones del sistema cuando se sustituyen estos valores, y el método ha convergido en exactamente 8 iteraciones como se esperaba debido a la fuerte dominancia diagonal de la matriz de coeficientes. Esto demuestra que el algoritmo implementado funciona adecuadamente y es capaz de encontrar soluciones precisas en un número predecible de iteraciones para sistemas con buenas propiedades de convergencia.

### Ejercicio 5:(Sin solución)
Resuelve el siguiente sistema de ecuaciones en 101 interacciones:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Ejercicio%205.png" width="20%" alt="Ejercicio 5">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_seidel/Solucion%20E5.png" width="40%" alt="Solución Ejercicio 5">

**Análisis**
Este sistema no debería converger con el método de Gauss-Seidel porque no cumple con el criterio de dominancia diagonal. Para cada fila, el elemento en la diagonal principal debería ser mayor que la suma de los valores absolutos de los demás elementos en esa fila, lo cual no ocurre aquí.



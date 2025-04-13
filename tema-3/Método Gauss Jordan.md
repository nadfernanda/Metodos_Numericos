## Definición
El método de Gauss-Jordan es una técnica numérica utilizada para resolver sistemas de ecuaciones lineales de la forma ( Ax = b ). Se basa en la eliminación de Gauss con una serie de pasos adicionales para convertir la matriz de coeficientes en una matriz identidad, simplificando la obtención de la solución.

## Algoritmo 
1.Definir la matriz de coeficientes ( A ) y el vector de términos independientes ( b ).

2.Construir la matriz aumentada ([A | b]).

3.Aplicar las operaciones de fila para transformar la matriz aumentada en la forma ([I | x]), donde ( I ) es la matriz identidad.

4.El vector resultante en la columna de términos independientes es la solución ( x ).

### Implementación en Java
```java

public class GaussJordan {
    /**
     * @param a Matriz de coeficientes del sistema (matriz cuadrada n x n)
     * @param b Vector de términos independientes (tamaño n)
     * @return Vector con la solución del sistema de ecuaciones
     * @throws ArithmeticException Si la matriz es singular (no tiene solución única)
     */

    public static double [] gaussJordan (double [][] a, 
    double [] b){
        int n = b.length;
        double [][] augMatrix = new double[n][n+1];

        //Crear la matriz aumentada [A|b]
        for (int i=0; i<n;i++){ 
            System.arraycopy(a[i],0, augMatrix[i], 0, n);
            augMatrix[i][n] = b[i];// Último elemento de cada fila es el término independiente

        }

        //Aplicar aliminación Gauss Jordan 
        for (int i=0; i<n;i++){ // Buscar el máximo elemento en la columna i (pivoteo parcial)
            for (int i=0;i<n; i++){ 

        //Buscar el elemento maximo en la columna i
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augMatrix[k][i]) > Math.abs(augMatrix[maxRow][i])) {
                    maxRow = k;
            }
        }

        //Intercambiar filas para poner el elemento mayor absoluto en la diagonal
        double [] temp = augMatrix[i];
        augMatrix[i] = augMatrix[maxRow];
        augMatrix[maxRow] = temp;

        //Verficar si la matriz es singular
        // Si el elemento de la diagonal es cero (o muy cercano), el sistema no tiene solución única
        if (augMatrix[i][i] == 0) {
            throw new ArithmeticException("La matriz es singular y no puede resolverse");
        }

        // Normalizar la fila i (hacer que el elemento diagonal sea 1)
        double diag = augMatrix[i][i];
            for (int j = 0; j <= n; j++) {
                augMatrix[i][j] /= diag;
            }

        //Eliminar los demas elementos de la columna i
        // Este paso hace ceros todos los elementos de la columna excepto el elemento diagonal
        for (int j = 0; j < n; j++) {
            if (j != i) {
                double factor = augMatrix[j][i];
                for (int k = 0; k <= n; k++) {
                    augMatrix[j][k] -= factor * augMatrix[i][k];
                }
            }
        }
}
        //Extraer la solucion
        // En este punto, la matriz aumentada tiene la forma [I|x] donde I es la matriz identidad
        // y x es el vector solución

        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = augMatrix[i][n];
        }
        return x;
    }
    /**
     * Método principal para probar el algoritmo con un sistema de ejemplo 3x3.
     * Sistema de ejemplo:
     * x + 2y + 3z = 9
     * 2x + 3y + 3z = 15
     * 3x + 4y + 5z = 22
     */
public static void main (String[] args) {
    // Matriz de coeficientes
    double[][] a = {
        {2, 1, -1},
        {-3, -1, 2},
        {-2, 1, 2}
    };
     // Vector de términos independientes
    double[] b = {8, -11, -3};

    try {
        // Resolver el sistema
        double[] solucion = gaussJordan(a, b);
        // Mostrar la solución
            System.out.println("Solución del sistema:");
            System.out.printf("x = %.6f\n", solucion[0]);
            System.out.printf("y = %.6f\n", solucion[1]);
            System.out.printf("z = %.6f\n", solucion[2]);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

## Ejercicios Prácticos
### Ejercicio 1
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Ejercicio%201.png" width="20%" alt="Ejercicio 1">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Solucion%20E1.png" width="20%" alt="Solución Ejercicio 1">

**Análisis**

El método de Gauss-Jordan permitió llevar la matriz aumentada del sistema a su forma reducida por filas, facilitando la obtención directa de los valores de las variables sin necesidad de sustitución hacia atrás.
El sistema es compatible determinado, es decir, tiene una única solución, y los planos representados por las ecuaciones se intersecan en el punto (1, 2, 3). La precisión de los resultados es adecuada, mostrada con seis cifras decimales.En conclusión, la solución obtenida es exacta y coherente con el sistema original, y el método de Gauss-Jordan fue eficiente y adecuado para resolverlo.

### Ejercicio 2
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Ejercicio%202.png" width="20%" alt="Ejercicio 2">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Solucion%20E2.png" width="20%" alt="Solución Ejercicio 2">

**Análisis**

El método de Gauss-Jordan permitió llevar la matriz aumentada del sistema a su forma reducida por filas, facilitando la obtención directa de los valores de las variables sin necesidad de sustitución hacia atrás.
El sistema es compatible determinado, es decir, tiene una única solución, y los planos representados por las ecuaciones se intersecan en el punto (2, 3, -1). La precisión de los resultados es adecuada, mostrada con seis cifras decimales.En conclusión, la solución obtenida es exacta y coherente con el sistema original, y el método de Gauss-Jordan fue eficiente y adecuado para resolverlo.

### Ejercicio 3
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Ejercicio%203.png" width="20%" alt="Ejercicio 3">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Solucion%20E3.png" width="20%" alt="Solución Ejercicio 3">

**Análisis**

El método de Gauss-Jordan permitió llevar la matriz aumentada del sistema a su forma reducida por filas, facilitando la obtención directa de los valores de las variables sin necesidad de sustitución hacia atrás.
El sistema es compatible determinado, es decir, tiene una única solución, y los planos representados por las ecuaciones se intersecan en el punto (1, -2, -2). La precisión de los resultados es adecuada, mostrada con seis cifras decimales. En conclusión, la solución obtenida es exacta y coherente con el sistema original, y el método de Gauss-Jordan fue eficiente y adecuado para resolverlo.

### Ejercicio 4
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Ejercicio%204.png" width="20%" alt="Ejercicio 4">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Solucion%20E4.png" width="20%" alt="Solución Ejercicio 4">

**Análisis**

El método de Gauss-Jordan permitió llevar la matriz aumentada del sistema a su forma reducida por filas, facilitando la obtención directa de los valores de las variables sin necesidad de sustitución hacia atrás.
El sistema es compatible determinado, es decir, tiene una única solución, y los planos representados por las ecuaciones se intersecan en el punto (4, -1, 2). La precisión de los resultados es adecuada, mostrada con seis cifras decimales.
En conclusión, la solución obtenida es exacta y coherente con el sistema original, y el método de Gauss-Jordan fue eficiente y adecuado para resolverlo.

### Ejercicio 5 (sin solución)
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Ejercicio%205.png" width="20%" alt="Ejercicio 5">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_gauss_jordan/Solucion%20E5.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

Este sistema no tiene solución porque las dos primeras ecuaciones son equivalentes (representan el mismo plano), pero la tercera es contradictoria: dice que x + y + z = 4, mientras que la primera dice x + y + z = 3. No puede ser ambas cosas a la vez, por eso no hay ningún valor de x, y, z que cumpla las tres ecuaciones al mismo tiempo. El sistema es incompatible.

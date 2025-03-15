## Definición
El método de Gauss-Jordan es una técnica numérica utilizada para resolver sistemas de ecuaciones lineales de la forma ( Ax = b ). Se basa en la eliminación de Gauss con una serie de pasos adicionales para convertir la matriz de coeficientes en una matriz identidad, simplificando la obtención de la solución.

## Algoritmo 
1.Definir la matriz de coeficientes ( A ) y el vector de términos independientes ( b ).

2.Construir la matriz aumentada ([A | b]).

3.Aplicar las operaciones de fila para transformar la matriz aumentada en la forma ([I | x]), donde ( I ) es la matriz identidad.

4.El vector resultante en la columna de términos independientes es la solución ( x ).

### Implementación en Java
```java
import java.util.Arrays;

public class GaussJordan {
    public static double [] GaussJordan (double [][] a, 
    double [] b){
        int n = b.length;
        double [][] augMatrix = new double[n][n+1];

        //Crear la matriz aumentada
        for (int i=0; i<n;i++){
            System.arraycopy(a[i], 0, augMatrix[i], 0, n);
            augMatrix[i][n] = b[i];
        }

        //Aplicar aliminacion gauss jordan 
        for (int i=0;i<n; i++){

        //Buscar el elemento maximo en la columna i
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augMatrix[k][i]) > Math.abs(augMatrix[maxRow][i])) {
                    maxRow = k;
            }
        }
        //Intercambiar filas
        double [] temp = augMatrix[i];
        augMatrix[i] = augMatrix[maxRow];
        augMatrix[maxRow] = temp;

        //Verficar si la matriz es singular
        if (augMatrix[i][i] == 0) {
            throw new ArithmeticException("La matriz es singular y no puede resolverse");
        }
        //Hacer elemento diagonla sea 1
        double diag = augMatrix[i][i];
            for (int j = 0; j <= n; j++) {
                augMatrix[i][j] /= diag;
            }
        //Eliminar los demas elementos de la columna
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
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = augMatrix[i][n];
        }
        return x;
    }
public static void main (String[] args) {
//Matriz de uso (ejemplo)

    double[][] a = {
        {2, 1, -1},
        {-3, -1, 2},
        {-2, 1, 2}
    };
    double[] b = {8, -11, -3};

    try {
        double[] solucion = gaussJordan(a, b);
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
Resolver los siguientes sistemas de ecuaciones utilizando el método de eliminación de Gauss Jordan.
### Ejercicio 1: 
### Ejercicio 2:
### Ejercicio 3:
### Ejercicio 4:
### Ejercicio 5:

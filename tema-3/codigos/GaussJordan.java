
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
            System.out.printf("x = %.4f\n", solucion[0]);
            System.out.printf("y = %.4f\n", solucion[1]);
            System.out.printf("z = %.4f\n", solucion[2]);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}



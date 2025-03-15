import java.util.Arrays;

public class GaussJordan {
    public static double [] GaussJordan (double [][] a, 
    double [] b){
        int n = b.length;
        double [][] augMatrix = new double[n][n+1];

        //crear la matriz aumentada
        for (int i=0; i<n;i++){
            System.arraycopy(a[i], 0, augMatrix[i], 0, n);
            augMatrix[i][n] = b[i];
        }

        //aplicar aliminacion gauss jordan 
        for (int i=0;i<n; i++){

        //buscar el elemento maximo en la columna i
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augMatrix[k][i]) > Math.abs(augMatrix[maxRow][i])) {
                    maxRow = k;
            }
        }
        //intercambiar filas
        double [] temp = augMatrix[i];
        augMatrix[i] = augMatrix[maxRow];
        augMatrix[maxRow] = temp;

        //verficar si la matriz es singular
        if (augMatrix[i][i] == 0) {
            throw new ArithmeticException("La matriz es singular y no puede resolverse");
        }
        //hacer elemento diagonla sea 1
        double diag = augMatrix[i][i];
            for (int j = 0; j <= n; j++) {
                augMatrix[i][j] /= diag;
            }
        //eliminar los demas elementos de la columna
        for (int j = 0; j < n; j++) {
            if (j != i) {
                double factor = augMatrix[j][i];
                for (int k = 0; k <= n; k++) {
                    augMatrix[j][k] -= factor * augMatrix[i][k];
                }
            }
        }
}
        //extraer la solucion
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = augMatrix[i][n];
        }
        return x;
    }
public static void main (String[] args) {
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



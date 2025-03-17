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
        int n = b.length;
        double[] x = Arrays.copyOf(x0, n);
        boolean convergencia = false;
        int k;
        
        for (k = 0; k < Nmax; k++) {
            double[] x_ant = Arrays.copyOf(x, n);
            
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - suma) / A[i][i];
            }
            
            // Criterio de convergencia
            if (norma(restaVectores(x, x_ant)) < tol) {
                convergencia = true;
                break;
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
            suma += v * v;
        }
        return Math.sqrt(suma);
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
    
    public static void main(String[] args) {
        // Ejemplo de sistema de ecuaciones lineales
        double[][] A = {
            {5, 1, 1},
            {1, 4, 1},
            {1, 1, 6}
        };
        double[] b = {7, 6, 8};
        double[] x0 = new double[b.length]; // Inicializado con ceros
        double tol = 1e-10;
        int Nmax = 100;
        
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


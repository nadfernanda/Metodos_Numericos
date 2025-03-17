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


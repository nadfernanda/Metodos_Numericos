
public class Jacobi {

    // Clase interna para almacenar el resultado del método: la solución y el número de iteraciones
    public static class Result {
        double[] solution;   // Vector solución aproximada
        int iterations;      // Número de iteraciones realizadas

        public Result(double[] solution, int iterations) {
            this.solution = solution;
            this.iterations = iterations;
        }
    }

    /**
     * Método que implementa el algoritmo de Jacobi.
     *
     * @param A              Matriz de coeficientes del sistema (n x n)
     * @param b              Vector de términos independientes (n)
     * @param tolerance      Tolerancia del error para la condición de parada
     * @param maxIterations  Número máximo de iteraciones permitidas
     * @return               Objeto Result que contiene la solución aproximada y el número de iteraciones
     */
    public static Result jacobiMethod(double[][] A, double[] b, double tolerance, int maxIterations) {
        int n = b.length;
        double[] x = new double[n];      // Vector inicializado en ceros
        double[] xNew = new double[n];   // Vector para almacenar la nueva aproximación
        double error;                    // Error entre iteraciones

        // Bucle principal del método de Jacobi
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Calcular nueva aproximación xNew
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j]; // Suma de A[i][j] * x[j], excluyendo j = i
                    }
                }
                xNew[i] = (b[i] - suma) / A[i][i];  // Fórmula de Jacobi
            }

            // Calcular el error como la norma euclidiana ||xNew - x||
            error = 0;
            for (int i = 0; i < n; i++) {
                double diff = xNew[i] - x[i];
                error += diff * diff;
            }
            error = Math.sqrt(error);

            // Verificar si el error es menor que la tolerancia -> solución encontrada
            if (error < tolerance) {
                return new Result(xNew, iteration + 1);  // Se retorna xNew y el número de iteraciones
            }

            // Copiar xNew en x para la siguiente iteración
            System.arraycopy(xNew, 0, x, 0, n);
        }

        // Si se alcanza el número máximo de iteraciones sin cumplir la tolerancia
        return new Result(x, maxIterations);
    }

    // Método principal para probar el algoritmo de Jacobi con un sistema 3x3
    public static void main(String[] args) {
        // Definición de la matriz A (coeficientes) y vector b (términos independientes)
        double[][] A = {
            {10, 2, 1},
            {2, 20, -2},
            {-2, 3, 10}
        };

        double[] b = {9, -44, 22};

        double tolerance = 1e-10;      // Tolerancia deseada
        int maxIterations = 100;      // Máximo número de iteraciones

        // Llamada al método de Jacobi
        Result result = jacobiMethod(A, b, tolerance, maxIterations);

        // Imprimir la solución aproximada
        System.out.println("Solución aproximada:");
        for (int i = 0; i < result.solution.length; i++) {
            String variable = (i == 0) ? "x" : (i == 1) ? "y" : "z";
           System.out.printf("%s = %.4f%n", variable, result.solution[i]);
        }

        // Imprimir el número de iteraciones realizadas
        System.out.println("Iteraciones realizadas: " + result.iterations);
    }
}

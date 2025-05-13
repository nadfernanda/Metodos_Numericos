public class InterpolacionPolinomial {

    /**
     * Calcula los coeficientes del polinomio interpolante usando el método de 
     * diferencias divididas de Newton.
     *
     * @param x Arreglo con los valores de x (nodos).
     * @param y Arreglo con los valores de y correspondientes a cada x.
     * @return Arreglo con los coeficientes del polinomio en forma de Newton.
     */
    public static double[] diferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[] coeficientes = new double[n];       // Arreglo para guardar los coeficientes del polinomio
        double[][] tabla = new double[n][n];         // Tabla de diferencias divididas

        // Llenar la primera columna de la tabla con los valores de y
        for (int i = 0; i < n; i++)
            tabla[i][0] = y[i];

        // Calcular el resto de las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Extraer los coeficientes del polinomio (primera fila de la tabla)
        for (int i = 0; i < n; i++)
            coeficientes[i] = tabla[0][i];

        return coeficientes;
    }

    /**
     * Evalúa el polinomio interpolante en un valor dado, usando la forma de Newton.
     *
     * @param coef Arreglo de coeficientes calculados con diferencias divididas.
     * @param x Arreglo con los nodos usados para construir el polinomio.
     * @param valor Valor en el que se desea evaluar el polinomio.
     * @return Resultado de evaluar el polinomio en el valor dado.
     */
    public static double evaluarPolinomio(double[] coef, double[] x, double valor) {
        double resultado = coef[0];       // Valor inicial del polinomio (coeficiente independiente)
        double termino = 1.0;             // Acumula el producto (x - x0)(x - x1)... para cada término

        // Sumar los términos del polinomio usando la forma de Newton
        for (int i = 1; i < coef.length; i++) {
            termino *= (valor - x[i - 1]);        // Construcción del término (x - x0)...(x - xi-1)
            resultado += coef[i] * termino;       // Suma el término correspondiente al coef[i]
        }

        return resultado;
    }
}

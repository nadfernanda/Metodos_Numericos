
public class InterpolacionNewton {
    public static double[][] calcularDiferenciasDivididas(double[] xPuntos, double[] yPuntos) {
        int n = xPuntos.length;
        double[][] tabla = new double[n][n];

        // Primera columna: valores de y conocidos
        for (int i = 0; i < n; i++) {
            tabla[i][0] = yPuntos[i];
        }

        // Llenado de la tabla de diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i+1][j-1] - tabla[i][j-1]) / (xPuntos[i+j] - xPuntos[i]);
            }
        }

        return tabla;
    }

    /**
     * Evalúa el polinomio de Newton en un punto x
     * @param tablaDiferencias Matriz de diferencias divididas
     * @param xPuntos Arreglo de valores de x conocidos
     * @param x Punto donde se desea interpolar
     * @return Valor aproximado de f(x)
     */
    public static double interpolar(double[][] tablaDiferencias, double[] xPuntos, double x) {
        int n = xPuntos.length;
        double resultado = tablaDiferencias[0][0]; // Primer término (f[x0])

        double producto = 1.0;
        for (int i = 1; i < n; i++) {
            producto *= (x - xPuntos[i-1]);
            resultado += tablaDiferencias[0][i] * producto;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double[] xPuntos = {1.0, 2.0, 4.0};
        double[] yPuntos = {2.0, 3.0, 5.0};

        // Calcular la tabla de diferencias divididas
        double[][] tablaDiferencias = calcularDiferenciasDivididas(xPuntos, yPuntos);

        // Punto a interpolar
        double x = 3.0;

        // Interpolación
        double valorInterpolado = interpolar(tablaDiferencias, xPuntos, x);

        // Mostrar el resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
} 


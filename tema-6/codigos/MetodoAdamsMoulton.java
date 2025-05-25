public class MetodoAdamsMoulton {

    /**
     * Define la función f(x, y) correspondiente a la ecuación diferencial y' = f(x, y)
     */
    public static double f(double x, double y) {
        return x + y; // Ejemplo: y' = x + y
    }

    /**
     * Método de Adams-Moulton implícito de 4 pasos para aproximar y(x)
     * @param x0 valor inicial de x
     * @param y0 valor inicial de y
     * @param h paso
     * @param n número de pasos totales (n * h debe cubrir el intervalo)
     * @return valor aproximado de y en x_n
     */
    public static double adamsMoulton(double x0, double y0, double h, int n) {
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] f = new double[n + 1];

        // Condiciones iniciales
        x[0] = x0;
        y[0] = y0;

        // Usamos Runge-Kutta de orden 4 para obtener los primeros 3 puntos
        for (int i = 0; i < 3; i++) {
            double k1 = h * f(x[i], y[i]);
            double k2 = h * f(x[i] + h / 2, y[i] + k1 / 2);
            double k3 = h * f(x[i] + h / 2, y[i] + k2 / 2);
            double k4 = h * f(x[i] + h, y[i] + k3);
            y[i + 1] = y[i] + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            x[i + 1] = x[i] + h;
        }

        // Calculamos f(x, y) para los primeros 4 valores
        for (int i = 0; i < 4; i++) {
            f[i] = f(x[i], y[i]);
        }

        // Adams-Moulton de orden 4: fórmula implícita corregida con predicción
        for (int i = 3; i < n; i++) {
            x[i + 1] = x[i] + h;

            // Predicción con Adams-Bashforth (orden 4)
            double y_pred = y[i] + (h / 24.0) * (
                    55 * f[i]
                  - 59 * f[i - 1]
                  + 37 * f[i - 2]
                  - 9  * f[i - 3]);

            // Corrección con Adams-Moulton
            double f_pred = f(x[i + 1], y_pred);
            y[i + 1] = y[i] + (h / 24.0) * (
                    9  * f_pred
                  + 19 * f[i]
                  - 5  * f[i - 1]
                  +      f[i - 2]);

            // Guardamos el nuevo f(x, y)
            f[i + 1] = f(x[i + 1], y[i + 1]);
        }

        // Retornamos el valor final
        return y[n];
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        int n = 10;

        double resultado = adamsMoulton(x0, y0, h, n);
        double xn = x0 + n * h;

        System.out.printf("El valor aproximado de y(%.1f) es %.6f\n", xn, resultado);
    }
}

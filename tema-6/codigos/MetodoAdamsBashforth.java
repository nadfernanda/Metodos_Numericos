public class MetodoAdamsBashforth {

    /**
     * Define la función f(x, y) de la ecuación diferencial y' = f(x, y)
     */
    public static double f(double x, double y) {
        return x + y;  // Ejemplo: y' = x + y
    }

    /**
     * Método de Adams-Bashforth de 4 pasos
     * @param x0 Valor inicial de x
     * @param y0 Valor inicial de y
     * @param h Paso
     * @param n Número de pasos totales (debe ser >= 4)
     * @return Valor aproximado de y en x_n
     */
    public static double adamsBashforth(double x0, double y0, double h, int n) {
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] f = new double[n + 1];

        // Condiciones iniciales
        x[0] = x0;
        y[0] = y0;

        // Calculamos los primeros 3 valores con Runge-Kutta de orden 4
        for (int i = 0; i < 3; i++) {
            double k1 = h * f(x[i], y[i]);
            double k2 = h * f(x[i] + h / 2, y[i] + k1 / 2);
            double k3 = h * f(x[i] + h / 2, y[i] + k2 / 2);
            double k4 = h * f(x[i] + h, y[i] + k3);
            y[i + 1] = y[i] + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            x[i + 1] = x[i] + h;
        }

        // Calculamos f[i] para los valores iniciales
        for (int i = 0; i < 4; i++) {
            f[i] = f(x[i], y[i]);
        }

        // Aplicamos Adams-Bashforth
        for (int i = 3; i < n; i++) {
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + (h / 24.0) * (
                    55 * f[i]
                  - 59 * f[i - 1]
                  + 37 * f[i - 2]
                  - 9  * f[i - 3]);
            f[i + 1] = f(x[i + 1], y[i + 1]);
        }

        // Retornamos solo el último valor
        return y[n];
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        int n = 10;

        double resultado = adamsBashforth(x0, y0, h, n);
        double xn = x0 + n * h;

        System.out.printf("El valor aproximado de y(%.1f) es %.4f\n", xn, resultado);
    }
}

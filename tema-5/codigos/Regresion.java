/**
 * Clase Regresion
 * 
 * Este programa realiza una regresión lineal simple sobre un conjunto de datos (x, y).
 * Calcula la ecuación de la recta de mejor ajuste (y = a + b*x) y el error cuadrático medio (MSE).
 */
public class Regresion {
    public static void main(String[] args) {
        
        // Datos de entrada: arreglos que representan los valores de x e y
        double[] x = {1, 2, 3, 4, 5};  // Valores independientes (x)
        double[] y = {2, 4, 5, 4, 5};  // Valores dependientes (y)
        int n = x.length;             // Número de datos

        // Variables para almacenar sumas necesarias para los cálculos
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Cálculo de sumatorias: sumX, sumY, sumXY y sumX²
        for (int i = 0; i < n; i++) {
            sumX += x[i];               // Suma de todos los valores de x
            sumY += y[i];               // Suma de todos los valores de y
            sumXY += x[i] * y[i];       // Suma del producto de x*y
            sumX2 += x[i] * x[i];       // Suma del cuadrado de x
        }

        // Cálculo de la pendiente (b) de la recta de regresión
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        
        // Cálculo de la intersección (a) con el eje y
        double a = (sumY - b * sumX) / n;

        // Mostrar la ecuación de la recta de regresión
        System.out.printf("Ecuación de la recta: y = %.4f + %.4fx\n", a, b);

        // Cálculo del Error Cuadrático Medio (Mean Squared Error - MSE)
        double mse = 0;
        for (int i = 0; i < n; i++) {
            double yEst = a + b * x[i];           // Valor estimado de y usando la recta
            mse += Math.pow(y[i] - yEst, 2);      // Error al cuadrado (real - estimado)
        }

        mse /= n;  // Promedio de los errores al cuadrado

        // Mostrar el valor del MSE
        System.out.printf("Error cuadrático medio: %.4f\n", mse);
    }
}

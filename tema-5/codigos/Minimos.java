/**
 * Clase Minimos
 * 
 * Este programa realiza un ajuste de datos mediante el método de los mínimos cuadrados.
 * Calcula la recta de mejor ajuste (y = a + b*x) para un conjunto de puntos (x, y),
 * e imprime la ecuación obtenida junto con el error cuadrático medio (MSE).
 */
public class Minimos {
    public static void main(String[] args) {
        
        // Datos de entrada: arreglos que representan pares de valores (x, y)
        double[] x = {1, 2, 3, 4, 5};  // Valores de la variable independiente
        double[] y = {2, 4, 5, 4, 5};  // Valores de la variable dependiente
        int n = x.length;             // Número de puntos o datos

        // Inicialización de variables para las sumatorias necesarias
        double sumX = 0;    // Suma de los valores de x
        double sumY = 0;    // Suma de los valores de y
        double sumXY = 0;   // Suma del producto x*y
        double sumX2 = 0;   // Suma del cuadrado de x

        // Cálculo de las sumatorias necesarias para la fórmula de regresión lineal
        for (int i = 0; i < n; i++) {
            sumX += x[i];               // Acumula la suma de x
            sumY += y[i];               // Acumula la suma de y
            sumXY += x[i] * y[i];       // Acumula la suma de x*y
            sumX2 += x[i] * x[i];       // Acumula la suma de x^2
        }

        // Cálculo de la pendiente (b) de la recta de regresión
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);

        // Cálculo del intercepto (a) de la recta con el eje y
        double a = (sumY - b * sumX) / n;

        // Imprimir la ecuación de la recta ajustada: y = a + b*x
        System.out.printf("Ecuación de la recta: y = %.4f + %.4fx\n", a, b);

    }
}

/**
 * Clase Correlacion
 *
 * Este programa implementa un método para calcular el coeficiente de correlación de Pearson
 * entre dos conjuntos de datos. Este coeficiente mide la fuerza y dirección de una relación
 * lineal entre dos variables.
 */
public class Correlacion {

    /**
     * Método que calcula el coeficiente de correlación de Pearson entre dos conjuntos de datos.
     *
     * @param x Arreglo con los valores de la primera variable.
     * @param y Arreglo con los valores de la segunda variable.
     * @return El coeficiente de correlación de Pearson, un valor entre -1 y 1.
     *         - 1 indica correlación positiva perfecta.
     *         - -1 indica correlación negativa perfecta.
     *         - 0 indica ausencia de correlación lineal.
     */
    public static double calcularCorrelacion(double[] x, double[] y) {
        int n = x.length;  // Número de elementos (se asume que x e y tienen la misma longitud)

        // Inicialización de variables para las sumatorias requeridas
        double sumX = 0;     // Suma de los valores de x
        double sumY = 0;     // Suma de los valores de y
        double sumXY = 0;    // Suma del producto x[i] * y[i]
        double sumX2 = 0;    // Suma de los cuadrados de x[i]
        double sumY2 = 0;    // Suma de los cuadrados de y[i]

        // Recorrido de los datos para calcular las sumatorias
        for (int i = 0; i < n; i++) {
            sumX += x[i];               // Acumula la suma de x
            sumY += y[i];               // Acumula la suma de y
            sumXY += x[i] * y[i];       // Acumula la suma de x*y
            sumX2 += x[i] * x[i];       // Acumula la suma de x^2
            sumY2 += y[i] * y[i];       // Acumula la suma de y^2
        }

        // Cálculo del numerador de la fórmula de Pearson
        double numerador = n * sumXY - sumX * sumY;

        // Cálculo del denominador de la fórmula de Pearson
        double denominador = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        // Retorna el valor del coeficiente de correlación
        return numerador / denominador;
    }
}

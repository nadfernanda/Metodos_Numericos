
public class InterpolacionLagrange {
    public static double interpolar(double[] xPuntos, double[] yPuntos, double x) {
        int n = xPuntos.length;
        double resultado = 0.0;

        // Recorrer cada término del polinomio de Lagrange
        for (int i = 0; i < n; i++) {
            double termino = yPuntos[i]; // Comenzamos con yi
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    // Multiplicamos (x - xj) / (xi - xj)
                    termino *= (x - xPuntos[j]) / (xPuntos[i] - xPuntos[j]);
                }
            }
            resultado += termino; // Sumamos el término al resultado
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double[] xPuntos = {1.0, 2.0, 4.0};
        double[] yPuntos = {2.0, 3.0, 5.0};

        // Punto a interpolar
        double x = 3.0;

        // Cálculo de la interpolación
        double valorInterpolado = interpolar(xPuntos, yPuntos, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

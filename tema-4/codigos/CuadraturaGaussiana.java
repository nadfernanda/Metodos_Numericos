
public class CuadraturaGaussiana {

    // Método para calcular la integral usando la cuadratura gaussiana
    public static double gaussiana(int n, double a, double b) {
        // Puntos y pesos de la cuadratura Gauss-Legendre para n puntos
        double[] puntos = obtenerPuntos(n);
        double[] pesos = obtenerPesos(n);

        double resultado = 0.0;

        // Calculamos la integral con el cambio de variable y la fórmula de cuadratura
        for (int i = 0; i < n; i++) {
            double xi = puntos[i];  // Punto de Gauss
            double wi = pesos[i];   // Peso de Gauss

            // Transformación del intervalo [a, b] a [-1, 1]
            double x = 0.5 * (b - a) * xi + 0.5 * (a + b);

            // La integral aproximada será la suma de los valores de la función multiplicados por los pesos
            resultado += wi * funcion(x);
        }

        // Escalar por el factor de cambio de variable
        resultado *= 0.5 * (b - a);

        return resultado;
    }

    public static double funcion(double x) {
        return x * x;  // Función a integrar
    }

    // Obtener los puntos de Gauss-Legendre para n puntos
    public static double[] obtenerPuntos(int n) {
        // Aquí se colocan los puntos de Gauss-Legendre. Los valores dependen de n.
        // Los puntos y pesos deben ser predefinidos para cada n.
        switch (n) {
            case 2:
                return new double[]{-Math.sqrt(1.0 / 3), Math.sqrt(1.0 / 3)};
            case 3:
                return new double[]{-Math.sqrt(3.0 / 5), 0, Math.sqrt(3.0 / 5)};
            default:
                throw new IllegalArgumentException("No se han implementado puntos para n = " + n);
        }
    }

    // Obtener los pesos de Gauss-Legendre para n puntos
    public static double[] obtenerPesos(int n) {
        // Los pesos de Gauss-Legendre también dependen de n.
        switch (n) {
            case 2:
                return new double[]{1.0, 1.0};
            case 3:
                return new double[]{5.0 / 9, 8.0 / 9, 5.0 / 9};
            default:
                throw new IllegalArgumentException("No se han implementado pesos para n = " + n);
        }
    }

    public static void main(String[] args) {
        // Definir el intervalo de integración [a, b]
        double a = 0;
        double b = 1;

        // Definir el número de puntos de Gauss
        int n = 2;  // Usamos 2 puntos de Gauss para la cuadratura

        // Calcular la integral
        double resultado = gaussiana(n, a, b);

        // Imprimir el resultado
        System.out.println("Resultado de la integral: " + resultado);
    }
}

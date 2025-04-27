public class InterpolacionCuadratica {
    public static double interpolar(double x0, double y0, double x1, double y1, double x2, double y2, double x) {
        // Cálculo de las diferencias divididas
        double f01 = (y1 - y0) / (x1 - x0);
        double f12 = (y2 - y1) / (x2 - x1);
        double f012 = (f12 - f01) / (x2 - x0);

        // Fórmula de interpolación cuadrática de Newton
        double resultado = y0 + f01 * (x - x0) + f012 * (x - x0) * (x - x1);
        return resultado;
    }

    public static void main(String[] args) {
        // Valores conocidos
        double x0 = 1.0, y0 = 2.0;
        double x1 = 2.0, y1 = 3.0;
        double x2 = 4.0, y2 = 5.0;
        
        // Punto a interpolar
        double x = 3.0;
        
        // Cálculo de la interpolación
        double valorInterpolado = interpolar(x0, y0, x1, y1, x2, y2, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

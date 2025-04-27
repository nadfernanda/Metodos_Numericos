
public class InterpolacionLineal {
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Aplicar la fórmula de interpolación lineal:
        // f(x) = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
        double resultado = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double x0 = 2.0, y0 = 4.0;
        double x1 = 5.0, y1 = 10.0;

        // Punto a interpolar
        double x = 3.5;

        // Cálculo de la interpolación
        double valorInterpolado = interpolar(x0, y0, x1, y1, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}  


public class ErrorRedondeo {
        public static void main(String[] args) {
            // Definimos el valor real que queremos redondear
            double valorReal = 9.87654321;  // Número original con todos sus decimales
    
            // Definimos la cantidad de decimales a los cuales queremos redondear
            int decimales = 3;  // En este caso, redondearemos a 3 decimales
    
            // Redondeamos el valor real a los decimales especificados
            // Multiplicamos por 10^decimales, redondeamos el valor y luego dividimos por 10^decimales
            double valorRedondeado = Math.round(valorReal * Math.pow(10, decimales)) / Math.pow(10, decimales);
    
            // Calculamos el error de redondeo
            // El error es la diferencia absoluta entre el valor real y el valor redondeado
            double error = Math.abs(valorReal - valorRedondeado);
    
            // Mostramos los resultados en consola con un máximo de 6 decimales
            System.out.printf("Valor real:        %.6f\n", valorReal);          // Imprime el valor original
            System.out.printf("Valor redondeado:  %.6f\n", valorRedondeado);    // Imprime el valor redondeado
            System.out.printf("Error de redondeo: %.6f\n", error);             // Imprime el error de redondeo
        }
    }

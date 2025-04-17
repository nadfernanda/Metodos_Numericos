public class ErrorTruncamiento {
    
        /**
         * Calcula el error absoluto de truncamiento.
         * 
         * @param valorReal        El valor exacto de la función.
         * @param valorAproximado  El valor obtenido por una aproximación.
         * @return El error absoluto.
         */
        public static double calcularErrorTruncamiento(double valorReal, double valorAproximado) {
            return Math.abs(valorReal - valorAproximado);
        }
    
        /**
         * Calcula el error relativo porcentual de truncamiento.
         * 
         * @param valorReal        El valor exacto de la función.
         * @param valorAproximado  El valor obtenido por una aproximación.
         * @return El error relativo en porcentaje.
         */
        public static double calcularErrorPorcentual(double valorReal, double valorAproximado) {
            double errorAbsoluto = calcularErrorTruncamiento(valorReal, valorAproximado);
            return (errorAbsoluto / Math.abs(valorReal)) * 100;
        }
    
        public static void main(String[] args) {
            // Ejemplo: valor real de e^1 = 2.7182818
            double valorReal = 2.7182818;
            
            // Aproximación con 2 términos de la serie de Taylor: 1 + 1 = 2.0
            double valorAproximado = 2.0;
    
            double errorAbsoluto = calcularErrorTruncamiento(valorReal, valorAproximado);
            double errorPorcentual = calcularErrorPorcentual(valorReal, valorAproximado);
    
            System.out.printf("Error absoluto: %.8f%n", errorAbsoluto);
            System.out.printf("Error porcentual: %.4f%%%n", errorPorcentual);
        }
    }
    
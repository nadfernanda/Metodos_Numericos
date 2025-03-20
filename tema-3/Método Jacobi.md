## Definición
El método de Jacobi es una técnica de resolución de sistemas de ecuaciones lineales que genera una sucesión
de aproximaciones a la solución exacta. Funciona especialmente bien cuando la matriz A es diagonalmente
dominante (es decir, cuando el valor absoluto de cada elemento diagonal es mayor que la suma de los valores
absolutos de los demás elementos en su fila).

## Algoritmo 
# Pasos del Método de Jacobi

1. **Despejar** cada variable xi de su ecuación correspondiente:
   xi = (bi - suma de aij·xj para j≠i) / aii

2. **Elegir** valores iniciales para todas las variables x₁⁽⁰⁾, x₂⁽⁰⁾, ..., xₙ⁽⁰⁾

3. **Calcular** nuevos valores usando la fórmula:
   xi⁽ᵏ⁺¹⁾ = (bi - suma de aij·xj⁽ᵏ⁾ para j≠i) / aii

4. **Repetir** el paso 3 hasta que |xi⁽ᵏ⁺¹⁾ - xi⁽ᵏ⁾| < ε para todas las variables

5. **Verificar** que la solución obtenida satisface el sistema original

### Implementación en Python
```java
public class Jacobi {

    public static class Result {
        double[] solution;
        int iterations;

        public Result(double[] solution, int iterations) {
            this.solution = solution;
            this.iterations = iterations;
        }
    }

    public static Result jacobiMethod(double[][] A, double[] b, double tolerance, int maxIterations) {
        int n = b.length;
        double[] x = new double[n];      // Vector inicial (todo ceros)
        double[] xNew = new double[n];   // Vector para almacenar nueva aproximación
        double error;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }
                xNew[i] = (b[i] - suma) / A[i][i];
            }

            error = 0;
            for (int i = 0; i < n; i++) {
                double diff = xNew[i] - x[i];
                error += diff * diff;
            }
            error = Math.sqrt(error);

            if (error < tolerance) {
                return new Result(xNew, iteration + 1);
            }

            System.arraycopy(xNew, 0, x, 0, n);
        }

        return new Result(x, maxIterations);
    }

    public static void main(String[] args) {
        double[][] A = {
    {10, 2, 1},
    {2, 20, -2},
    {-2, 3, 10}
};

double[] b = {9, -44, 22};

        double tolerance = 1e-10;
        int maxIterations = 100;

        Result result = jacobiMethod(A, b, tolerance, maxIterations);

        System.out.println("Solución aproximada:");
        for (int i = 0; i < result.solution.length; i++) {
            String variable = (i == 0) ? "x" : (i == 1) ? "y" : "z";
            System.out.printf("%s = %1.6f%n", variable, result.solution[i]);
        }

        System.out.println("Iteraciones realizadas: " + result.iterations);
    }
}

```
## Ejercicios Prácticos
Resolver los siguientes sistemas de ecuaciones utilizando el método de Jacobi.
### Ejercicio 1:
### Ejercicio 2:
### Ejercicio 3:
### Ejercicio 4:
### Ejercicio 5:(cuando no existe una solución)

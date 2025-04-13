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

### Implementación en Java
```java
public class Jacobi {

    // Clase interna para almacenar el resultado del método: la solución y el número de iteraciones
    public static class Result {
        double[] solution;   // Vector solución aproximada
        int iterations;      // Número de iteraciones realizadas

        public Result(double[] solution, int iterations) {
            this.solution = solution;
            this.iterations = iterations;
        }
    }

    /**
     * Método que implementa el algoritmo de Jacobi.
     *
     * @param A              Matriz de coeficientes del sistema (n x n)
     * @param b              Vector de términos independientes (n)
     * @param tolerance      Tolerancia del error para la condición de parada
     * @param maxIterations  Número máximo de iteraciones permitidas
     * @return               Objeto Result que contiene la solución aproximada y el número de iteraciones
     */
    public static Result jacobiMethod(double[][] A, double[] b, double tolerance, int maxIterations) {
        int n = b.length;
        double[] x = new double[n];      // Vector inicializado en ceros
        double[] xNew = new double[n];   // Vector para almacenar la nueva aproximación
        double error;                    // Error entre iteraciones

        // Bucle principal del método de Jacobi
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Calcular nueva aproximación xNew
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j]; // Suma de A[i][j] * x[j], excluyendo j = i
                    }
                }
                xNew[i] = (b[i] - suma) / A[i][i];  // Fórmula de Jacobi
            }

            // Calcular el error como la norma euclidiana ||xNew - x||
            error = 0;
            for (int i = 0; i < n; i++) {
                double diff = xNew[i] - x[i];
                error += diff * diff;
            }
            error = Math.sqrt(error);

            // Verificar si el error es menor que la tolerancia -> solución encontrada
            if (error < tolerance) {
                return new Result(xNew, iteration + 1);  // Se retorna xNew y el número de iteraciones
            }

            // Copiar xNew en x para la siguiente iteración
            System.arraycopy(xNew, 0, x, 0, n);
        }

        // Si se alcanza el número máximo de iteraciones sin cumplir la tolerancia
        return new Result(x, maxIterations);
    }

    // Método principal para probar el algoritmo de Jacobi con un sistema 3x3
    public static void main(String[] args) {
        // Definición de la matriz A (coeficientes) y vector b (términos independientes)
        double[][] A = {
            {10, 2, 1},
            {2, 20, -2},
            {-2, 3, 10}
        };

        double[] b = {9, -44, 22};

        double tolerance = 1e-10;      // Tolerancia deseada
        int maxIterations = 100;      // Máximo número de iteraciones

        // Llamada al método de Jacobi
        Result result = jacobiMethod(A, b, tolerance, maxIterations);

        // Imprimir la solución aproximada
        System.out.println("Solución aproximada:");
        for (int i = 0; i < result.solution.length; i++) {
            String variable = (i == 0) ? "x" : (i == 1) ? "y" : "z";
            System.out.printf("%s = %1.6f%n", variable, result.solution[i]);
        }

        // Imprimir el número de iteraciones realizadas
        System.out.println("Iteraciones realizadas: " + result.iterations);
    }
}

```
## Ejercicios Prácticos
### Ejercicio 1
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Ejercicio1.png" width="20%" alt="Ejercicio 1">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Solucion%20E1.png" width="20%" alt="Solución Ejercicio 1">

**Análisis**

El método de Jacobi permitió resolver el sistema de ecuaciones de manera iterativa, separando la actualización de cada variable en función de los valores anteriores hasta alcanzar la convergencia.
El sistema es compatible determinado, ya que tiene una única solución en el punto:
x=1.000000,y=−2.000000,z=3.000000
El algoritmo alcanzó esta solución después de 18 iteraciones, lo que indica que la convergencia fue estable, aunque requirió más iteraciones en comparación con el método de Gauss-Seidel, debido a que Jacobi es más conservador en la actualización de valores.

### Ejercicio 2
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Ejercicio%202.png" width="20%" alt="Ejercicio 2">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Solucion%20E2.png" width="20%" alt="Solución Ejercicio 2">

**Análisis**

El método de Jacobi permitió resolver el sistema de ecuaciones mediante una actualización iterativa de las variables en función de los valores anteriores.
El sistema es compatible determinado, ya que tiene una única solución en el punto:
x=1.000000,y=2.000000,z=3.000000
El algoritmo alcanzó esta solución después de 35 iteraciones, lo que indica que la convergencia fue más lenta, posiblemente debido a la configuración de los coeficientes o la cercanía de los valores entre las ecuaciones.

### Ejercicio 3
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Ejercicio%203.png" width="20%" alt="Ejercicio 3">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Solucion%20E3.png" width="20%" alt="Solución Ejercicio 3">

**Análisis**

El método de Jacobi resolvió el sistema de ecuaciones de manera eficiente mediante un proceso iterativo.
El sistema es compatible determinado, ya que tiene una única solución en el punto:
x=2.000000,y=1.000000,z=3.000000
La solución fue alcanzada tras 29 iteraciones, mostrando una convergencia moderada. La estructura del sistema permitió que el método de Jacobi convergiera de manera relativamente rápida.


### Ejercicio 4
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Ejercicio%204.png" width="20%" alt="Ejercicio 4">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Solucion%20E4.png" width="20%" alt="Solución Ejercicio 4">

**Análisis**

El método de Jacobi permitió resolver el sistema mediante la actualización progresiva de las variables en función de los valores anteriores.
El sistema es compatible determinado, ya que tiene una única solución en el punto:
x=1.000000,y=2.000000,z=3.000000
El algoritmo alcanzó esta solución después de 38 iteraciones, lo que indica que la convergencia fue un poco más lenta, posiblemente debido a la estructura de las ecuaciones.


### Ejercicio 5 (sin solución)
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Ejercicio%205.png" width="20%" alt="Ejercicio 5">

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-3/imagenes/metodo_jacobi/Solucion%20E5.png" width="20%" alt="Solución Ejercicio 5">

**Análisis**

El método de Jacobi intentó resolver el sistema de ecuaciones de manera iterativa, separando la actualización de cada variable en función de los valores anteriores. Sin embargo, debido a la naturaleza del sistema, el algoritmo no logró encontrar una solución estable. El sistema es incompatible, ya que las ecuaciones presentan una contradicción: x+y+z=3x + y + z = 3x+y+z=3 y x+y+z=4x + y + z = 4x+y+z=4. Esta inconsistencia implica A pesar de las iteraciones realizadas, el algoritmo no pudo alcanzar la convergencia. Esto ocurre porque el método de Jacobi, al ser un método iterativo, solo es efectivo en sistemas compatibles y bien condicionados. Dado que el sistema es incompatible, Jacobi no puede estabilizarse, y los resultados no se aproximan a ninguna solución razonable.


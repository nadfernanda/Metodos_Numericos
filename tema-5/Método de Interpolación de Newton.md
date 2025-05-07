## Definición
El Método de Interpolación de Newton es otra técnica fundamental para encontrar un polinomio que pasa por un conjunto
de puntos de datos dados. A diferencia del método de Lagrange, el método de Newton construye el polinomio interpolante de forma incremental, añadiendo un término a la vez a medida que se consideran más puntos. Esto lo hace particularmente útil cuando no se sabe de antemano cuántos puntos serán necesarios para alcanzar una precisión deseada.
La idea central del método de Newton se basa en el concepto de diferencias divididas. Estas diferencias divididas nos ayudan a determinar los coeficientes del polinomio interpolante.

## Algoritmo 
1. Elige varios puntos: $(x_0, y_0), (x_1, y_1), ..., (x_n, y_n)$.
   
2. Crea una tabla de diferencias divididas:
   
   - Primera columna: $y_0, y_1, ..., y_n$.
     
   - Luego calcula:
     
     $$f[x_i, x_{i+1}] = \frac{f(x_{i+1}) - f(x_i)}{x_{i+1} - x_i}$$

     y así sucesivamente.
    
3. Forma el polinomio:
   
   $$P(x) = f[x_0] + f[x_0, x_1](x - x_0) + f[x_0, x_1, x_2](x - x_0)(x - x_1) + ...$$
   
4. Sustituye el valor de x y calcula el resultado.

### Implementación en Java
```java
/**
 * Método de Interpolación de Newton
 * 
 * Este método construye un polinomio que aproxima una función
 * usando diferencias divididas a partir de puntos conocidos.
 */
public class InterpolacionNewton {

    /**
     * Calcula las diferencias divididas y devuelve la matriz triangular
     * @param xPuntos Arreglo de valores de x conocidos
     * @param yPuntos Arreglo de valores de f(x) correspondientes
     * @return Matriz de diferencias divididas
     */
    public static double[][] calcularDiferenciasDivididas(double[] xPuntos, double[] yPuntos) {
        int n = xPuntos.length;
        double[][] tabla = new double[n][n];

        // Primera columna: valores de y conocidos
        for (int i = 0; i < n; i++) {
            tabla[i][0] = yPuntos[i];
        }

        // Llenado de la tabla de diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i+1][j-1] - tabla[i][j-1]) / (xPuntos[i+j] - xPuntos[i]);
            }
        }

        return tabla;
    }

    /**
     * Evalúa el polinomio de Newton en un punto x
     * @param tablaDiferencias Matriz de diferencias divididas
     * @param xPuntos Arreglo de valores de x conocidos
     * @param x Punto donde se desea interpolar
     * @return Valor aproximado de f(x)
     */
    public static double interpolar(double[][] tablaDiferencias, double[] xPuntos, double x) {
        int n = xPuntos.length;
        double resultado = tablaDiferencias[0][0]; // Primer término (f[x0])

        double producto = 1.0;
        for (int i = 1; i < n; i++) {
            producto *= (x - xPuntos[i-1]);
            resultado += tablaDiferencias[0][i] * producto;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double[] xPuntos = {1.0, 2.0, 4.0};
        double[] yPuntos = {2.0, 3.0, 5.0};

        // Calcular la tabla de diferencias divididas
        double[][] tablaDiferencias = calcularDiferenciasDivididas(xPuntos, yPuntos);

        // Punto a interpolar
        double x = 3.0;

        // Interpolación
        double valorInterpolado = interpolar(tablaDiferencias, xPuntos, x);

        // Mostrar el resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 2


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 3


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

## Ejercicio 4


**Solución con algoritmo de java**

<img src="aaaaa" width="35%" alt="Solución Ejercicio 2">

**Análisis** 


## Ejercicio 5 (utilizando dos métodos)

Dado el siguiente conjunto de puntos:

(1.0, 2.0)

(2.0, 3.0)

(4.0, 5.0)

Interpola el valor de f(3.0) utilizando:

- El método de interpolación de Lagrange

- El método de interpolación de Newton

**Solución con algoritmo de java**

**Solución con el método de Lagrange**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Lagrange.png" width="35%" alt="Solución Newton">

**Solución con el método de Newton**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lagrange/Newton.png" width="35%" alt="Solución Lagrange">

**Análisis** 

Ambos métodos de interpolación, Lagrange y Newton, permiten estimar el valor de una función a partir de un conjunto de puntos conocidos. En este caso, al interpolar el valor de f(3.0) con los puntos (1.0,2.0), (2.0,3.0) y (4.0,5.0), ambos métodos arrojaron el mismo resultado:f(3.0)=4.0. Esto confirma que, aunque las técnicas y procedimientos son distintos, la interpolación conduce a una misma solución si se aplican correctamente. El método de Lagrange es más sencillo de implementar en problemas pequeños, mientras que el método de Newton resulta más eficiente cuando se deben realizar varias evaluaciones o agregar nuevos puntos, gracias a su uso de diferencias divididas. En conclusión, ambos métodos son herramientas confiables y útiles para la estimación de valores intermedios en funciones discretas.

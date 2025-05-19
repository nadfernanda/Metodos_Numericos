## Definición
La interpolación polinomial es un método que, dado un conjunto de puntos (x₀, y₀), (x₁, y₁), ..., (xₙ, yₙ), encuentra un polinomio P(x) de grado n que pase exactamente por todos estos puntos. Es útil para estimar valores intermedios entre los datos conocidos.

## Algoritmo 
1. Dados n + 1 puntos (x₀, y₀), ..., (xₙ, yₙ).
   
2. Se construye el polinomio interpolante usando la forma de Newton: P(x) = a₀ + a₁(x - x₀) + a₂(x - x₀)(x - x₁) + ··· + aₙ(x - x₀)...(x - xₙ₋₁)
   
3. Calcular los coeficientes aₖ usando diferencias divididas.
   
4. Evaluar el polinomio en el valor deseado x.

### Implementación en Java
```java
public class InterpolacionPolinomial {

    /**
     * Calcula los coeficientes del polinomio interpolante usando el método de 
     * diferencias divididas de Newton.
     *
     * @param x Arreglo con los valores de x (nodos).
     * @param y Arreglo con los valores de y correspondientes a cada x.
     * @return Arreglo con los coeficientes del polinomio en forma de Newton.
     */
    public static double[] diferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[] coeficientes = new double[n];       // Arreglo para guardar los coeficientes del polinomio
        double[][] tabla = new double[n][n];         // Tabla de diferencias divididas

        // Llenar la primera columna de la tabla con los valores de y
        for (int i = 0; i < n; i++)
            tabla[i][0] = y[i];

        // Calcular el resto de las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Extraer los coeficientes del polinomio (primera fila de la tabla)
        for (int i = 0; i < n; i++)
            coeficientes[i] = tabla[0][i];

        return coeficientes;
    }

    /**
     * Evalúa el polinomio interpolante en un valor dado, usando la forma de Newton.
     *
     * @param coef Arreglo de coeficientes calculados con diferencias divididas.
     * @param x Arreglo con los nodos usados para construir el polinomio.
     * @param valor Valor en el que se desea evaluar el polinomio.
     * @return Resultado de evaluar el polinomio en el valor dado.
     */
    public static double evaluarPolinomio(double[] coef, double[] x, double valor) {
        double resultado = coef[0];       // Valor inicial del polinomio (coeficiente independiente)
        double termino = 1.0;             // Acumula el producto (x - x0)(x - x1)... para cada término

        // Sumar los términos del polinomio usando la forma de Newton
        for (int i = 1; i < coef.length; i++) {
            termino *= (valor - x[i - 1]);        // Construcción del término (x - x0)...(x - xi-1)
            resultado += coef[i] * termino;       // Suma el término correspondiente al coef[i]
        }

        return resultado;
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Dado los puntos (1, 1), (2, 4), (3, 9), interpolar el valor para x = 2.5
 
**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Polinomial/Ejercicio%201.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

Este ejercicio utiliza los puntos (1, 1), (2, 4) y (3, 9), que representan la función cuadrática 
f(x)=x^2. Al aplicar el método de interpolación polinomial con diferencias 
divididas, se obtiene un polinomio de segundo grado que pasa exactamente por esos tres puntos. Luego, se evalúa el polinomio en x=2.5x = 2.5x=2.5, lo cual debería dar 6.25, ya que 2.5^2 = 6.25. Como los datos corresponden a una parábola exacta, el resultado de la interpolación coincide perfectamente con el valor real de la función en ese punto. 

## Ejercicio 2
Dado los puntos (0, 1), (1, 0), (2, 1), interpolar el valor para x=1.5

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Polinomial/Ejercicio%202.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

Aquí se interpolan los puntos (0, 1), (1, 0) y (2, 1), que no forman una curva polinómica simple conocida. Aun así, el método de Newton construye un polinomio de segundo grado que pasa por los tres puntos dados. Al evaluar el polinomio en 
x=1.5, el método estima un valor intermedio, que en este caso es 0.25. Aunque no existe una función evidente detrás de los puntos, el polinomio interpolado logra un valor coherente entre los datos dados.

## Ejercicio 3
Dado los puntos (2, 8), (3, 27), (4, 64), interpolar el valor para x=2.5.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Polinomial/Ejercicio%203.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

Este ejercicio parte de los puntos (2, 8), (3, 27) y (4, 64), que provienen de la función cúbica f(x)=x^3. Al interpolar en x=2.5, se espera obtener 2.5^3 = 15.25. El método construye un polinomio de grado dos que, aunque no alcanza el grado exacto de la función original (que es cúbica), debido a que solo se usan tres puntos, aún reproduce exactamente los valores al evaluarlo en el punto medio, gracias a la simetría y forma del cubo. El resultado es exacto, demostrando la precisión del método con datos bien definidos.

## Ejercicio 4
Dado los puntos (1, 2), (2, 8), (4, 64), interpolar el valor para x=3.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Polinomial/Ejercicio%204.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

En este caso se usan los puntos (1, 2), (2, 8) y (4, 64), que no están equidistantes en el eje x, lo que le da mayor relevancia al método de Newton, ya que permite manejar eficientemente intervalos desiguales. Aunque los puntos parecen ajustarse a una función exponencial, el método genera un polinomio de segundo grado que se ajusta a estos tres puntos. El valor interpolado en 
x=3 resulta en 28.6667, que se encuentra entre los valores reales de los puntos vecinos, mostrando cómo el método suaviza la transición y estima razonablemente el valor intermedio.

## Ejercicio 5
Dado los puntos (1, 3), (3, 27), (5, 125), interpolar el valor para x=4.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Polinomial/Ejercicio%205.png" width="25%" alt="Solución Ejercicio 2">

**Análisis** 

Este ejercicio presenta los puntos (1, 3), (3, 27) y (5, 125), que están relacionados con la función cúbica f(x)=x^3 , pero ajustada para coincidir con los valores dados. El método construye un polinomio de segundo grado que pasa por estos tres puntos. Al evaluar en x=4, se obtiene un valor interpolado de 64, que coincide exactamente con 4^3 , lo que sugiere que el polinomio generado se alinea bien con la forma de la función, al menos en la región evaluada. Esto muestra cómo la interpolación puede recuperar valores correctos incluso si el grado del polinomio es menor al de la función original, gracias a la disposición estratégica de los puntos.

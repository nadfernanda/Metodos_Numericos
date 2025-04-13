## Definición
El método de Simpson 3/8 es una técnica de integración numérica que aproxima el valor de una integral 
definida mediante la interpolación cúbica (polinomios de tercer grado) en subintervalos. Es una extensión
del método de Simpson 1/3, pero en lugar de usar parábolas, utiliza polinomios cúbicos para mayor precisión en ciertos casos.

## Algoritmo 
**Paso 1: Escoge $n$ subintervalos, tal que $n$ sea múltiplo de 3**

Más subintervalos = más precisión.

**Paso 2: Calcular el ancho $h$**

$h = \frac{b - a}{n}$

**Paso 3: Generar los puntos $x_0, x_1, ..., x_n$**

$x_i = a + ih$ para $i = 0, 1, ..., n$

**Paso 4: Evaluar la función en esos puntos: $f(x_0), f(x_1), ..., f(x_n)$**

**Paso 5: Aplicar la fórmula general**

$\int_a^b f(x) dx \approx \frac{3h}{8} \left[ f(x_0) + 3 \sum_{\substack{i=1 \\ i \equiv 1, 2 \pmod 3}}^{n-1} f(x_i) + 2 \sum_{\substack{i=3 \\ i \equiv 0 \pmod 3, i \neq 0, n}}^{n-3} f(x_i) + f(x_n) \right]$

### Implementación en Java
```java
public class SimpsonTresOctavos {

    /**
     * Función que se desea integrar.
     * En este ejemplo se usa f(x) = x^3, pero puedes cambiarla según tu necesidad.
     *
     * @param x Valor en el que se evalúa la función
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        return Math.pow(x, 3); // f(x) = x^3
    }

    /**
     * Método que implementa la regla de Simpson 3/8.
     * Requiere que el número de subintervalos n sea múltiplo de 3.
     *
     * @param a Límite inferior de integración
     * @param b Límite superior de integración
     * @param n Número de subintervalos (debe ser múltiplo de 3)
     * @return Valor aproximado de la integral definida
     */
    public static double simpsonTresOctavos(double a, double b, int n) {
        // Verificamos que n sea múltiplo de 3, como exige Simpson 3/8
        if (n % 3 != 0) {
            throw new IllegalArgumentException("El número de subintervalos debe ser múltiplo de 3.");
        }

        // Calculamos el ancho de cada subintervalo
        double h = (b - a) / n;

        // Iniciamos la suma con los valores en los extremos del intervalo
        double suma = funcion(a) + funcion(b);

        // Recorremos los puntos intermedios
        for (int i = 1; i < n; i++) {
            double x = a + i * h; // Punto intermedio xi

            // Si el índice es múltiplo de 3, el coeficiente es 2; en otro caso, 3
            if (i % 3 == 0) {
                suma += 2 * funcion(x);
            } else {
                suma += 3 * funcion(x);
            }
        }

        // Aplicamos la fórmula de Simpson 3/8
        return (3 * h / 8) * suma;
    }

    /**
     * Método principal para ejecutar el programa.
     * Define el intervalo y el número de subintervalos, y muestra el resultado.
     */
    public static void main(String[] args) {
        double a = 0;  // Límite inferior
        double b = 1;  // Límite superior
        int n = 6;     // Número de subintervalos (debe ser múltiplo de 3)

        // Calculamos la integral aproximada
        double resultado = simpsonTresOctavos(a, b, n);

        // Mostramos el resultado en consola
        System.out.println("Resultado de la integral: " + resultado);
    }
}

```

## Ejercicios Prácticos
## Ejercicio 1
Dada la Función:

f(x) = x³ - 2x² + 3x - 1 en el intervalo [1, 3] con n=6.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%9C/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

El método de Simpson 3/8 proporciona una excelente aproximación para esta integral polinómica de grado 3, con un error de aproximadamente 0.01 respecto al valor exacto.
Esto se debe a que la regla de Simpson 3/8 integra exactamente polinomios hasta grado 3, pero los errores de redondeo en los cálculos manuales introducen pequeñas discrepancias.
La función polinómica x³ - 2x² + 3x - 1 tiene cambios de curvatura en el intervalo [1,3], lo que normalmente requeriría más puntos para una buena aproximación con métodos más
simples. Sin embargo, el método de Simpson 3/8 captura bien estos cambios con solo 6 subdivisiones. A diferencia de la regla de Simpson 1/3, la regla 3/8 divide cada intervalo en
tres partes iguales y utiliza un polinomio de interpolación de tercer grado, lo que generalmente proporciona una mejor aproximación para el mismo número de evaluaciones
de función.

## Ejercicio 2
Dada la Función:

f(x) = e^x · sin(x) en el intervalo [0, π/2] con n=3.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%9C/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

El método de Simpson 3/8 ofrece una muy buena aproximación para esta integral de una función trascendental, con un error de aproximadamente 0.0125 respecto al valor exacto de
2.905. Esta función e^x · sin(x) es interesante porque combina el crecimiento exponencial con la oscilación sinusoidal. En el intervalo [0, π/2], la función comienza en 0 (ya que sin(0)
= 0) y crece rápidamente debido al factor exponencial, alcanzando un valor máximo en x = π/2. Con solo 3 subdivisiones, el método de Simpson 3/8 logra capturar bien este
comportamiento. La regla 3/8 es particularmente efectiva para funciones que tienen una curvatura significativa, como es este caso donde la función combina características
exponenciales y trigonométricas.

## Ejercicio 3
Dada la Función:

f(x) = ln(X)/x en el intervalo [1, 3] con n=6.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%9C/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

Para esta integral, el método de Simpson 3/8 proporciona un resultado muy preciso con solo 3 subdivisiones, coincidiendo casi exactamente con el valor analítico. Esto se debe
principalmente a que la función ln(x)/x tiene una curvatura suave en el intervalo [1, 3], lo que permite que el método de Simpson 3/8 la aproxime eficientemente. La función ln(x)/x tiene
una propiedad interesante: su integral indefinida es ln(x)²/2, lo que se puede comprobar por derivación utilizando la regla de la cadena. Esta función aparece en diversos contextos,
incluyendo la teoría de la información (relacionada con la entropía) y en problemas de física estadística.

## Ejercicio 4
Dada la Función:

f(x) = cos(x²) en el intervalo [0, 2] con n=6.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%9C/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**

El método de Simpson 3/8 ofrece una buena aproximación para esta integral que involucra la función cos(x²), con un error de aproximadamente 0.027 respecto al valor exacto. Esta
integral es particularmente interesante porque no tiene una expresión cerrada en términos de funciones elementales. El resultado exacto involucra la integral de Fresnel coseno, que
es una función especial definida por su integral. La función cos(x²) oscila con frecuencia creciente a medida que x aumenta, lo que la hace difícil de aproximar con polinomios de
bajo grado. Sin embargo, el método de Simpson 3/8 maneja bien este comportamiento porque utiliza subintervalos pequeños donde la función puede aproximarse localmente.

## Ejercicio 5
Dada la Función:

f(x) = √(1 + x³) en el intervalo [0, 2] con n=3.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%9C/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

El método de Simpson 3/8 proporciona una excelente aproximación para esta integral que involucra una raíz cuadrada de un polinomio cúbico. Con solo 3 subdivisiones, obtenemos
un error de aproximadamente 0.003 respecto al valor exacto. La función √(1 + x³) es interesante porque combina un comportamiento no lineal con una raíz, lo que hace que su
primitiva no sea una función elemental. Esta función aparece en problemas de física relacionados con el cálculo de longitudes de curva y en problemas de ingeniería donde se
necesita integrar expresiones con raíces. A pesar de que la función tiene una curvatura considerable en el intervalo [0, 2], el método de Simpson 3/8 la aproxima bien incluso con
pocas subdivisiones. Esto se debe a que la regla 3/8 utiliza un polinomio de interpolación de tercer grado, que captura mejor las variaciones en la curvatura que métodos más simples.

## Ejercicio 6 (sin solución)
Dada la Función:

f(x) = e^(-x²) · sin(1/x) en el intervalo [0.1, 1] con n=6.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%9C/Ejercicio%206.png" width="35%" alt="Solución Ejercicio 6">

**Análisis**

Este ejercicio presenta una función que combina un decaimiento gaussiano con oscilaciones de alta frecuencia cerca del origen. El comportamiento de sin(1/x) cuando x se
acerca a 0 hace que la función oscile infinitamente, aunque el factor e^(-x²) amortigua estas oscilaciones. El intervalo de integración [0.1, 1] evita la singularidad en x=0, pero aún
incluye una región donde la función oscila rápidamente. El método de Simpson 3/8 maneja relativamente bien estas oscilaciones con 6 subdivisiones, pero para una mayor precisión se
necesitarían más puntos, especialmente cerca de x=0.1 donde las oscilaciones son más frecuentes.

## Definición
El método de Simpson 1/3 es una técnica de integración numérica que aproxima el valor de una
integral definida mediante la interpolación cuadrática de la función en subintervalos. Es más preciso
que el método del trapecio, ya que utiliza polinomios de segundo grado (parábolas) en lugar de rectas para aproximar la función.

## Algoritmo
**Paso 1: Elegir el número de subintervalos n (debe ser par)**
Más subintervalos = más precisión.

**Paso 2: Calcular el ancho de subintervalo**

$h = \frac{b - a}{n}$

**Paso 3: Generar los puntos $x_0, x_1, ..., x_n$**

$x_i = a + ih$ para $i = 0, 1, ..., n$

**Paso 4: Evaluar la función en esos puntos: $f(x_0), f(x_1), ..., f(x_n)$**

**Paso 5: Aplicar la fórmula**

$\int_a^b f(x) dx \approx \frac{h}{3} \left[ f(x_0) + 4 \sum_{\substack{i=1 \\ i \text{ impares}}}^{n-1} f(x_i) + 2 \sum_{\substack{i=2 \\ i \text{ pares}}}^{n-2} f(x_i) + f(x_n) \right]$

### Implementación en Java
```java
// Clase que implementa el método de integración numérica de Simpson 1/3
public class Simpson13 {

    /**
     * Función que se desea integrar.
     * En este ejemplo: f(x) = x^2.
     * Puedes cambiar la función según tu necesidad.
     *
     * @param x Valor en el que se evalúa la función
     * @return Resultado de f(x)
     */
    public static double f(double x) {
        return Math.pow(x, 2); // f(x) = x^2
    }

    /**
     * Método que implementa la regla de Simpson 1/3.
     * Requiere que el número de subintervalos n sea par.
     *
     * @param a Límite inferior del intervalo de integración
     * @param b Límite superior del intervalo de integración
     * @param n Número de subintervalos (debe ser par)
     * @return Valor aproximado de la integral definida
     */
    public static double simpson13(double a, double b, int n) {
        // Verificamos que n sea par, como exige Simpson 1/3
        if (n % 2 != 0) {
            throw new IllegalArgumentException("El número de subintervalos (n) debe ser par para usar Simpson 1/3.");
        }

        // Calculamos el tamaño de cada subintervalo
        double h = (b - a) / n;

        // Inicializamos la suma con los valores en los extremos del intervalo
        double suma = f(a) + f(b);

        // Recorremos los puntos intermedios para sumar los valores con los coeficientes adecuados
        for (int i = 1; i < n; i++) {
            double xi = a + i * h; // Calculamos el punto xi

            // Si i es par, se multiplica por 2, si es impar por 4
            if (i % 2 == 0) {
                suma += 2 * f(xi);
            } else {
                suma += 4 * f(xi);
            }
        }

        // Aplicamos la fórmula de Simpson 1/3
        return (h / 3.0) * suma;
    }

    /**
     * Método principal que ejecuta el cálculo de la integral.
     * Define los límites y el número de subintervalos.
     */
    public static void main(String[] args) {
        double a = 0;  // Límite inferior
        double b = 4;  // Límite superior
        int n = 6;     // Número de subintervalos (debe ser par)

        // Calculamos la integral aproximada
        double resultado = simpson13(a, b, n);

        // Mostramos el resultado en consola
        System.out.println("Resultado usando Simpson 1/3: " + resultado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1
Dada la Función:

f(x) = x³ + 2x² - 4x + 5 en el intervalo [0,2], n=6

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%93/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**
En este ejercicio, el método de Simpson 1/3 proporciona una aproximación muy cercana al valor exacto para la integral de un polinomio de grado 3. El método de Simpson tiene un
error de truncamiento de orden O(h⁴), lo que significa que debería ser exacto para polinomios de grado ≤ 3. Sin embargo, observamos un pequeño error debido a los cálculos
de punto flotante y al redondeo durante las operaciones aritméticas.

## Ejercicio 2
Dada la Función:

f(x) = sin(x) + cos(x) en el intervalo [0,π], n=6

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%93/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**
En este ejercicio, el método de Simpson 1/3 proporciona una aproximación extremadamente precisa para la integral de sin(x) + cos(x) en el intervalo [0, π]. La regla de Simpson 1/3 es
exacta para polinomios de grado ≤ 3, y aunque sin(x) + cos(x) no es un polinomio, su comportamiento en este intervalo se puede aproximar muy bien con la regla de Simpson. El
error es prácticamente nulo (del orden de 10^-16), lo que demuestra la eficacia del método para funciones trigonométricas.

## Ejercicio 3
Dada la Función:

f(x) = √(x) · ln(x) en el intervalo [1,4], n=4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%93/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**
En este ejercicio, aplicamos el método de Simpson 1/3 para aproximar una integral que combina funciones no polinómicas (raíz cuadrada y logaritmo natural). La precisión obtenida
es bastante buena con solo 4 subdivisiones, con un error de aproximadamente 0.017 respecto al valor exacto. La regla de Simpson funciona bien para este tipo de funciones
suaves porque aproxima la curva con parábolas, capturando mejor el comportamiento de la función que métodos más simples como el trapezoidal. Dado que la función (x) · ln(x) tiene
una curvatura moderada en este intervalo, Simpson 1/3 proporciona una aproximación bastante precisa.

## Ejercicio 4
Dada la Función:

f(x) = x² / (x² + 4) en el intervalo [0,3], n=6

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%93/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**
Este ejercicio presenta una función racional (cociente de polinomios) que tiende asintóticamente a 1 cuando x tiende a infinito. A pesar de su apariencia simple, calcular la
antiderivada analíticamente requiere técnicas de integración como sustitución y descomposición en fracciones parciales. El método de Simpson 1/3 aproxima muy bien esta
integral con solo 6 subdivisiones, obteniendo un resultado con un error de aproximadamente 0.001 respecto al valor exacto. La precisión es excelente considerando que la función tiene
una curvatura moderada que cambia de cóncava a convexa.


## Ejercicio 5
Dada la Función:

f(x) = 1 / (1 + x²) en el intervalo[0,1], n=4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%93/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**
Este ejercicio resuelve numéricamente la integral de la función 1 / (1 + x²), que es la función de Cauchy o Lorentziana, ampliamente utilizada en física y estadística. Es conocido que la
integral de esta función da como resultado arctan(x), y en el intervalo [0, 1] el valor exacto es π/4 ≈ 0.785398. El método de Simpson 1/3 proporciona una aproximación muy precisa
con solo 4 subdivisiones, obteniendo un error menor a 0.0004. Esta precisión es notable considerando la simplicidad del método y el pequeño número de puntos de evaluación
utilizados.

## Ejercicio 6 (sin solución)
Dada la Función:

f(x) = 1 / (x·ln(x)) en el intervalo [2,5], n=4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Simpson_%E2%85%93/Ejercicio%206.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**
La integral de f(x) = 1 / (x·ln(x)) no tiene una solución analítica en términos de funciones elementales. Esta es una integral que da como resultado la función logaritmo integral Li(x),
que es una función especial definida como: Li(x) = ∫₂ˣ dt / ln(t) El método de Simpson 1/3 nos permite obtener una aproximación numérica, pero no podemos verificar el resultado exacto
mediante cálculo analítico directo.

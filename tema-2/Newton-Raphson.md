## Definición
El método de Newton-Raphson es un algoritmo iterativo utilizado para encontrar aproximaciones de las raíces (ceros) de una función real. Es ampliamente utilizado debido a su rápida convergencia cuando la estimación inicial está cerca de la raíz.
Dado un valor inicial $x_0$, se generan nuevas aproximaciones usando la fórmula:

$$x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}$$

Este método requiere que la función sea derivable y que la derivada no sea cero en los puntos de iteración.

## Algoritmo
1. **Elegir una función** $f(x)$ cuya raíz se desea encontrar.
   
2. **Calcular su derivada** $f'(x)$.
   
3. **Elegir un valor inicial** $x_0$ cercano a la raíz esperada.
   
4. **Repetir** hasta que el error sea menor al deseado:
   
   - a. Evaluar $f(x_n)$ y $f'(x_n)$.
     
   - b. Calcular la nueva aproximación:
     
     $$x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}$$
     
   - c. Calcular el error: $|x_{n+1} - x_n|$
     
   - d. Verificar si el error es menor a la tolerancia deseada (por ejemplo, $10^{-4}$). Si es así, detener.

5. La última aproximación $x_{n+1}$ se toma como la raíz.

### Implementación en Java
```java
```
## Ejercicios Prácticos
## Ejercicio 1 
Dada la función:

f(x) = x^3 - x - 2  con valor inicial x0 = 1.5

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Newton-Raphson/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

El método de Newton-Raphson muestra una convergencia rápida y estable para esta función, alcanzando la raíz real en muy pocas iteraciones. La elección del valor inicial cercano a la raíz favorece el comportamiento del algoritmo, evitando oscilaciones o divergencias. Además, la derivada nunca se anula durante el proceso, lo que garantiza la validez del método en cada paso. El resultado obtenido, cercano a 1.5214, confirma la eficacia del método para funciones polinómicas bien comportadas.

## Ejercicio 2
Dada la función:

f(x) = cos(x) - x  con valor inicial x0 = 0.5

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Newton-Raphson/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

Este ejercicio representa un caso clásico con una raíz real bien definida en el intervalo [0, 1]. El método de Newton-Raphson se adapta muy bien a esta función trascendental, y a pesar de la no linealidad, la convergencia es eficiente y precisa. La derivada tampoco representa un problema, y el algoritmo llega a la raíz esperada de aproximadamente 0.7391 sin complicaciones, demostrando su versatilidad incluso con funciones no polinómicas.

## Ejercicio 3
Dada la función:

f(x) = -e^-x - x  con valor inicial x0 = 0

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Newton-Raphson/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

En este caso, la función es continua, decreciente y bien comportada, lo que permite que el método actúe con gran precisión. El valor inicial en cero está lo suficientemente cerca de la raíz, lo que facilita una convergencia sin sobresaltos. A medida que avanzan las iteraciones, el valor se estabiliza rápidamente alrededor de 0.5671. Este ejercicio destaca cómo el método también puede aplicarse con éxito en funciones exponenciales.

## Ejercicio 4
Dada la función:

f(x) = x^2 - 612  con valor inicial x0 = 10

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Newton-Raphson/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**

Este ejemplo busca encontrar la raíz cuadrada de 612 mediante una función polinómica simple. Aunque el valor inicial está alejado de la solución exacta (≈ 24.7386), el método corrige el rumbo en cada paso y converge sin problemas. La derivada es siempre positiva, por lo que no hay riesgo de división por cero. El resultado demuestra la utilidad del método en cálculos numéricos como raíces cuadradas con alta precisión.

## Ejercicio 5 (sin solución)
Dada la función:

f(x) = x^3  con valor inicial x0 = 0

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/Newton-Raphson/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

Este caso representa un escenario problemático para Newton-Raphson. Aunque la función tiene una raíz real evidente en x = 0, el valor inicial elegido hace que la derivada también sea cero en ese punto, lo cual impide continuar con el método. El algoritmo detecta correctamente este inconveniente y detiene el proceso. Este ejemplo ilustra uno de los principales riesgos del método: que la derivada se anule y haga imposible seguir iterando.

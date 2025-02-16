## Definición
El **método gráfico** es una técnica utilizada en métodos numéricos para resolver sistemas de ecuaciones lineales
o problemas de optimización con dos variables. Su principal ventaja es la facilidad de interpretación 
al representar visualmente las soluciones en un plano cartesiano.

## Algoritmo 
1.**Plantear el sistema de ecuaciones** en la forma estándar.

2.**Despejar 𝑦 en ambas ecuaciones** (opcional) para facilitar la gráfica.

3.**Graficar ambas ecuaciones**
-Encontrar dos puntos por ecuación.
-Dibujar las rectas en el plano cartesiano.

4.**Identificar el punto de intersección**
-Si las rectas se cruzan en un solo punto → solución única.

-Si son coincidentes → infinitas soluciones.

-Si son paralelas → sin solución.

5.**Verificar la solución** (opcional) sustituyendo los valores en las ecuaciones.

## Ejercicios Prácticos

### Ejercicio 1: Encuentro entre un ciclista y un corredor 🚴‍♂️🏃‍♂️
Un ciclista y un corredor comienzan su recorrido en diferentes puntos y con velocidades distintas.
El ciclista sigue la ecuación:
d(t)=3t+12
donde d(t) representa la distancia recorrida en metros después de t minutos.
El corredor sigue la ecuación:
p(t)=-3+36
donde p(t) representa su distancia en metros después de t minutos.
**Pregunta:** 
¿En qué momento y a qué distancia del punto de inicio se encontrarán el ciclista y el corredor?

**Solución**

<img src="https://raw.githubusercontent.com/nadfernanda/Metodos_Numericos/main/tema-2/Imagenes/metodo%20grafico%20ejemplo1.png" width="40%" alt="método gráfico ejemplo1">

El ciclista y el corredor se encuentran en el minuto 4, a una distancia de 24 metros del punto de inicio. En la gráfica, este punto de intersección se representa como: **(4,24)**.
Esto indica que cuando t=4 minutos, ambas ecuaciones tienen el mismo valor de distancia 24, lo que confirma que en ese instante ambos coinciden en el mismo lugar.

### Ejercicio 2: El Puente Inestable 🌉
En una ciudad costera, los ingenieros están diseñando un puente colgante sobre un río. La estabilidad del puente depende de la tensión en los cables principales, la cual varía según la ecuación:  f(x) = x³ - 3x² - 3x + 1
donde x representa la distancia horizontal en metros desde un extremo del puente y f(x) representa la fuerza neta ejercida en esa posición.
Por motivos de seguridad, es crucial encontrar los puntos donde la fuerza neta es cero, es decir, los valores de 
x para los cuales f(x)=0. Estos puntos indican los lugares donde la tensión en los cables es nula, lo que podría comprometer la estabilidad del puente.

**Pregunta:**
Determina en qué puntos el puente presenta una tensión nula resolviendo la ecuación:  x³ - 3x² - 3x + 1 = 0

**Solución**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/metodo%20grafico%20ejemplo2.png"  alt="método gráfico ejemplo2">

El puente presenta puntos de tensión nula en las posiciones x ≈ -1, x ≈ 0.27 y x ≈ 3.73. Los ingenieros deben prestar especial atención a estos puntos para reforzar la estructura y evitar riesgos.

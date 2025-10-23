Actividad 1. Resolviendo juegos con recursividad. Sudoku

Objetivos

Sudoku es un juego japones que se inventó en la década de 1970 y se dio a conocer a nivel mundial en 2005 cuando los periódicos empezaron a publicarlo en sus secciones de pasatiempos.

El objetivo del sudoku es rellenar una cuadrícula de 9 × 9 celdas (ochenta y una casillas) dividida en subcuadrículas de 3 × 3 (también llamadas cajas o regiones) con las cifras del 1 al 9, partiendo de algunos números ya dispuestos en algunas de las celdas. La forma inicial del juego es que sean nueve elementos diferenciados, que no se deben repetir en una misma fila, columna o subcuadrícula. Un sudoku bien planteado solo puede tener una solución y ha de tener al menos diecisiete pistas iniciales. 

Con técnicas de backtracking y recursividad, se generará un programa para solucionar un sudoku, con la variante de que ningún número se puede repetir en las diagonales (también conocido como sudoku X).

Pautas de elaboración

El programa debe tener las siguientes funciones:

	Print_sudoku(sudoku): función para imprimir el sudoku sin solucionar y sudoku solucionado.
	Resolver(sudoku): función que resuelve el sudoku, como variable de entrada es un arreglo de 9 × 9 de tipo entero, que será el sudoku sin resolver. Este se hará utilizando técnicas de backtracking y recursividad 

	Valido(sudoku,n,i,j): función que va a detectar si el numero n está en una posición valida con fila i y columna j. Aquí se va a analizar si el número no existe en la fila, columna, subcuadrícula de 3 × 3 ni diagonal.

Instrumentalizar el código (contar el número de operaciones simples) para analizar el tiempo de ejecución del siguiente sudoku sin resolver:


        |0|9|0| 8|0|7| 0|4|0|
        |0|1|0| 4|0|0| 0|9|0|
        |0|0|0| 0|0|0| 0|0|8|
        
	      |0|2|0| 0|5|0| 0|0|0|
        |0|0|9| 0|3|2| 0|0|0|
        |0|5|0| 0|0|0| 0|0|3|
       
	      |0|0|0| 0|0|0| 0|7|1|
        |0|0|6| 0|7|0| 0|0|0|
        |8|0|0| 0|0|0| 0|0|0|

Extensión y formato 

El documento para entregar debe incluir una explicación del uso de recursividad para solucionar el sudoku, utilizando las funciones descritas en el punto anterior, así como el tiempo de ejecución para el juego dado. El formato para subirse debe ser en PDF y se debe adjuntar el código fuente en el mismo documento o en un archivo extra (indicar qué lenguaje de programación utilizaron para que el profesor lo pueda compilar).

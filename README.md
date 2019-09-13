# AREP-ProyectoPrimerTercio

## Autores 
* Daniel Felipe Rodriguez Villalba

Clonar el proyecto:

    git clone https://github.com/danielrodriguezvillalba/AREP-ProyectoPrimerTercio

cd para navegar por los archivos hacia el proyecto AREP-ProyectoPrimerTercio

    cd AREP-ProyectoPrimerTercio

Finalmente para compilarlo y ejecutarlo

    mvn package
    mvn exec:java -D exec.mainClass="edu.escuelaing.arep.aplicacion.Controlador"

## Problematica

Para este proyecto los estudiantes deberán construir un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo y desplegarlo en Heroku. El servidor debe atender múltiples solicitudes no concurrentes.

Se Plantea el siguiente diagrama de clases para el problema dado por el profesor, el cual se desplego en heroku.

![Imagenes](https://github.com/danielrodriguezvillalba/AREP-ProyectoPrimerTercio/blob/master/resources/Diagrama.PNG)



## Heroku Imagen

https://safe-sea-88689.herokuapp.com/resources/imgBug.png

## Aplicacion en funcionamiento

El siguiente resultado es el de invocar la clase Cuadrado de manera local, la cual devuelve un HTML en forma de String y da como resultado lo mostrado en la imagen:

![Imagenes](https://github.com/danielrodriguezvillalba/AREP-ProyectoPrimerTercio/blob/master/resources/cuadrado.PNG)

Ademas la aplicacion dibuja las imagenes con el siguiente recurso

![Imagenes](https://github.com/danielrodriguezvillalba/AREP-ProyectoPrimerTercio/blob/master/resources/Img1.PNG)

![Imagenes](https://github.com/danielrodriguezvillalba/AREP-ProyectoPrimerTercio/blob/master/resources/Img2.PNG)

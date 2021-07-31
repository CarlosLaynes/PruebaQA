# PruebaQA
En este repositorio está el proyecto de prueba para mi postulación como QA Automatizador.

Para ejecutar el proyecto deberá abrirlo en Eclipse (versión recomendada la 2021-03), tener instalado Java versión 8 en adelante. Instalar en Marketplace de Eclipse "TestNG".
Deberá descargar el proyecto e importarlo, es un proyecto maven por lo tanto se deberán cargar las dependencias.
Luego de importarlo y haber descargado las dependencias, ingresar a la carpeta "src/test/resource" ahí estará un excel llamado "input" donde se podrán agregar la data de prueba, por default se encuentra con tres caso (dos OK y uno NO OK), pero se pueden agregar muchos más con diferentes datos.
El siguiente paso será ejecutar los test, son dos, tanto para el Logout y para Comprar, ingresar a "com.project.test" ahi estarán ambos test, al ingresar a cada uno le daremos click derecho y lo ejecutaremos como TestNG (para ello el excel debe estar cerrado).
Luego de ejecutarlo y que haya terminado, abrir el excel y verificar el estado de cada caso de prueba (dos OK y uno NO OK).

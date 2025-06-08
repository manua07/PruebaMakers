* Instrucciones para ejecutar pruebas UI

Configuración:
Para ejecutar las pruebas UI se debe tener configuradas las siguientes variables de entorno en el sistema:
- Tener instalado Java 17.
- Tener instalado maven 3.11
En el archivo pom.xml se definen los plugins necesarios con sus respectivas versiones.

Ejecución de los tests:
Sigue estos pasos para ejecutar los test:
 - Clonar repositorio en la máquina local:
  	   git clone https://github.com/manua07/PruebaMakers
   
 - Importar el proyecto en IDE.

 - Navegar en el directorio del proyecto
      cd PruebaMakers 

 - Para ejecutar todas las pruebas se utitliza el siguiente comando:
   	mvn clean compile test
   
 - Para correr pruebas específicas se utiliza el siguiente comando:
      mvn clean compile test -Dcucumber.filter.tags="@completecheckout"


* Instrucciones para ejecutar pruebas de carga

Configuración:
Para ejecutar las pruebas de carga se debe tener configurada la última versión de JMETER.

Ejecución del test:
Sigue estos pasos para ejecutar los test:

 - Descargar en el computador el archivo pruebaMakers.jmx.
 
 - Abrir Jmeter e importar el archivo descargado.
 
 - Se muestra un test plan con las configuraciones solicitadas:
      Thread group: usuarios y tiempo.
      Get post: URL y HTTP Request. 
      Summary report: para ver los resultados de la ejecución.

 - Se selecciona Thread group y se da clic en la opción “Start”. 
 - Una vez finalizada el ejercicio, se pueden observar los resultados en la opción “Summary report”.
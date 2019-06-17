# Java App Config File
[![Build Status](https://travis-ci.com/universy-code/java-app-config-file.svg?branch=master)](https://travis-ci.com/universy-code/java-app-config-file)

## Programa de java que descarga el archivo de configuracion para la aplicacion de flutter


### Para compilar 
`./gradlew clean build`

### Para ejecutar 

`java -jar java-app-config-file-1.0.jar <stage>` 

Donde `<stage>` es el ambiente del cual se quiere obtener la configuracion.

El programa busca el archivo y de encontrarlo lo escribe en 

`./config/config.json`


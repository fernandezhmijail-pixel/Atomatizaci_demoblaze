# README - Demoblaze Automation Web Functional Tests

## 1. Requisitos previos

1. Java 17 o superior instalado.
2. Maven instalado y agregado al PATH.
3. IDE recomendado: IntelliJ IDEA o VS Code.
4. Navegador Chrome (u otro compatible con WebDriver).
5. Conexión a internet para descargar dependencias Maven.

Opcional:
- Docker instalado para ejecutar tests en contenedores.
- Jenkins para integraciones continuas y automatización programada.

## 2. Instalación del proyecto

1. Clonar o descargar el proyecto a tu máquina local.
2. Abrir el proyecto en tu IDE.
3. Verificar que el archivo `pom.xml` tenga las siguientes dependencias principales:
   - Serenity BDD
   - Cucumber
   - Selenium
   - JUnit 5
4. Ejecutar en la terminal del proyecto:
mvn clean install

Esto descargará todas las dependencias y compilará el proyecto.

## 3. Estructura del proyecto

- `src/test/java` → Runners, Steps y Screenplay Tasks/Interactions.
- `src/test/resources/features` → Archivos `.feature` con escenarios de Cucumber.
- `pom.xml` → Configuración Maven, dependencias y plugins.

## 4. Cómo ejecutar las pruebas

### 4.1 Ejecutar todos los tests

mvn clean verify


### 4.2 Ejecutar un escenario o feature específico
mvn clean verify -Dcucumber.options="classpath:features/web/add_to_cart.feature"

### 4.3 Generar reportes Serenity
mvn serenity:aggregate

Luego abrir el reporte:
target/site/serenity/index.html


## 5. Notas importantes sobre la ejecución

- La automatización usa **Screenplay** para separar actores, tareas y preguntas.
- Algunos elementos dinámicos del sitio, como productos con nombres variables, se identifican mediante **imágenes o selectores relativos** en lugar de analizar profundamente el HTML.
- Se puede ejecutar en **Docker** para aislamiento de entornos y consistencia de ejecución.
- Puede integrarse con **Jenkins**, incluyendo pipelines y schedules para ejecución automática.
- Asegúrate de que el navegador y WebDriver estén correctamente configurados.


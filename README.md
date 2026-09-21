# Examen Final 

Este repositorio contiene la arquitectura de automatización de pruebas, la configuración del pipeline de Integración Continua (CI) y el flujo de Despliegue Continuo (CD) con mecanismos de resiliencia para el Examen de Asignatura almacenado en Repositorio como `Examen_ADP`.

---

## Tecnologías y Requisitos Previos

* **Lenguaje:** Java 17 (JDK 17)
* **Gestor de Construcción:** Apache Maven 3.8+
* **Frameworks de Pruebas:** JUnit 5 (Unitarias, Integración y Aceptación), Selenium WebDriver
* **Control de Versiones:** Git & GitHub
* **Orquestador CI/CD:** GitHub Actions

--- 

## Estructura del Proyecto

```text
Examen_ADP/
├── .github/
│   └── workflows/
│       └── ci.yml                            # Definición del Pipeline CI/CD
├── src/
│   ├── main/
│   │   └── java/com/examen/
│   │       └── Calculadora.java              # Lógica principal del sistema
│   └── test/
│       └── java/com/examen/
│           ├── CalculadoraTest.java          # Pruebas Unitarias Atómicas
│           ├── CalculadoraIntegrationTest.java # Pruebas de Integración
│           └── AcceptanceTest.java           # Gate de Pruebas de Aceptación
├── .gitignore                                # Exclusión de artefactos (/target/)
├── pom.xml                                   # Configuración de dependencias Maven
└── README.md                                 # Documentación del proyecto
```

## Ejecución de Pruebas en Entorno Local
Para compilar el proyecto y ejecutar la suite completa de pruebas de forma local, ejecuta en tu terminal:
```bash
# Compilar el proyecto y ejecutar la suite completa de pruebas
mvn clean test

# Ejecutar una clase de prueba específica (ejemplo: AcceptanceTest)
mvn test -Dtest=AcceptanceTest
```
Los reportes de ejecución se generan automáticamente en la ruta: target/surefire-reports/.

## Flujo del Pipeline CI/CD (GitHub Actions)
El workflow .github/workflows/ci.yml automatiza de forma declarativa las siguientes etapas ante eventos de push o pull_request en la rama feature/* o main:

1. Stage 1 (Build): Descarga del código fuente, configuración del JDK 17 y compilación del proyecto (mvn clean compile).
2. Stage 2 (CI Tests): Ejecución de pruebas unitarias atómicas y de integración (CalculadoraTest, CalculadoraIntegrationTest).
3. Stage 3 (Acceptance Gate): Validación de salud y disponibilidad en el ambiente de Staging (AcceptanceTest).
4. Stage 4 (Canary Deploy): Despliegue progresivo en Staging ejecutado únicamente tras superar los gates de aceptación (if: success()).
5. Stage 5 (Rollback Automático): Cancelación del despliegue y ejecución del script de reversión en caso de falla en los tests (if: failure()).
6. Stage 6 (Artefactos): Embalaje y almacenamiento de reportes de prueba en target/surefire-reports/ (if: always()).

---
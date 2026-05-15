# Demo - Aplicación Java Maven
## Principio Abierto/Cerrado (OCP)

Proyecto de demostración desarrollado en Java con Maven para ilustrar el **Open/Closed Principle (OCP)** - uno de los cinco principios SOLID de la programación orientada a objetos.

---

##  ¿Qué es el Open/Closed Principle (OCP)?

El principio dice:

**"Las clases deben estar abiertas para extensión, pero cerradas para modificación."**

Es decir:
- Puedes agregar nuevas funcionalidades
- Sin modificar el código ya existente
- Evitando dañar lo que ya funciona

### Significado Fundamental

Una clase debe:
1. **Estar cerrada para modificaciones** - No cambiar código ya probado
2. **Estar abierta para extensiones** - Agregar nuevas funcionalidades mediante herencia, interfaces o polimorfismo

---

##  Ejemplo INCORRECTO (No cumple OCP)

### Problema

Supongamos una aplicación que calcula pagos de empleados. En un diseño incorrecto, la clase toma un tipo de empleado como texto y aplica condiciones internas para decidir el salario.

### ¿Por qué está mal?

Porque cada vez que aparece un nuevo tipo de empleado:
- "Practicante"
- "Coordinador"
- "Gerente"

**Debemos modificar la misma clase**, lo que rompe el principio OCP y aumenta el riesgo de errores.

---

##  Ejemplo CORRECTO (Cumple OCP)

### Concepto

En el diseño correcto, se define una interfaz `Empleado` con un método para calcular el salario. Cada tipo de empleado implementa esa interfaz en su propia clase.

### Implementación

- `Administrador` implementa `Empleado` y devuelve su propio salario.
- `Tecnico` implementa `Empleado` y devuelve su propio salario.
- `Gerente` implementa `Empleado` y puede ofrecer otra regla de salario.
- `CalculadoraSalario` centraliza el cálculo del salario usando objetos `Empleado`.

### Ventaja clave

Si aparece un nuevo tipo de empleado:
- **NO modificamos el código existente**
- **Solo agregamos una nueva clase**

Esto mantiene el sistema abierto para extensión y cerrado para modificación.

---

##  Ventajas del OCP

### 1. Menos errores
- No dañamos código ya funcionando
- Reducimos riesgo de bugs

### 2. Más escalabilidad
- Podemos agregar nuevas funciones fácilmente
- El sistema crece sin afectar lo existente

### 3. Mejor mantenimiento
- El sistema es más organizado
- Código más limpio y legible

### 4. Facilita reutilización
- Las clases pueden reutilizarse en otros proyectos
- Mayor modularidad

---

##  Relación con POO

El OCP utiliza los siguientes conceptos de Programación Orientada a Objetos:

- **Herencia** - Las clases se basan en una abstracción común
- **Interfaces** - Definen contratos que las clases implementan
- **Polimorfismo** - Diferentes implementaciones del mismo contrato
- **Abstracción** - Se abstrae el comportamiento común en la interfaz

---

## Requisitos Previos

- **Java 17** o superior
- **Maven 3.6** o superior

## Estructura del Proyecto

```
demo/
├── pom.xml                 # Configuración del proyecto Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── Administrador.java
│   │   │       ├── CalculadoraSalario.java
│   │   │       ├── Empleado.java
│   │   │       ├── Gerente.java
│   │   │       ├── Main.java
│   │   │       └── Tecnico.java
│   │   └── resources/
│   └── test/
│       └── java/
└── target/                 # Directorio de salida compilado (generado)
```

## Compilación

Para compilar el proyecto, ejecuta:

```bash
mvn clean compile
```

## Ejecución

Para ejecutar la aplicación compilada:

```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

O después de compilar, puedes ejecutarla directamente desde Java:

```bash
java -cp target/classes com.example.Main
```

## Empaquetado

Para crear un archivo JAR del proyecto:

```bash
mvn clean package
```

## Propiedades del Proyecto

- **Versión Java:** 17
- **Versión del Proyecto:** 1.0-SNAPSHOT
- **GroupId:** com.example
- **ArtifactId:** demo

## Contribuciones

Las contribuciones son bienvenidas. Por favor, crea un fork, realiza tus cambios y envía un pull request.

## Licencia

Este proyecto es de código abierto.


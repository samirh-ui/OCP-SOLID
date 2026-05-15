# Demo - Aplicación Java Maven
## Principio Abierto/Cerrado (OCP)

Proyecto de demostración desarrollado en Java con Maven para ilustrar el **Open/Closed Principle (OCP)** - uno de los cinco principios SOLID de la programación orientada a objetos.

---

## 📖 ¿Qué es el Open/Closed Principle (OCP)?

El principio dice:

**"Las clases deben estar abiertas para extensión, pero cerradas para modificación."**

Es decir:
- ✅ Puedes agregar nuevas funcionalidades
- ✅ Sin modificar el código ya existente
- ✅ Evitando dañar lo que ya funciona

### Significado Fundamental

Una clase debe:
1. **Estar cerrada para modificaciones** - No cambiar código ya probado
2. **Estar abierta para extensiones** - Agregar nuevas funcionalidades mediante herencia, interfaces o polimorfismo

---

## ❌ Ejemplo INCORRECTO (No cumple OCP)

### Problema

Supongamos una aplicación que calcula pagos de empleados:

```java
public class CalculadoraSalario {

    public double calcular(String tipoEmpleado) {

        if(tipoEmpleado.equals("Administrador")) {
            return 5000000;
        }

        if(tipoEmpleado.equals("Tecnico")) {
            return 2500000;
        }

        return 0;
    }
}
```

### ¿Por qué está mal?

Porque cada vez que aparezca un nuevo tipo de empleado:
- "Practicante"
- "Coordinador"
- "Gerente"

**Debemos MODIFICAR la clase**, lo que rompe el principio OCP.

---

## ✅ Ejemplo CORRECTO (Cumple OCP)

### Paso 1: Crear una interfaz

```java
public interface Empleado {
    double calcularSalario();
}
```

### Paso 2: Crear clases independientes

#### Administrador
```java
public class Administrador implements Empleado {

    @Override
    public double calcularSalario() {
        return 5000000;
    }
}
```

#### Técnico
```java
public class Tecnico implements Empleado {

    @Override
    public double calcularSalario() {
        return 2500000;
    }
}
```

### Paso 3: Clase principal

```java
public class Main {

    public static void main(String[] args) {

        Empleado admin = new Administrador();
        Empleado tecnico = new Tecnico();

        System.out.println("Salario Administrador: " 
                + admin.calcularSalario());

        System.out.println("Salario Tecnico: " 
                + tecnico.calcularSalario());
    }
}
```

### ¿Por qué este ejemplo sí cumple OCP?

Porque si aparece un nuevo tipo de empleado:
- **NO modificamos el código existente**
- **Solo creamos una nueva clase**

```java
public class Gerente implements Empleado {

    @Override
    public double calcularSalario() {
        return 7000000;
    }
}
```

---

## 💡 Ventajas del OCP

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

## 🎯 Relación con POO

El OCP utiliza los siguientes conceptos de Programación Orientada a Objetos:

- **Herencia** - Las clases heredan del tipo base
- **Interfaces** - Definen contratos que las clases implementan
- **Polimorfismo** - Diferentes implementaciones del mismo contrato
- **Abstracción** - Abstraemos el comportamiento común en la interfaz

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
│   │   │       └── Main.java
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

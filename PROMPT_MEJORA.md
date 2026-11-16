# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/infrastructure/controllers/ReservaController.java` — La fase "Creación de la API básica" se implementa aqui: este archivo es el ejercicio.
- `src/main/java/infrastructure/adapters/SalaJpaRepository.java` — La logica del reto vive aqui: la seleccion por fase solo encontraba pegamento.

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Java, Tecnología Spring Boot, Junior L1

### Brecha de conocimiento
Construye APIs REST con validaciones y manejo de errores.

### Reto
- Tema: Sistema de reservas de salas con control de concurrencia
- Seniority: junior-l1
- Tipo: practical
- Título: Implementación de API de reservas de salas
- Tiempo estimado: 4 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Creación de la API básica — objetivo: Implementar la API que permite reservar una sala. — entregable (NO resolver): API REST funcional que permite reservar una sala con validaciones básicas.
- Fase 2: Implementación de validaciones y manejo de errores — objetivo: Mejorar la API para incluir validaciones adicionales y manejo de errores más robusto. — entregable (NO resolver): API REST mejorada con validaciones adicionales y manejo de errores más robusto.
- Fase 3: Optimización y refactorización — objetivo: Optimizar y refactorizar la API para mejorar su rendimiento y mantenibilidad. — entregable (NO resolver): API REST optimizada y refactorizada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/main/java/Application.java ===
package com.pragma.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.pragma.reservas.domain", "com.pragma.reservas.infrastructure"})
@EnableJpaRepositories(basePackages = {"com.pragma.reservas.infrastructure.adapters"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.10.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/application/dto/ReservaRequest.java ===
package application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record ReservaRequest(
    @NotBlank(message = "El nombre de la sala es obligatorio")
    String nombreSala,

    @NotNull(message = "La fecha y hora de inicio son obligatorias")
    LocalDateTime fechaHoraInicio,

    @NotNull(message = "La fecha y hora de fin son obligatorias")
    LocalDateTime fechaHoraFin,

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    String solicitante,

    @Positive(message = "La capacidad debe ser un número positivo")
    int capacidadRequerida
) {
}

// === ARCHIVO: src/main/java/application/dto/ReservaResponse.java ===
package application.dto;

import java.time.LocalDateTime;

public record ReservaResponse(
    Long id,
    String nombreSala,
    LocalDateTime fechaHoraInicio,
    LocalDateTime fechaHoraFin,
    String solicitante,
    int capacidad,
    String estado
) {
}

// === ARCHIVO: src/main/java/domain/Sala.java ===
package domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.Objects;

public class Sala {
    private Long id;

    @NotBlank(message = "El nombre de la sala es obligatorio")
    private String nombre;

    @Positive(message = "La capacidad debe ser un número positivo")
    private int capacidad;

    private boolean disponible;

    public Sala() {
        this.disponible = true;
    }

    public Sala(Long id, String nombre, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.disponible = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// === ARCHIVO: src/main/java/domain/Reserva.java ===
package domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
    private Long id;

    @NotBlank(message = "El nombre de la sala es obligatorio")
    private String nombreSala;

    @NotNull(message = "La fecha y hora de inicio son obligatorias")
    private LocalDateTime fechaHoraInicio;

    @NotNull(message = "La fecha y hora de fin son obligatorias")
    private LocalDateTime fechaHoraFin;

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    private String solicitante;

    private int capacidad;

    private String estado;

    public Reserva() {
        this.estado = "ACTIVA";
    }

    public Reserva(Long id, String nombreSala, LocalDateTime fechaHoraInicio,
                   LocalDateTime fechaHoraFin, String solicitante, int capacidad) {
        this.id = id;
        this.nombreSala = nombreSala;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.solicitante = solicitante;
        this.capacidad = capacidad;
        this.estado = "ACTIVA";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// === ARCHIVO: src/main/java/domain/ports/SalaRepository.java ===
package domain.ports;

import domain.Sala;
import java.util.List;
import java.util.Optional;

public interface SalaRepository {
    Optional<Sala> findByNombre(String nombre);
    List<Sala> findAll();
    Sala save(Sala sala);
    Optional<Sala> findById(Long id);
    void deleteById(Long id);
}

// === ARCHIVO: src/main/java/domain/ports/ReservaRepository.java ===
package domain.ports;

import domain.Reserva;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Optional<Reserva> findById(Long id);
    List<Reserva> findByNombreSalaAndFechaHoraInicioBetween(String nombreSala,
                                                            LocalDateTime start,
                                                            LocalDateTime end);
    List<Reserva> findAll();
    Reserva save(Reserva reserva);
    void deleteById(Long id);
}

// === ARCHIVO: src/main/java/domain/validation/ReservaValidator.java ===
package domain.validation;

import domain.Reserva;
import domain.Sala;
import domain.ports.ReservaRepository;
import domain.ports.SalaRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaValidator {

    private final SalaRepository salaRepository;
    private final ReservaRepository reservaRepository;

    public ReservaValidator(SalaRepository salaRepository, ReservaRepository reservaRepository) {
        this.salaRepository = salaRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<String> validar(Reserva reserva) {
        List<String> errores = new ArrayList<>();

        if (reserva.getNombreSala() == null || reserva.getNombreSala().isBlank()) {
            errores.add("El nombre de la sala es obligatorio");
            return errores;
        }

        Optional<Sala> salaOpt = salaRepository.findByNombre(reserva.getNombreSala());
        if (salaOpt.isEmpty()) {
            errores.add("La sala no existe");
            return errores;
        }

        Sala sala = salaOpt.get();
        if (!sala.isDisponible()) {
            errores.add("La sala no está disponible");
        }

        if (reserva.getCapacidad() > sala.getCapacidad()) {
            errores.add("La capacidad requerida excede la capacidad de la sala");
        }

        if (reserva.getFechaHoraInicio() == null || reserva.getFechaHoraFin() == null) {
            errores.add("Las fechas de inicio y fin son obligatorias");
            return errores;
        }

        if (reserva.getFechaHoraInicio().isAfter(reserva.getFechaHoraFin())) {
            errores.add("La fecha de inicio no puede ser posterior a la fecha de fin");
        }

        if (reserva.getFechaHoraInicio().isBefore(LocalDateTime.now())) {
            errores.add("La fecha de inicio no puede ser en el pasado");
        }

        if (reserva.getFechaHoraInicio().equals(reserva.getFechaHoraFin())) {
            errores.add("La reserva debe tener una duración mínima");
        }

        List<Reserva> reservasExistentes = reservaRepository
            .findByNombreSalaAndFechaHoraInicioBetween(
                reserva.getNombreSala(),
                reserva.getFechaHoraInicio(),
                reserva.getFechaHoraFin()
            );

        for (Reserva existente : reservasExistentes) {
            if (existente.getEstado().equals("ACTIVA")) {
                if (hayConflicto(reserva, existente)) {
                    errores.add("Ya existe una reserva activa para este horario");
                    break;
                }
            }
        }

        return errores;
    }

    private boolean hayConflicto(Reserva nueva, Reserva existente) {
        return nueva.getFechaHoraInicio().isBefore(existente.getFechaHoraFin())
            && nueva.getFechaHoraFin().isAfter(existente.getFechaHoraInicio());
    }
}

// === ARCHIVO: src/main/java/infrastructure/adapters/SalaJpaRepository.java ===
package infrastructure.adapters;

import domain.Sala;
import domain.ports.SalaRepository;
import java.util.List;
import java.util.Optional;

public class SalaJpaRepository implements SalaRepository {

    @Override
    public Optional<Sala> findByNombre(String nombre) {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public List<Sala> findAll() {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public Sala save(Sala sala) {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public Optional<Sala> findById(Long id) {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("TODO(reto)");
    }
}

// === ARCHIVO: src/main/java/infrastructure/adapters/ReservaJpaRepository.java ===
package infrastructure.adapters;

import domain.Reserva;
import domain.ports.ReservaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaJpaRepository implements ReservaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Reserva> findById(Long id) {
        Reserva reserva = entityManager.find(Reserva.class, id);
        return Optional.ofNullable(reserva);
    }

    @Override
    public List<Reserva> findByNombreSalaAndFechaHoraInicioBetween(String nombreSala,
                                                                    LocalDateTime start,
                                                                    LocalDateTime end) {
        TypedQuery<Reserva> query = entityManager.createQuery(
            "SELECT r FROM Reserva r WHERE r.nombreSala = :nombreSala " +
            "AND r.fechaHoraInicio < :end AND r.fechaHoraFin > :start",
            Reserva.class
        );
        query.setParameter("nombreSala", nombreSala);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }

    @Override
    public List<Reserva> findAll() {
        TypedQuery<Reserva> query = entityManager.createQuery(
            "SELECT r FROM Reserva r",
            Reserva.class
        );
        return query.getResultList();
    }

    @Override
    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            entityManager.persist(reserva);
            return reserva;
        } else {
            return entityManager.merge(reserva);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Reserva> reservaOpt = findById(id);
        reservaOpt.ifPresent(reserva -> entityManager.remove(reserva));
    }
}

// === ARCHIVO: src/main/java/infrastructure/controllers/ReservaController.java ===
package infrastructure.controllers;

import application.dto.ReservaRequest;
import application.dto.ReservaResponse;
import application.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> crearReserva(@Valid @RequestBody ReservaRequest request) {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para crear una reserva");
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponse>> listarReservas() {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para listar todas las reservas");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> obtenerReserva(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para obtener una reserva por ID");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para cancelar una reserva");
    }
}

// === ARCHIVO: src/main/java/application.properties ===
# Configuración del servidor
server.port=8080

# Configuración de la aplicación
spring.application.name=reto-reservas

# Configuración de H2 en memoria
spring.datasource.url=jdbc:h2:mem:reservasdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuración de Logging
logging.level.org.springframework.web=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Configuración de Actuator
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always

# Configuración de OpenAPI/Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true

// === ARCHIVO: src/main/java/application/ReservaService.java ===
package application;

import application.dto.ReservaRequest;
import application.dto.ReservaResponse;
import domain.Reserva;
import domain.Sala;
import domain.ports.ReservaRepository;
import domain.ports.SalaRepository;
import domain.validation.ReservaValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;
    private final ReservaValidator reservaValidator;

    public ReservaService(ReservaRepository reservaRepository,
                          SalaRepository salaRepository,
                          ReservaValidator reservaValidator) {
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
        this.reservaValidator = reservaValidator;
    }

    public ReservaResponse crearReserva(ReservaRequest request) {
        Optional<Sala> salaOpt = salaRepository.findByNombre(request.nombreSala());
        
        if (salaOpt.isEmpty()) {
            throw new SalaNoEncontradaException("La sala '" + request.nombreSala() + "' no existe");
        }

        Sala sala = salaOpt.get();
        
        if (!sala.isDisponible()) {
            throw new SalaNoDisponibleException("La sala '" + request.nombreSala() + "' no está disponible");
        }

        if (request.capacidadRequerida() > sala.getCapacidad()) {
            throw new CapacidadInsuficienteException(
                "La capacidad requerida (" + request.capacidadRequerida() + 
                ") excede la capacidad de la sala (" + sala.getCapacidad() + ")"
            );
        }

        Reserva reserva = new Reserva();
        reserva.setNombreSala(request.nombreSala());
        reserva.setFechaHoraInicio(request.fechaHoraInicio());
        reserva.setFechaHoraFin(request.fechaHoraFin());
        reserva.setSolicitante(request.solicitante());
        reserva.setCapacidad(request.capacidadRequerida());
        reserva.setEstado("ACTIVA");

        List<String> erroresValidacion = reservaValidator.validar(reserva);
        if (!erroresValidacion.isEmpty()) {
            throw new ValidacionReservaException(String.join("; ", erroresValidacion));
        }

        Reserva reservaGuardada = reservaRepository.save(reserva);
        
        return mapToResponse(reservaGuardada);
    }

    public List<ReservaResponse> listarReservas() {
        return reservaRepository.findAll().stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    public ReservaResponse obtenerReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        
        if (reservaOpt.isEmpty()) {
            throw new ReservaNoEncontradaException("La reserva con ID " + id + " no existe");
        }
        
        return mapToResponse(reservaOpt.get());
    }

    public void cancelarReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        
        if (reservaOpt.isEmpty()) {
            throw new ReservaNoEncontradaException("La reserva con ID " + id + " no existe");
        }

        Reserva reserva = reservaOpt.get();
        
        if ("CANCELADA".equals(reserva.getEstado())) {
            throw new ReservaYaCanceladaException("La reserva ya está cancelada");
        }

        reserva.setEstado("CANCELADA");
        reservaRepository.save(reserva);
    }

    private ReservaResponse mapToResponse(Reserva reserva) {
        return new ReservaResponse(
            reserva.getId(),
            reserva.getNombreSala(),
            reserva.getFechaHoraInicio(),
            reserva.getFechaHoraFin(),
            reserva.getSolicitante(),
            reserva.getCapacidad(),
            reserva.getEstado()
        );
    }

    public static class SalaNoEncontradaException extends RuntimeException {
        public SalaNoEncontradaException(String message) {
            super(message);
        }
    }

    public static class SalaNoDisponibleException extends RuntimeException {
        public SalaNoDisponibleException(String message) {
            super(message);
        }
    }

    public static class CapacidadInsuficienteException extends RuntimeException {
        public CapacidadInsuficienteException(String message) {
            super(message);
        }
    }

    public static class ValidacionReservaException extends RuntimeException {
        public ValidacionReservaException(String message) {
            super(message);
        }
    }

    public static class ReservaNoEncontradaException extends RuntimeException {
        public ReservaNoEncontradaException(String message) {
            super(message);
        }
    }

    public static class ReservaYaCanceladaException extends RuntimeException {
        public ReservaYaCanceladaException(String message) {
            super(message);
        }
    }
}
```

# Implementación de API de reservas de salas

El sistema de reservas de salas permite a los usuarios reservar salas de reuniones en una empresa. Cada sala tiene un nombre, capacidad y estado de disponibilidad. El sistema debe manejar la concurrencia para evitar que dos usuarios reserven la misma sala al mismo tiempo. Los usuarios pueden reservar una sala especificando el nombre de la sala y la duración de la reserva. El sistema debe validar que la sala exista, que esté disponible en el momento solicitado y que la duración de la reserva sea válida. En caso de error, el sistema debe retornar un mensaje descriptivo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Sistema de reservas de salas con control de concurrencia |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 4 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Creación de la API básica

**Objetivo:** Implementar la API que permite reservar una sala.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Crear una API REST que acepte solicitudes de reserva de salas.
- La API debe validar que la sala exista y que esté disponible en el momento solicitado.
- En caso de éxito, la API debe marcar la sala como reservada por la duración especificada.
- En caso de error, la API debe retornar un mensaje descriptivo.

**Entregable:** API REST funcional que permite reservar una sala con validaciones básicas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejarías la concurrencia en un sistema multiusuario.
- Piensa en los posibles errores y cómo los manejarías.

</details>

### Fase 2: Implementación de validaciones y manejo de errores

**Objetivo:** Mejorar la API para incluir validaciones adicionales y manejo de errores más robusto.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Agregar validaciones para asegurar que la duración de la reserva sea válida.
- Implementar un manejo de errores más robusto que incluya diferentes tipos de errores y sus respectivos mensajes.
- Asegurar que la API maneje correctamente las situaciones de concurrencia.

**Entregable:** API REST mejorada con validaciones adicionales y manejo de errores más robusto.

<details>
<summary>Pistas de conocimiento</summary>

- Considera diferentes tipos de errores que podrían ocurrir y cómo los manejarías.
- Piensa en cómo podrías mejorar la experiencia del usuario en caso de error.

</details>

### Fase 3: Optimización y refactorización

**Objetivo:** Optimizar y refactorizar la API para mejorar su rendimiento y mantenibilidad.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identificar y eliminar duplicaciones de código.
- Optimizar las validaciones y el manejo de errores para mejorar el rendimiento.
- Refactorizar el código para mejorar su legibilidad y mantenibilidad.

**Entregable:** API REST optimizada y refactorizada.

<details>
<summary>Pistas de conocimiento</summary>

- Considera patrones de diseño que podrían mejorar la legibilidad y mantenibilidad del código.
- Piensa en cómo podrías mejorar el rendimiento de la API.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API REST y cómo se utiliza en este sistema de reservas de salas?
- **paraQueSirve**: ¿Para qué sirve la validación en la API de reservas de salas?
- **comoSeUsa**: ¿Cómo se usa la API para reservar una sala?
- **erroresComunes**: ¿Qué errores comunes pueden ocurrir al usar la API de reservas de salas y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la optimización y refactorización de la API?

## Criterios de Evaluacion

- Implementación de la API REST que permite reservar una sala.
- Validación de que la sala exista y que esté disponible en el momento solicitado.
- Manejo de errores con mensajes descriptivos.
- Optimización y refactorización del código.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*

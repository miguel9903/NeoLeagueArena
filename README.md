# NeoLeagueArena

**NeoLeagueArena** es una aplicación de escritorio desarrollada en **Java** con **Swing**, siguiendo los principios de programación orientada a objetos y utilizando los patrones de diseño **MVC**, **DAO** y **DTO**. Este proyecto ha sido desarrollado como trabajo final para la asignatura de **Programación I**, con el objetivo de brindar una solución integral a la organización y gestión de torneos de videojuegos competitivos (E-Sports).

## 📌 Contexto

NeoLeague Arena es una organización dedicada a la planeación y realización de torneos de videojuegos a nivel nacional e internacional. Algunos de los títulos más destacados en sus competencias incluyen **Gran Turismo, FIFA, Fórmula 1 y Rocket League**.

Frente al crecimiento de la escena competitiva, la organización ha detectado diversos desafíos:

- Registros desorganizados o desactualizados de jugadores y equipos.
- Falta de control sobre emparejamientos y seguimiento de partidas.
- Dificultad para notificar eventos o cambios a los participantes.
- Pérdida de información por falta de mecanismos de persistencia.
- Generación manual e imprecisa de informes y reportes.

Ante esta situación, se propuso el desarrollo de un sistema de información que permita automatizar procesos, mejorar la experiencia del usuario y optimizar la toma de decisiones mediante el uso de datos confiables y actualizados.

---

## 🎯 Objetivos del Sistema

- Gestionar información de usuarios: jugadores, entrenadores y administradores.
- Administrar equipos y sus alineaciones por torneo.
- Configurar distintos tipos de torneos y fases.
- Registrar resultados de partidas, visualizar cronogramas y fases.
- Automatizar notificaciones por correo electrónico ante eventos importantes.
- Generar reportes estadísticos (jugadores destacados, rendimiento de equipos, etc.).
- Asegurar la persistencia y respaldo de información sensible.
- Brindar una experiencia fluida y visualmente amigable.

---

## ⚙️ Arquitectura

El proyecto se estructura bajo una arquitectura modular y escalable que incluye:

- **MVC (Modelo-Vista-Controlador):** Separación de la lógica de negocio, presentación e interacción.
- **DAO (Data Access Object):** Capa de acceso a datos que gestiona la persistencia en archivos.
- **DTO (Data Transfer Object):** Entidades simplificadas para transportar información entre capas.
- **Persistencia:** Archivos planos y/o binarios para almacenamiento de datos.

---

## 🧩 Módulos Funcionales

- ✔️ Gestión de usuarios (jugadores, entrenadores, admins).
- ✔️ Registro y administración de equipos.
- ✔️ Creación y configuración flexible de torneos.
- ✔️ Emparejamiento, seguimiento y registro de partidas.
- ✔️ Visualización de fases y cronogramas.
- ✔️ Sistema de notificaciones automáticas por correo.
- ✔️ Generación de reportes e indicadores clave.
- ✔️ Módulo de premiaciones.
- ✔️ Configuración general de parámetros del sistema.
- ✔️ Mecanismo de respaldo y recuperación de datos.

---

## 💡 Tecnologías Utilizadas

- **Lenguaje:** Java SE
- **Interfaz Gráfica:** Swing
- **Arquitectura:** MVC
- **Persistencia:** Archivos (binarios y/o texto)
- **Correo Electrónico:** Envío de notificaciones mediante JavaMail (si aplica)

---

## 🛠️ Requisitos

- JDK 17 o superior
- IDE recomendado: IntelliJ IDEA, Eclipse o NetBeans

---

## 👥 Equipo de Desarrollo

Proyecto desarrollado por estudiantes de Programación I – Ingeniería de Sistemas / Bioingeniería  
Universidad El Bosque

---

## 📌 Nota Final

Este sistema busca resolver de forma práctica los desafíos reales en la gestión de torneos de E-Sports, integrando componentes de software sólidos y buenas prácticas de desarrollo.

---

© 2025 NeoLeagueArena – Proyecto académico sin fines comerciales.

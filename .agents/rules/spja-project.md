---
description: Core context for the SPJA (Sistem Penjadwalan Tayang Anime) project
alwaysApply: true
---

# SPJA Project Context

## Overview
SPJA (Sistem Penjadwalan Tayang Anime) is a desktop Java Swing application for managing anime broadcast schedules. Built with **Java 21**, **Maven**, and **NetBeans 20**.

## Tech Stack
- **Language**: Java 21
- **Build**: Maven (`pom.xml`)
- **IDE**: NetBeans 20
- **UI Framework**: Java Swing (JFrame, JTable, JPanel, GridBagLayout)
- **Package**: `com.pololer.spjaprak`
- **Main class**: `Spjaprak.java` (entry point)

## Class Hierarchy
```
Media (abstract superclass, private fields, abstract methods: getInfoLengkap(), hitungNilai())
├── Anime (anime series — studio, totalEpisode, musim, hariTayang)
└── AnimeFilm (anime films — durasiMenit, tanggalRilis, distributor)

JadwalTayang (standalone, private fields + getter/setter — BAB 4 Enkapsulasi)
```.

- `GUI_Anime` — Swing GUI for managing `Anime` objects
- `GUI_AnimeFilm` — Swing GUI for managing `AnimeFilm` objects
- `GUI_JadwalTayang` — Swing GUI for managing `JadwalTayang` objects (BAB 4)
- `Spjaprak` — Main menu launcher (opens GUI_Anime, GUI_AnimeFilm, or GUI_JadwalTayang)
- `Terminal` — Console-based testing class

## Coding Conventions
- All **Javadoc and comments** must be written in **Indonesian (Bahasa Indonesia)**.
- Retain the **NetBeans license header** at the top of each file (`nbfs://nbhost/...`).
- Use `protected` access for superclass (`Media`) fields.
- Use `private` access for encapsulation model fields (`JadwalTayang`).
- Use `private final` for collection fields in GUI classes (e.g., `private final ArrayList<Anime> listAnime`).
- Method names use **camelCase** in Indonesian (e.g., `tambahAnime()`, `hitungProgress()`, `tampilkanInfo()`).
- Use `@author Administrator` and `@version 1.0` in Javadoc class-level tags.

## Project Structure
```
src/main/java/com/pololer/spjaprak/
├── Media.java            (superclass)
├── Anime.java            (extends Media)
├── AnimeFilm.java        (extends Media)
├── JadwalTayang.java     (enkapsulasi model — BAB 4)
├── GUI_Anime.java        (Swing GUI for Anime)
├── GUI_AnimeFilm.java    (Swing GUI for AnimeFilm)
├── GUI_JadwalTayang.java (Swing GUI for JadwalTayang)
├── Spjaprak.java         (main entry point)
└── Terminal.java          (console testing)
```

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
Media (superclass, protected fields)
├── Anime (anime series — studio, totalEpisode, musim, hariTayang)
└── AnimeFilm (anime films — durasiMenit, tanggalRilis, distributor)
```.

- `GUI_Anime` — Swing GUI for managing `Anime` objects
- `GUI_AnimeFilm` — Swing GUI for managing `AnimeFilm` objects
- `Spjaprak` — Main menu launcher (opens GUI_Anime or GUI_AnimeFilm)
- `Terminal` — Console-based testing class

## Coding Conventions
- All **Javadoc and comments** must be written in **Indonesian (Bahasa Indonesia)**.
- Retain the **NetBeans license header** at the top of each file (`nbfs://nbhost/...`).
- Use `protected` access for superclass (`Media`) fields.
- Use `private final` for collection fields in GUI classes (e.g., `private final ArrayList<Anime> listAnime`).
- Method names use **camelCase** in Indonesian (e.g., `tambahAnime()`, `hitungProgress()`, `tampilkanInfo()`).
- Use `@author Administrator` and `@version 1.0` in Javadoc class-level tags.

## Project Structure
```
src/main/java/com/pololer/spjaprak/
├── Media.java          (superclass)
├── Anime.java          (extends Media)
├── AnimeFilm.java      (extends Media)
├── GUI_Anime.java      (Swing GUI for Anime)
├── GUI_AnimeFilm.java  (Swing GUI for AnimeFilm)
├── Spjaprak.java       (main entry point)
└── Terminal.java        (console testing)
```

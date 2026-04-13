---
description: Documentation standards for SPJA project markdown files
globs:
  - "*.md"
---

# Documentation Standards

## Language
All documentation must be written in **Indonesian (Bahasa Indonesia)**.

## GUI Property Table Format (`Tabel_Properti_GUI.md`)
Use this format for documenting GUI component properties:

```markdown
|  No   | Nama Komponen     | Properti      | Value             |
| :---: | :---------------- | :------------ | :---------------- |
|   1   | `JLabel` (anonim) | Text          | Judul:            |
|   2   | `tfJudul`         | Name<br>Text  | tfJudul<br>*(kosong)* |
```

### Rules:
- Anonymous labels → `JLabel (anonim)`
- Named components → backtick-quoted name (e.g., `` `tfJudul` ``)
- Multi-value properties → separated with `<br>`
- Empty text fields → `*(kosong)*`
- JTable model → list column names in `[brackets]`

## Class Diagram Table Format
Use single-column markdown tables with the class name as header:

```markdown
| ClassName                                    |
| :------------------------------------------- |
| - field1 : Type<br>- field2 : Type           |
| + method1() : ReturnType<br>+ method2() : void |
```

### Rules:
- `+` for public, `-` for private, `#` for protected
- Separate fields and methods into two rows
- Use `<br>` to separate multiple items within a cell
- Use `&lt;` and `&gt;` for generic type parameters (e.g., `ArrayList&lt;Anime&gt;`)

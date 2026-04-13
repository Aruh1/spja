---
description: Java Swing GUI conventions for SPJA project
globs:
  - "*.java"
---

# Java Swing GUI Conventions

## Component Naming Prefixes
| Prefix   | Component Type | Example          |
|----------|---------------|------------------|
| `tf`     | JTextField    | `tfJudul`        |
| `btn`    | JButton       | `btnTambah`      |
| `lbl`    | JLabel        | `lblProgress`    |
| `table`  | JTable        | `tableAnime`     |
| `model`  | TableModel    | `modelAnime`     |

## GUI Class Pattern
Every GUI class must follow this structure:
1. **Extend `JFrame`** — each GUI is a standalone window.
2. **Constructor** — set title, size, close operation, call `initComponents()`, then `setVisible(true)`.
3. **`initComponents()`** — build all UI components (form panel, table, bottom panel).
4. **`addFormField(JPanel, GridBagConstraints, String, int)`** — helper to add a label + text field row.
5. **`clearFields()`** — reset all text fields to empty.
6. **`main(String[])`** — standalone launcher using `SwingUtilities.invokeLater()`.

## Layout Conventions
- **Form panels**: `GridBagLayout` with `Insets(4, 6, 4, 6)`.
- **Frame layout**: `BorderLayout(10, 10)` — form at `NORTH`, table at `CENTER`, actions at `SOUTH`.
- Use `BorderFactory.createTitledBorder()` for section grouping.

## JTable Setup
```java
DefaultTableModel model = new DefaultTableModel(columns, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Non-editable
    }
};
JTable table = new JTable(model);
add(new JScrollPane(table), BorderLayout.CENTER);
```

## Thread Safety
Always launch GUIs on the Event Dispatch Thread:
```java
SwingUtilities.invokeLater(() -> new GUI_ClassName());
```

## Validation Pattern
- Check all fields non-empty → `JOptionPane.WARNING_MESSAGE`
- Parse numeric fields with try-catch → `JOptionPane.ERROR_MESSAGE`
- Show success dialog → `JOptionPane.INFORMATION_MESSAGE`

## Window Behavior
- Use `JFrame.DISPOSE_ON_CLOSE` for sub-windows (GUI_Anime, GUI_AnimeFilm).
- Use `JFrame.EXIT_ON_CLOSE` only for the main entry point (Spjaprak).
- Call `setLocationRelativeTo(null)` to center on screen.

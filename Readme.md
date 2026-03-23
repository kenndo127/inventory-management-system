# Inventory Management System

A terminal-based inventory management application built in Java. This project was built primarily as a hands-on exercise for the **Java Collections Framework**, with emphasis on `HashMap` operations and `Map.Entry` usage.

---

## Project Structure

```
org.kenneth.inventoryManagement
├── entity
│   └── Product.java          # Product model (fields, getters, setters)
├── repository
│   └── InventoryRepository.java  # HashMap storage and manipulation
├── services
│   └── InventoryService.java     # Business logic, delegates to repository
└── main
    └── Main.java             # Entry point, user interface, menu loop
```

---

## Features

- Add a new product
- Update product quantity
- Search for a product by name
- List all products sorted by price
- Calculate total inventory value
- Remove a product by name

---

## How It Works

The app runs as a terminal menu loop. On each iteration the user picks an action, the `Main` class collects input and calls the appropriate method on `InventoryService`, which delegates to `InventoryRepository` where the actual `HashMap` operations happen.

`InventoryService` and `InventoryRepository` have a **composition relationship** — the service holds a reference to the repository and depends on it for all storage and retrieval.

---

## Key Technical Decisions

- **`HashMap<String, Product>`** is the backing data structure, keyed by product name.
- **`Map.Entry`** is used when iterating over entries that require both key and value (e.g. search, remove, sort by price).
- **Sorting** is done by extracting entries into a `List<Map.Entry<String, Product>>` and using `List.sort()` with a `Comparator` based on `Double.compare()`.
- **`removeIf()`** is used as a cleaner alternative to loop-and-break for removing entries.

---

## Assumptions

Since the focus of this project was the Collections layer, several simplifications were made:

- No input validation (assumes well-formed user input)
- No persistent storage (data is lost when the app exits)
- Product names are assumed to be unique

---

## How to Run

1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `Main.java`

Requires **Java 17+** and **Maven**.

---

## Purpose

This project was built to practise Java Collections in a real application context, specifically:

- `HashMap` — storage and lookup
- `Map.Entry` / `entrySet()` — iteration over key-value pairs
- `List.sort()` with a custom `Comparator`
- `removeIf()` for safe collection modification
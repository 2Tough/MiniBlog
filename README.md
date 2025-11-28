# MiniBlog

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
[![Maven](https://img.shields.io/badge/Maven-3+-green.svg)](https://maven.apache.org/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21+-orange.svg)](https://openjfx.io/)

A simple Java desktop application that demonstrates:

- Java 17+
- JavaFX UI development
- CRUD note management
- Local file storage
- Clean and responsive GUI

---

## Description

**JavaNoteManager** is a lightweight JavaFX desktop app for creating, editing, saving, and deleting simple text notes.

- Notes are loaded and saved automatically.
- The interface is clean, centered, and designed for readability.
- Ideal as a small JavaFX project template or learning tool.

---

## Features

- Create new notes  
- Edit and delete existing notes  
- Auto-refresh of note list  
- Notes stored in `.txt` or `.json` (depending on implementation)  
- Error handling for file operations  
- Minimalist, modern JavaFX interface  

---

## Screenshot

<img width="599" height="426" alt="image" src="https://github.com/user-attachments/assets/a026ec0e-7c14-4eee-bb2a-075838c66104" />
<img width="598" height="429" alt="image" src="https://github.com/user-attachments/assets/75546fb1-d8e1-42e8-bbd2-1933af8b7d84" />




---

## How to Run

### Requirements

- Java 17+  
- Maven  
- JavaFX 21+  

### Steps

1. Clone the repository:

```bash
git clone MiniBlogJava
```

2. Run the app with Maven:

```bash
mvn clean javafx:run
```

---

## Project Structure

```
src/
 └─ main/
     ├─ java/
     │   └─ com.mooc.interfaces.MiniBlogJava/
     │        ├─ Main.java
     │        ├─ MiniBlogApp.java
     │        ├─ MiniBlogGUI.java
     │        ├─ Post.java
     │        └─ PostRepository.java
     └─ resources/
         
```

---

## Build

To create an executable JAR:

```bash
mvn clean package
```

The JAR will appear in:

```
target/MiniBlogJava.jar
```

---

## License

Distributed under the **MIT License**.


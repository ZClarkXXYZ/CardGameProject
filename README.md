# CardGameProject

A JavaFX card game demonstrating software design patterns (Builder, Command, Observer, Decorator, Adapter, Singleton).

---

## Requirements

- **Java 23 or newer**
- Maven is included

---

## Setup

### 1. Install Java 23

**Mac:**
```bash
brew install openjdk
```
Or download from https://adoptium.net/

**Windows:**
- Download latest JDK from https://adoptium.net/
- Run the installer
- Verify: Open Command Prompt and type `java -version`

**Linux:**
```bash
sudo apt install openjdk-23-jdk        # Ubuntu/Debian
sudo dnf install java-latest-openjdk-devel # Fedora
```

### 2. Get the Project

```bash
git clone https://github.com/ZClarkXXYZ/CardGameProject.git
cd CardGameProject
```

---

## Running the Game

**Windows:**
```cmd
mvnw.cmd javafx:run
```

**Mac/Linux:**
```bash
./mvnw javafx:run
```

That's it!

---

## If It Doesn't Work

### "mvnw: Permission denied" (Mac/Linux)

chmod +x mvnw
./mvnw javafx:run

### "Wrong Java version" or "release version not supported"
Check your version:

java -version


Must be 23 or higher, Install a newer version if needed.

### "JAVA_HOME not set"
The Maven wrapper should work without this, but if needed:

**Mac:**
Add to `~/.zshrc`:

export JAVA_HOME=$(/usr/libexec/java_home)


**Windows:**
- Search for "Environment Variables" in Start menu
- Add new System variable: `JAVA_HOME` = path to your JDK installation

**Linux:**
Add to `~/.bashrc`:

export JAVA_HOME=/usr/lib/jvm/java-23-openjdk-amd64


---

## Building

Only needed if you want to create a JAR file:

**Windows:**

mvnw.cmd clean install

**Mac/Linux:**

./mvnw clean install


JAR file will be in `target/CardGameProject-1.0-SNAPSHOT.jar`

---

## Using an IDE

### IntelliJ IDEA
1. File → Open
2. Select the CardGameProject folder
3. Wait for Maven to import
4. Right-click `GameApplication.java` → Run

---

## Project Structure

```
src/main/java/com/example/cardgameproject/
├── adapter/              # Adapter pattern
├── command/              # Command pattern
├── decorator/            # Decorator pattern
├── observerAndBuilder/   # Observer & Builder patterns
├── singleton/            # Singleton pattern (GameModel)
└── GameApplication.java  # Start here
```

---

## Design Patterns Used

- **Singleton** - GameModel (one game state)
- **Builder** - UnitBuilder (construct units)
- **Command** - Button actions
- **Decorator** - Card modifications
- **Observer** - Army-unit notifications
- **Adapter** - Recipe/Quest compatibility

---

## Help

- Make sure Java 23+ is installed: `java -version`
- Make sure you're in the CardGameProject folder
- On Mac/Linux, make mvnw executable: `chmod +x mvnw`
- Use Maven wrapper to run: `./mvnw javafx:run` (not `java -jar`)
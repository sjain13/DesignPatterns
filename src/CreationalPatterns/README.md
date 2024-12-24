# Creational Design Patterns

Creational Design Patterns are a category of design patterns in software engineering that focus on object creation mechanisms. These patterns abstract the instantiation process, making a system independent of how its objects are created, composed, and represented. By doing so, they help reduce dependencies and provide greater flexibility in determining which objects to create for a given situation.

---

## Key Characteristics of Creational Design Patterns

1. **Encapsulation of Object Creation**:
   - Encapsulate the process of object creation to hide the complexity and provide a more flexible approach.

2. **Flexibility**:
   - Allow systems to decide what kind of objects to create during runtime, instead of being hardcoded during compile time.

3. **Reduce Coupling**:
   - Help in decoupling the instantiation process from the usage of objects, promoting loose coupling.

---

## Comparison of Patterns

| **Pattern**         | **Purpose**                                      | **Key Example Use**               |
|---------------------|--------------------------------------------------|------------------------------------|
| **Singleton**       | Ensures one instance and global access           | Logging, configuration management |
| **Factory Method**  | Creates objects via a factory interface          | GUI elements, shapes              |
| **Abstract Factory**| Creates families of related or dependent objects | Cross-platform GUI                |
| **Builder**         | Constructs complex objects step-by-step          | Assembling products, constructing UIs |
| **Prototype**       | Clones existing objects to create new ones       | Cloning database objects, game entities |

---

## When to Use Creational Design Patterns

1. When object creation becomes complex or repetitive.
2. When you want to provide flexibility in creating objects at runtime.
3. When decoupling object creation logic from object usage is necessary.

---

Creational Design Patterns play a crucial role in making software designs more modular, reusable, and maintainable. By choosing the right pattern for the scenario, developers can simplify object creation and focus on the core logic of their applications.

# Creational Design Patterns

- [Singleton Pattern](#Singleton-Pattern)

# Singleton Pattern
* Ensures that a class has only one instance and provides a global point of access to it.
* Useful for resources like database connections, configuration settings, etc.

# Singleton Pattern in Java

## Implementation

Below is an example of a simple Singleton pattern implementation in Java:

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

# Singleton Pattern in Java

## Explanation

### Private Constructor
- Ensures that the class cannot be instantiated from outside.

### Static Instance Variable
- Stores the single instance of the class.

### Lazy Initialization
- The instance is created only when it is needed (**lazy loading**).

### Global Access Point
- The `getInstance()` method provides a way to access the Singleton instance.

---

## Potential Issues with the Above Implementation
- This implementation is **not thread-safe**. Multiple threads accessing `getInstance()` simultaneously might create multiple instances.

---

## Thread-Safe Singleton (with Double-Checked Locking)

To make the Singleton thread-safe, consider the following approach:

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

# Key Changes

## `volatile` Keyword
- Ensures visibility and prevents instruction reordering issues.
- When a variable is declared as `volatile`, it ensures that any thread that reads the value of the variable sees the most recent value written by any other thread.

## Double-Checked Locking
- Minimizes synchronization overhead by adding an additional `if` check outside the synchronized block.
- This approach ensures that synchronization only occurs when the instance is being created, reducing the performance cost of synchronization on subsequent accesses after the instance has been initialized.


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
```
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
```

# Key Changes

## `volatile` Keyword
- Ensures visibility and prevents instruction reordering issues.
- When a variable is declared as `volatile`, it ensures that any thread that reads the value of the variable sees the most recent value written by any other thread.

## Double-Checked Locking
- Minimizes synchronization overhead by adding an additional `if` check outside the synchronized block.
- This approach ensures that synchronization only occurs when the instance is being created, reducing the performance cost of synchronization on subsequent accesses after the instance has been initialized.

# Breaking the Singleton Design Pattern in Java

## Overview

The Singleton Design Pattern is meant to ensure that a class has only one instance and provides a global access point to that instance. However, it can be broken under certain circumstances. Below are some common ways the Singleton pattern can be violated, along with solutions to prevent them.

---

## 1. Breaking Singleton Using Reflection

Reflection allows bypassing private constructors and can be used to create a new instance of the Singleton class, breaking the pattern.

### Example:

```java
import java.lang.reflect.Constructor;

public class SingletonBreaker {
    public static void main(String[] args) throws Exception {
        // Get the Singleton class constructor
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);  // Bypass private constructor

        // Create a new instance using reflection
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = constructor.newInstance();

        // Check if both instances are different
        System.out.println(instance1 == instance2);  // Output: false
    }
}
```
### Solution:
To prevent breaking the pattern using reflection, throw an exception in the constructor if the instance already exists:

```java
private Singleton() {
    if (instance != null) {
        throw new IllegalStateException("Instance already created");
    }
}
```
## 2. Breaking Singleton Using Serialization
Serialization and deserialization can create a new instance of the Singleton, effectively breaking the pattern.

```java
import java.io.*;

public class SingletonSerializationBreaker {
    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();

        // Serialize the Singleton instance
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        // Deserialize the Singleton instance
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        Singleton instance2 = (Singleton) in.readObject();
        in.close();

        // Check if both instances are different
        System.out.println(instance1 == instance2);  // Output: false
    }
}
```
### Solution:
Override the readResolve() method in the Singleton class to return the existing instance during deserialization:

```java
protected Object readResolve() {
    return getInstance();
}
```
## 3. Breaking Singleton Using Cloning
Cloning the Singleton class can bypass the Singleton pattern and create another instance.

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Cloning not allowed");
}
```
## 4. Breaking Singleton Using Multithreading Bugs (Double-Checked Locking Issue)
Without the volatile keyword, multiple threads can end up creating multiple instances, breaking the Singleton pattern.

```java
public class Singleton {
    private static Singleton instance;

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
```
### Solution:
Use the volatile keyword to ensure the instance is correctly published to other threads:

```java
private static volatile Singleton instance;
```

## 5. Breaking Singleton Using Multiple Classloaders
In complex systems, such as those using OSGi or web containers, multiple classloaders may create different instances of the Singleton class, breaking the pattern.

### Solution:
Ensure that the Singleton class is loaded by a single classloader, preventing the creation of multiple instances.

## Summary of Solutions
- **Reflection:** Prevent instantiation via reflection by throwing an exception in the constructor if an instance already exists.
- **Serialization:** Use readResolve() to ensure deserialization returns the same instance.
- **Cloning**: Override the clone() method to prevent cloning.
- **Threading:** Use volatile for the Singleton instance and ensure proper synchronization.
- **Classloaders:** Ensure the Singleton class is loaded by a single classloader in a system with multiple classloaders.




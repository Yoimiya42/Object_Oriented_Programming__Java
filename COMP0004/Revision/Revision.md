Created by [@Yoimiya] on 2025-05-15
### Data Types
- **`Primitives Types`**: Store **actual values** on the **stack**.(assignment: **value** is copied)

- **`Reference Types / Class Types`**: Store **references(memory addresses)** to access objects on the **heap**. (assignment: **reference** is copied, e.g. `String`, `Array`, `Class`)
  1. `Array`: a sequences of values, fixed size, identical type.
    - `C arrays`: directly accessible sequences of **real memory locations**; no bounds checking(overbound but no error).
    - `Java arrays`: managed data structure wrapped in an **object**, no access to real memory; strict bound checking.
  - `2D Array`: an array of **references** to arrays. Each row can have different lengths(jagged array).
  ```java
  int[][] arr = new int[3][]; // 3 rows, but varying columns
  arr[0] = new int[2]; 
  arr[1] = new int[7]; 
  arr[2] = new int[4]; 
  ```
  1. `String`: *Immutable* sequence of characters. Strings are **objects** in Java, but they are often treated as primitive types for convenience.
    - `StringBuilder`: Mutable sequence of characters. It is used when you need to modify a string frequently.
  2. `Class`: A blueprint/template for creating objects. It defines the `attributes / properties / fields`(implemented as `instance variables`) + `behaviors`(implemented as `methods`).
     - `object` is an instance of a class. Objects have `attributes` (`instance variables`) and `behavior` (`methods`), created dynamically in heap memory.
     - `Autoboxing & Unboxing`: Automatic conversion between primitive types and their corresponding object wrapper classes .
       - `int` -> `Integer`, autoboxing
       - `Integer` -> `int`, unboxing
     `null reference`: does not refer to any object. If use a method or access a field on a null reference, then `NullPointerException`.

When the type checking is done?
- `Static Type`: The type of a variable is known at compile time. (e.g. `int`, `String`, `ArrayList`)
- `Dynamic Type`: The type of an object is known at runtime. (e.g. `Object`, `ArrayList<String>`)
The strictness of type rules:
- `Weakly Typed Language`: The type of a variable **can change at runtime**. (e.g. JavaScript, Python)
- `Strongly Typed Language`: All variables and expressions has a type that is known at compile time, **cannot change at runtime**.(`Type Checking` is done at compile time. e.g., Java, C++)

- `==`:
  - for primitive types: compares the **actual values**.
  - for reference types: compares the **memory addresses** of the objects.
- `equals()`: compares the contents of the objects. Can be overridden in a class to provide custom equality logic.


- `arguments`: values passed ton a method call.
- `parameters`: variables declared in the method parameters list.
The parameter variable is initialized to a *copy* (actual value or reference) of the argument value.(Call-by-value, not the variable itself)
- `Scope`: defines **where** a variable can be accessed, e.g., `local`, `method`, `class`.
- `Lifetime`: defines **how long** a variable exists in memory. e.g., 
  - *local/parameter variables* exist only within the block they are declared; 
  - *instance variables* belong to an object and exist as long as the object exists.
- `Garbage Collection`: The JVM automatically reclaims memory occupied by objects that are no longer referenced.
  
Class + compiler + type checking + JVM ensures behaviour must conform to the type system.
- `JVM`: Java Virtual Machine, an abstract machine that enables a computer to run Java programs. It provides a **runtime environment** and **converts Java bytecode into machine code**.

---
## Exceptions
**Checked exception**: *Checked at compile time*. The compiler forces you to either handle them using `try-catch` or declare with `throws` keyword(informs the caller to handle or propagate it), otherwise the code won't compile.(i.e. `IOException`, `ClassNotFoundException`)

**Unchecked exception**: *Not checked at compile time*. Occurs **at runtime** due to programming errors, such as `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`. The compiler does not force you to handle them, better to fix the underlying code issue.

`Exception propagation` is the process where an exception, if not caught in the method it was thrown, is passed up the call stack to the calling method.

`try-with-resources`: resources are automatically closed at the end of the `try` block, whether it completes normally or an exception occurs.  

Create a custom exception:
```java
public class MyException extends Exception {
    public MyException(String message){
        super(message);
    }
}
```
- `throw` myException by an *instance of an exception* in a method:
```java
public void myMethod() throws MyException {
    if (condition) {
        throw new MyException("Error message");
    } 
    // Do something
}
```
- Using `try-catch-finally` to handle exception in the client code:
- `finally` block always executes, regardless of whether an exception was thrown or caught.
```java
public void clientMethod() {
    try {
        myMethod();
    } catch (MyException e) {
        System.out.println("Caught exception: " + e.getMessage());
    } finally {
        System.out.println("Finally block always executed");
    }
}
```



---
### OOP concepts
- `Abstraction`: Hide the complex implementation details and focusing on the essential features of the object.(e.g. `abstract class`, `interface`)
- `Encapsulation`: Bundle attributes and methods that operate on data into a single unit (class), restrict access to the inner workings, provide a public API to interact.
- `Inheritance`: subclass is a "specialization-of"/"kind-of" superclass, shared `public` and `protected` fields and methods, can add more properties or override methods.
- `Override`:  provides a specific implementation for method already defined in its superclass.
- `Overload`: multiple methods with the same name but different parameters in the same class or subclass.

- `abstract method`: method without implementation, defined in an abstract class or interface, must be implemented by concrete class.
- `static variable/method`:
  - belongs to the class itself, *not to any specific instance*. 
  - It can be accessed without creating an instance of the class. 
    ```java
    Math.sqrt(4); // static method
    Math.MAX_VALUE; // static variable
    ```
  - It is **shared** among all instances of the class.

||`abstract class`|`interface`|
|:----------------:|:-----------:|:----------------:|
|**Design**|a "specialization of" rel. with sharing partial implementation; - serves as a blueprint for other classes; - includes concrete methods and fields to provide shared functionality; - defines `abstract` methods that enforcing specific implementation| a "can-do" rel. capability or contract| 
|**Instantiation**|No|No|
|**Fields**|All|Only `static final`|
|**Methods**|concrete and `abstract` | `abstract` + (`default` method with concrete implementation, override optionally)|

- `Programming to interface`: depends on abstract types (interface or abstract class) rather than concrete impelementation (decouple from concrete class). Enhances the maintainability and extensibility of the code.

- `Type`: defines a set of possible values and a set of operations (methods) that can be performed on those values.  In Java, classes, interfaces, records, and enums all define types. An object can conform to multiple types.

- `Polymorphism`:
  - `Inheritance polymorphism(Runtime polymorphism)`: 
    - **Method overriding**
    - achieved via **Dynamic binding**, method called at **runtime** is determined by the **actual object type**.
    - **Supertype reference to subtype object**.
     ```java
     Animal ani = new Cat(); // Supertype: Animal; Subtype: Cat
     ani.sound(); // Calls Cat's version at runtime
     ```
  - `Ad-hoc polymorphism(Compile-time polymorphism)`:
    - **Method overloading**
    - achieved via **Static binding**, method called at **compile time** is determined by the **reference type**(based on method para. types and count).
    ```java
    public class MathUtil {
        public int add(int a, int b);
        public double add(double a, double b);
    }

    MathUtil math = new MathUtil();
    math.add(5, 10); // Calls add(int, int)
    math.add(5.0, 10.0); // Calls add(double, double)
    ```
  - `Parametric polymorphism`:
    - achieved via **Generic classes and methods**
      ```java
       class A <T>{}
       class B <T extends Comparable<T>>{
            ArrayList<T> list;

            public T getMethod(T t){
                return t;
            }
       }
       ```
- `Generic`: code works with any data type, using **type parameters** instead of specific types. It allows for **type safety** and **reusability**.
  - `invariance`: `List<Integer>` is NOT a subtype of `List<Number>`.
  - `covariance`: `Integer[]` is a subtype of `Number[]`.
  - `Type erasure`: The compiler replaces all type parameters with their bounds or `Object` if no bounds are specified.  This means that the generic type information is **not available at runtime**.
    ```java
    // In .java file
    class Box<T> {
        private T item; // T is unbounded 
    }

    class Price<T extends Comparable<T>>{
        private T price; // T is bounded by Comparable
    }

    // In .class file
    class Box {
        private Object item; // T is replaced with Object
    }

    class Price {
        private Comparable price; // T is replaced with Comparable
    }
    ```
- `<? extends T>`: **upper bound** wildcard, accepts **subtypes** of T.
- `<? super T>`: **lower bound** wildcard, accepts **supertypes** of T.
- `?`: **unbounded** wildcard, accepts any type.

- `Object class`: All classes either directly or indirectly inherit from `Object`. It provides methods like `toString()` and `equals()`.
       
- `final class`: cannot be inherited.
- `final method`: cannot be overridden.
- `record`: final class with final fields.
  ```java
  public record Person(String name, int age){
        // All fields are final and private
        public void OptionalCustomMethods(){
            // Custom methods
        }
        .name() // getter
        .age() // getter
        .toString() // toString
        .equals() // equals

        public boolean equals(Object obj){
            // Compare to itself
            if (this == obj) return true;
            // Check if obj is null or not the same class
            if (obj == null || this.getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            return this.name.equals(other.name) 
                && this.age == other.age;
        }
  }
  ```

- `couple`: the degree of dependency between two modules.
- `cohesion`: the degree which a module is focused on a single task.

- `private` members can be inherited by children classes but can **not be accessed**(`protected` can do) in the child class(need to use `getter` and `setter` methods).



---
## File Handling

ReadFile:
```java
public static void readFile(String filePath){
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
        String line;
        while ((line = reader.readline()) != null){
            System.out.println(line);
        }
    }catch (IOException e){
        System.out.println("Error reading file: " + e.getMessage());    
    }
}
```
WriteFile:
```java
public static void writeFile(String filePath, String content){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
        writer.write(content);
        writer.newLine(); // Add a new line
        writer.flush(); // Ensure all data is written
    }catch (IOException e){
        System.out.println("Error writing file: " + e.getMessage());
    }
}
```

`ByteStream`: `InputStream` and `OutputStream` abstract classes, used for reading and writing binary data. (e.g. `FileInputStream`, `FileOutputStream`)  
`CharacterStream`: `Reader` and `Writer` abstract classes, used for reading and writing character data. (e.g. `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)


- `package`: a collection of `interface`, `enum` and `class`, provides a **namespace** to avoid name conflicts. 
  - non-private (public or protected) classes, fields and methods have a Package Scope, which means it can be only accessed by other classes inside the same Package.

- `module`: a collection of packages, provides a **module system** to manage **dependencies** and access control.
- `JAR`: Java Archive, compress multiple `.class`, related resources and `metadata` into a single file. 

---
## API

### Array
```java
int[] arr = new int[10]; // Declare
int[] arr_ = {1, 2, 3, 4, 5}; // Declare and initialize
int[][] arr2 = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
}; // 2D array

int len = arr.length; 
Arrays.sort(arr); 
Arrays.toString(arr); // Print array
```
### String
```java
String str = "Yoimiya";

int len = str.length();
char ch = str.charAt(0); // Get char at index
String sub = str.substring(0,3);
int index = str.indexOf("Yo"); // Get the index where "Yo" occurs first
boolean isStart = str.startsWith("Y"); // Check if it starts with "Y"
String replace = str.replace("Y", "A"); // Replace "Y" with "A"
String[] split = str.split("o"); 
String lowercase = str.toLowerCase(); 
boolean isEqual = str.equals("Yoimiya"); 
int compare = str.compareTo("Yoimiya"); 

String reverse = new StringBuilder(str).reverse().toString();
```
### ArrayList
```java
List<String> list = new ArrayList<>(); 

List<String> list_ = Arrays.asList("A", "B", "C"); // Arrays to List
String[] arr = list_.toArray(); // List to Array

list.add(7, "Yoimiya"); // Add element at specific index
list.get(7); // Get element at index 0
list.set(7, "Kazuha"); // Set element at index
String str = list.remove(7); // Remove and return element at index
int size = list.size(); // Get size
boolean contains = list.contains("Y");
list.indexOf("Y"); // Get index of element

Collections.sort(list); 
Collections.reverse(list); // Reverse
```

### HashMap
```java
Map<String, Object> map = new HashMap<>();
map.put("key", "value");
map.get("key");
map.remove("key"); // Remove key-value pair
map.containsKey("key"); // Check if key exists
map.containsValue("value"); // Check if value exists
map.size(); 

Set<String> keys = map.keySet(); // Get all keys
Collection<Object> values = map.values(); // Get all values
```
### Math
```java
(int)Math.random() * (max - min) + min; 
// [1,7]：
(int)Math.random() * (7 - 1) + 1;

Math.abs(-5); 
Math.max(5, 10);
Math.min(5, 10);
Math.pow(2, 3); // 2^3
Math.sqrt(16); // Square root
Math.round(3.14); // Round to nearest integer

Integer.parseInt("123"); // Convert String to int
String.valueOf(123); // Convert int to String
```


```java
switch (expression) {
    case value1:
        // code block
        break;
    case value2:
        // code block
        break;
    default:
        // code block
}
```

- `Recursion` pros and cons:
  - Pros:
    - Break down complex problems into smaller problems.
    - **More readable** and easier to understand.
  - Cons:
    - Can lead to **stack overflow** if the recursion depth is too high.
    - May consume **more memory** due to maintaining multiple function calls on the stack.
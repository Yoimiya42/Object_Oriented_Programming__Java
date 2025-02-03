# Java Foundations
## __Contents__
- [Basics](#Basics)
- [DataType for Java](#Data-Type-in-Java)
- [String](#String)
- [Array](#Array)
- [Random](#Random)
<!-- - [Generics](#Generics) -->
- [Container](#Container)
- [Stream](#Stream)
- [Exception](#Exception)

## Basics
### Compile and run

You compile the file with the following command:
```
javac [filename].java
```
You will end up with a bytecode file named `filename.class` which is stored in the same directory as the source file.
Now, launch the program by issuing the following command(remember to leave off the `.class` extension):
```
java [filename]
```

### A simple Java Program
```
public class className
{
    public static void main(String[] args)
    {
        /*program statements...*/
    }
}
```

- Everything in a Java program must be inside a class.  
- `className` must be the same as your file name.


### Distinction between Function and Method

A ***function*** can be executed independently, with all parameters passed explicitly.

A ***method*** is associated with an object and is implicitly passed to the object calling it, able to operate on the data contained within an instance of a class.

- **C** is a ***procedural*** programming language without object-oriented concepts, so it <ins>only has functions</ins>.
- **Java** and **C#** are ***object-oriented*** programming language where code blocks(<ins>methods</ins>) are typically part of a class. Static methods behave like functions because they are bounded to the class and cannot access specific instance variables.
- **C++** and **Python** support <ins>both</ins> ***procedural*** programming (functions) and ***object-oriented*** programming (methods).


## Data Type in Java

### Part I: Primitive data types

| Type | Symbol | Space Occupied | Minimum Value | Maximum Value | Default Value|
|:-----|:------:|:--------------:|:--------------|:--------------|:------------:|
|Integer|byte| 1 byte| -2^7| 2^7-1|0|
|       |short|	2 bytes| -2^15 | 2^15-1| 0|	
|       | int|	4 bytes	| -2^31 |2^31-1| 0|
|       |long| 8 bytes | -2^63 | 2^63-1| 0L|
|Float| float| 4 bytes| 1.175*10^(-38) | 3.403*10^38|0.0f|
|     |double| 8 bytes| 2.225*10^(-308)|1.798*10^308|0.0|
|Char | char | 2 bytes| 0| 2^16 -1|0|
|Boolean|bool| 1 byte | **false** | **true**|_false_| 

- **float** supports a precision of 7 significant digits.Literal value need to be added 'f', like `3.14`.  
  **double** supports a precision of 15 significant digits.
- Java supports ***Unicode*** encoding instead of just ASCII encoding.
- **false** and **true** are all lowercase.

### Part II: Reference types
The reference type used to store reference or memory address of a object, rather than a specific value.

- `Class`: in java, **class** is a cornerstone of the object-oriented programming. A class defines the blueprint or template for objects, including ***attribute(fields)*** and ***behaviour(methods)***.
  *`String` is a class in Java.*
- `Array`
- `Enum`
- `Interface`

### Distinction between Primitive and Reference data types:

|Features| Primitive Data Type| Reference Data Type|
|:-------|:-------------------|:-------------------|
|Content | Value | Memory Address|
|Memory allocation| ***On Stack***| ***On Heap***|
|`null` or not| Cannot be `null` | Can be `null`|
|Default value| 0(numbers), `false`(boolean)| `null`|


## String
### Features
String is a `class` in Java, not a primitive data type. 
And more than anything, ***<ins>string is immutable</ins>***
- Modification operations or reassignments just return a new string object.
  ```java
  String str1 = "Computer";
  String str2 = "Computer";
  boolean test = (str1 == str2); // true
  ```    
  str1 and str2 share the same memory address due to the string pool mechanism.
  Now we modify and reassign `str2`:
  ```java
  str2 = str1.substring(0,6).concat("ation"); // "Computation"
  boolean test2 = (str1 == str2); // false
  ```
  `str2` now points to a new object, whereas the original object is still in memory.

  we can use C++ to simulate the process:
  ```cpp
  char* str = "immutable";
  char* temp = malloc(12);
  strcpy(temp,str, 6);
  strcpy(temp+6,"ation",6);
  str = temp;
  ```
- We can check the source code of `String` class in Java([String.java](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/lang/String.java)) to see how it is implemented.
  ```java
  public final class String
  {
      private final char value[];
      /*...*/
  }
  ```

### Methods related to String
1. Use `+` to concatenate multiple strings or converted string from value;
   ```java
   int century = 21;
   String str1 = "Computer Science";
   String output = str1 + " in the " + century + "st century.";
   // => "Computer Science in the 21st century."
   ```
2. If you need to put multiple strings together, separated by a delimiter, use the static `join` method.
   ```java
   String path = String.join("/", "https:/", "github.com", "Yoimiya42" );
   // => "https://github.com/Yoimiya42"
   ```
3. The `split(String regex)` method splits a string into parts along a given boundary.
   ```java
   String[] parts = "Computer Science".split(" ");
   // parts[0] = "Computer"
   // parts[1] = "Science"
   ```
   yields an array with two elements: `Computer` and `Science`.

4. `.length()` returns the number of chars in a string
   ```java
   String str = "prelude";
   int len = str.length(); // len = 7
   ```
5. `.charAt(int index)` returns the char at position `n`.
   ```java
   char at6 = "Algorithm".charAt(6); // 't'
   ```
6. `.indexOf(String str)` returns the position of the first occurrence of `str` in the entire string.
   ```java
   int a = "mathematics".indexOf("at"); // 1
   ```
   which opposes the `lastIndexOf(String str)` method:
   ```java
   int b = "mathematics".lastIndexOf("at"); // 6
   ```
7. `.substring(int beginIndex, int endIndex)` returns the substring from index `beginIndex` (included) to `endIndex` (excluded).
   ```java
   String substr = "inadequate".substring(2,10); // "adequate"
   ```
8. `.equals(Object obj)` to indicate whether two strings are equals.
   ```java
   String a = "abc";
   boolean test1 = a.equals("abcd"); // false
   boolean test2 = a.equals("abc");  // true
   ```
   NOTE: Do not use `==` operator! It only determined whether or not the strings are stored in the same location(memory address)
   ```java
   String str1 = "frustrate";
   String str2 = str1;
   String str3 = "frustrate";

   boolean test1 = (str1 == "frustrate"); // true 
   boolean test2 = (str1 == str2);  // true (str1 and str2 point to the same memory address)

   boolean test3 = (str1 == str3);  // true 
   ```
   For the `test3`, in Java, when you create a string literal, the JVM checks the **string pool** to see if the string already exists. If it does, the JVM returns a reference to the existing string. If it doesn't, the JVM creates a new string and adds it to the pool.
   If you use the `new` keyword to explicitly create a string, the JVM creates a new string object in the **heap memory**, and the string pool is not used.
   ```java
   String str4 = new String("frustrate");
   boolean test4 = (str1 == str4); // false
   ```
9. `.compareTo(String str)` compares two strings lexicographically. 
     - Return `0` if the strings are completely equal.
        ```java
        int res1 = "abc".compareTo("abc");   // 0
        ```
     - Return a `negative` value if the `str1 < str2`:
       ```java
       int res2 = "abc".compareTo("abh");   // -3
       ```
     - Return a `positive` value if the `str1 > str2`:
       ```java
       int res3 = "abc".compareTo("aba");   // 1
       ```
 10. `String.format(String format, Object... args)` returns a formatted string using the specified format string and arguments.
     ```java
     String formatted = String.format("Price: £ %,.1f", 8888.888);
      // => "Price: £ 8,888.9"
     ```
     Also, you can use `System.out.printf()` which follows the venerable conventions from C library to print formatted strings.

### StringBuilder
`StringBuilder` is a mutable sequence of characters. It is more efficient than `String` when you need to perform a lot of string manipulation.
#### Constructor
```java
StringBuilder sb = new StringBuilder(); // default capacity is 16
StringBuilder sb = new StringBuilder(int capacity); // specify the initial capacity
StringBuilder sb = new StringBuilder(String str); // initialize with a string
```
#### Methods
1. `append(String str`) appends the string representation of the argument to the sequence.
   Also, you can append the string representation of other data types, e.g., `append(double d)`, `append(int i)`, `append(char[] str, int offset, int len)`.
   ```java
   StringBuilder sb = new StringBuilder("Computer");
   sb.append("Science"); // "ComputerScience"

   char[] arr = {'0', '2', '0', '2', '5', '1'};
   sb.append(arr, 1, 4); // "ComputerScience2025"
   ```
2. `insert(int offset, String str)` inserts the string representation of the argument into the sequence at the specified position.
   ```java
   StringBuilder sb = new StringBuilder("Java");
   sb.insert(4, "Script"); // "JavaScript"
   ```  
3. `delete(int start, int end)` removes the characters in a substring `[start, end)`of this sequence.
   ```java
   StringBuilder sb = new StringBuilder("JavaScript");
   sb.delete(4, 10); // "Java"
   ``` 
4. `deleteCharAt(int index)` removes the character at the specified position.
   ```java
   StringBuilder sb = new StringBuilder("stream");
   sb.deleteCharAt(2); // "steam"
   ```
5. `replace(int start, int end, String str)` replaces the characters in a substring `[start, end)` with the specified string.
   ```java
   StringBuilder sb = new StringBuilder("conjunction");
   sb.replace(0, 3, "dis"); // "disjunction"
   ```
6. `reverse()` reverses the sequence of characters in the buffer.
   ```java
   StringBuilder sb = new StringBuilder("trap");
   sb.reverse(); // "part"
   ```
7. Methods similar to `String` class:  
   - `length()`
   - `charAt(int index)`
   - `indexOf(String str)`
   - `substring(int start, int end)`
   - `toString()`
   - `setCharAt(int index, char ch)`
   - `compareTo(StringBuilder sb)`


## Array
Array is actually an **object** in Java.
### Features
- **Same type**. An array is a collection of elements of the same data type.
- **Fixed size**. The size of an array is fixed and cannot be changed once it is created.
- **continuous in memory allocation**.

### Declaration
```java
// 1. declare and initialize with default values
dataType[] arrayName = new dataType[int size]; // Template
// every element is initialized to the default value of the date type.
int[] arr1 = new int[5]; // [0,0,0,0,0]
String[] arr2 = new String[3]; // [null, null, null] 

// 2. declare and initialize with specific values by assignment
int[] arr3 = {5,6,7,8,9};
```
### Access Elements using for-each loop
```java
for(dataType element: arrayName)  // Template
```
example:
```java
int[] arr = {1,2,3,4,5};
for(int i: arr)
{
      System.out.println(i);
}
```
To print the whole array, you can use `Arrays.toString(Array)`method.
```java
import java.util.Arrays;

int[] arr = {1,2,3,4,5};
System.out.println(Arrays.toString(arr)); // [1,2,3,4,5]
```
For two-dimensional arrays:
```java
import java.util.Arrays;

int[][] arr2D = 
{
   {1,2,3},
   {4,5,6},
   {7,8,9}
};

for(int[] row : arr2D)
{
      System.out.println(Arrays.toString(row));
}
// OR
for(int[] row : arr2D)
{
    for(int elem : row)
    {
      System.out.print(elem + " ");
    }
    System.out.println();
}
```

### Array Copying
```java
import java.util.Arrays;

int[] arr1 = {2,3,5,8,13};
int[] arr2 = arr1; // assigned the memory address of arr1 to arr2.
System.out.println(Arrays.toString(arr2)); // [2,3,5,8,13]
System.out.println(Arrays.toString(arr2)); // [2,3,5,8,13]
// arr2 points to the same memory address as arr1
// If you modify arr2, arr1 will also be modified.
for(int elem : arr2)
{
   elem *=2;
}
System.out.println(Arrays.toString(arr1)); // [4,6,10,16,26]
System.out.println(Arrays.toString(arr2)); // [4,6,10,16,26]
```   
If you actually want to copy all values of one array into a new array, use the `Arrays.copyOf(T[] original, int newlength)`method.
```java
int[] arr1 = {2,3,5,8,13};
int[] arr2 = Arrays.copyOf(arr1, arr1.length); // [2,3,5,8,13]

int[] arr3 = Arrays.copyOf(arr1, 2 * arr1.length); // [2,3,5,8,13,0,0,0,0,0] fill the rest with default value.
```
Or use `Arrays.copyOfRange(T[] original, int start, int end)` to copy a range of elements.
```java
int[] arr1 = {2,3,5,8,13};
int[] arr2 = Arrays.copyOfRange(arr1, 1, 4); // [3,5,8]
```

## Random

1. `Math.random()` returns a double value within `[0.0, 1.0)`. It is a **static** method provided by the `java.lang.Math` class and can be invoked without a class instance.
   ```java
   double random = Math.random(); // [0.0, 1.0) 
   ```
2. `Random` class in `java.util` package provides a more flexible way to generate random numbers.
   You can indicate a certain random sequence by setting a seed value.
   ```java
   import java.util.Random;
   // Random random = new Random(seed); 
   // random1 and random2 will generate the same sequence of random sequence as they have the same seed.
   Random random1 = new Random(42); // 78, 89, 52, 45, 63...
   Random random2 = new Random(42); // 78, 89, 52, 45, 63...
   ```
   2.1. `nextInt(int bound)` returns a random integer within `[0, bound)`.
      `nextInt()` returns a random integer wihtin the full range of `int` by default.
      ```java
      int randomInt = random.nextInt(100); // [0, 100)
      ```
   2.2. `nextDouble()` returns a random double value within `[0.0, 1.0)`.
      ```java
      double randomDouble = random.nextDouble(); // `[0.0, 1.0)`
      ```
      You can use this method to simulate probability events.
      ``` java
      boolean probability_50 = random.nextDouble() < 0.5; // 50% probability
      ```
   2.3. `nextBoolean()` returns a random boolean value `true` or `false`.
      ``` java
      boolean randomBoolean = random.nextBoolean(); // true or false
      ```
 ### Customize random number range `[min, max]`:
 
 1. Formula: Integer within [min, max]
   ```java
   // 
   random.nextInt(max - min + 1) + min;
   (int)((Math.random() * (max - min + 1)) + min;
   ```
   Example：
   ``` java
   // Desired range: [0, 50]
   random.nextInt(51) + 0;
   (int)(Math.random() * 51);
   // Desired range: [50, 100]
   random.nextInt(51) + 50; 
   (int)(Math.random() * 51) + 50;
   // Desired range: [-50, 50]
   random.nextInt(101) - 50;
   // Desired range: [-100, -50]
   random.nextInt(51) - 100;
   // Desired range: [0.0, 10.0]
   random.nextDouble()
   ```
2. Formula: Double within [min, max]
   ```java
   +
   random.nextDouble() * (max - min) + min;
   Math.random() * (max - min) + min;
   ```
   Example:
   ```java
   // Desired range: [0.0, 10.0)
   random.nextDouble() * 10.0;
   // Desired range: [3.0, 7.0)
   random.nextDouble() * 4.0 + 3.0;
   Math.random() * 4.0 + 3.0;
   // Desired range: [-0.999, 0.999)
   random.nextDouble() * 1.998 - 0.999;
   ```


## Container

A container class like `ArratList`, `LinkedList`, `HashMap` is used to store multiple objects.  

A container class can store ***object reference*** only, not primitive types.
But you can use the **wrapper Class**:
- `int`     -> `Integer`
- `double`  -> `Double`
- `float`   -> `Float`
- `char`    -> `Character`
- `boolean` -> `Boolean`  
- 
**Autoboxing**: Primitive types -> Object(Wrapper class):
`alist.add(7)` converts the `int 7` to `Integer 7`
**Unboxing** : Object(Wrapper class) -> Primitive types:
`int elem = alist.get(1)` converts the `Integer 1 ` to `in 1 `.  

### ArrayList
#### **Declaration**
```java
import java.util.ArrayList;

ArrayList<Integer> alist = new ArrayList<>();  // 
ArrayList<String> slist = new ArrayList<>(10); // specify the initial capacity;
ArrayList<Object> olist = new ArrayList<>();   // any object of defined class by the user. 
```

#### **Methods**
Given an `ArrayList<Integer> alist` 
1. `add(E element)` adds an element to the end of the list.
   `add(int index, E element)` adds an element at the specified index.
   ```java
   ArrayList<Integer> alist = new ArrayList<>();
   alist.add(7); // Automatically boxed from int to Integer
   alist.add(1, 42);
   ```
2. `get(int index)` returns the element at the specified index.
   ```java
   int elem = alist.get(1);
   ```
3. `set(int index, E element)` replace the element at the specified index with the new element.
   ```java
   alist.set(0, 99);
   ```
4. `remove(int index)` removes the element at the specified index.
   `remove(Object obj)` removes the first occurrence of the specified element.
   ```java
   alist.remove(1);
   alist.remove(Integer.valueOf(99));
   ```
5. `size()` returns the number of elements in the list.
   ```java
   int size = alist.size();
   ```
6. `clear()` removes all elements from the list.
   ```java
   alist.clear();
   ```
7. `isEmpty()` returns `true` if the list is empty.
   ```java
   boolean empty = alist.isEmpty();
   ```
8. `contains(Object obj)` returns `true` if the list contains the specified element.
   ```java
   boolean contain = alist.contains(99);
   ```
9. `indexOf(Object obj)` returns the index of the first occurrence of the specified element.
   `lastIndexOf(Object obj)` returns the index of the last occurrence of the specified element.
   ```java
   int index = alist.indexOf(99);
   ```  
10. `toArray()` returns an array containing all of the elements in the list.
    ```java
    Integer[] arr = alist.toArray(new Integer[alist.size()]);
    ```
11. To print the whole ArrayList, just use `System.out.println(alist);`. [_, _, _,...]

### Map

**Declaration**
..BUILDING...




## Stream

### Features:
1. ***Functional in nature***, only produces a result and does not modify its source.
2. ***Laziness seeking***, like `.filter()`, `.map()` and other **Intermediate operations** are always lazy, do not start processing until a **terminal operation** invoked.
3. ***Consumable***, a elements of a stream are only visited once during the life of the stream(stream closed once a terminal operation invoked).
   ```java
   Stream<Integer> stream = Stream.of(1,2,3,4,5);
   stream.forEach(System.out::println); // 1,2,3,4,5
   stream.forEach(System.out::println); // java.lang.IllegalStateException: stream has already been operated upon or closed
   ```

### Stream Operations and Pipeline
#### Step 1: create a stream form a source
1. **from Collection**      
   `default Stream<E> stream()` method in the `Collection` interface.      
   ```java
   import java.util.ArrayList;

   ArrayList<Integer> alist = {9,7,8,2,1,3,4,6,5};
   Stream<Integer> stream = alist.stream();
   ```
2. **from Array**    
   `static <T> Stream<T> stream(T[] array)` method in the `Arrays` class.      
   ```java

   import java.util.Arrays;

   int arr[] = {9,8,7,6,4,3,1,2,5};
   IntStream stream = Arrays.stream(arr);
   ```
3. **from Stream Factory Methods(discrete data elements)**      
   ``static IntStream range(int startInclusive, int endExclusive)`` method in the `IntStream` interfaces.  


   Or, ``static <T> Stream<T> of(T... values)`` method in the `Stream` interface.      
   ```java
   import java.util.stream.IntStream;
   IntStream stream = IntStream.range(1, 10); // [1, 10)

   import java.util.stream.Stream;
   Stream<String> stream = Stream.of("dog", "cat", "bird");
   ```

#### Step 2: Intermediate Operations  
Usually, the return type is `Stream <T>`.    
1. `Stream <T> distinct()`  
   return a stream consisting of the distinct elements of this stream.
2. `Stream <T> filter(Predicate<? super T> predicate)`  
   return a stream consisting of the elements of this stream that match the given predicate.  
   NOTE: you can use lambda expression to define the predicate.
3. `Stream <R> map(Function<? super T, ? extends R> mapper)`  
   return a stream consisting of the results of applying the given function to the elements of this stream.
4. `Stream <T> skip(long n)`  
   return a stream consisting of the remaining elements of this stream after discarding the first `n` elements.
5. `Stream <T> sorted()`  
   return a stream consisting of the elements of this stream, sorted according to their natural order.
6. `Stream <T> limit(long maxSize)`  
   return elements stream truncated to be no longer than `maxSize` in length.  


#### Step 3: Terminal Operations

- Consumable operation:  
  `forEach()`    
- Reduction operation:  
  `reduce()`   
- Collection operation:  
  `collect(Collectors.toList())`   
  `collect(Collectors.toSet())`  
- Aggregation operation:
  `count()`  
  `max()`  
  `min()`  
  `sum()`  
  `average()`  
- Short-circuiting operation:
  `anyMatch()`  
  `allMatch()`  
  `findAny()`  
  `findFirst()`  

#### Example:

```java
import java.util.ArrayList;
import java.util.Arrays;

ArrayList<String> list = new ArrayList<>(Arrays.asList(
             "restrictive"
            ,"deploy"
            ,"elegant"
            ,"gateway"
            ,"restrictive" // duplicate
            ,"privilege"
            ,"authorization"
            ,"catalogue"
            ,"elegant"  // duplicate
            ,"privilege"//duplicate
            ,"forgery"
            ,"administrative"
            ));

list.stream()    // create a stream from a collection
    .distinct()  // stateful intermediate operation
    .filter(str -> str.length() > 7) // stateful intermediate operation
    .map(String::toUpperCase)        // stateful intermediate operation
    .sorted()                        // stateful intermediate operation

// Example of terminal operation:
    .forEach(System.out::println);    // consumable terminal operation
   /* output:
    * AUTHORIZATION
    * ADMINISTRATIVE
    * CATALOGUE
    * PRIVILEGE
    * RESTRICTIVE
   */

    .collect(Collectors.toList());    // collection terminal operation
   /* output:
    * [AUTHORIZATION, ADMINISTRATIVE, CATALOGUE, PRIVILEGE, RESTRICTIVE]
   */

    .count();                        // aggregation terminal operation
    // output: 5

    .reduce((str1, str2) -> str1 + " " + str2); // reduction terminal operation
    // output: "AUTHORIZATION ADMINISTRATIVE CATALOGUE PRIVILEGE RESTRICTIVE"

    .anyMatch(str -> str.startWith("A");)       // short-circuiting terminal operation
```


## Exception:

### Keywords

#### "try-catch" block
```java
try{
   // Code they may trigger an exception
}catch(Exception e){
   // do something to recover from the exception
}finally{
   // Code that always executed regardless of whether an exception is thrown.
   // But at here, 'finally' block is unnecessary. cause the exception has been caught and program continues to run.
}
```
`Exception e` means that **any exception of type** `Exception`, you can replace it with a specific exception type.  
`e` is a **reference variable** that holds the exception object.       
It contains information about the error, such as message and stack trace.  

#### finally block
```Java
try{
   // Code they may trigger exception.
} finally {
   // The program may terminate due to an uncaught exception caused by a missing catch block.
   // Anyway, the codes in 'finally' block are always executed.
}
```

#### 'throw' keyword

The `throw` keyword is used to **inside a method** to explicitly **trigger an exception**. And it is **followed by an instance of an exception**.  
Only one exception can be thrown at a time.
```java
public static void checkAge(int age){
   if(age < 18)
   {
      throw new IllegalArgumentException("Age must be 18 or above.");
   }
   system.out.println("Age is valid.");
}
```
#### 'throws' keyword
The `throws` keyword is used in a **method signature** to **declare** that this method **might** throw one of the listed exceptions.  
It **does not handle the exception itself**; it just **informs** the **caller that they should handle or propagate** it.   
```java
public void readFile(String filePath) throws IOException{
   FileReader file = new FileReader(filePath);
}
```

NOTE: both `throw` and `throws` do not handle the exceptions immediately, requiring the caller to handle them.

#### Checked vs Unchecked Exceptions

- Checked Exception:
  - **Must be handle** either with `try-catch` or by declaring with `throws` in the method signature.
  - Checked at compile time, meaning the program won't compile if they're not handled.
  - Recoverable exceptions, such as `IOException`(wrong input/output operation), `SQLException`(database connection error)...
  - Extends: `Exception` but not `RuntimeException`.  
  - 
- Unchecked Exception:
  - Not checked at compile time, meaning that Java not forced to handle or declare them.
  - Occur at **runtime** due to logical errors or programming mistakes(e.g. accessing a null reference, invalid index, division by zero.)  
  - Extends: `RuntimeException`

#### Custom Exception
You can create your own exception by extending the `Exception `class.
```java
class MyException extends Exception{
   public MyException(String message){
      super(message); // call the constructor of the parent class
   }
}

public class CustomExceptionExample{
   public static void customMethod(String code) throws MyException{
      if(!code.equals("5207")){
         throw new MyException("Invalid code.");
      }
   }


   public static void main(String[] args){
      CustomExceptionExample obj = new CustomExceptionExample();
      try{
         obj.customMethod("12334");
      }catch(MyException e){
         System.out.println("Caught custom exception: "e.getMessage());
      }
   }
}
```
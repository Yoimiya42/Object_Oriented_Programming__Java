# Java Foundations
## __Contents__
- [Basics](#Basics)
- [DataType for Java](#Data-Type-in-Java)
- [String](#String)
- [Array](#Array)
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





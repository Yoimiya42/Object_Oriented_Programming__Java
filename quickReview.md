# Java Foundations

## Compile and run

You compile the file with the following command:
```
javac [filename].java
```
You will end up with a bytecode file named `filename.class` which is stored in the same directory as the source file.
Now, launch the program by issuing the following command(remember to leave off the `.class` extension):
```
java [filename]
```

## A simple Java Program
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


## Distinction between Function and Method

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
- Java supports Unicode encoding instead of just ASCII encoding.
- **false** and **true** are all lowercase.

### Part II: Reference types
The reference type used to store reference or memory address of a object, rather than a specific value.

- Class: in java, **class** is a cornerstone of the object-oriented programming. A class defines the blueprint or template for objects, including ***attribute(fields)*** and ***behaviour(methods)***.
  *`String` is a class in Java.*
- Array
- Enum: 
- Interface

### Distinction between Primitive and Reference data types:

|Features| Primitive Data Type| Reference Data Type|
|:-------|:-------------------|:-------------------|
|Content | Value | Memory Address|
|Memory allocation| ***On Stack***| ***On Heap***|
|`null` or not| Cannot be `null` | Can be `null`|
|Default value| 0(numbers), `false`(boolean)| `null`|
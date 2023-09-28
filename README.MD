# Kotlin for Java Developers 

## Section 03 Topics
- Kotlin Stand Library
- Mutable and Immutable variables
- Type aliases
- Structural equality vs Referential equality
- Bitwise OR and AND
- Smart Casting
- String templates
- Raw strings
- Kotlin REPL
- Challenges (Round 1)

## Section 04 Topics
### DataTypes
- Kotlin has no primitive types, only Object types
  - Double (default for decimal)
  - Float
  - Long
  - Integer (default for non-decimal)
  - Short
  - Byte
  - Boolean
  - Char
  - Any     (like Object in Java)
  - Unit    (Not return anything in Kotlin)  
  - Nothing (Indicates it won't return) 
    - Use case: it only throws an exception (method not yet implemented)
    - Use case: Method goes into an infinite loop
    - Code is not reachable after calling a function that returns Nothing

### Array
  - Array of Longs, Ints
  - Array indexing
  - Create Array with size & a initializing lambda
  - Create Array without initializing lambda
  - Array of mixed types (Any)
  - Java int[] vs Kotlin IntArray vs Kotlin Array
    - Convert Kotlin Array -> Java int[]
    - Convert Java int[] -> Kotlin Array

### Null References
  - Null-safe operator  ?
  - Safe calls operator ?.
  - Elvis operator      ?:
  - Safe cast operator  as?
  - Not null assertion  !!
  - Let operator        .let
  - Array of Nulls

## Section 05 Topics

### Access Modifiers (on top level methods / classes):
|        | private | protected | public | internal |
|--------|---------|-----------|--------|----------|
| <b>Kotlin</b> | Visible within the same file | Can't be used | Visible everywhere | Visible within the same module |
| <b>Java</b> | Can't be used | Can't be used | Visible everywhere | N/A |

<br>

  - Kotlin Classes are public final by default
  - Const can be at the top level and not inside a class
  - Private classes are assessible, only if in the same file
  - Top level private classes are allowed in Kotlin, not for Java

### Constructor
  - Primary
    - Outside of {}, only ONE
  - Secondary
    - Inside of {}, can have multiple
    - Refers to primary constructor (using this) if that exists

### Getters / Setters & function parameters
  - Kotlin auto generates getters / setters for properties
  - Kotlin supports defining custom getter/setter
    - getter/setter NEEDS to come RIGHT AFTER the field declaration
    - Use the "field" identifier in the getter/setter to refer to the backing property

### Functions
  - Function can be called with position or named arguments 
  - Function parameters have "default value" support
  - Vararg
    - Can only have ONE vararg parameter
    - if vararg is the first arg, we need to use named arg after the vararg
  - Function can be defined with:
    - Block Body { ... } 
    - Expression Body = ...

### Extension function
  - Creating in illusion that this has been added to a class

### Inline function  
  - Compiler will optimize the bytecode to have the body of this function inline where it is called instead of a separate function. *Might give performance gain or negative impact*

### Spread operator
  - unpacking array -> vararg
  - Use Spread operator to combine arrays and items into a single array

### Data classes
  - Data classes get hashCode(), toString(), equals() and copy() methods for FREE
  - Printing out data classes looks nicer than regular classes
  - Kotlin: copy() method to copy an object. Method has values override
  - Data classes are NOT extendable

### Inheritance
  - Because classes and functions are public "final" by default
    - To extend a class, set this class to "open"
    - To override a function, set this function to "open"
    - use "override" keyword for the overriding method
    - "override" implicitly means "open"
    - Use "final" to stop a method being overridable
  - Kotlin classes / methods can be abstract
  - Sub-classing:
    - "super" keyword to refer to the super-class

### Interface
  - Interfaces do not need to be set "open" to be extendable
  - Note: interface in Kotlin can have member variables (becomes abstract properties)
  - Note: interface in Kotlin can have default value, but have to define a getter method for it

### Enum
  - enum is a class in Kotlin
    - allow methods inside the enum class

### "object" keyword
  - 3 Major Uses:
  1. Use "object" keyword on an object declaration to make a Singleton object
    - object declaration declares and create at the same time
  2. Define "companion object" 
    - This block is defined inside a class to make static methods
    - Call these methods by Class.staticMethod()
    - We can use "companion object" to implement the Factory Method Pattern
  3. Anonymous object
    - NOTE: anonymous object is NOT a Singleton

### Module
  - By default, one module can call another module's method, classes, etc.
  - To make a method, class only accessible to its own module, use "internal" keyword

### Import
  - We can shorten the class/method imported with "as" keyword

## Section 06 Topics

### Try-Catch
- Kotlin does not distinguish between checked and unchecked exceptions
- Try-catch can be an expression and return a value
- Finally cannot return a value

### If Condition / Expression
- If can be used to as a condition check and also an expression (which can return a value)
- Kotlin does NOT have Ternary operation, instead use the "if" expression

### When Condition / Expression
- "when" in Kotlin is like "switch" in Java
- "when" can be used to as a condition check and also an expression (which can return a value)
- "when" conditions:
  - Comma means OR <b>e.g. x,y</b>
  - In range <b>e.g. in x..y</b>
  - Expressions <b>e.g. y + 10</b>
  - Switch between different types <b>e.g. is String</b>
  - Switch between different tests (without a value pass into when) <b>e.g. num1 < num2</b>
  - Can switch between different enums <b>e.g. Season.FALL</b>

### Range operator
- range operator 
  - range numbers are INCLUSIVE: 1..5 means 1 <= x <= 5
  - range can be for numbers, chars, strings (anything comparable)
  - backward range (.downTo())
  - Changing step in range (only for numeric range)

### Loops
- While loop in Kotlin is the same as Java
- For loop in Kotlin is DIFFERENT than in Java
- For loop:
  - with range <b>e.g. for (i in range)</b>
  - loop through each char in a string <b>e.g. for (c in str)</b>
  - loop until <b>e.g. for (i in 1 until 10)</b> Note: (end num is exclusive: 1 <= x < 10)
  - loop through an array <b>e.g. for (season in seasons)</b>
  - loop through an array with indexes <b>e.g. for (index in seasons.indices)</b>
  - forEach with lambda <b>e.g. seasons.forEach {}</b>
  - forEachIndexed with lambda <b>e.g. seasons.forEachIndexed {}</b>
  - named loop (use case: breaking out of nested loop, could get ugly)


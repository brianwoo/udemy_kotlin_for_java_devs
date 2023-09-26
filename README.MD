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
  - Any  

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
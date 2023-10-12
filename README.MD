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
  - Kotlin's "Arrays" are Java Object[] under the hood (e.g. Integer[], Double[])
  - Kotlin array creation under the hood:
    - Array(5) {...}   produces => Java Integer[]
    - arrayOf(1,2,3)   produces => Java Integer[]
    - intArrayOf(1,2)  produces => Java int[] 
    - IntArray(5)      produces => Java int[]

### Array Conversion  
  - Convert Java int[] -> Integer[]:
    - kotlinArray = smallInts.toTypedArray()
  - Convert Integer[] -> Java int[]
    - smallInts = kotlinArray.toIntArray()    

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


## Section 07 Topics

### Lambda Expressions
- Lambdas are written in between a set of {}
- Use "it" to refer to a parameter passed in
- "it" is only available if that's the only parameter
- Instead of using a lambda, we can use "member reference" as a parameter
- Lambda can change variables outside of the lambda, unlike in Java
- 3 Ways to execute a Lambda:
  1. "run" function:
      * "run" can take a function that takes no parameter and returns a Unit
  2. "with" function:
      * takes a parameter (aka a receiver)
      * takes a lambda (last arg, which we can write it as {})
      * return a value
      * Shortcut: when using "with", the "receiver" inside the lambda can be ignored
      * Shortcut: or use "this" to refer to the receiver
      * Shortcut: last line in the lambda is automatically returned (don't need return)
  3. "apply" function:
      - takes a lambda (last arg, which we can write it as {})
      - return the receiver
- Return inside lambda:
  - non-local return, meaning, it returns from lambda and the enclosing function
  - for local return, meaning, it returns from lambda only, use a label
- Nested lambda:
  - Use label to clarify which lambda "this" we are referring to

### Collections
- Collections has mutable / immutable versions
- Tip: use yourObject.javaClass to find out what Java class it is
- Useful methods (like in JS):
  - filter(), map()
  - all() - return true if the condition of ALL entries satisfies
  - any() - return true if the condition of ANY entry satisfies
  - count() - return the number of conditions satisfies
  - find() - find a entry with condition in a List
  - groupBy() - group certain entry by a condition, returns a Map
  - toSortedMap() - sort a Map by key
  - sortedBy() - sort a List by a condition

### Collections: List
- Creating different lists:
  - listOf() produces an immutable list
  - arrayListOf() produces a mutable list
  - emptyList()
  - listOfNotNull()
  - Convert array to list: listOf(*array)
  - Convert int[] to Kotlin List: ints.toList()
- list.minBy(): Look for the minimum number
- list.last(): Get last element of a List
- list.reversed():   Reverse a list
- list.asReversed(): Reverse a list
- list.getOrNull(5): Get Element at position Or Null
- list.max(): Get max in a List
- list1 + list2: Join 2 lists together
- list1.zip(list2): Join 2 lists together in pairs
- list1.union(list2): Combining 2 lists with NO DUPLICATES
- list.distinct(): Remove duplicate items in a List
- list.toMutableList(): Change list to mutable

### Collections: Map
- Like Lists, there is a mutable and an immutable version
- mapOf() produces an immutable Map
- mutableMapOf() produces a mutable Map
- hashMapOf() produces a mutable Map
- Pair: we can use destructuring function like in JS
- Destructuring a regular object:
  - For a regular class to destructure, we need to add "component functions"
  - Data classes come with "component functions" for FREE

### Collections: Set
- plus(), minus(), average(), drop() methods
- setOf() produces an immutable set
- immutableSet.plus() will return a new immutable set
- mutableSetOf() produces a mutable set
- mutableSet.plus() will return change the set

### Collection vs Sequence
- Collection:
  - Each operation is executed on the entire collection
  - New collection is created for each operation
  - Should be used on a SMALL data set
- Sequence:
  - Uses an iterator to pass one element at a time to each intermediate operation
  - The same element is then passed to the next operation, ... until reaches the terminal operation
  - It then process the next element (remember: it uses an iterator)
  - If terminal operation (which does not return a sequence e.g. toList()) is missing at the end, the sequence operations will NOT be executed
  - Sequence can save time when working with a LARGE data set as some condition may end early
- Convert collection --> sequence
  - collection.asSequence()


### Generics
- Generics can be used in functions and extension functions

### Generics (upperbound)
- fun <T: Number?> myFunc()
  - Generic type but only subclass of Number (setting upper bound)
  - Nullable Upper bound is set by adding "?"
  - where keyword: to set multiple generics upper bound
  - Generic type T is "nullable Any" by default
    - To restrict "non-nullable Any", we just do <T: Any>
  - Kotlin is similar to Java where generic types are erased (Generics is a COMPILE TIME feature)
  - To type check generic types, we have to use <*> (star projection)
    - E.g. if (listAny is List<*>) {}

### Generics (reified - dealing with erasure)
- To get around the type being "erased" in collections, we can use Reified Type
  - Need to do 2 things:
    - Set the function as inline
    - Set the generic type as <reified T>
- Reified is only useful if we need to check a generic type inside a function
- Only inline functions can be reified

### Generics (Variance)
- 3 Types of Variant classes:
  - Invariant (default for generic classes)
  - Covariant
  - Contravariant
- <b>For easy memorization</b>:
  - Covariant:
    - Super class: Garden\<Flower>, can accept ITSELF and DOWN the inheritance tree
    - Use "out" keyword - return type only
    - Remember: <b>Covariance - Down - out</b>
  - Contravariant:
    - Garden\<Rose>, can accept ITSELF and UP the inheritance tree
    - Use "in" keyword - input params only
    - Remember: <b>Contravariance - Up - in</b>

### Generics (Invariant)
- Invariant wants the exact generic type, if param is Garden\<Number>, passing Garden\<Int> gives err
- A "sub" type generic class variable can NOT be passed to its "super" type as a parameter
- E.g. Garden\<Rose> is passed as a param to a fun myFunc(Garden\<Flower>)
- Solution: Convert the Invariant generic type to a Covariant type
- Reasoning: Invariant only wants the exact generic type:
  - There is no chance that a wrong type is passed into an add().
  - Invariant classes are made READ, WRITE
  - E.g. MutableList

### Generics (Invariant -> Covariant)
- Covariant means it can take both generic types: the same type and sub types
- E.g. It's OK to pass Garden\<Rose> as a param to a function myFunc(Garden\<Flower>)
- To convert an Invariant generic type to a Covariant type:
  - we add "out" keyword to the Invariant generic type
  - e.g. class Garden\<out T: Flower>
  - "out" means MEMBER functions can ONLY return T, not T as an input param
  - Reasoning: Because both generic types can be passed, as a protection feature:
  - All member functions can not accept this covariant variable as an input param
    - This covariant variable can only be returned
    - Covariant classes are made READONLY
    - E.g. List and ImmutableList

### Generics (Invariant -> Contravariant)
- The opposite of the Covariance
  - We start with a class of Sub type E.g. Garden\<Rose>
  - Use "in" keyword - input params only
  - where the member methods of Garden\<Rose> can accept both ITSELF and the Super type E.g. Garden\<Flower>
  - We are looking at "UP" the inheritance tree
  
### Generics (Use site vs Declaration Site Variance)
- Use Site Variance:
  - It's applied to method outside of OUR classes
  - It's used when a class cannot be changed (E.g. 3rd party classes)
- Declaration Site Variance:
  - It's applied to OUR classes
  - It's used when we have control of changing a class


## Section 08 Topics

### Reading text files
- Reader.readLines() automatically closes the reader when done
- Reader.readText() needs closing reader explicitly
- Reader.use() function - a closeable function even if exception thrown
- Tip: functions with "use" in its name mean it does auto close
- File.readText() automatically closes the reader when done
- Reader.readLines(), Reader.readText(), Reader.use(), File.readText()
  - Read all lines into memory. Not recommended if file is BIG
- use forEachLine to read BIG files

### Reading Binary Files
- Reading binary files will need to use Java library
- Try with Resources equivalent in Kotlin is to use one of the "use" functions

### Walking file tree
- walkTopDown() returns a sequence
- walkBottomUp() returns a sequence
- walk(), specify a direction, returns a sequence


# Basics of Scala


This section is a quick tour of the Scala language. The idea is give you some general ideas you might have seen 
in any mainstream programming language.

After this section you will get familiar enough to write sort of code in Scala without difficult.

## Compile-time and Run-time
There are two different stages that scala program goes through

1. Compiled: The program must be syntactically correct
2. Run or evaluated

## Expressions Types and Values 

Expressions, types and values are concepts will allow you build a mental model of how Scala programs work 

so what exactly are expressions, types and values? 

**Expressions** are part of a program's text whatever we type in a file (console or worksheet) <br>
**Types** in Scala all values are Objects, The types can be understood as restrictions on our programs
that limit how we can manipulate them.<br>
**Values** are the information stored in the memory



### Primitives 

These types are identical primitive types in Java or any statically typed language

| Type    | Values                                                  |
|---------|---------------------------------------------------------|
| Byte    | -128 to 127                                             |
| short   | -32,768 to 32,767                                       |
| Int     | -2,147,483,648 to 2,147,483,647                         |
| Long    | -9,223,372,036,854,775,808 to -9,223,372,036,854,775,807|
| Boolean | true, false                                             |
| Char    | 'a', '0', 'Z' ...                                       |
| Float   | 32-bit Floating point                                   |
| Double  | 64-bit Floating point                                   |


## Methods and functions

In Scala you can define methods using the `def` keyword

```scala
def sayHello(name: String): Unit =
  println(s"Hello $name")
  
def defaultGreeting(name: String = "Bob"): Unit =
  println(s"Hello $name")
```

about methods, you don't need using `return` keyword, because Scala is able to infer the type of latest 
expression in the block code

to call a methods you could use 

```scala
sayHello("new Scala developer!")

defaultGreeting()
```

## Function values

Function values are similar to methods (probably you can find this concept as Lambda functions too), unlike methods
you can't have default values neither using Generics (we will see that concept in deep later)

```scala
val myFunctionValue: Int => Int = i => i + 1
// other alternative  less verbose val myFunctionValue: Int => Int = _ + 1
```

In general, you should prefer using methods unless you really need the flexibility to pass as parameters or store them in variables. But if you need that flexibility, function values are a great tool to have.


## Objects and Classes

### Classes

You can define classes using the class keyword, and instantiate them using new.

```scala
class Foo(x: Int) {
    def printMsg(msg: String) = {
      println(msg + x)
  }
}
```

for create a new instance you will need a `new` keyword 
```scala
val foo = new Foo(1)

f.printMsg("hello")
```

### Case Classes

Case classes are an exceptionally useful shorthand for defining a class

```scala
case class Foo(x: Int)
```

for create a new instance 

```scala
val foo = Foo(1)
```

Features of case class 
- A fields does not require a `val` to set public access
- A default `toString` prints asensible constructor-like representation of the class 
- Sensible equals,and hash Code methods that operate on the field values in the object.
- A copy method that creates  a new object with the same field values as the current one, also you can modify the object but you will get other

### Objects 
objects in Scala are a class with exactly one instance (Singleton) 

```scala
object Foo

object Bar {
  def foo(in: String): String = ???
}
```

#### Companion object
A companion object is an object with the same name as a class

```scala
import scala.math.{pow, Pi}

case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

val circle1 = Circle(5.0)
```

*function application syntax* it's a Scala's feature to call an object like a function
Naming a method apply will allow you do `Foo(args)` instead of `Foo.apply(args)`


```scala
class TimeStamp(val seconds: Long)

object TimeStamp {
  def apply(hours: Int, minutes: Int, seconds: Int): TimeStamp =
    new TimeStamp(hours * 3600 + minutes * 60 + seconds)
}
```

### Case objects

A final note. If you find yourself defining a case class with no constructor arguments you can instead a define a case object. A case object is defined just like a regular singleton object, but has a more meaningful toString method and extends the Product and Serializable traits:

```scala
case object Citizen {
  def firstName = "John"
  def lastName  = "Doe"
  def name = firstName + " " + lastName
}
```


### Traits
Traits are templates for creating classes, in the same way that classes are tem- plates for creating objects. Traits allow us to express that two or more classes can be considered the same, and thus both implement the same operations.

```scala
import java.util.Date
sealed trait Visitor {
    def id: String
    def createdAt: Date
    def age: Long = new Date().getTime() - createdAt.getTime()
}

case class Anonymous(
    id: String,
    createdAt: Date = new Date() 
) extends Visitor

case class User(
  id: String,
  email: String,
  createdAt: Date = new Date()
) extends Visitor
```
### Pattern Matching
Pattern Matching is like an extended `if` expression that allow us to 
evaluate an expression depending on the shape of the data. 
Pattern syntax
```scala
expr0 match {
  case pattern1 => expr1
  case pattern2 => expr2
}
```

A pattern can be one of
- a name 
- a underscore, matching and ignore
- a literal
- a constructor-style
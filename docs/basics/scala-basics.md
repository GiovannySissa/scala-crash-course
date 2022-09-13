# Basics of Scala


This section is a quick tour of the Scala language. The idea is give you some general ideas you might have seen 
in any mainstream programming language.

After this section you will get familiar enough to write sort of code in Scala without difficult.


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

Some examples:

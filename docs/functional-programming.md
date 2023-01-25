# Functional programming

Is a programming paradigm or a way of thinking when you try to write software programs.
This is supported theoretically for lambda calculus which is a mathematical model.

As its name says is focused on functions, we will see the techniques for working with
functions such as *curring*, *recursion* and *high order functions*


The loop is a single unit and cannot be broken into smaller components
```scala
var i = 0 
var n = 10
var sum = 0 

while(i <= n) {
  i  = i + 1
  sum = sum + i  * i
} 

```

Functional programming allow us to define a build system on a high level without caring
about the implementation details.

Probably you will feel awkward at first

## Pure Functions

A pure function is one that lack side effects,  in other words is a function  that relates
every input value to exactly one of set of responses.

```scala
val fn: A => B
```
It means pure function is a function such as have to following rigorous requirements

- Take one parameter (lambda calculus)
- Perform a computation
- Return exactly one result

## Side effects

Since pure functions can't change any external variables, these functions are impure 

```scala
writeFile(fileName)
updateDatabaseTable(sqlCommand)
```
Those are called impure functions, because when you call them, they change something
outside the function definition.

In other words they do more than just and operation that means we are not able to 
predict what these functions will return.


## Immutability

Let's think about when we want to modify variables.

1. change a single value of an object
2. loop counters

There are no variables, that could be seen as constant values

Immutability is a way to create simpler and safer code.

```scala
var x = 1 
x = x + 1  
```

## Referential transparency

Referential transparency is a property of expressions in general and not just for functions.
Basically it means we can replace the expression in any piece of program without changing
the meaning of the program.

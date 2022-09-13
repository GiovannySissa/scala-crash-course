
# Monoid

**Monoids** allow us to add or combine values in simple types we have
* Integer addition: binary operation that takes two integers and produces another integer
```(Int, Int) => Int```

Formally a monoid for a type T is.
* an operation combine with type (T, T) => T
* an element empty of type T

here is a simplified version

```scala
trait Monoid[T]{
  def combine(x: T, y: T): T
  def empty: T
}
```

Given the combine and empty operations, monoids must follow several laws. For all values x, y, z in A 
combine must be associative and empty must be an identity element.

```scala
def associativeLaw[A](x: A, y: A, z: A)
      (implicit m: Monoid[A]): Boolean = {
  m.combine(x, m.combine(y, z)) ==
    m.combine(m.combine(x, y), z)
}
def identityLaw[A](x: A)
      (implicit m: Monoid[A]): Boolean = {
  (m.combine(x, m.empty) == x) &&
    (m.combine(m.empty, x) == x)
}

```

package com.github.gs.scc.monoid

object ListMonoid {
  implicit def listMonoid[T]:Monoid[List[T]] = new Monoid[List[T]] {
    override def empty: List[T] = ???
    override def combine(lhs: List[T], rhs: List[T]): List[T] = ???
  }
}

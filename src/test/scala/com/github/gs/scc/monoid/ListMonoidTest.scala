package com.github.gs.scc.monoid

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ListMonoidTest extends AnyFunSuite with Matchers {

  import MonoidOps._
  import ListMonoid._
  "list monoid" should {
    "append lists" in {
      List(1, 2, 3) |+| List(4, 5, 6) shouldBe List(1, 2, 3, 4, 5, 6)
    }
    "obey identity" in {
      List(1, 2, 3, 4, 5) |+| Monoid.mzero[List[Int]] shouldBe List(1, 2, 3, 4, 5)
    }
    "obey associtiativity" in {
      val a = List(1, 2, 3)
      val b = List(4, 5, 6)
      val c = List(7, 8, 9)
      a |+| b |+| c shouldBe a |+| (b |+| c)
    }
  }
}

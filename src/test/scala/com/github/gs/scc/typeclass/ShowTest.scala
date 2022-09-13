package com.github.gs.scc.typeclass

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShowTest extends AnyFlatSpec with Matchers {
  import ShowInstances._

  "show" should "show int " in {
    Printer.show(5) shouldBe "5"
  }

  it should "show double" in {
    Printer.show(5.0) shouldBe "5.0"
  }

  it should "show list of int" in {
    Printer.show(List(5, 10, 20)) shouldBe "[5, 10, 20]"
  }
}

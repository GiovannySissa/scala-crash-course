import sbt._

object Dependencies {

  object Versions{
    lazy val log4j = "2.17.2"
    lazy val bigDataTypes = "1.1.2"
    lazy val scalatestplus = "3.2.2.0"
    lazy val scalaCheck = "1.16.0"
    lazy val scalaTest = "3.2.9"
  }


  lazy val common: Seq[ModuleID] = Seq(
    "org.apache.logging.log4j" % "log4j-api" % Versions.log4j,
    "org.apache.logging.log4j" % "log4j-core" % Versions.log4j,

  )

  lazy val tests: Seq[ModuleID] = Seq(
    "org.scalatest"       %% "scalatest"   % Versions.scalaTest  % "test",
    "org.scalacheck"      %% "scalacheck"  % Versions.scalaCheck % "test",
    "org.scalatestplus" %% "scalacheck-1-14" % Versions.scalatestplus % "test"
  )

}

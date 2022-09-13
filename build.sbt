scalaVersion := "2.13.3"
organization := "com.github.gs"
name := "scc" // scala-crash-course

libraryDependencies ++= Dependencies.common ++ Dependencies.tests


// Microsite settings
micrositeName := "/n Scala crash course"
micrositePalette := Map(
  "brand-primary"         -> "#14284B",
  "brand-secondary"       -> "#FF8C00",
  "white-color"           -> "#FFFFFF")

enablePlugins(MicrositesPlugin)
# Type class

Type classes are a powerful feature that allow us to extend existing functionalities
without using inheritance.

Type classes give us a third implementation, this means we can add new methods or new data
without changing existing code.


## Anatomy of a type class 

```
    - traits: type class
    - implicit values: type class instances
    - implicit parameters: type class use
    - implicit clases: (optional) make type clases easier to use  

```

### Example
- Existing functionality
  ```scala
      sealed trait Json
      final case class JsObject(value: Map[String, Json]) extends Json
      final case class JsString(value: String) extends Json
      final case class JsNumber(value: Double) extends Json
      final case object JsNull extends Json
    ```
- type class: Json writer "serialize to Json"
    ```scala
      trait JsonWriter[A] {
        def write(input: A): Json
      } 
    ```
- type class instances 
  ```scala
  
  final case class Person(name: String, email: String)
  
  object JsonWriterInstances {
    implicit val stringJsWriter: JsonWriter[String] = new JsonWriter[String]{
      def write(input: String): Json = JsString(input)
    }
    
    // compact way 
    // implicit val stringJsWriter: JsonWriter[String] = (input: String) => JsString(input)
  }
  
  
  ```
- type class use: there are two ways it does this `Interface objects` and `Interface Syntax`

  ```scala
     /*
      ===== Interface objects =======    
     */

    object Json {
      def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
        w.write(value)
    }
  ```

   ```scala
     /*
      ===== Interface syntax =======    
     */

    object JsonSyntax {
      implicit class JsonWriterOps[A](value: A){
        def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
          w.write(value)
      }
    }
  ```
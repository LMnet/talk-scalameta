package macros

import scala.annotation.StaticAnnotation
import scala.meta._

class HelloWorld extends StaticAnnotation {
  inline def apply(defn: Any): Any = meta {
    defn // macro code
  }
}

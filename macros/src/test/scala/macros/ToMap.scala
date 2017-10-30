package macros

import scala.annotation.StaticAnnotation
import scala.meta._

class ToMap extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    ??? // TODO
  }
}

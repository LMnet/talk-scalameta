package macros

import scala.annotation.StaticAnnotation
import scala.collection.immutable.Seq
import scala.meta._

class ToMap extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    defn match {
      case cls @ Defn.Class(_, _, _, ctor, template) =>
        val tuples: Seq[Term.Tuple] = ctor.paramss.flatten.map { param: Term.Param =>
          q"(${Lit.String(param.name.value)}, ${Term.Name(param.name.value)}.toString)"
        }

        val method: Defn.Def =
          q"""def toMap: _root_.scala.collection.Map[String, String] = {
            _root_.scala.collection.Map[String, String](..$tuples)
          }"""

        val templateStats: Seq[Stat] = method +: template.stats.getOrElse(Nil)
        cls.copy(templ = template.copy(stats = Some(templateStats)))

      case _ =>
        abort("@ToMap must annotate a class")
    }
  }
}

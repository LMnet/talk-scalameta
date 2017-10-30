import scala.meta._

val fooClass = q"case class User(name: String)"

fooClass.structure

case class Foo(bar: String)

Defn.Class(
  mods = List(Mod.Case()),
  name = Type.Name("User"),
  tparams = Nil,
  ctor = Ctor.Primary(
    mods = Nil,
    name = Name(""),
    paramss = List(List(
      Term.Param(
        mods = Nil,
        name = Term.Name("name"),
        decltpe = Some(Type.Name("String")),
        default = None
      )
    ))
  ),
  templ = Template(Nil, Nil, Self(Name(""), None), Nil)
)

val method = q"def upperName: String = name.toUpperCase"

q"""case class User(name: String) {
  $method
}"""

q"case class User(name: String)" match {
  case q"case class $className(..$paramss)" =>
    val ageParam = param"age: Int"
    val newParamss = paramss :+ ageParam
    q"case class $className(..$newParamss)"
  case other => other
}

source"""
  sealed trait Op[A]
  object Op extends B {
    case class Foo(i: Int) extends Op[Int]
    case class Bar(s: String) extends Op[String]
  }
""".collect {
  case cls: Defn.Class => cls.name
}

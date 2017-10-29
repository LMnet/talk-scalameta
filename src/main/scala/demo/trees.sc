import scala.meta._

val code = "foo(bar)"

code.parse[Stat] // show Parsed

val parsed = code.parse[Stat].get

parsed.syntax
parsed.structure

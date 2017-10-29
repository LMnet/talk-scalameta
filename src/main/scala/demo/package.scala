import scala.meta._

package object demo {

  implicit class TokensOps(val tokens: Tokens) {

    def printWithTokenNames: String = {
      tokens.map { token =>
        f"${token.structure}%10s -> ${token.productPrefix}"
      }.mkString("\n","\n", "")
    }
  }
}

import scala.meta._
import demo._

val code = "val x = 2"

code.tokenize // show Tokenized

val tokens: Tokens = code.tokenize.get

tokens.tokens
tokens.syntax
tokens.structure

// show Token.scala

tokens.printWithTokenNames

val code2 =
  s"""foo match {
     |  case 15 => true
     |  case _ => false
     |}""".stripMargin

code2.tokenize.get.printWithTokenNames

version := "0.1"

scalaVersion := "2.12.4"

lazy val demo = project.in(file("."))
  .settings(
    libraryDependencies += "org.scalameta" %% "scalameta" % "2.0.1"
  )
  .aggregate(macros)

lazy val macros = project.in(file("macros"))
  .settings(
    libraryDependencies += "org.scalameta" %% "scalameta" % "1.8.0",
    addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M10" cross CrossVersion.full),
    scalacOptions += "-Xplugin-require:macroparadise"
  )

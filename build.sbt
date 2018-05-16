
enablePlugins(ScalaJSPlugin)

enablePlugins(ScalaJSBundlerPlugin)

name := "react4s"
organization := "com.github.react-react4s-redux-spike"
version := "0.1-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")
libraryDependencies += "com.github.ahnfelt" %%% "react4s" % "0.9.13-SNAPSHOT"
libraryDependencies += "com.github.werk" %%% "router4s" % "0.1.0-SNAPSHOT"

scalaVersion := "2.12.6"

scalaJSUseMainModuleInitializer := true

emitSourceMaps := false

libraryDependencies ++= Seq(
  "com.raquo" %%% "laminar" % "0.3",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.raquo" %%% "domtestutils" % "0.7" % Test,
  "org.scalatest" %%% "scalatest" % "3.0.5" % Test
)

import org.scalafmt.sbt.ScalafmtPlugin.autoImport._

course := "progfun1"
assignment := "recfun"

scalaVersion := "3.3.0"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test

inThisBuild(List(
  scalafmtOnCompile := true
))

// Add this somewhere in your build.sbt
lazy val formatAll = taskKey[Unit]("Format all files using scalafmt")
formatAll := {
  (Compile / scalafmt).value
  (Test / scalafmt).value
  (Compile / scalafmtSbt).value
}

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val Part1 = project.in(file("Part1"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % "test",
      "org.mockito" %% "mockito-scala" % "1.16.46" % "test"
    ))
lazy val Part2= project.in(file("Part2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % "test",
      "org.mockito" %% "mockito-scala" % "1.16.46" % "test"
    ))


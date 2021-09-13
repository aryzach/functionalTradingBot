
scalaVersion := "2.12.8"


// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================

// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.3"

// It's possible to define many kinds of settings, such as:

name := "scalaTradingBot"
organization := "aryzach.github.io"
version := "0.2.2-SNAPSHOT"

libraryDependencies ++= Seq(
				"org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
				"com.larroy" % "ibclient_2.12" % "0.2.2-SNAPSHOT",
				"com.tictactec" % "ta-lib" % "0.4.0",
				"org.ta4j" % "ta4j-core" % "0.14"
				)

/*
	 libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
	 libraryDependencies += "dev.zio" %% "zio" % zioVersion

// both needed for zio test
libraryDependencies ++= Seq(
"dev.zio" %% "zio-test"          % zioVersion % "test",
"dev.zio" %% "zio-test-sbt"      % zioVersion % "test",
"dev.zio" %% "zio-test-magnolia" % zioVersion % "test" // optional
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

//libraryDependencies +=
//  "com.typesafe.akka" %% "akka-actor" % "2.3.16"

val AkkaVersion = "2.6.16"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % AkkaVersion
 */

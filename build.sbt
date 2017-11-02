name := "akka-cookbook-remoting"

version := "0.1"

scalaVersion := "2.12.4"

val example7_2 = (project in file("example7_2")).settings(
    name := "example7_2",
    version := "0.1",
    scalaVersion := "2.12.4"
)

val example7_3 = (project in file("example7_3")).settings(
    name := "example7_3",
    version := "0.1",
    scalaVersion := "2.12.4",
    description := "Looking up Remote Actors"
)

val example7_4 = (project in file("example7_4")).settings(
    name := "example7_4",
    version := "0.1",
    scalaVersion := "2.12.4",
    description := "Deploying Remote Actors programatically"
)


val example7_5 = (project in file("example7_5")).settings(
    name := "example7_5",
    version := "0.1",
    scalaVersion := "2.12.4",
    description := "Scaling out application using Remote Actors"
)



val example7_6 = (project in file("example7_6")).settings(
    name := "example7_6",
    version := "0.1",
    scalaVersion := "2.12.4",
    description := "Creating chat based application using Remote Actors"
)

package com.packt.example7_4

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object RemoteActorsProgrammatically1 extends App {
  val actorSystem = ActorSystem("RemoteActorsProgramatically1", ConfigFactory.load("application-1"))
}

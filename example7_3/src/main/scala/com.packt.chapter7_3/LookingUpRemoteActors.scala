package com.packt.chapter7_3

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object LookingUpRemoteActors extends App {
  val actorSystem = ActorSystem("LookingUpRemoteActors", ConfigFactory.load("application-2"))
  val actorRef = actorSystem.actorOf(Props[SimpleActor], "remoteActor")
  println(s"actorRef path is ${actorRef.path}")
}

package com.packt.example7_4

import akka.actor.{ActorSystem, Address, Deploy, Props}
import akka.remote.RemoteScope
import com.typesafe.config.ConfigFactory

object RemoteActorsProgrammatically2 extends App {
  val actorSystem = ActorSystem("RemoteActorsProgramatically2", ConfigFactory.load("application-2"))
  println("Creating actor from RemoteActorsProgramatically2")
  val address = Address("akka.tcp", "RemoteActorsProgramatically1", "localhost", 2552) // this gives the same
  val actorRef = actorSystem.actorOf(Props[SimpleActor].withDeploy(Deploy(scope = RemoteScope(address))), "remoteActor")
  actorRef ! "Checking"
  println(s"actorRef path ${actorRef.path}")
}

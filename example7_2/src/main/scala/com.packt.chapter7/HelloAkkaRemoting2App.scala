package com.packt.chapter7

import akka.actor.{Actor, Props, ActorSystem}
import com.typesafe.config.ConfigFactory

object HelloAkkaRemoting2App extends App {
  val actorSystem = ActorSystem("HelloAkkaRemoting2", ConfigFactory.load("application-2"))
  println(s"creating actor from HelloAkkaRemoting2")

  val actorRef = actorSystem.actorOf(Props[SimpleActor], "simpleRemoteActor")
  actorRef ! "checking"

  println(s"actorRef reference is ${actorRef.path}")
}

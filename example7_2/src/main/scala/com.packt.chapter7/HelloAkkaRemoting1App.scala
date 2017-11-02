package com.packt.chapter7

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object HelloAkkaRemoting1App extends App {
  val actorSystem = ActorSystem("HelloAkkaRemoting1", ConfigFactory.load("application-1"))
}

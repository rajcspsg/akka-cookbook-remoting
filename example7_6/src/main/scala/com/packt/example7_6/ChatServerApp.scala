package com.packt.example7_6

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object ChatServerApp extends App {
  val actorSystem = ActorSystem("ChatServer", ConfigFactory.load("application-1"))
  actorSystem.actorOf(ChatServer.props, "chatServer")
}

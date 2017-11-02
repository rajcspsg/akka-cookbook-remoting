package com.packt.example7_6

import akka.actor.{Actor, ActorSystem, ActorRef, Props}
import scala.concurrent.duration._
import com.typesafe.config.ConfigFactory

object ChatClientApp extends App {

  val actorSystem = ActorSystem("ChatServer", ConfigFactory.load(args(0)))
  implicit val dispatcher = actorSystem.dispatcher

  val chatServerAddress = "akka.tcp://ChatServer@localhost:2552/user/chatServer"

  actorSystem.actorSelection(chatServerAddress).resolveOne(3 seconds).onSuccess {
    case chatServer: ActorRef =>
      println(s"chatServer resolved ${chatServer.path}")
      val client = actorSystem.actorOf(ChatClient.props(chatServer), "chatClient")
      actorSystem.actorOf(ChatClientInterface.props(client), "chatClientInterface")
  }
}

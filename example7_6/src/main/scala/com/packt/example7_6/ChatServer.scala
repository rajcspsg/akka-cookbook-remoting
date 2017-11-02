package com.packt.example7_6

import akka.actor.{Actor, ActorSystem, ActorRef, Props, Terminated}
import Messages._

object ChatServer {
  def props = Props(new ChatServer())
}
class ChatServer extends Actor {

  var onlineClients = Set.empty[ActorRef]

  override def receive: Receive = {
    case Connect =>
      onlineClients += sender()
      context.watch(sender())
    case Disconnect =>
      onlineClients -= sender()
      context.unwatch(sender())
      sender() ! Disconnected
    case Terminated(ref) =>
      onlineClients -= ref
    case msg: Message =>
      onlineClients.filter(_ != sender()).foreach(_ ! msg)
  }
}

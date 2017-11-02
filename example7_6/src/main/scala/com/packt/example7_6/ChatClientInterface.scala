package com.packt.example7_6

import akka.actor.{ActorRef, Actor, Props, Terminated}
object ChatClientInterface {
  case object Check
  def props(chatClient: ActorRef) = Props(new ChatClientInterface(chatClient))
}

class ChatClientInterface(chatClient: ActorRef) extends Actor {

  import ChatClientInterface._
  import Messages._

  override def preStart() = {
    println("You are logged in. please type and press enter to send messages. TYPE Disconnect")
    self ! Check
  }

  override def receive: Receive = {
    case Check =>
      readLine() match {
        case "DISCONNECT" =>
          chatClient ! Disconnect
          println(s"Disconnecting...")
          context.stop(self)
        case msg =>
          chatClient ! msg
          self ! Check
      }
  }

}

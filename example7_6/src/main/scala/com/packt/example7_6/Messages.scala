package com.packt.example7_6

import akka.actor.{ActorRef}

object Messages  {
  case object Connect
  case object Disconnect
  case object Disconnected
  case class Message(author: ActorRef, body: String,
    creationTimeStamp: Long = System.currentTimeMillis())
}

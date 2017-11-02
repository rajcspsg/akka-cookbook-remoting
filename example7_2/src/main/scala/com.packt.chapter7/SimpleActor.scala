package com.packt.chapter7

import akka.actor.Actor

class SimpleActor extends Actor {
  override def receive: Receive = {
    case msg => println(s"$msg is received by ${self.path}")
  }
}

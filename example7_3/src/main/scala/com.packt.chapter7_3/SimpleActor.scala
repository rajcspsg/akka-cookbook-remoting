package com.packt.chapter7_3

import akka.actor.Actor

class SimpleActor extends Actor {

  override def receive: Receive = {
    case msg => println(s"$msg received at ${self.path}")
  }
}

package com.packt.chapter7_5

import akka.actor.Actor

class WorkerActor extends Actor {

  override def receive: Receive = {
    case Work(id) =>
      Thread.sleep(3000L)
      sender() ! WorkDone(id)
      println(s"Work $id was done by worker Actor ${self.path}")
  }

}

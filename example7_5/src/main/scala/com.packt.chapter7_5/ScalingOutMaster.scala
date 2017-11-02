package com.packt.chapter7_5

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
object ScalingOutMaster extends App {
  val actorSystem = ActorSystem("MasterActorSystem", ConfigFactory.load("application-1"))
  val masterActor = actorSystem.actorOf(Props[MasterActor], "masterActor")
  (1 to 100).foreach { i => {
      masterActor ! Work(s"$i")
      Thread.sleep(5000)

    }
  }
}

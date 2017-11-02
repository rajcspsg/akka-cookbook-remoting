package com.packt.chapter7_5

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import scala.concurrent.duration._
import akka.routing.RoundRobinPool
import com.typesafe.config.ConfigFactory

object ScalingOutWorker extends App {
  val actorSystem = ActorSystem("WorkerActorSystem", ConfigFactory.load(args(0)))
  implicit val dispatcher = actorSystem.dispatcher
  val selection = actorSystem.actorSelection("akka.tcp://MasterActorSystem@localhost:2552/user/masterActor")
  selection.resolveOne(3 seconds).onSuccess {
    case masterActor: ActorRef =>
      println(s"We got ActorRef for the Master Actor")
      val pool = RoundRobinPool(10)
      val workerpool = actorSystem.actorOf(Props[WorkerActor].withRouter(pool), "workerActor")
      masterActor ! RegisterWorker(workerpool)
  }
}

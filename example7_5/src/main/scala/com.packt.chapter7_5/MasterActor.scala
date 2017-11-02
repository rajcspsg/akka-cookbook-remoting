package com.packt.chapter7_5

import akka.actor.{Actor, ActorRef, Terminated}
import scala.util.Random

class MasterActor extends Actor {

  var workers: List[ActorRef] = List.empty[ActorRef]

  override def receive: Receive = {
    case RegisterWorker(actorRef) =>
      context.watch(actorRef)
      workers = actorRef :: workers
    case Terminated(actorRef) =>
      println(s"actor ${actorRef.path} has been terminated. Removing from worker list")
      workers = workers.filterNot(_ == actorRef)

    case work: Work if workers.isEmpty =>
      println(s"actors are empty right now")
    case work: Work =>
        workers(Random.nextInt(workers.size)) ! work
    case WorkDone(workId) =>
        println(s"Work with $workId done")
  }
}

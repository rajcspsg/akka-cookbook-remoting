package com.packt.chapter7_5

import akka.actor.ActorRef

case class Work(workId: String)
case class WorkDone(workId: String)
case class RegisterWorker(WorkerActor: ActorRef)

package com.packt.chapter7_3

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import scala.concurrent.duration._
import com.typesafe.config.ConfigFactory

object LookingUpActorSelection extends App {
  val actorSystem = ActorSystem("LookingUpActors", ConfigFactory.load("application-1"))
  implicit val dispatcher = actorSystem.dispatcher

  val selection = actorSystem.actorSelection("akka.tcp://LookingUpRemoteActors@localhost:2553/user/remoteActor")
  selection ! "test"

  selection.resolveOne(3 seconds).onSuccess {
    case actorRef : ActorRef =>
      println("We got an ActorRef")
      actorRef ! "test"
  }
}

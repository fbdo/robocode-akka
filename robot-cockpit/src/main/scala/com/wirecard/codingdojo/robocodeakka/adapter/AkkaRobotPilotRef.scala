package com.wirecard.codingdojo.robocodeakka.adapter

import akka.actor.ActorSystem

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
object AkkaRobotPilotRef {

  val system = ActorSystem()

  val ref = system.actorSelection("akka.tcp://AkkaRobotPilotSystem@127.0.0.1:2552/user/robopilot")


}

package com.github.fbdo.robocodeakka.pilot

import akka.actor.{ActorSystem, Props}

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
object AkkaRobotPilotMain {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("AkkaRobotPilotSystem")

    val ref = system.actorOf(Props(new AkkaRobotPilot), "robopilot")
  }
}

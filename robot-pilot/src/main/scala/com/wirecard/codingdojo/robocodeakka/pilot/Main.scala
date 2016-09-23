package com.wirecard.codingdojo.robocodeakka.pilot

import akka.actor.{ActorSystem, Props}

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
class Main {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem()

    val ref = system.actorOf(Props(new AkkaRobotPilot))
  }
}

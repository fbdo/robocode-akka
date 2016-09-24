package com.wirecard.codingdojo.robocodeakka.adapter

import akka.actor.{ActorSelection, ActorSystem}

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
object AkkaRobotPilotRef {

  val system = ActorSystem()

  def ref(addr: String): ActorSelection = system.actorSelection(addr)


}

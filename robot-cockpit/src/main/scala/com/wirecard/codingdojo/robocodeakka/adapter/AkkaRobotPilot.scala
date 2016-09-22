package com.wirecard.codingdojo.robocodeakka.adapter

import akka.actor.Actor
import akka.event.Logging
import com.wirecard.codingdojo.robocodeakka.messages._

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
class AkkaRobotPilot extends Actor {

  val log = Logging(context.system, this)

  val commands = Array(Ahead(100), TurnGunRight(360), Back(100), TurnGunRight(360))

  var count = 0

  override def receive: Receive = {
    case ScannedRobot => sender ! logCommand(Fire(1))
    case NextCommand => sender ! {
      count = count + 1; commands(count % 4)
    }
  }

  def logCommand(command: RobotCommand): RobotCommand = {
    log.debug("Received command [{}]", command)
    command
  }

  override def preStart() = {
    log.debug("Starting")
  }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    log.error(reason, "Restarting due to [{}] when processing [{}]",
      reason.getMessage, message.getOrElse(""))
  }
}

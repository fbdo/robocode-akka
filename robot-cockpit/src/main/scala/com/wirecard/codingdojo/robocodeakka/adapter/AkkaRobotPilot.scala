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
    case ScannedRobot(_, _, _, _, _, _, _) => sender ! logCommand(Fire(1))
    case NextCommand => sender ! logCommand({
      count = count + 1; commands(count % 4)
    })
  }

  def logCommand(command: RobotCommand): RobotCommand = {
    System.out.println("Sending command " + command)
    log.debug("Sending command [{}]", command)
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

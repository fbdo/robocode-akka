package com.wirecard.codingdojo.robocodeakka.pilot

import akka.actor.Actor
import com.wirecard.codingdojo.robocodeakka.messages._

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
class AkkaRobotPilot extends Actor {

  val commands = Array(Ahead(100), TurnGunRight(360), Back(100), TurnGunRight(360), GetX())

  var count = 0

  override def receive: Receive = {
    case ScannedRobot(_, _, _, _, _, _, _) => sender ! Fire(1)
    case X(x) => System.out.println("X position: " + x)
    case NextCommand() => sender ! {
      count = count + 1;
      commands(count % commands.size)
    }
    case BattleEnded() => context stop self
    case _ => sender ! DoNothing()
  }

}

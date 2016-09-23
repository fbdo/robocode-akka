package com.wirecard.codingdojo.robocodeakka.adapter

import akka.actor.{ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.wirecard.codingdojo.robocodeakka.messages._
import robocode.{BattleEndedEvent, Robot, ScannedRobotEvent}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
class AkkaRobotCockpit extends Robot {

  val system = ActorSystem()

  val ref = system.actorOf(Props(new AkkaRobotPilot))


  override def run() = {
    while (true) {
      implicit val timeout = Timeout(1 seconds)

      val future = ref ? NextCommand

      val result = Await.result(future, timeout.duration).asInstanceOf[RobotCommand]

      result match {
        case Ahead(x) => ahead(x)
        case TurnGunRight(x) => turnGunRight(x)
        case Back(x) => back(x)
        case Fire(x) => fire(x)
        case _ => doNothing()
      }

      //ahead(100);
      //turnGunRight(360);
      //back(100);
      //turnGunRight(360);
    }
  }

  override def onScannedRobot(e: ScannedRobotEvent) = {
    ref ! ScannedRobot(e.getName, e.getEnergy, e.getHeading, e.getBearing, e.getDistance, e.getVelocity, e.isSentryRobot)
    //fire(1)
  }

  override def onBattleEnded(e: BattleEndedEvent) = {
    ref ! PoisonPill
  }

}

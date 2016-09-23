package com.wirecard.codingdojo.robocodeakka.adapter

import akka.actor.{ActorSystem, Props}
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
      triggerEvent(NextCommand())
    }
  }

  override def onScannedRobot(e: ScannedRobotEvent) = {
    triggerEvent(ScannedRobot(e.getName, e.getEnergy, e.getHeading, e.getBearing, e.getDistance, e.getVelocity, e.isSentryRobot))
  }

  def triggerEvent(message: RobotEvents): Unit = {
    implicit val timeout = Timeout(1 seconds)
    val future = ref ? message

    val result = Await.result(future, timeout.duration).asInstanceOf[RobotCommand]

    result match {
      case x: RobotCommand => x.apply(this)
      case _ => doNothing()
    }
  }

  override def onBattleEnded(e: BattleEndedEvent) = {
    ref ! BattleEnded()
  }

}

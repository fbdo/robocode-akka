package com.wirecard.codingdojo.robocodeakka.adapter

import akka.pattern.ask
import akka.util.Timeout
import com.wirecard.codingdojo.robocodeakka.messages._
import robocode._

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
class AkkaRobotCockpit() extends Robot {

  val ref = AkkaRobotPilotRef.ref()

  implicit val timeout = Timeout(0.5 seconds)

  override def run() = {
    while (true) {
      triggerEvent(NextCommand())
    }
  }

  override def onScannedRobot(e: ScannedRobotEvent) = {
    triggerEvent(ScannedRobot(e.getName, e.getEnergy, e.getHeading, e.getBearing, e.getDistance, e.getVelocity, e.isSentryRobot))
  }

  override def onBulletHit(event: BulletHitEvent): Unit = {
    triggerEvent(BulletHit(event.getName, event.getEnergy, event.getBullet))
  }

  override def onBulletHitBullet(event: BulletHitBulletEvent): Unit = {
    triggerEvent(BulletHitBullet(event.getBullet, event.getHitBullet))
  }

  override def onBulletMissed(event: BulletMissedEvent): Unit = {
    triggerEvent(BulletMissed(event.getBullet))
  }

  override def onHitByBullet(event: HitByBulletEvent): Unit = {
    triggerEvent(HitByBullet(event.getBearing, event.getBullet))
  }

  override def onHitRobot(event: HitRobotEvent): Unit = {
    triggerEvent(HitRobot(event.getName, event.getBearing, event.getEnergy, event.isMyFault))
  }

  override def onHitWall(event: HitWallEvent): Unit = {
    triggerEvent(HitWall(event.getBearing))
  }

  def triggerEvent(message: RobotEvents): Unit = {
    implicit val timeout = Timeout(0.5 seconds)
    val future = ref ? message

    val result = Await.result(future, timeout.duration).asInstanceOf[RobotCommand]


    result match {
      case x: RobotCommand => x.apply(this, ref)
      case _ => doNothing()
    }
  }

  override def onBattleEnded(e: BattleEndedEvent) = {
    ref ! BattleEnded()
    AkkaRobotPilotRef.reset()
  }

  override def onRoundEnded(e: RoundEndedEvent) = {
    AkkaRobotPilotRef.reset()
  }

}

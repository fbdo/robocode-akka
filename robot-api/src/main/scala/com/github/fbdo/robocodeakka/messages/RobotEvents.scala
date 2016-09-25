package com.github.fbdo.robocodeakka.messages

import robocode.Bullet

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
abstract class RobotEvents

case class NextCommand() extends RobotEvents

case class ScannedRobot(name: String, energy: Double, heading: Double, bearing: Double, distance: Double, velocity: Double, sentryRobot: Boolean) extends RobotEvents

case class BattleEnded() extends RobotEvents

case class Heading(value: Double) extends RobotEvents

case class X(value: Double) extends RobotEvents

case class Y(value: Double) extends RobotEvents

case class GunHeading(value: Double) extends RobotEvents

case class GunHeat(value: Double) extends RobotEvents

case class Others(value: Int) extends RobotEvents

case class RadarHeading(value: Double) extends RobotEvents

case class Velocity(value: Double) extends RobotEvents

case class BulletHit(name: String, energy: Double, bullet: Bullet) extends RobotEvents

case class BulletHitBullet(bullet: Bullet, hitBullet: Bullet) extends RobotEvents

case class BulletMissed(bullet: Bullet) extends RobotEvents

case class HitByBullet(bearing: Double, bullet: Bullet) extends RobotEvents

case class HitRobot(name: String, bearing: Double, energy: Double, myFault: Boolean) extends RobotEvents

case class HitWall(bearing: Double) extends RobotEvents
